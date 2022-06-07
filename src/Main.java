import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Main {
    static void draw(Robot robot) throws InterruptedException {
        for(int i = 0; i < robot.getLawn().getxSize(); i++){
            for(int j = 0; j < robot.getLawn().getySize(); j++){
                if(robot.getCoordinate().getX() == i && robot.getCoordinate().getY() == j){
                    System.out.print("R\t");
                }else{
                    System.out.print(robot.getLawn().getGrid()[i][j] + "\t");
                }
            }
            System.out.println();
        }
        TimeUnit.SECONDS.sleep(1);
        System.out.println();
    }


    public static void main(String[] args) throws InterruptedException {
        Lawn lawn = new Lawn(5, 8, new int[][]{
                {1, 1, 1, 1, 1, 0, 1, 1},
                {1, 1, 1, 1, 1, 0, 1, 1},
                {1, 0, 0, 1, 1, 1, 1, 1},
                {0, 0, 0, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1}
        });

        Coordinate startCoordinate = new Coordinate(1,1);
        Robot lawnMower = new Robot(startCoordinate);
        lawnMower.setLawn(lawn);

        draw(lawnMower);
        lawnMower.cut();
        boolean end;
        do{
            end = true;
            Coordinate newCoordinate = lawnMower.findNextMove();
            if(newCoordinate != null){
                lawnMower.stepForward(newCoordinate);
                lawnMower.cut();
                end = false;
            }else if(!lawnMower.getPath().empty()){
                lawnMower.stepBackward();
                end = false;
            }
            draw(lawnMower);
        }while (!end);

    }
}