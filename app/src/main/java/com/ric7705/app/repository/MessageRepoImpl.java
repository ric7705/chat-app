package com.ric7705.app.repository;

import com.mongodb.reactivestreams.client.MongoClient;
import com.ric7705.app.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.Tailable;
import reactor.core.publisher.Flux;

public class MessageRepoImpl implements CustomMessageRepo {
    @Autowired
    ReactiveMongoTemplate reactiveMongoTemplate;

    @Override
//    @Tailable
    public Flux<Message> findTwoUserMessage(String user1, String user2){
        Query q = new Query();
        Criteria criteria = new Criteria();

        criteria.orOperator(Criteria.where("from").is(user1).and("to").is(user2) ,Criteria.where("from").is(user2).and("to").is(user1));

        q.addCriteria(criteria);

        System.out.println(q);
        return reactiveMongoTemplate.find(q, Message.class);

    }

    @Override
    public Flux<Message> findUserMessage(String user) {
        Query q = new Query();
        Criteria criteria = new Criteria();

        criteria.orOperator(Criteria.where("from").is(user), Criteria.where("to").is(user));

        q.addCriteria(criteria);

        System.out.println(q);
        return reactiveMongoTemplate.find(q, Message.class);
    }
}
