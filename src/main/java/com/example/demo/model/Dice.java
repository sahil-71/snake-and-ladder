package com.example.demo.model;

import lombok.ToString;

import java.util.Random;
@ToString
public class Dice {
  private int minVal;
  private int maxVal;
  private Random random;

  public int rollDice() {
    return random.nextInt(minVal, maxVal + 1);
  }

  public Dice(int minVal, int maxVal, Random random) {
    this.minVal = minVal;
    this.maxVal = maxVal;
    this.random = random;
  }

  public int getMinVal() {
    return minVal;
  }

  public void setMinVal(int minVal) {
    this.minVal = minVal;
  }

  public int getMaxVal() {
    return maxVal;
  }

  public void setMaxVal(int maxVal) {
    this.maxVal = maxVal;
  }

  public Random getRandom() {
    return random;
  }

  public void setRandom(Random random) {
    this.random = random;
  }
}
