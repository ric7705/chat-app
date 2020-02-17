package com.ric7705.app.controller.param;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@Builder

@NoArgsConstructor
@AllArgsConstructor
public class MessageParam {

    private Long id;
    private String title;
    private String content;
    private String from;
    private String to;
    private Date createDate;

}
