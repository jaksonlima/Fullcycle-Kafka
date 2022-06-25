package com.kafka.model;

import java.io.Serializable;

public class Pessoa implements Serializable {
  private String id;
  private String name;
  private String email;

  public Pessoa() {
  }

  public Pessoa(String id, String name, String email) {
    this.id = id;
    this.name = name;
    this.email = email;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    return "Pessoa [email=" + email + ", id=" + id + ", name=" + name + "]";
  }
}