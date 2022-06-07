import java.util.HashSet;
import java.util.Stack;

public class Robot {
    Coordinate coordinate;
    Stack<Coordinate> path;

    public Robot(Coordinate coordinate) {
        this.coordinate = coordinate;
        this.path = new Stack<>();
    }

    void cut(Lawn lawn){
        int[][] newGrid = lawn.getGrid();
        newGrid[coordinate.getX()][coordinate.getY()] = 2;
        lawn.setGrid(newGrid);
    }

    Coordinate check(){
        int[][] directions = {{-1,0,},{0,1},{1,0},{0,-1}};

        Coordinate up = new Coordinate(coordinate.getX() - 1,coordinate.getY());
        Coordinate right = new Coordinate(coordinate.getX(),coordinate.getY() + 1);
        Coordinate down = new Coordinate(coordinate.getX() + 1,coordinate.getY());
        Coordinate left = new Coordinate(coordinate.getX(),coordinate.getY() - 1);

        if()
    }

    backtrack(){

    }

    boolean move(){

        return true;
    }



}
