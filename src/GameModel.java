public class GameModel {
    Snake snake;
    Food food;
    GameModel(Snake snake,Food food){
        this.snake=snake;
        this.food=food;
    }

    public Snake getSnake() {
        return snake;
    }

    public Food getFood() {
        return food;
    }
}
