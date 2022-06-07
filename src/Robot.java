import java.util.HashSet;
import java.util.Stack;

public class Robot {
    private Coordinate coordinate;
    private Stack<Coordinate> path;
    private Lawn lawn;

    public Robot(Coordinate coordinate) {
        this.coordinate = coordinate;
        this.path = new Stack<>();
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public Stack<Coordinate> getPath() {
        return path;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public void setLawn(Lawn lawn) {
        this.lawn = lawn;
    }

    public Lawn getLawn() {
        return lawn;
    }

    public void cut(){
        int[][] newGrid = lawn.getGrid();
        newGrid[getCoordinate().getX()][getCoordinate().getY()] = 2;
        lawn.setGrid(newGrid);
    }

    Coordinate findNextMove(){
        int[][] directions = {{-1,0}, {0,1}, {1,0}, {0,-1}}; // up, right, down, left

        for(int i=0; i<4; i++){
            int x = getCoordinate().getX()+directions[i][0];
            int y = getCoordinate().getY()+directions[i][1];

            if(x < lawn.getxSize() && x >= 0 && y < lawn.getySize() && y >= 0 && lawn.getGrid()[x][y] == 1){
                return new Coordinate(x,y);
            }
        }
        return null;
    }

    //backtracking
    void stepBackward(){
        setCoordinate(getPath().pop());
    }

    void stepForward(Coordinate nextCoordinate){
        setCoordinate(getPath().push(nextCoordinate));
    }

}
