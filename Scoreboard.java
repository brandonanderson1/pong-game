package game;

public class Scoreboard {
    private int rightScore = 1;
    private int leftScore =1;
    public Scoreboard(int rightScore, int leftScore) {
        this.rightScore = rightScore;
        this.leftScore = leftScore;
    }
    public void rightMiss() {
        rightScore++;
    }
    public void leftMiss() {
        leftScore ++;
    }
    public String getRightScore() {
        return rightScore+"";
    }
    public int getIntRightScore() {
        return rightScore;
    }
    public int getIntLeftScore() {
        return leftScore;
    }
    public String getLeftScore() {
        return leftScore+"";
    }
    public String gameOver() {
        if (rightScore > leftScore) return ("Player One Wins. The final score was " + rightScore + " : " + leftScore + ". Press ENTER to play again.");
        return ("Player Two Wins. The final score was " + rightScore + " : " + leftScore + ". Press ENTER to play again.");
    }
    public void reset (){
        rightScore = 0;
        leftScore = 0;
    }
}
