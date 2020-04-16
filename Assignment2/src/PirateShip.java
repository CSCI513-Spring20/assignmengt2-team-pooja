import java.awt.Point;
import java.util.Observable;
import java.util.Observer;

public class PirateShip implements Observer {
    private Point pirateShipLocation;
    OceanMap oceanMap;

    PirateShip(OceanMap oceanMap, Point p){
        this.pirateShipLocation = p;
        this.oceanMap = oceanMap;
    }

    @Override
    public void update(Observable o, Object arg) {
        Point shipLocation = (Point) arg;
        int x = shipLocation.x;
        int y = shipLocation.y;
        int px = this.getPirateShipLocation().x;
        int py = this.getPirateShipLocation().y;

        // case-1 ship at (0,0) and pirate at (4,4)
        if (px > x){
            if (py > y){
                // (px-x) is horizontal distance
                // (py - y) is vertical distance
                if ((px - x) >= (py - y)){
                    if (goWest()){
                        return;
                    } else if (goNorth()){
                        return;
                    } else if (goSouth()) {
                        return;
                    }else{
                        goEast();
                        return;
                    }
                }else{
                    if (goNorth()){
                        return;
                    } else if (goWest()){
                        return;
                    } else if (goSouth()) {
                        return;
                    }else{
                        goEast();
                        return;
                    }
                }

            }
        }

        // case-2 ship at (10,10) and pirate at (0,0) (1,0)
        if (px < x){
            if (py < y){
                // (px-x) is horizontal distance
                // (py - y) is vertical distance
                if ((x - px) >= (y - py)){
                    if (goSouth()){
                        return;
                    } else if (goEast()){
                        return;
                    } else if (goNorth()) {
                        return;
                    }else{
                        goWest();
                        return;
                    }
                }else{
                    if (goEast()){
                        return;
                    } else if (goSouth()){
                        return;
                    } else if (goWest()) {
                        return;
                    }else{
                        goNorth();
                        return;
                    }
                }

            }
        }


        // case-3 ship at (10,4) and pirate at (5,5)
        if (px < x){
            if (py > y){
                // (px-x) is horizontal distance
                // (py - y) is vertical distance
                if ((x - px) >= (py - y)){
                    if (goEast()){
                        return;
                    } else if (goSouth()){
                        return;
                    } else if (goNorth()) {
                        return;
                    }else{
                        goWest();
                        return;
                    }
                }else{
                    // pirate (5,5) to ship (4,2)
                    if (goEast()){
                        return;
                    } else if (goNorth()){
                        return;
                    } else if (goSouth()) {
                        return;
                    }else{
                        goEast();
                        return;
                    }
                }

            }
        }

        // case 4 ship at (4,10) and pirate at (5,5)

        if (px > x){
            if (py < y){
                // (px-x) is horizontal distance
                // (py - y) is vertical distance
                if ((px - x) >= (y - py)){
                    if (goSouth()){
                        return;
                    } else if (goWest()){
                        return;
                    } else if (goEast()) {
                        return;
                    }else{
                        goNorth();
                        return;
                    }
                }else{
                    // pirate (5,5) to ship (4,2)
                    if (goSouth()){
                        return;
                    } else if (goWest()){
                        return;
                    } else if (goEast()) {
                        return;
                    }else{
                        goNorth();
                        return;
                    }
                }

            }
        }

        // case 5 pirate ship at (5,5) and ship (5,4)
        if (px == x){
            if (py > y){
                if (goNorth()){
                    return;
                } else if (goEast()){
                    return;
                } else if (goWest()) {
                    return;
                }else{
                    goSouth();
                    return;
                }
            } else if (py < y){
                if (goSouth()){
                    return;
                } else if (goWest()){
                    return;
                } else if (goEast()) {
                    return;
                }else{
                    goNorth();
                    return;
                }
            } else {
                return;
            }
        }


        // pirate ship at (5,5) and ship (4,5)
        if (py == y){
            if (px > x){
                if (goWest()){
                    return;
                } else if (goNorth()){
                    return;
                } else if (goSouth()) {
                    return;
                }else{
                    goWest();
                    return;
                }
            } else if (px < x){
                if (goEast()){
                    return;
                } else if (goNorth()){
                    return;
                } else if (goSouth()) {
                    return;
                }else{
                    goWest();
                    return;
                }
            }else {
                return;
            }
        }

    }

    private boolean goEast(){
        int x = pirateShipLocation.x;
        int y = pirateShipLocation.y;
        if(x < oceanMap.getDimensions()-1 && oceanMap.isOcean(x+1, y)){
            pirateShipLocation.x++;
            return true;
        }
        return false;
    }

    private boolean goWest(){
        int x = pirateShipLocation.x;
        int y = pirateShipLocation.y;
        if(x > 0 && oceanMap.isOcean(x-1, y)){
            pirateShipLocation.x--;
            return true;
        }
        return false;
    }

    private boolean goNorth(){
        int x = pirateShipLocation.x;
        int y = pirateShipLocation.y;
        if(y > 0 && oceanMap.isOcean(x, y-1)){
            pirateShipLocation.y--;
            return true;
        }
        return false;
    }

    private boolean goSouth(){
        int x = pirateShipLocation.x;
        int y = pirateShipLocation.y;
        if(y < oceanMap.getDimensions()-1 && oceanMap.isOcean(x, y+1)){
            pirateShipLocation.y++;
            return true;
        }
        return false;
    }


    public Point getPirateShipLocation(){
        return this.pirateShipLocation;
    }
}
