package com.example.tictactoeultimate;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Main {

    public static int WIDTH = 500;
    public static int HEIGHT = 500;

    public static int ROWS = 3;
    public static int MATCH = 3;
    public static int SIZE = ROWS * ROWS;

    public static void main(String[] args) {

        JFrame frameSettings = new JFrame("Game-Settings");

        JLabel labelDifficulty = new JLabel("Difficulty");
        labelDifficulty.setFont(new Font("Verdana", Font.PLAIN, 11));
        labelDifficulty.setBounds(10,10,100,25);
        String[] difficulty = {"Easy", "Medium", "Hard"};
        JList<String> listDifficulty = new JList<>(difficulty);
        listDifficulty.setFont(new Font("Verdana", Font.PLAIN, 11));
        labelDifficulty.setBounds(10, 45, 100, 100);

        JLabel labelOpponent = new JLabel("Opponent");
        labelOpponent.setFont(new Font("Verdana", Font.PLAIN, 11));
        labelOpponent.setBounds(10,155,100,25);
        String[] opponent = {"Play against computer", "Play with friend"};
        JList<String> listOpponent = new JList<>(opponent);
        listOpponent.setFont(new Font("Verdana", Font.PLAIN, 11));
        listOpponent.setBounds(10, 190, 100, 100);

        JButton button = new JButton("New game");
        button.setFont(new Font("Verdana", Font.PLAIN, 11));
        button.setBounds(10,300,100,25);
        button.setBackground(Color.PINK);
        button.setFocusable(false);
        button.setBorderPainted(false);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameSettings.setVisible(false);

                JFrame frame = new JFrame("Tic-Tac-Toe");
                GamePanel game = new GamePanel(new Color(0x464646));

                frame.add(game);
                frame.addMouseListener(game);
                frame.addMouseMotionListener(game);
                frame.pack();
                frame.setResizable(false);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
                frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
                frame.setVisible(true);

            }
        });

        frameSettings.setLayout(new FlowLayout());
        frameSettings.add(labelDifficulty);
        frameSettings.add(listDifficulty);
        frameSettings.add(labelOpponent);
        frameSettings.add(listOpponent);
        frameSettings.add(button);
        frameSettings.pack();
        frameSettings.setResizable(false);
        frameSettings.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameSettings.setSize(500, 105);
        Dimension dimSettings = Toolkit.getDefaultToolkit().getScreenSize();
        frameSettings.setLocation(dimSettings.width/2-frameSettings.getSize().width/2, dimSettings.height/2-frameSettings.getSize().height/2);
        frameSettings.setVisible(true);
    }

}