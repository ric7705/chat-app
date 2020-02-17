package com.ric7705.app.repository;

import com.ric7705.app.model.Message;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface MessageRepo extends ReactiveMongoRepository<Message, Long> {

    Flux<Message> findAllByTo(String to);
}
