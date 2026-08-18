package com.erp.core;

import static org.assertj.core.api.Assertions.assertThat;

import com.erp.core.domain.IaAccount;
import com.erp.core.domain.IaAuditLog;
import com.erp.core.domain.IaPermission;
import com.erp.core.domain.IaRole;
import com.erp.core.domain.IaRolePermission;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Boots the full core-model context (H2 in-memory) WITHOUT Spring Data repositories
 * (data-access lives in the consuming service) and verifies that the 8 auth entities
 * are mapped, JPA auditing populates timestamps, FK links work, and the Postgres-style
 * JSON column round-trips (via {@link EntityManager} directly).
 */
@SpringBootTest(classes = CoreModelTestApplication.class)
class CoreModelIntegrationTest {

    @PersistenceContext
    private EntityManager em;

    @Test
    void auditingAndJsonColumnWork() {
        IaAccount account = new IaAccount();
        account.setUsername("admin");
        account.setEmail("admin@erp.local");
        em.persist(account);
        em.flush();
        em.clear();

        IaAccount saved = em.find(IaAccount.class, account.getId());
        // UUID PK generated + auditing timestamps populated
        assertThat(saved.getId()).isNotNull().hasSize(36);
        assertThat(saved.getCreatedAt()).isNotNull();
        assertThat(saved.getUpdatedAt()).isNotNull();
        assertThat(saved.getStatus()).isEqualTo("ACTIVE");

        // role -> permission link (FK + composite unique constraint)
        IaRole role = new IaRole();
        role.setCode("ADMIN");
        role.setName("Administrator");
        em.persist(role);

        IaPermission perm = new IaPermission();
        perm.setCode("USER_READ");
        perm.setName("Read user");
        em.persist(perm);

        IaRolePermission rp = new IaRolePermission();
        rp.setRole(role);
        rp.setPermission(perm);
        em.persist(rp);
        em.flush();
        em.clear();

        IaRolePermission link = em.find(IaRolePermission.class, rp.getId());
        assertThat(link.getRole().getId()).isEqualTo(role.getId());
        assertThat(link.getPermission().getId()).isEqualTo(perm.getId());

        // JSON column (before_data / after_data)
        IaAuditLog log = new IaAuditLog();
        log.setAction("CREATE");
        log.setEntityType("IaAccount");
        log.setEntityId(saved.getId());
        Map<String, Object> after = new HashMap<>();
        after.put("username", "admin");
        after.put("status", "ACTIVE");
        log.setAfterData(after);
        em.persist(log);
        em.flush();
        em.clear();

        IaAuditLog audit = em.find(IaAuditLog.class, log.getId());
        assertThat(audit.getAfterData()).containsEntry("username", "admin");
    }
}
