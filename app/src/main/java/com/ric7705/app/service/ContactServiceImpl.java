package com.ric7705.app.service;

import com.ric7705.app.model.Contact;
import com.ric7705.app.repository.ContactRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    ContactRepo contactRepo;

    @Override
    public List<String> getContactByUser(String user) {

        Contact contact = contactRepo.findOneByUsername(user);

        System.out.println(contact);
        return contact.getContact();
    }
}
