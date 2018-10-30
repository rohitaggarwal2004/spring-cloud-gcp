/*
 *  Copyright 2018 original author or authors.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gcp.pubsub.support.converter.JacksonPubSubMessageConverter;
import org.springframework.context.annotation.Bean;

/**
 * Entry point into the sample application.
 *
 * @author Daniel Zou
 */
@SpringBootApplication
public class PubSubJsonPayloadApplication {

	private static final String EXAMPLE_TOPIC_NAME = "exampleTopic";

	private static final String EXAMPLE_SUBSCRIPTION_NAME = "exampleSubscription";

	public static void main(String[] args) {
		SpringApplication.run(PubSubJsonPayloadApplication.class, args);
	}

	/**
	 * This bean enables serialization/deserialization of Java objects to JSON allowing you
	 * utilize JSON message payloads in Cloud Pub/Sub.
	 */
	@Bean
	public JacksonPubSubMessageConverter jacksonPubSubMessageConverter() {
		return new JacksonPubSubMessageConverter(new ObjectMapper());
	}
}