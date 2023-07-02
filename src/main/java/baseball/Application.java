package baseball;

public class Application {
    public static void main(String[] args) {
        NumberManager numberManager = new BaseBallNumberManager();
        GameController game = new GameController(numberManager);
        game.start();
    }
}
