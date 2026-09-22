package com.erp.core.report;

import java.util.AbstractList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * Lazy view of a DTO list as a List<Map<String, Object>>.
 * Converts each DTO to a Map on-demand during rendering iteration,
 * allowing earlier map instances to be garbage collected immediately.
 */
public class LazyDtoRowList<T> extends AbstractList<Map<String, Object>> {

    private final List<T> items;
    private final Function<T, Map<String, Object>> mapper;

    public LazyDtoRowList(List<T> items, Function<T, Map<String, Object>> mapper) {
        this.items = items != null ? items : List.of();
        this.mapper = mapper;
    }

    @Override
    public Map<String, Object> get(int index) {
        return mapper.apply(items.get(index));
    }

    @Override
    public int size() {
        return items.size();
    }
}
