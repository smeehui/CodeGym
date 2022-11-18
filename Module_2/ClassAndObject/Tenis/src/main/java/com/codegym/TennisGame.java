package com.codegym;

public class TennisGame {
    final static String LOVE_ALL = "Love-All";
    final static String FIFTEEN_ALL = "Fifteen-All";
    final static String THIRTY_ALL = "Thirty-All";
    final static String FORTY_ALL = "Forty-All";
    final static String DEUCE = "Deuce";
    final static String LOVE = "Love";
    final static String FIFTEEN = "Fifteen";
    final static String THIRTY = "Thirty";
    final static String FORTY = "Forty";

    public static String getScore(String player1Name, String player2Name, int playerOneScore, int playerTwoScore) {
        if (playerOneScore == playerTwoScore) return whenScoresAreEqual(playerOneScore);
        else if (playerOneScore >= 4 || playerTwoScore >= 4) {
            return whenScoresAreMax(playerOneScore,playerTwoScore);
        } else return whilePlaying(playerOneScore, playerTwoScore);
    }

    private static String whilePlaying(int playerOneScore, int playerTwoScore) {
        String score = "";
        int tempScore = 0;
        for (int i = 1; i < 3; i++) {
            if (i == 1) tempScore = playerOneScore;
            else {
                score += "-";
                tempScore = playerTwoScore;
            }
            switch (tempScore) {
                case 0:
                    score += LOVE;
                    break;
                case 1:
                    score += FIFTEEN;
                    break;
                case 2:
                    score += THIRTY;
                    break;
                case 3:
                    score += FORTY;
                    break;
            }
        }
        return score;
    }

    private static String whenScoresAreMax(int playerOneScore, int playerTwoScore) {
        int minusResult = playerOneScore - playerTwoScore;
        if (minusResult == 1) return "Advantage player1";
        else if (minusResult == -1) return "Advantage player2";
        else if (minusResult >= 2) return "Win for player1";
        else return "Win for player2";
    }

    private static String whenScoresAreEqual(int playerOneScore) {
        switch (playerOneScore) {
            case 0:
                return LOVE_ALL;

            case 1:
                return FIFTEEN_ALL;

            case 2:
                return THIRTY_ALL;

            case 3:
                return FORTY_ALL;

            default:
                return DEUCE;
        }
    }
}