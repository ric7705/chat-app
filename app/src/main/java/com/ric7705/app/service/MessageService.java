package com.ric7705.app.service;

import com.ric7705.app.controller.param.MessageParam;
import com.ric7705.app.model.Message;

import reactor.core.publisher.Flux;


public interface MessageService {

    Flux<Message> getMessage(String id);

    void createMessage(MessageParam messageParam);

    Flux<Message> getAllMessage();
}
