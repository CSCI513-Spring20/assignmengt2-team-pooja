import java.awt.Point;
import java.util.Observable;


public class Ship extends Observable {
    private Point shipLocation;
    private OceanMap oceanMap;
    Ship(OceanMap oceanMap){
        this.oceanMap = oceanMap;
        this.shipLocation = oceanMap.getShipLocation();
    }

    public void goEast(){
        int x = shipLocation.x;
        int y = shipLocation.y;
        if(x < oceanMap.getDimensions()-1 && oceanMap.isOcean(x+1, y)){
            shipLocation.x++;
            setChanged();
            notifyObservers(shipLocation);
        }
    }

    public void goWest(){
        int x = shipLocation.x;
        int y = shipLocation.y;
        if(x > 0 && oceanMap.isOcean(x-1, y)){
            shipLocation.x--;
            setChanged();
            notifyObservers(shipLocation);
        }
    }

    public void goNorth(){
        int x = shipLocation.x;
        int y = shipLocation.y;
        if(y > 0 && oceanMap.isOcean(x, y-1)){
            shipLocation.y--;
            setChanged();
            notifyObservers(shipLocation);
        }
    }

    public void goSouth(){
        int x = shipLocation.x;
        int y = shipLocation.y;
        if(y < oceanMap.getDimensions()-1 && oceanMap.isOcean(x, y+1)){
            shipLocation.y++;
            setChanged();
            notifyObservers(shipLocation);
        }
    }

    public Point getShipLocation() {
        return shipLocation;
    }
}
