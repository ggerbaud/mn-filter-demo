package com.example.filter.filters;

import java.lang.annotation.*;

/**
 * @author Guillaume Gerbaud
 */
@FilterA
@FilterB
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface AllFilters {
}
