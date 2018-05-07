package pt.isel.poo.boxes;



import java.io.*;
import java.util.Scanner;

/**
 * Acts as the "Model" for the application in the MVC division standard.
 */
 class Boxes {
    private static final int MAX_POSITIONS = 1000 ;
    private Type[][] boxGrid;
    private static int height;
    private static int width;
    private static int level;
    private static int points;
    private Listener listener = null;
    private int highScore = 0;
    private int[] positions = new int[MAX_POSITIONS];
    private char[] name = {'N', 'O', 'N', 'A', 'M', 'E'};


    Boxes() {
        createGrid(3, 2, 1, 0);
    }




    public interface Listener {
        void onPointsChanged(int points);

        void onHighscoreChanged(int points);
    }

    void setListener(Listener l) {
        listener = l;
    }

    enum Type {
        VISIBLE, INVISIBLE, NEW;

    }

    void touch(int l, int c) {
        switch (boxGrid[l][c]) {
            case NEW:
                points++;
                listener.onPointsChanged(points);
                boxGrid[l][c] = Type.VISIBLE;
                if (!isOver()) {
                    createRandomNew();
                    return;
                }
                nextLevel();
                createGrid(height, width, level, points);
                break;
            case VISIBLE:
                if (points > highScore)
                    listener.onHighscoreChanged(points);
                createGrid(3, 2, 1, 0);
                listener.onPointsChanged(points);
        }

    }

    private void nextLevel() {
        ++level;
        if (level % 2 == 0) ++height;
        else ++width;

    }

    private boolean isOver() {
        for (int l = 0; l < height; l++) {
            for (int c = 0; c < width; c++) {
                if (isInvisible(l, c) || isNew(l, c))
                    return false;
            }
        }
        return true;
    }

    private void createRandomNew() {
        int randomC, randomL;
        do {
            randomC = getRandom(width);
            randomL = getRandom(height);
        } while (boxGrid[randomL][randomC] != Type.INVISIBLE);
        boxGrid[randomL][randomC] = Type.NEW;
    }

    int getPoints() {
        return points;
    }

    void setPoints(int points) {
        this.points = points;
    }

    int getLevel(){
        return level;
    }

    int getHighscore() {
        return highScore;
    }

    void setHighscore(int point) {
        highScore = point;
    }

    public String getName() {
        return String.valueOf(name);
    }

    public void setName(String name) {
        this.name = name.toCharArray();
    }

    int getBoardHeight() {
        return height;
    }

    int getBoardWidth() {
        return width;
    }

    int[] getPosition() {
        return positions;
    }

     void createGrid(int h, int w, int lev, int p) {
        height = h;
        width = w;
        points = p;
        level = lev;
        boxGrid = new Type[height][width];
        for (int l = 0; l < height; l++) {
            for (int c = 0; c < width; c++) {
                boxGrid[l][c] = Type.INVISIBLE;
            }
        }
        createRandomNew();
    }

    private int getRandom(int maxValue) {
        return (int) (Math.random() * maxValue);
    }


    boolean isInvisible(int l, int c) {
        return boxGrid[l][c] == Type.INVISIBLE;
    }

    private boolean isNew(int l, int c) {
        return boxGrid[l][c] == Type.NEW;
    }

    void savePositions() {
        int i = 0;
        for (int l = 0; l < height; l++) {
            for (int c = 0; c < width; c++) {
                int position = boxGrid[l][c].ordinal();
                positions[i] = position;
                ++i;
            }
        }
    }

    void loadPositions(int[] positions) {
        int i = 0;
        for (int l = 0; l < height; l++) {
            for (int c = 0; c < width; c++) {
                boxGrid[l][c] =  Type.values()[positions[i]];
                ++i;
            }
        }
    }
}
