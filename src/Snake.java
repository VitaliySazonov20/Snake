public class Snake {
    public Node head;

    public enum Direction{
        Up,Down,Left,Right
    }
    Direction direction;
    public static class Node{
        private int x;
        private int y;
        Node next;
        Node previous;
        Node(int x,int y){
            this.x=x;
            this.y=y;
            this.next=null;
            this.previous=null;
        }
        public int getX() {
            return x;
        }
        public int getY(){
            return y;
        }
    }
    Snake(){
        head=new Node(15,15);
        direction=Direction.Right;
        Node current=head;
        int size = 1;
        while(size <3 &&current.next==null){
            Node newNode= new Node(current.x-1,current.y);
            current.next=newNode;
            newNode.previous=current;
            size++;
            current=current.next;
        }
    }
    public void move(){
        Node current= head;
        while(current.next!=null){
            current=current.next;
        }
        while (current.previous!=null){
            current.x=current.previous.x;
            current.y=current.previous.y;
            current=current.previous;
        }
        switch (direction){
            case Up -> current.y=current.y-1;
            case Down -> current.y=current.y+1;
            case Left -> current.x=current.x-1;
            case Right -> current.x= current.x+1;
        }
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
    public void addBody(){
        Node current= head;
        while (current.next!=null){
            current=current.next;
        }
        Node newNode= new Node(current.getX(),current.getY());
        current.next=newNode;
        newNode.previous=current;
    }
}
