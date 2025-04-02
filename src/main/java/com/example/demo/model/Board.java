package com.example.demo.model;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Board {

  private List<Snake> snakes;
  private List<Ladder> ladders;
}
