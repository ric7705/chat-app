package com.ric7705.app.repository;

import com.ric7705.app.model.Message;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
//public interface MessageRepo extends ReactiveMongoRepository<Message, Long> {
public interface MessageRepo extends ReactiveMongoRepository<Message, Long>, CustomMessageRepo {


//  to enable Tailable, we need to define findAll method by ourselves
    @Override
    default Flux<Message> findAll(){
        return findMessageBy();
    }

    @Tailable
    Flux<Message> findMessageBy();

    @Tailable
    Flux<Message> findByFromOrTo(String user1, String user2);


}
