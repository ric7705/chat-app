package com.ric7705.app.repository;

import com.ric7705.app.model.Message;
import org.springframework.data.mongodb.repository.Tailable;
import reactor.core.publisher.Flux;

public interface CustomMessageRepo {

    Flux<Message> findTwoUserMessage(String user1, String user2);

    Flux<Message> findUserMessage(String user);

}
