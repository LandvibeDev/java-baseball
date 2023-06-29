package baseball;

public class ResultDto {
    private int strikeCount=0;
    private int ballCount=0;

    public void plusStrikeCount(){
        strikeCount++;
    }
    public void plusBallCount(){
        ballCount++;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }
}
