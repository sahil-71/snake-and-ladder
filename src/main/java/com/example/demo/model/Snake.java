package com.example.demo.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Snake {
  private int head;
  private int tail;
}
