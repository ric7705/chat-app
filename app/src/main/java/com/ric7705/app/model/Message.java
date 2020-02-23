package com.ric7705.app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Data
@Builder

@NoArgsConstructor
@AllArgsConstructor
@Document(value = "message")
public class Message {

    @Id
    private String id;
    private String content;
    private String from;
    private String to;

    @Field("create_date")
    private Date createDate;

}
