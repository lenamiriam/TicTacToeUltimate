package com.example.tictactoeultimate;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class AI implements IGameObject {

    private Minimax minimax;
    private Ultimate ultimate;
    private Grid grid;
    private Grid mainGrid;

    private int timedelay = 10;
    private int currentTime;
    private boolean beginTimer;

    private int currentTurn = 0;


    public AI(Grid grid, Ultimate ultimate) {
        this.mainGrid = grid;
        minimax = new Minimax();
        this.ultimate = ultimate;
    }

    public void makeMove() {
        currentTime = 0;
        beginTimer = true;
    }

    @Override
    public void update(float deltaTime) {
        if(!beginTimer) {
            return;
        }
        currentTime += deltaTime;
        if(currentTime >= timedelay) {
            grid.setMarkerIndex(currentTurn);
            int move = minimax.getBestMove(grid.getMarkers(), currentTurn);
            int x = move % Main.ROWS;
            int y = move / Main.ROWS;
            grid.placeMarker(move);

            ultimate.setActiveGrid(x, y);
            beginTimer = false;

            if(grid.getWinner() >= 0) {
                mainGrid.placeMarker(grid.getX(), grid.getY(), grid.getWinner());
            }
        }
    }

    @Override
    public void render(Graphics2D graphicsRender) {
    }

    public boolean isMoving() {
        return beginTimer;
    }

    public void setTurn(Grid grid, int turn) {
        this.grid = grid;
        this.currentTurn = turn;
    }

    public void makeMove(ArrayList<Grid> grids, boolean multipleGridsActive, int turn) {
        this.currentTurn = turn;
        if(multipleGridsActive) {
            //todo find perfect spot in main grid
            int bestMainGridMove = minimax.getBestMove(mainGrid.getMarkers(), turn);
            setTurn(grids.get(bestMainGridMove), turn);
        } else {
            // move in current active grid
            for (Grid grid : grids) {
                if(grid.isActive()) {
                    setTurn(grid, turn);
                }
            }
        }
        makeMove();
    }
}