package com.example.servlets;

import java.util.Random;

/**
 *
 * @author Student
 */
public class NumberHunter {

    int level = 1;
    int randomNumber = 0;
    int tryCount = 10;

    int defaultRange = 100;

    public void levelUp() {
        tryCount = 10;
        level++;
        randomNumber = new Random().nextInt(defaultRange * level);
    }

    public void gameOver() {
        level = 1;
        randomNumber = new Random().nextInt(defaultRange);
        tryCount = 10;
    }

    @Override
    public String toString() {
        return "NumberHunter{" + "level=" + level + ", randomNumber=" + randomNumber + ", tryCount=" + tryCount + ", defaultRange=" + defaultRange + '}';
    }
    
}
