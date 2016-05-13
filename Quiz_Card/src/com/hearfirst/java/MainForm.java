package com.hearfirst.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm {
    public static void main(String[] args) {
        JFrame frame = new JFrame("QuizCard");
        JPanel jPanel = new JPanel();
        JButton cardBuilder = new JButton("Card Builder");
        JButton cardPlayer = new JButton("Card Player");
        jPanel.add(BorderLayout.EAST,cardBuilder);
        jPanel.add(BorderLayout.WEST,cardPlayer);

        cardBuilder.addActionListener(new CardBuilderListner());
        cardPlayer.addActionListener(new CardPlayerListner());

        frame.getContentPane().add(jPanel);
        frame.setSize(300,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private static class CardBuilderListner implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            QuizCardBuilder qb = new QuizCardBuilder();
            qb.go();
        }
    }

    private static class CardPlayerListner implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            QuizCardPlayer qp = new QuizCardPlayer();
            qp.go();

        }
    }

}
