package com.cash.history.utils;

import javax.validation.constraints.NotNull;

public class Coalescing {
    @SafeVarargs
    @NotNull
    public static <T> T firstNotNull(T... values) {
        /*
         * firstNotNull
         * eg: firstNotNull(optionalValue, secondOptionalValue, "default value")
         * return first not null value, to avoid exceptions put a hardcoded value
         * as last parameter.
         */
        for (T value : values) if (value != null) return value;
        return values[values.length - 1];
    }
}
