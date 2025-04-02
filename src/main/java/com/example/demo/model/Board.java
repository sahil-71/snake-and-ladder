package com.example.demo.model;

import lombok.ToString;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

@ToString
public class Board {
  private int maxCell;
  private Random random;
  private List<Snake> snakes;
  private List<Ladder> ladders;
  private Set<Integer> occupied;

  public Board(int maxCell, Random random) {
    this.maxCell = maxCell;
    this.random = random;
    this.occupied = new HashSet<>(Set.of(maxCell));
  }

  public Set<Integer> getOccupied() {
    return occupied;
  }

  public void setOccupied(Set<Integer> occupied) {
    this.occupied = occupied;
  }

  public int getMaxCell() {
    return maxCell;
  }

  public void setMaxCell(int maxCell) {
    this.maxCell = maxCell;
  }

  public List<Snake> getSnakes() {
    return snakes;
  }

  public void setSnakes(List<Snake> snakes) {
    this.snakes = snakes;
  }

  public List<Ladder> getLadders() {
    return ladders;
  }

  public void setLadders(List<Ladder> ladders) {
    this.ladders = ladders;
  }

  public List<Snake> buildSnakes(int size) {
    List<Snake> snakes = new ArrayList<>();
    while (snakes.size() < size) {
      int head = getNextRandom();
      int tail = getNextRandom();

      if (!occupied.contains(head) && head > tail) {
        snakes.add(new Snake(head, tail));
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
        ladders.add(new Ladder(bottom, top));
        occupied.add(bottom);
      }
    }
    return ladders;
  }

  private int getNextRandom() {
    return random.nextInt(this.getMaxCell()) + 1;
  }
}
