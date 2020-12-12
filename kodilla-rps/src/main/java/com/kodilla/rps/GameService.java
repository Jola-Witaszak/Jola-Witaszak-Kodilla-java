package com.kodilla.rps;

import java.util.Random;
import java.util.Scanner;

public class GameService {
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);

    boolean gameOver = false;

    String playerNumber;
    int cpuRandomNumber;

    int rounds = 0;
    int countOfRounds = 0;
    int cpuWinCounter = 0;
    int playerWinCounter = 0;

    public void playGame() {

        System.out.println();
        System.out.println("Welcome to the game paper, rock, scissors!\nHow many rounds do you want to play? Enter from 1 to 5:");

        rounds = getNumberOfRound();
        System.out.println("We're starting the game!\n");
        System.out.println("Select the number:\n paper = 1 \n stone = 2 \n scissors = 3 \n exit = x \n new game = n");

        while (!gameOver && rounds > 0) {
            System.out.println();
            System.out.println("Round no. " + ++countOfRounds);

            getCorrectMove();
            getUserMove(playerNumber);

            if (!gameOver) {
                System.out.println();
                cpuRandomNumber = random.nextInt(3) + 1;
                draw(cpuRandomNumber);
                System.out.println();

                String resultOfTheRound = checkWinner(playerNumber, cpuRandomNumber);
                System.out.println(resultOfTheRound);

                rounds--;
                String gameResult = printCurrentResult(cpuRandomNumber, playerNumber, rounds);
                System.out.println(gameResult);
            }
        }
        gameOver = true;
        scanner.close();
        System.out.println("End of the game!");
    }

    public int getNumberOfRound() {
        int rounds = scanner.nextInt();
        while (rounds < 1) {
            System.out.println("Incorrect number, enter a number greater than zero");
            rounds = scanner.nextInt();
        }
        return rounds;
    }

    public String getCorrectMove() {
        playerNumber = scanner.next();
        while (!(playerNumber.equals("1") || playerNumber.equals("2") || playerNumber.equals("3") ||
                playerNumber.equals("x") || playerNumber.equals("n"))) {
            System.out.println("Incorrect number, enter a number (1-3) x or n !");
            playerNumber = scanner.next();
        }
        return playerNumber;
    }

    private void getUserMove(String playerNumber) {
        int selectedNumber;
        switch (playerNumber) {
            case "1":
            case "2":
            case "3":
                selectedNumber = convertsToNumber(playerNumber);
                draw(selectedNumber);
                break;
            case "n":
                initializeNewGame();
                break;
            case "x":
                endsTheGame();
                break;
        }
    }

    public int convertsToNumber(String playerNumber) {
        int number = 0;
        if (playerNumber.equals("1") || playerNumber.equals("2") || playerNumber.equals("3")) {
            number = Integer.parseInt(playerNumber);
        }
        return number;
    }

    public  void initializeNewGame() {
        rounds = 0;
        cpuWinCounter = 0;
        playerWinCounter = 0;
        countOfRounds = 0;
        gameOver = false;
        playGame();
    }

    public void endsTheGame() {
        gameOver = true;
        scanner.close();
        System.out.println("Thanks!");
        return;
    }

    public  void draw(int number) {

        Paper paper = new Paper();
        Stone stone = new Stone();
        Scissors scissors = new Scissors();
        if (number == 1) {
            paper.drawSymbol();
        } else if (number == 2) {
            stone.drawSymbol();
        } else if (number == 3) {
            scissors.drawSymbol();
        }
    }

    public String checkWinner(String number, int cpuNumber) {
        int playerNumber = convertsToNumber(number);
        if ((playerNumber == 1 && cpuNumber == 2) || (cpuNumber == 1 && playerNumber == 2)) {
            return "The paper cover the stone!";
        } else if ((playerNumber == 2 && cpuNumber == 3) || (cpuNumber == 2 && playerNumber == 3)) {
            return "The stone crushes the scissors!";
        } else if ((playerNumber == 3 && cpuNumber == 1) || (cpuNumber == 3 && playerNumber == 1)) {
            return "The scissors cut paper!";
        } else if (playerNumber == cpuNumber) {
            return "Same :)";
        }
        return "";
    }

    public String printCurrentResult(int cpuNumber, String userNumber, int rounds) {
        int playerNumber = convertsToNumber(userNumber);

        if ((playerNumber == 1 && cpuNumber == 2) || (playerNumber == 2 && cpuNumber == 3) || (playerNumber == 3 && cpuNumber == 1)) {
            playerWinCounter++;
            if (rounds == 0) {
                return printFinalResult(playerWinCounter, cpuWinCounter);
            }
            return "player " + playerWinCounter + " : cpu " + cpuWinCounter;
        } else if ((cpuNumber == 3 && playerNumber == 1) || (cpuNumber == 1 && playerNumber == 2) || (cpuNumber == 2 && playerNumber == 3)) {
            cpuWinCounter++;
            if (rounds == 0) {
                return printFinalResult(playerWinCounter, cpuWinCounter);
            }
            return "player " + playerWinCounter + " : cpu " + cpuWinCounter;
        } else if (playerNumber == cpuNumber) {
            if (rounds == 0) {
                return printFinalResult(playerWinCounter, cpuWinCounter);
            }
            return "player " + playerWinCounter + " : cpu " + cpuWinCounter;
        }
        return "";
    }

    public String printFinalResult(int playerWinCounter, int cpuWinCounter) {
        if (playerWinCounter == cpuWinCounter) {
            return "No one wins ... player " + playerWinCounter + " : cpu " + cpuWinCounter;
        } else if (playerWinCounter > cpuWinCounter) {
            return "Congratulations you won! player " + playerWinCounter + " : cpu " + cpuWinCounter;
        } else {
            return "CPU wins! Sorry... player " + playerWinCounter+ " : cpu " + cpuWinCounter;
        }
    }

}
