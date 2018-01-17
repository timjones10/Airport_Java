import java.util.ArrayList;

public class Airport {

    private ArrayList<Plane> planeArrayList;
    private int capacity;

    public Airport() {
        this(1);
        planeArrayList = new ArrayList<>();
    }

    public Airport(int capacity) {
        this.capacity = capacity;
        planeArrayList = new ArrayList<>();
    }

    private int getCapacity() {
        return capacity;
    }

    public int GetNumberOfPlanes() {
        return planeArrayList.size();
    }

    public boolean land(Plane plane) {
        if (GetNumberOfPlanes() == getCapacity() || plane.isLanded()){
            return false;
        }
        planeArrayList.add(plane);
        plane.land();
        return true;
    }

    public boolean takeOff(Plane plane) {
        if(!planeArrayList.contains(plane)|| !plane.isLanded()) {
            return false;
        }
        planeArrayList.remove(plane);
        plane.takeOff();
        return true;
    }
}
