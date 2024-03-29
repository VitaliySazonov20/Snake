import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameKeyListener implements KeyListener {
    private Snake snake;
    GameKeyListener(Snake snake){
        this.snake=snake;
    }
    @Override
    public void keyTyped(KeyEvent e) {
        // This method is called when a key is typed (pressed and released)
        // You might handle typed events if needed, but it's often not used for arrow key input
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // This method is called when a key is pressed
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_UP:
                if(snake.direction!=Snake.Direction.Down)
                    snake.setDirection(Snake.Direction.Up);
                break;
            case KeyEvent.VK_DOWN:
                if(snake.direction!=Snake.Direction.Up)
                    snake.setDirection(Snake.Direction.Down);
                break;
            case KeyEvent.VK_LEFT:
                if(snake.direction!=Snake.Direction.Right)
                    snake.setDirection(Snake.Direction.Left);
                break;
            case KeyEvent.VK_RIGHT:
                if(snake.direction!=Snake.Direction.Left)
                    snake.setDirection(Snake.Direction.Right);
                break;
            // Handle any other keys if needed
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // This method is called when a key is released
        // You may handle key release events if needed
    }
}
