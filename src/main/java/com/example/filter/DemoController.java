package com.example.filter;

import io.micronaut.http.HttpMessage;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.context.ServerRequestContext;
import io.reactivex.Single;

import javax.inject.Inject;

/**
 * @author Guillaume Gerbaud
 */
@Controller("/demo")
public class DemoController {

	@Inject
	private NotWorkingDemoClient notWorkingDemoClient;
	@Inject
	private WorkingDemoClient workingDemoClient;

	@Get("/hello/ok")
	public Single<String> sayHelloOk() {
		return workingDemoClient.sayWho()
				.map(who -> "Hello " + who + " !");
	}

	@Get("/hello/ko")
	public Single<String> sayHello() {
		return notWorkingDemoClient.sayWho()
				.map(who -> "Hello " + who + " !");
	}

	@Get("/who")
	public Single<String> sayWho() {
		boolean filterA = ServerRequestContext.currentRequest().map(HttpMessage::getHeaders).flatMap(h -> h.findFirst("x-filter-a")).isPresent();
		boolean filterB = ServerRequestContext.currentRequest().map(HttpMessage::getHeaders).flatMap(h -> h.findFirst("x-filter-b")).isPresent();
		if(!filterA || !filterB) {
			return Single.error(new RuntimeException("need filters"));
		}
		return Single.just("World");
	}
}
