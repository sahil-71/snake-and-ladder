package com.example.demo;

import com.example.demo.model.Board;
import com.example.demo.model.Dice;
import com.example.demo.model.Ladder;
import com.example.demo.model.Player;
import com.example.demo.model.Snake;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Random;

public class Game {
  private static final Logger log = LoggerFactory.getLogger(Game.class); // Manually define logger

  private Dice dice;
  private Random random;
  private List<Player> players;
  private Board board;

  public Game(Dice dice, Random random, List<Player> players, Board board) {
    this.dice = dice;
    this.random = random;
    this.players = players;
    this.board = board;
  }

  public Dice getDice() {
    return dice;
  }

  public void setDice(Dice dice) {
    this.dice = dice;
  }

  public Random getRandom() {
    return random;
  }

  public void setRandom(Random random) {
    this.random = random;
  }

  public List<Player> getPlayers() {
    return players;
  }

  public void setPlayers(List<Player> players) {
    this.players = players;
  }

  public Board getBoard() {
    return board;
  }

  public void setBoard(Board board) {
    this.board = board;
  }

  public void movePlayer(Player player, int move) {
    int originalPos = player.getPosition();

    int pos = originalPos + move;
    if (pos > board.getMaxCell()) return;
    boolean hasJump = false;
    for (Snake snake : board.getSnakes()) {
      if (snake.getHead() == pos) {
        pos = snake.getTail();
        hasJump = true;
        break;
      }
    }
    if (!hasJump) {
      for (Ladder ladder : board.getLadders()) {
        if (ladder.getBottom() == pos) {
          pos = ladder.getTop();
          break;
        }
      }
    }
    player.setPosition(pos);
  }

  public void play() {
    int move = 0;
    boolean gameEnd = false;
    while (!gameEnd) {
      for (Player player : players) {
        move = dice.rollDice();

        log.info("{} moving {} steps", player, move);
        movePlayer(player, move);
        log.info("{} turn ended", player);

        if (player.getPosition() == board.getMaxCell()) {
          gameEnd = true;
          log.info("Player {} wins the game", player);
          break;
        }
      }
    }
  }
}
