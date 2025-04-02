package com.example.demo.model;

import lombok.ToString;

@ToString
public class Player {
  private int id;
  private int position;

  public Player(int id, int position) {
    this.id = id;
    this.position = position;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getPosition() {
    return position;
  }

  public void setPosition(int position) {
    this.position = position;
  }
}
