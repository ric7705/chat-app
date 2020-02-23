package com.ric7705.app.controller;

import com.ric7705.app.controller.param.MessageParam;
import com.ric7705.app.model.Message;
import com.ric7705.app.repository.MessageRepo;
import com.ric7705.app.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;


@RestController
@RequestMapping("/message")
@CrossOrigin(value = "http://localhost:4200")
public class MessageController {

    @Autowired
    MessageService messageService;

    @Autowired
    MessageRepo messageRepo;

    @GetMapping("/test")
    public String echoHello(){
        return "Hello test";
    }

    @PostMapping
    public void createMessage(@RequestBody MessageParam messageParam){
        messageService.createMessage(messageParam);
    }
//
//    @GetMapping(value = "/{user}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
//    public Flux<Message> getUserMessage(@PathVariable String user){
//       return messageService.getUserMessage(user);
//    }

    @GetMapping(value = "/pm/{user1}/{user2}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Message> getOneToOneMessage(@PathVariable String user1, @PathVariable String user2){
        return messageService.getOneToOneMessage(user1, user2);
    }

    @GetMapping(value = "/all", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Message> getMessage(){
        return messageService.getAllMessage();
    }

    @GetMapping(value = "/{user}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Message> getUserMessage2(@PathVariable String user){
        return messageRepo.findByFromOrTo(user, user);

//        return messageService.getUserMessage(user);

    }


}
