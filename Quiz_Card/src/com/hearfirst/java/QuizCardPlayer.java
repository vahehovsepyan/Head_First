package com.hearfirst.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class QuizCardPlayer {
   private JTextArea question;
   private JTextArea display;
   private ArrayList<QuizCard> cardList;
   private JFrame frame;
   private JButton nextButton;
    private QuizCard currentCard;
    private int currentCardIndex;
   private boolean isShowAnswer;

    public void go(){
        frame = new JFrame("Quiz Card Player");
        JPanel mainPanel = new JPanel();

        display = new JTextArea(10,20);
        Font bigFont = new Font("sanserif",Font.BOLD, 24);
        display.setFont(bigFont);
        display.setLineWrap(true);
        display.setEditable(false);

        JScrollPane qScrollPane = new JScrollPane(display);
        qScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        qScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        nextButton = new JButton("Show Text");
        mainPanel.add(qScrollPane);
        mainPanel.add(nextButton);
        nextButton.addActionListener(new NextCardListner());

        JMenuBar menuBar = new JMenuBar();
        JMenu filMenu = new JMenu("File");
        JMenuItem loadMenuItem = new JMenuItem("Load");
        loadMenuItem.addActionListener(new OpenMenuListner());
        filMenu.add(loadMenuItem);
        menuBar.add(filMenu);
        frame.setJMenuBar(menuBar);
        frame.getContentPane().add(BorderLayout.CENTER,mainPanel);
        frame.setSize(640,500);
        frame.setVisible(true);
    }

    public class NextCardListner implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (isShowAnswer){
                display.setText(currentCard.getAnswer());
                nextButton.setText("Next Card");
                isShowAnswer=false;
            }
            else {
                if (currentCardIndex<cardList.size()){
                    showNextCard();
                }
            }
        }
    }

    public class OpenMenuListner implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileOpen = new JFileChooser("Open");
            fileOpen.showOpenDialog(frame);
            load(fileOpen.getSelectedFile());
        }
    }

    private void load(File file){
        cardList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))){
            String line = null;
            while (br.ready()){
                line = br.readLine();
                makeCard(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        showNextCard();
    }

    private void makeCard(String lineToParse){
        String[] result = lineToParse.split("/");
        QuizCard card = new QuizCard(result[0],result[1]);
        cardList.add(card);
        System.out.println("Made a Card");
    }

    private void showNextCard() {
        currentCard= cardList.get(currentCardIndex);
        currentCardIndex++;
        display.setText(currentCard.getQuestion());
        nextButton.setText("Show Answer");
        isShowAnswer = true;
    }

}
