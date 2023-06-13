package Testy;

import GameLogic.Loader;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoaderTest {
Loader loader=new Loader();
    @org.junit.Test
    void loadLevels() {
        loader.loadLevels("");
    }

    @Test
    void load() {
       loader.loadLevels();
    }
}