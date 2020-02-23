package com.ric7705.app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;

@Data
@Builder

@NoArgsConstructor
@AllArgsConstructor
@Document
public class Contact {

    @Id
    private String id;
    private String username;
    private List<String> contact;

}
