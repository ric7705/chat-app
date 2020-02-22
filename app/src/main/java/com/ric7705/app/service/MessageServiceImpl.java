package com.ric7705.app.service;

import com.ric7705.app.controller.param.MessageParam;
import com.ric7705.app.model.Message;
import com.ric7705.app.repository.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.UUID;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageRepo messageRepo;

    @Override
    public Flux<Message> getUserMessage(String to) {

        return messageRepo.findUserMessage(to);
    }

    @Override
    public Flux<Message> getOneToOneMessage(String user1, String user2) {

//        MessageParam mock = new MessageParam();
//        mock.setFrom("user1");
//        mock.setTo("user2");

        return messageRepo.findTwoUserMessage(user1, user2);
    }

    @Override
    public void createMessage(MessageParam param) {

        Message newMsg = new Message().builder().from(param.getFrom())
                .to(param.getTo())
                .content(param.getContent())
                .id(UUID.randomUUID().toString())
                .createDate(new Date())
                .build();

        messageRepo.save(newMsg).subscribe();
    }

    @Override
    public Flux<Message> getAllMessage(){
        return messageRepo.findAll();
    }

    @Override
    public Flux<Message> getMsgByUser(String user) {
        return messageRepo.findByFromOrTo(user, user);
    }
}
