package com.outbrain.sample.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class UserInfo {

  private String name;
  @Id
  private String phone;
  private String accessKey;
  private String secretAccessKey;

  public UserInfo(final String name, final String phone, final String accessKey, final String secretAccessKey) {
    this.name = name;
    this.phone = phone;
    this.accessKey = accessKey;
    this.secretAccessKey = secretAccessKey;
  }

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public String getAccessKey() {
    return accessKey;
  }

  public void setAccessKey(final String accessKey) {
    this.accessKey = accessKey;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(final String phone) {
    this.phone = phone;
  }

  public String getSecretAccessKey() {
    return secretAccessKey;
  }

  public void setSecretAccessKey(final String secretAccessKey) {
    this.secretAccessKey = secretAccessKey;
  }
}
