import java.util.concurrent.TimeUnit;

public class Main {


    public static void main(String[] args) throws InterruptedException {
        Lawn lawn = new Lawn(5, 8, new int[][]{
                {1, 1, 1, 1, 1, 0, 1, 1},
                {1, 1, 1, 1, 1, 0, 1, 1},
                {1, 0, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1}
        });

        Coordinate startCoordinate = new Coordinate(0,0);
        Robot lawnMower = new Robot(startCoordinate);
        lawnMower.setLawn(lawn);

        do{
            System.out.flush();
            lawnMower.cut();
            Coordinate newCoordinate = lawnMower.findNextMove();
            if(newCoordinate != null){
                lawnMower.stepForward(newCoordinate);
            }else{
                lawnMower.stepBackward();
            }

            for(int i = 0; i < lawn.getxSize(); i++){
                for(int j = 0; j < lawn.getySize(); j++){
                    if(lawnMower.getCoordinate().getX() == i && lawnMower.getCoordinate().getY() == j){
                        System.out.print("R");
                    }else{
                        System.out.print(lawn.getGrid()[i][j] + " ");
                    }
                }
                System.out.println();
            }
            TimeUnit.SECONDS.sleep(1);
            System.out.println();
        }while (lawnMower.getCoordinate() != startCoordinate);



    }
}