/*
 * Copyright 2002-2020 the original author or authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.cloud.appbroker.acceptance;

import reactor.core.publisher.Mono;

import org.springframework.cloud.appbroker.manager.BackingAppManagementService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * A controller for testing the {@link BackingAppManagementService}
 */
@RestController
public class ManagementController {

	private final BackingAppManagementService service;

	/**
	 * Construct a new {@literal ManagementController}
	 *
	 * @param service the service to test
	 */
	public ManagementController(BackingAppManagementService service) {
		this.service = service;
	}

	/**
	 * Tests service start
	 *
	 * @param serviceInstanceId the id of the service to test
	 * @return a response
	 */
	@GetMapping("/start/{serviceName}/{planName}/{serviceInstanceId}")
	public Mono<String> startApplications(
		@PathVariable String serviceInstanceId,
		@PathVariable String serviceName,
		@PathVariable String planName
	) {
		return service.start(serviceInstanceId, serviceName, planName)
			.thenReturn("starting " + serviceInstanceId);
	}

	/**
	 * Tests service stop
	 *
	 * @param serviceInstanceId the id of the service to test
	 * @return a response
	 */
	@GetMapping("/stop/{serviceName}/{planName}/{serviceInstanceId}")
	public Mono<String> stopApplications(
		@PathVariable String serviceInstanceId,
		@PathVariable String serviceName,
		@PathVariable String planName
	) {
		return service.stop(serviceInstanceId, serviceName, planName)
			.thenReturn("stopping " + serviceInstanceId);
	}

	/**
	 * Tests service restart
	 *
	 * @param serviceInstanceId the id of the service to test
	 * @return a response
	 */
	@GetMapping("/restart/{serviceName}/{planName}/{serviceInstanceId}")
	public Mono<String> restartApplications(
		@PathVariable String serviceInstanceId,
		@PathVariable String serviceName,
		@PathVariable String planName
	) {
		return service.restart(serviceInstanceId, serviceName, planName)
			.thenReturn("restarting " + serviceInstanceId);
	}

	/**
	 * Tests service restage
	 *
	 * @param serviceInstanceId the id of the service to test
	 * @return a response
	 */
	@GetMapping("/restage/{serviceName}/{planName}/{serviceInstanceId}")
	public Mono<String> restageApplications(
		@PathVariable String serviceInstanceId,
		@PathVariable String serviceName,
		@PathVariable String planName
	) {
		return service.restage(serviceInstanceId, serviceName, planName)
			.thenReturn("restaging " + serviceInstanceId);
	}

}
