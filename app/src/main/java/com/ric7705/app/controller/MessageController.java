package com.ric7705.app.controller;

import com.ric7705.app.controller.param.MessageParam;
import com.ric7705.app.model.Message;
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

    @GetMapping("/test")
    public String echoHello(){
        return "Hello test";
    }

    @PostMapping
    public void createMessage(@RequestBody MessageParam messageParam){
        messageService.createMessage(messageParam);
    }

    @GetMapping(value = "/{to}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Message> getMessage(@PathVariable String to){
       return messageService.getMessage(to);
    }

    @GetMapping(value = "/all", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Message> getMessage(){
        return messageService.getAllMessage();
    }

}
