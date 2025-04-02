package com.example.demo.util;

import com.example.demo.model.Ladder;
import com.example.demo.model.Snake;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import org.springframework.stereotype.Service;

@Service
public class Utils {
  private static final Random random = new Random();
  private static final Set<Integer> occupied = new HashSet<>(Set.of(100));

  public List<Snake> buildSnakes(int size) {
    List<Snake> snakes = new ArrayList<>();
    while (snakes.size() < size) {
      int head = getNextRandom();
      int tail = getNextRandom();

      if (!occupied.contains(head) && head > tail) {
        snakes.add(Snake.builder().head(head).tail(tail).build());
        occupied.add(head);
      }
    }
    return snakes;
  }

  public List<Ladder> buildLadders(int size) {
    List<Ladder> ladders = new ArrayList<>();
    while (ladders.size() < size) {
      int top = getNextRandom();
      int bottom = getNextRandom();

      if (!occupied.contains(bottom) && top > bottom) {
        ladders.add(Ladder.builder().top(top).bottom(bottom).build());
        occupied.add(bottom);
      }
    }
    return ladders;
  }

  private int getNextRandom() {
    return random.nextInt(100) + 1;
  }
}
