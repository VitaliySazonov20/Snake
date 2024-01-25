import java.util.Random;

public class Food {
    int x;
    int y;
    Food(){
        generateNew();
    }
    public void generateNew(){
        Random random=new Random();
        x= random.nextInt(30);
        y= random.nextInt(22);
    }
    public int getY(){
        return y;
    }

    public int getX() {
        return x;
    }
}
