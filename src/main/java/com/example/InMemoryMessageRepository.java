/*
 * Copyright 2012-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

/**
 * @author Dave Syer
 */
@Profile("memory")
@Repository
public class InMemoryMessageRepository implements MessageRepository {

	private static AtomicLong counter = new AtomicLong();

	private final ConcurrentMap<String, Message> messages = new ConcurrentHashMap<String, Message>();
	
	@Override
	public List<Message> findAll() {
		return new ArrayList<Message>(this.messages.values());
	}

	@Override
	public Message save(Message message) {
		String sId = message.getId();
		
		if (sId == null) {
			sId = String.valueOf(counter.incrementAndGet());
			message.setId(sId);
		}
		
		this.messages.put(sId, message);
		
		return message;
	}

	@Override
	public Message findOne(String id) {
		return this.messages.get(id);
	}

	@Override
	public void delete(Message message) {
		this.messages.remove(message.getId());
	}
}