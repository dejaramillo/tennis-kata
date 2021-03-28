
public class TennisGame2 implements TennisGame
{
    public int player1Point = 0;
    public int player2Point = 0;
    
    public String player1Score = "";
    public String player2Score = "";
    private String player1;
    private String player2;

    public TennisGame2(String player1, String player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public String getScore(){
        String score = "";
        score = playerEquals(score);
        score = playersDeuce(score);
        if (player1Point > player2Point) score = wonDiffPlayer1(score);
        else score = wonDiffPlayer2(score);
        if(validateWinPlayers()){
            score = advantageWinPlayers(score);
        }
        return score;
    }

    public void player1Score(){
        player1Point++;
    }

    public void player2Score(){
        player2Point++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            player1Score();
        else
            player2Score();
    }

    // PRIVATE METHODS

    private String playerScores(int playerPoint){
        String[] scores = {"Love","Fifteen","Thirty","Forty","Deuce"};
        return  scores[playerPoint];
    }

    private String advantageWinPlayers(String score){
        int partialScore = player1Point - player2Point;
        return score = validatePlayerScore(partialScore,score);
    }

    private String validatePlayerScore(int partialScore, String score){
        if (partialScore == 1) score = "Advantage player1";
        else if (partialScore >= 2) score = "Win for player1";
        else score = validateWinPlayer2(partialScore);
        return score;
    }

    private String validateWinPlayer2(int partialScore){
        String score = "";
        if (partialScore <= -2) score = "Win for player2";
        else if (partialScore == -1) score = "Advantage player2";
        else score = "Deuce";
        return score;
    }

    private String wonDiffPlayer1(String score){
        if (player1Point > 0 && player2Point ==0)
            score = playerScores(player1Point) + "-" + playerScores(player2Point);
        else score = partialDiffPlayer1(score);
        return score;
    }

    private String partialDiffPlayer1(String score){
        if (player1Point > player2Point && player1Point < 4)
            score = playerScores(player1Point) + "-" + playerScores(player2Point);
        return score;
    }

    private String wonDiffPlayer2(String score){
        if (player2Point > 0 && player1Point ==0)
            score = playerScores(player1Point) + "-" + playerScores(player2Point);
        else score = partialDiffPlayer2(score);
        return score;
    }
    private String partialDiffPlayer2(String score){
        if (player2Point > player1Point && player2Point < 4)
            score = playerScores(player1Point) + "-" + playerScores(player2Point);
        return score;
    }

    private String playerEquals(String score){
        if (player1Point == player2Point && player1Point < 4)
            score = playerScores(player1Point) + "-All";
        return score;
    }

    private String playersDeuce(String score){
        if (player1Point == player2Point && player1Point >=3)
            score = "Deuce";
        return score;
    }

    private boolean validateWinPlayers(){
        if (player1Point >=4 || player2Point >=4) return true;
        return false;
    }

}