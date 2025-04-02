package com.example.demo.model;

import lombok.ToString;

@ToString
public class Ladder {
  private int bottom;
  private int top;

  public Ladder(int bottom, int top) {
    this.bottom = bottom;
    this.top = top;
  }

  public int getBottom() {
    return bottom;
  }

  public void setBottom(int bottom) {
    this.bottom = bottom;
  }

  public int getTop() {
    return top;
  }

  public void setTop(int top) {
    this.top = top;
  }
}
