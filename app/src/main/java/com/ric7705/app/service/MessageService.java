package com.ric7705.app.service;

import com.ric7705.app.controller.param.MessageParam;
import com.ric7705.app.model.Message;

import reactor.core.publisher.Flux;


public interface MessageService {

    Flux<Message> getOneToOneMessage(String user1, String user2);

    Flux<Message> getUserMessage(String to);

    void createMessage(MessageParam messageParam);

    Flux<Message> getAllMessage();
    Flux<Message> getMsgByUser(String user);
}
