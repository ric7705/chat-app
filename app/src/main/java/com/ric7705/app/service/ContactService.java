package com.ric7705.app.service;

import com.ric7705.app.model.Contact;

import java.util.List;

public interface ContactService {

    List<String> getContactByUser(String user);
}
