import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {
    int WIDTH;
    int HEIGHT;
    double cellSize;
    GameModel gameModel;

    Panel(int WIDTH,int HEIGHT,GameModel gameModel){
        this.WIDTH=WIDTH;
        this.HEIGHT=HEIGHT;
        this.cellSize=(double) WIDTH/30;
        this.gameModel=gameModel;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawGrid(g);
        drawFood(g);
        drawSnake(g);
    }
    public void drawGrid(Graphics graphics){
        int i = 0;
        graphics.setColor(Color.black);
        while (i < WIDTH / cellSize) {
            graphics.drawLine((int) (i * cellSize), 0, (int) (i * cellSize), HEIGHT);
            i++;
        }
        i = 0;
        graphics.drawLine(WIDTH - 1, 0, WIDTH - 1, HEIGHT);
        while (i < HEIGHT / cellSize) {
            graphics.drawLine(0, (int) (i * cellSize), WIDTH, (int) (i * cellSize));
            i++;
        }
        graphics.drawLine(0, HEIGHT - 1, WIDTH, HEIGHT - 1);
    }
    public void drawSnake(Graphics graphics){

        Snake snake= gameModel.getSnake();
        Snake.Node current= snake.head;

        while (current.next!=null) {
            current=current.next;
            graphics.setColor(new Color(0,190,0));
            graphics.fillRect((int) (current.getX() * cellSize + 5), (int) (current.getY() * cellSize + 5), (int) (cellSize - 10), (int) (cellSize - 10));
            graphics.setColor(new Color(0,0,0));
            graphics.drawRect((int) (current.getX() * cellSize + 4), (int) (current.getY() * cellSize + 4), (int) (cellSize - 9), (int) (cellSize - 9));
        }
        drawSnakeHead(graphics, snake);
    }
    public void drawSnakeHead(Graphics graphics, Snake snake){
        graphics.setColor(new Color(0,190,0));
        graphics.fillRect((int) (snake.head.getX() * cellSize + 5), (int) (snake.head.getY() * cellSize + 5), (int) (cellSize - 10), (int) (cellSize - 10));
        graphics.setColor(new Color(0,0,0));
        graphics.drawRect((int) (snake.head.getX() * cellSize + 4), (int) (snake.head.getY() * cellSize + 4), (int) (cellSize - 9), (int) (cellSize - 9));
        switch (snake.direction){
            case Up -> {
                graphics.setColor(new Color(255,255,255));
                graphics.fillOval((int) (snake.head.getX() * cellSize + 5),(int) (snake.head.getY() * cellSize + 5), 13,13);
                graphics.fillOval((int) (snake.head.getX() * cellSize + 22),(int) (snake.head.getY() * cellSize + 5), 13,13);
                graphics.setColor(Color.BLACK);
                graphics.fillOval((int) (snake.head.getX() * cellSize + 10),(int) (snake.head.getY() * cellSize + 5), 7,7);
                graphics.fillOval((int) (snake.head.getX() * cellSize + 22),(int) (snake.head.getY() * cellSize + 5), 7,7);
            }
            case Down -> {
                graphics.setColor(new Color(255,255,255));
                graphics.fillOval((int) (snake.head.getX() * cellSize + 5),(int) (snake.head.getY() * cellSize +cellSize- 20), 13,13);
                graphics.fillOval((int) (snake.head.getX() * cellSize + 22),(int) (snake.head.getY() * cellSize +cellSize- 20), 13,13);
                graphics.setColor(Color.BLACK);
                graphics.fillOval((int) (snake.head.getX() * cellSize + 10),(int) (snake.head.getY() * cellSize +cellSize- 15), 7,7);
                graphics.fillOval((int) (snake.head.getX() * cellSize + 22),(int) (snake.head.getY() * cellSize +cellSize- 15), 7,7);
            }
            case Right -> {
                graphics.setColor(new Color(255,255,255));
                graphics.fillOval((int) (snake.head.getX() * cellSize + 22),(int) (snake.head.getY() * cellSize + 5), 13,13);
                graphics.fillOval((int) (snake.head.getX() * cellSize + 22),(int) (snake.head.getY() * cellSize +cellSize- 20), 13,13);
                graphics.setColor(Color.BLACK);
                graphics.fillOval((int) (snake.head.getX() * cellSize + 27),(int) (snake.head.getY() * cellSize + 10), 7,7);
                graphics.fillOval((int) (snake.head.getX() * cellSize + 27),(int) (snake.head.getY() * cellSize +cellSize- 20), 7,7);
            }
            case Left -> {
                graphics.setColor(new Color(255,255,255));
                graphics.fillOval((int) (snake.head.getX() * cellSize +5),(int) (snake.head.getY() * cellSize + 5), 13,13);
                graphics.fillOval((int) (snake.head.getX() * cellSize +5),(int) (snake.head.getY() * cellSize +cellSize- 20), 13,13);
                graphics.setColor(Color.BLACK);
                graphics.fillOval((int) (snake.head.getX() * cellSize + 5),(int) (snake.head.getY() * cellSize + 10), 7,7);
                graphics.fillOval((int) (snake.head.getX() * cellSize + 5),(int) (snake.head.getY() * cellSize +cellSize- 20), 7,7);
            }
        }
    }
    public void drawFood(Graphics graphics){
        Food food = gameModel.getFood();
        graphics.setColor(new Color(255,50,50));
        graphics.fillOval((int) (food.getX()*cellSize+5), (int) (food.getY()*cellSize+5), (int) (cellSize-10), (int) (cellSize-10));
    }
}
