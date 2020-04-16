import java.awt.Point;
import java.util.Random;

public class OceanMap {

    private int[][] myGrid;
    private  int islandCount;
    private int dimensions;
    private Point shipLocation;
    private Point[] pirateShips;

    OceanMap(int dimensions, int islandCount){
        this.myGrid = Grid(dimensions, islandCount);
        this.islandCount = islandCount;
        this.dimensions = dimensions;
        placeIslands();
        placeShips();
    }

    private static int[][] Grid(int rows, int columns) { //creates a grid of size rows x columns
        int[][] grid = new int[rows][columns];

        for (int row=0 ; row < rows; row++) {
            for (int column=0; column < columns; column++){
                grid[row][column] = 0;
            }
        }
        return grid;
    }

    // place islands onto map
    private void placeIslands(){
        int i = 0;
        Random random = new Random();
        while(i < islandCount){
            int x = random.nextInt(this.dimensions);
            int y = random.nextInt(this.dimensions);
            if(this.myGrid[x][y] == 0){
                // using 1 for representing island
                this.myGrid[x][y] = 1;
                i++;
            }
        }
    }

    private void placeShips(){
        boolean isShipPlaced = false;
        int piratesShip = 2;
        Point[] pirateShips = new Point[piratesShip];
        Random random = new Random();
        int x = 0;
        int y = 0;
        while(!isShipPlaced){ // places one christopher columbus ship
            x = random.nextInt(this.dimensions);
            y = random.nextInt(this.dimensions);
            if(this.myGrid[x][y] == 0){
                isShipPlaced = true;
                // temporary update
                this.myGrid[x][y] = 100;
            }
        }
        this.shipLocation = new Point(x,y);

        while(piratesShip > 0){ // places two pirate ships
            x = random.nextInt(this.dimensions);
            y = random.nextInt(this.dimensions);
            if(this.myGrid[x][y] == 0){
                piratesShip--;
                pirateShips[piratesShip] = new Point(x,y);
                // temporary update
                this.myGrid[x][y] = 100;
            }
        }

        // remove temporary updates
        this.myGrid[shipLocation.x][shipLocation.y] = 0;
        for(int i=0; i < pirateShips.length; i++){
            this.myGrid[pirateShips[i].x][pirateShips[i].y] = 0;
        }

        this.pirateShips = pirateShips;
    }

    public boolean isOcean(int x, int y){ // checks if there is ocean
        if (this.myGrid[x][y] == 0){
            return true;
        }
        return false;
    }

    public boolean isIsland(int x, int y){ // checks if there is island
        if (this.myGrid[x][y] == 1){
            return true;
        }
        return false;
    }

    public int[][] getMap() {
        return this.myGrid;
    } // returns the grid

    public Point getShipLocation() {
        return shipLocation;
    } //returns location of the ship

    public Point[] getPirateShips() {
        return pirateShips;
    } // returns the PirateShips

    public int getDimensions() {
        return dimensions;
    } // returns the dimensions

    public int getIslandCount() {
        return islandCount;
    } // returns the island count

}
