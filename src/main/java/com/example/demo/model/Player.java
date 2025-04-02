package com.example.demo.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Player {
  private int id;
  private int position = 0;
}
