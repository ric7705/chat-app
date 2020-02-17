package com.ric7705.app.service;

import com.ric7705.app.controller.param.MessageParam;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class MessageServiceImpl implements MessageService {
    @Override
    public Flux<MessageParam> getMessage(String id) {

        MessageParam mock = new MessageParam();
        mock.setFrom("user1");
        mock.setTo("user2");


        Flux<MessageParam> res = Flux.just(mock);
        return res;
    }

    @Override
    public void createMessage(MessageParam messageParam) {




    }
}
