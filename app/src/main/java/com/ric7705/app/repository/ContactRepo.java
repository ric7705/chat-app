package com.ric7705.app.repository;

import com.ric7705.app.model.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ContactRepo extends MongoRepository<Contact, Long> {

    Contact findOneByUsername(String username);
}
