package com.example.demo;

import com.example.demo.model.Board;
import com.example.demo.model.Player;
import com.example.demo.util.Utils;
import jakarta.annotation.PostConstruct;
import java.util.List;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
@RequiredArgsConstructor
public class DemoApplication {

  private final Utils utils;

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

  @PostConstruct
  public void playGame() {
    Board board =
        Board.builder().snakes(utils.buildSnakes(5)).ladders(utils.buildLadders(5)).build();

    log.info("Board is {}", board);

    Game game =
        Game.builder()
            .random(new Random())
            .players(List.of(Player.builder().id(0).build(), Player.builder().id(1).build()))
            .board(board)
            .build();

    game.play();
  }
}
