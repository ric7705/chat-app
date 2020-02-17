package com.ric7705.app.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Document
public class Message {

    @Id
    private Long id;
    private String title;
    private String content;
    private String from;
    private String to;

    @Field("create_date")
    private Date createDate;

}
