package com.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RockPaperScissors extends JFrame implements ActionListener {
    private JButton rockButton, paperButton, scissorsButton;
    private JLabel resultLabel, playerChoiceLabel, computerChoiceLabel;
    private String[] choices = {"Rock", "Paper", "Scissors"};
    private Random random = new Random();

    public RockPaperScissors() {
        setTitle("Rock, Paper, Scissors Game");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 1));

        JPanel buttonPanel = new JPanel();
        rockButton = new JButton("Rock");
        paperButton = new JButton("Paper");
        scissorsButton = new JButton("Scissors");

        buttonPanel.add(rockButton);
        buttonPanel.add(paperButton);
        buttonPanel.add(scissorsButton);

        rockButton.addActionListener(this);
        paperButton.addActionListener(this);
        scissorsButton.addActionListener(this);

        playerChoiceLabel = new JLabel("Your Choice: ");
        computerChoiceLabel = new JLabel("Computer Choice: ");
        resultLabel = new JLabel("Result: ");

        add(buttonPanel);
        add(playerChoiceLabel);
        add(computerChoiceLabel);
        add(resultLabel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String playerChoice = "";
        if (e.getSource() == rockButton) {
            playerChoice = "Rock";
        } else if (e.getSource() == paperButton) {
            playerChoice = "Paper";
        } else if (e.getSource() == scissorsButton) {
            playerChoice = "Scissors";
        }

        String computerChoice = choices[random.nextInt(3)];
        playerChoiceLabel.setText("Your Choice: " + playerChoice);
        computerChoiceLabel.setText("Computer Choice: " + computerChoice);

        String result = determineWinner(playerChoice, computerChoice);
        resultLabel.setText("Result: " + result);
    }

    private String determineWinner(String playerChoice, String computerChoice) {
        if (playerChoice.equals(computerChoice)) {
            return "It's a tie!";
        } else if ((playerChoice.equals("Rock") && computerChoice.equals("Scissors")) ||
                (playerChoice.equals("Paper") && computerChoice.equals("Rock")) ||
                (playerChoice.equals("Scissors") && computerChoice.equals("Paper"))) {
            return "You win!";
        } else {
            return "Computer wins!";
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RockPaperScissors());
    }
}

