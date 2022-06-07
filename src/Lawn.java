public class Lawn {
    private int xSize;
    private int ySize;
    private int[][] grid;

    public Lawn(int xSize, int ySize, int[][] grid) {
        this.xSize = xSize;
        this.ySize = ySize;
        this.grid = grid;
    }

    public int[][] getGrid() {
        return grid;
    }

    public void setGrid(int[][] grid) {
        this.grid = grid;
    }

    public int getxSize() {
        return xSize;
    }

    public void setxSize(int xSize) {
        this.xSize = xSize;
    }

    public int getySize() {
        return ySize;
    }

    public void setySize(int ySize) {
        this.ySize = ySize;
    }
}
