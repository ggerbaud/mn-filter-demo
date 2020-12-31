package com.example.filter;

import com.example.filter.filters.FilterA;
import com.example.filter.filters.FilterB;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import io.reactivex.Single;

/**
 * @author Guillaume Gerbaud
 */
@FilterA
@FilterB
@Client("/demo")
public interface WorkingDemoClient {
	@Get("/who")
	Single<String> sayWho();
}
