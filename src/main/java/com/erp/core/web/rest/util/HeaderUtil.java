package com.erp.core.web.rest.util;

import java.net.URI;
import org.springframework.http.HttpHeaders;

/**
 * Helpers for building alert/entity-creation headers used by CRUD endpoints.
 */
public final class HeaderUtil {

    public static final String ALERT_HEADER = "X-ERP-Alert";
    public static final String PARAMS_HEADER = "X-ERP-Params";

    private HeaderUtil() {
    }

    public static HttpHeaders createAlert(String applicationName, String message, String param) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(ALERT_HEADER, applicationName + ":" + message);
        headers.add(PARAMS_HEADER, param);
        return headers;
    }

    public static HttpHeaders createEntityCreationAlert(String applicationName, boolean enableTranslation, String entityName, String param) {
        String message = enableTranslation ? entityName + ".created" : "A new " + entityName + " is created";
        return createAlert(applicationName, message, param);
    }

    public static HttpHeaders createEntityDeletionAlert(String applicationName, boolean enableTranslation, String entityName, String param) {
        String message = enableTranslation ? entityName + ".deleted" : "A " + entityName + " is deleted";
        return createAlert(applicationName, message, param);
    }

    public static HttpHeaders createEntityUpdateAlert(String applicationName, boolean enableTranslation, String entityName, String param) {
        String message = enableTranslation ? entityName + ".updated" : "A " + entityName + " is updated";
        return createAlert(applicationName, message, param);
    }

    public static HttpHeaders location(URI uri) {
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uri);
        return headers;
    }
}
