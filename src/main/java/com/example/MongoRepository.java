/**
 * 
 */
package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

/**
 * @author Usuario
 *
 */

@Profile("mongo")
@Repository
public class MongoRepository implements MessageRepository {
	
	@Autowired
	private MongoMessageRepository mongoMessageRepository;

	@Override
	public List<Message> findAll() {
		return mongoMessageRepository.findAll();
	}

	@Override
	public Message save(Message message) {
		return mongoMessageRepository.save(message);
	}

	@Override
	public Message findOne(String id) {
		return mongoMessageRepository.findOne(id);
	}

	@Override
	public void delete(Message message) {
		mongoMessageRepository.delete(message);		
	}
	
	
}
