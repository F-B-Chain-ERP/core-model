package com.erp.core.constants;

import com.erp.core.enums.AuthProvider;
import com.erp.core.enums.EntityStatus;

/**
 * Default values applied to columns when an entity is first persisted.
 */
public final class Defaults {

    public static final EntityStatus DEFAULT_STATUS = EntityStatus.ACTIVE;
    public static final AuthProvider DEFAULT_AUTH_PROVIDER = AuthProvider.LOCAL;
    public static final boolean DEFAULT_HAS_LOCAL_PASSWORD = true;

    private Defaults() {
    }
}
