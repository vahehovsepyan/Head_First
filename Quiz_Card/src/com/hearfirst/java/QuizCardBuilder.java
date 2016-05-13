package com.hearfirst.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class QuizCardBuilder {
    private JTextArea question;
    private JTextArea answer;
    private ArrayList<QuizCard> qardList;
    private JFrame frame;

    public void go(){
        frame = new JFrame("Quiz Card Builder");
        JPanel mainPanel = new JPanel();
        Font bigFont = new Font("sanserif", Font.BOLD, 24);

        question = new JTextArea(6,20);
        question.setLineWrap(true);
        question.setWrapStyleWord(true);
        question.setFont(bigFont);

        JScrollPane qScrollPane = new JScrollPane(question);
        qScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        qScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        answer = new JTextArea(6,20);
        answer.setLineWrap(true);
        answer.setWrapStyleWord(true);
        answer.setFont(bigFont);

        JScrollPane aScrollPane = new JScrollPane(answer);
        aScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        aScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        JButton nextButton = new JButton("Next Card");

        qardList = new ArrayList<>();

        JLabel qLabel = new JLabel("Question: ");
        JLabel aLabel = new JLabel("Answer: ");

        mainPanel.add(qLabel);
        mainPanel.add(qScrollPane);
        mainPanel.add(aLabel);
        mainPanel.add(aScrollPane);
        mainPanel.add(nextButton);

        nextButton.addActionListener(new NextCardListner());

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem newMenuItem = new JMenuItem("New");
        JMenuItem saveMenuItem = new JMenuItem("Save");
        newMenuItem.addActionListener(new NewMenuListner());

        saveMenuItem.addActionListener(new SaveMenuListner());

        fileMenu.add(newMenuItem);
        fileMenu.add(saveMenuItem);
        menuBar.add(fileMenu);

        frame.setJMenuBar(menuBar);
        frame.getContentPane().add(BorderLayout.CENTER,mainPanel);
        frame.setSize(650,500);
        frame.setVisible(true);

    }
    public class NextCardListner implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            QuizCard card = new QuizCard(question.getText(),answer.getText());
            qardList.add(card);
            clearCard();

        }
    }


    public class NewMenuListner implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            qardList.clear();
            clearCard();

        }
    }
    private void clearCard(){
        question.setText("");
        answer.setText("");
        question.requestFocus();
    }


    public class SaveMenuListner implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            QuizCard card = new QuizCard(question.getText(),answer.getText());
            qardList.add(card);

            JFileChooser fileChooser = new JFileChooser();
            fileChooser.showSaveDialog(frame);
            saveFile(fileChooser.getSelectedFile());

        }
    }

    private void saveFile(File file){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            for (QuizCard card :
                    qardList) {
                bw.write(card.getQuestion() + "/");
                bw.write(card.getAnswer()+"\n");
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
