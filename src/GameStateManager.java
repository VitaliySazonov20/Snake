public class GameStateManager implements Runnable {
    Panel panel;
    Snake snake;
    Food food;
    private  boolean running=true;
    int time=500;
    GameStateManager(Panel panel,Snake snake,Food food){
        this.panel=panel;
        this.snake=snake;
        this.food=food;
        start();
    }
    public void start() {
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        long lastTime = System.currentTimeMillis();
        while (running){
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastTime >= time){
                lastTime = currentTime;
                snake.move();
                if(snake.head.getX()<0||snake.head.getX()>30||snake.head.getY()<0||snake.head.getY()>21){
                    stop();
                }
                checkSelfCollision();
                if(running)
                    panel.repaint();

                if(snake.head.getX()== food.getX()&&snake.head.getY()== food.getY()){
                    food.generateNew();
                    snake.addBody();
                }
            }
        }

    }
    public void stop(){
        running=false;
    }
    public void checkSelfCollision(){
        Snake.Node current = snake.head;
        while(current.next!=null){
            current=current.next;
            if(snake.head.getX()==current.getX()&&snake.head.getY()== current.getY()){
                stop();
            }
        }
    }
}
