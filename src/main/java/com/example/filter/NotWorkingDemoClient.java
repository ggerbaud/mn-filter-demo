package com.example.filter;

import com.example.filter.filters.AllFilters;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import io.reactivex.Single;

/**
 * @author Guillaume Gerbaud
 */
@AllFilters
@Client("/demo")
public interface NotWorkingDemoClient {
	@Get("/who")
	Single<String> sayWho();
}
