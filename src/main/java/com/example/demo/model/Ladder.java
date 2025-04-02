package com.example.demo.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Ladder {
  private int bottom;
  private int top;
}
