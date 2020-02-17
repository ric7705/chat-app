package com.ric7705.app.service;

import com.ric7705.app.controller.param.MessageParam;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;


public interface MessageService {

    Flux<MessageParam> getMessage(String id);

    void createMessage(MessageParam messageParam);
}
