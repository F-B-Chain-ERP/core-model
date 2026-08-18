package com.erp.core.web.rest.util;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Builds pagination headers ({@code X-Total-Count} and {@code Link}) following
 * the pattern used by Spring Data REST / JHipster clients.
 */
public final class PaginationUtil {

    public static final String HEADER_X_TOTAL_COUNT = "X-Total-Count";
    public static final String HEADER_LINK = "Link";

    private PaginationUtil() {
    }

    public static <T> HttpHeaders generatePaginationHttpHeaders(Page<T> page, String baseUrl) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HEADER_X_TOTAL_COUNT, Long.toString(page.getTotalElements()));
        headers.add(HEADER_LINK, buildLinkHeader(page, baseUrl));
        return headers;
    }

    private static <T> String buildLinkHeader(Page<T> page, String baseUrl) {
        List<String> links = new ArrayList<>();
        int pageNumber = page.getNumber();
        int totalPages = page.getTotalPages();
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(baseUrl);
        if (pageNumber > 0) {
            links.add(buildLink(builder, 0, "first"));
        }
        if (page.hasPrevious()) {
            links.add(buildLink(builder, pageNumber - 1, "prev"));
        }
        if (page.hasNext()) {
            links.add(buildLink(builder, pageNumber + 1, "next"));
        }
        if (pageNumber < totalPages - 1) {
            links.add(buildLink(builder, totalPages - 1, "last"));
        }
        return String.join(", ", links);
    }

    private static String buildLink(UriComponentsBuilder builder, int page, String rel) {
        return "<" + builder.replaceQueryParam("page", page).toUriString() + ">; rel=\"" + rel + "\"";
    }
}
