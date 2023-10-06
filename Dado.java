import java.util.Random;

public class Dado{//classe do objeto dado

    private int sideUp;

    public int getSideUp(){
        return sideUp;
    }

    public void roll(){
        Random random = new Random();

        sideUp = random.nextInt(6) + 1;
    }
    
    public String toString(){
        return " "+sideUp;
    }
}