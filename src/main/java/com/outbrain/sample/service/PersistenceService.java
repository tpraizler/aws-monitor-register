package com.outbrain.sample.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.outbrain.sample.model.UserInfo;

@Repository
public class PersistenceService {
  private static final Logger logger = LoggerFactory.getLogger(PersistenceService.class);
  public static final String COLLECTION_NAME = "DETAILS";

  @Autowired
  private MongoTemplate mongoTemplate;

  public void persist(final UserInfo info) {

    if (!mongoTemplate.collectionExists(UserInfo.class)) {
      mongoTemplate.createCollection(UserInfo.class);
    }
    final String shortPhoneNumber = info.getPhone().substring(1);
    info.setPhone("+972" + shortPhoneNumber);
    System.out.println("new Phone saved to mongo: +972" + shortPhoneNumber);
    mongoTemplate.insert(info, COLLECTION_NAME);
  }
}
