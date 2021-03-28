
public class TennisGame1 implements TennisGame {

    private int player1Score = 0;
    private int player2Score = 0;
    private String player1;
    private String player2;

    public TennisGame1(String player1, String player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            player1Score += 1;
        else
            player2Score += 1;
    }

    public String getScore() {
        String score = "";
        if (playersDraw()) score = showEqualScore();
        else if (differenceInScores()) score = showPartialScore();
        else score = scoreBoard();
        return score;
    }

    //PRIVATE METHODS

    private boolean playersDraw(){
        if (player1Score == player2Score)
            return true;
        return false;
    }

    private String showEqualScore(){
        String score = "";
        String[] equalScores = {"Love-All","Fifteen-All","Deuce"};
        switch (player1Score)
        {
            case 0:
                score = "Love-All";
                break;
            case 1:
                score = "Fifteen-All";
                break;
            case 2:
                score = "Thirty-All";
                break;
            default:
                score = "Deuce";
                break;
        }
        return score;
    }

    private boolean differenceInScores(){
        if (player1Score >=4 || player2Score >=4) return true;
        return false;
    }

    private String showPartialScore(){
        String score = "";
        int result = player1Score - player2Score;
        if (advantagePlayer1(result)) score ="Advantage player1";
        else if (advantagePlayer2(result)) score ="Advantage player2";
        else if (winPlayer1(result)) score = "Win for player1";
        else score ="Win for player2";
        return score;
    }
    private boolean advantagePlayer1(int result){
        if (result == 1) return true;
        return false;
    }
    private boolean advantagePlayer2(int result){
        if (result == -1) return true;
        return false;
    }
    private boolean winPlayer1(int result){
        if (result >= 2) return true;
        return false;
    }

    private String scoreBoard(){
        String score = "";
        for (int i=1; i<3; i++)
        {
           score += optionsScore(i);
        }
        return score;
    }
    private String optionsScore(int i){
        String score = "";
        int partialScore = 0;
        String[] scores = {"Love","Fifteen","Thirty","Forty"};
        if (i==1) partialScore = player1Score;
        else { score+="-"; partialScore = player2Score;}
        score += scores[partialScore];
        return score;
    }

}
