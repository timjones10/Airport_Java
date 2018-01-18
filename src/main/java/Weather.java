import java.util.Random;

public class Weather {

    public boolean stormy() {
       return randomNumber() <= 1;
    }

    private int randomNumber() {
        Random rand = new Random();
        return rand.nextInt(4) + 1;
    }
}
