package com.example.demo;

import com.example.demo.model.Board;
import com.example.demo.model.Dice;
import com.example.demo.model.Player;
import java.util.List;
import java.util.Random;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class DemoApplication {
  private static final Logger log = LoggerFactory.getLogger(DemoApplication.class); // Manually define logger


  public static void main(String[] args) {
    Random random = new Random();

    Board board = new Board(100, random);

    board.setLadders(board.buildLadders(5));
    board.setSnakes(board.buildSnakes(5));

    log.info("Board is {}", board);

    Dice dice = new Dice(0, 6, random);
    Game game = new Game(dice, random, List.of(new Player(0, 0), new Player(1, 0)), board);

    game.play();
  }
}
