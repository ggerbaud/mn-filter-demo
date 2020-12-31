package com.example.filter.filters;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MutableHttpRequest;
import io.micronaut.http.filter.ClientFilterChain;
import io.micronaut.http.filter.HttpClientFilter;
import org.reactivestreams.Publisher;

import javax.inject.Singleton;

/**
 * @author Guillaume Gerbaud
 */
@FilterA
@Singleton
public class MyAFilter implements HttpClientFilter {
	@Override
	public Publisher<? extends HttpResponse<?>> doFilter(MutableHttpRequest<?> request, ClientFilterChain chain) {
		return chain.proceed(request.header("x-filter-a", "OK"));
	}
}
