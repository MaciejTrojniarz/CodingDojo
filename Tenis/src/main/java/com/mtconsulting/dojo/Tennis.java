package com.mtconsulting.dojo;

public class Tennis {

    private static final String DEUCE = "Deuce";
    private static final String FIRST_PLAYER_WINS = "First Player Wins";
    private static final String SECOND_PLAYER_WINS = "Second Player Wins";
    private static final String FIRST_PLAYER_ADVANTAGE = "First Player Advantage";
    private static final String SECOND_PLAYER_ADVANTAGE = "Second Player Advantage";
    private static final String LOVE = "Love";
    private static final String FIFTEEN = "Fifteen";
    private static final String THIRTY = "Thirty";
    private static final String FORTY = "Forty";


    public String printScore(int firstPlayerScore, int secondPlayerScore) {
        if (firstPlayerScore == secondPlayerScore && atLeast3PointsScored(firstPlayerScore)) {
            return DEUCE;
        }
        if (atLeastFourPointsScored(firstPlayerScore) && haveAtLeastTwoPointsAdvantage(firstPlayerScore, secondPlayerScore)) {
            return FIRST_PLAYER_WINS;
        }
        if (atLeastFourPointsScored(secondPlayerScore) && haveAtLeastTwoPointsAdvantage(secondPlayerScore, firstPlayerScore)) {
            return SECOND_PLAYER_WINS;
        }
        if (atLeast3PointsScored(firstPlayerScore) && haveOnePointAdvantage(firstPlayerScore, secondPlayerScore)) {
            return FIRST_PLAYER_ADVANTAGE;
        }
        if (atLeast3PointsScored(secondPlayerScore) && haveOnePointAdvantage(secondPlayerScore, firstPlayerScore)) {
            return SECOND_PLAYER_ADVANTAGE;
        }
        return String.format("%s - %s", getPointString(firstPlayerScore), getPointString(secondPlayerScore));
    }

    private boolean atLeast3PointsScored(int playerScore) {
        return playerScore > 2;
    }

    private boolean haveOnePointAdvantage(int firstPlayerScore, int secondPlayerScore) {
        return firstPlayerScore == secondPlayerScore + 1;
    }

    private boolean haveAtLeastTwoPointsAdvantage(int playerScore, int opponentScore) {
        return playerScore >= opponentScore + 2;
    }

    private boolean atLeastFourPointsScored(int playerScore) {
        return playerScore > 3;
    }

    private String getPointString(int value) {
        switch (value) {
            case 1:
                return FIFTEEN;
            case 2:
                return THIRTY;
            case 3:
                return FORTY;
            default:
                return LOVE;
        }
    }
}