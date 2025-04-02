package com.example.demo;

import com.example.demo.model.Board;
import com.example.demo.model.Ladder;
import com.example.demo.model.Player;
import com.example.demo.model.Snake;
import java.util.List;
import java.util.Random;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Builder
public class Game {

  private Random random;
  private List<Player> players;
  private Board board;

  public int rollDice() {
    return random.nextInt(6) + 1;
  }

  public void movePlayer(Player player, int move) {
    int originalPos = player.getPosition();

    int pos = originalPos + move;
    if (pos > 100) return;
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
        move = rollDice();

        log.info("Player {} moving {} steps", player, move);
        movePlayer(player, move);
        log.info("Player {} turn ended", player);

        if (player.getPosition() == 100) {
          gameEnd = true;
          log.info("Player {} wins the game", player);
          break;
        }
      }
    }
  }
}
