import javax.swing.*;
import java.awt.*;

public class Game {
    JFrame window;
    JPanel board;
    JButton restart;
    Snake snake;
    Food food;
    GameStateManager gameStateManager;
    final int WIDTH=1500;
    final int HEIGHT=1000;
    Game(){
        window=new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(WIDTH, HEIGHT);
        window.setLayout(null);
        window.setVisible(true);

        restart=new JButton("Restart Game");
        restart.setBounds(WIDTH-200,100,150,50);
        restart.addActionListener(e -> {
            window.dispose();
            new Game();
        });
        snake=new Snake();
        food=new Food();

        GameModel gameModel=new GameModel(snake, food);
        GameKeyListener gameKeyListener= new GameKeyListener(snake);
        window.addKeyListener(gameKeyListener);
        window.setFocusable(true);

        board=new Panel(WIDTH-250,HEIGHT-75,gameModel);
        board.setBounds(25,25,WIDTH-250,HEIGHT-83);
        board.setBackground(Color.lightGray);
        window.add(board);

        gameStateManager=new GameStateManager((Panel) board,snake,food);

        window.add(restart);

    }
}
