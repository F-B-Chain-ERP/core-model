package com.erp.core.web.rest.util;

import static org.assertj.core.api.Assertions.assertThat;

import com.erp.core.domain.IaAccount;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;

class PaginationUtilTest {

    @Test
    void generatesTotalCountAndLinkHeaders() {
        var page = new PageImpl<IaAccount>(List.of(), PageRequest.of(0, 10), 42);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "http://localhost/api/accounts");

        assertThat(headers.getFirst(PaginationUtil.HEADER_X_TOTAL_COUNT)).isEqualTo("42");
        String link = headers.getFirst(PaginationUtil.HEADER_LINK);
        assertThat(link).contains("rel=\"next\"");
        assertThat(link).contains("rel=\"last\"");
    }
}
