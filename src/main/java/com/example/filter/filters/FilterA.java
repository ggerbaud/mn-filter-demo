package com.example.filter.filters;

import io.micronaut.http.annotation.FilterMatcher;

import java.lang.annotation.*;

/**
 * @author Guillaume Gerbaud
 */
@FilterMatcher
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface FilterA {
}
