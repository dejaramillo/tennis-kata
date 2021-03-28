
public class TennisGame3 implements TennisGame {
    
    private int player2Point;
    private int player1Point;
    private String player1Score;
    private String player2Score;

    public TennisGame3(String player1Score, String player2Score) {
        this.player1Score = player1Score;
        this.player2Score = player2Score;
    }

    public String getScore() {
        String score;
        if (validatePointOfPlayers()) {
            String[] scores = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
            score = scoreBoard(scores);
        } else {
            if (player1Point == player2Point)
                return "Deuce";
            score = playersDiff();
        }
        return score;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            player1Point += 1;
        else
            player2Point += 1;

    }

    //PRIVATE METHODS

    private  boolean validatePointOfPlayers(){
        boolean validate = true;
        if (validateScoreBoard()) validate = true;
        else validate = false;
        return validate;
    }

    private boolean validateScoreBoard(){
       return  player1Point < 4 && player2Point < 4 && !((player1Point + player2Point) == 6);
    }

    private String scoreBoard(String[] scores){
        String score = "";
        score = scores[player1Point];
        score = (player1Point == player2Point) ? score + "-All" : score + "-" + scores[player2Point];
        return score;
    }

    private String playersDiff(){
        String score = "";
        int subtractPoint = (player1Point - player2Point) * (player1Point - player2Point);
        score = player1Point > player2Point ? player1Score : player2Score;
        score = partialScoreBoard(score, subtractPoint);
        return score;
    }

    private String partialScoreBoard(String score, int totalPoints){
        String partialScore = "";
        if (totalPoints == 1)
            partialScore = "Advantage " + score;
        else partialScore = "Win for " + score;
        return partialScore;
    }



}
