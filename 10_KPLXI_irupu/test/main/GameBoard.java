package main;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GameBoard {
    Game game;

    @Before
    public void before() {
        game = new Game(null);
    }

    @Test
    public void blockPlacement() {
        Assert.assertTrue(game.addBlock(new Figure(1, 1, false)));

    }
}
