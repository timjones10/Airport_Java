import java.util.ArrayList;

public class Airport {

    private ArrayList<Plane> planeArrayList;
    private int capacity;

    public Airport() {
        this(5);
        planeArrayList = new ArrayList<>();
    }

    public Airport(int capacity) {
        this.capacity = capacity;
        planeArrayList = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public int GetNumberOfPlanes() {
        return planeArrayList.size();
    }

    public boolean land(Plane plane) {
        if (GetNumberOfPlanes() == getCapacity()) {
            return false;
        }
        planeArrayList.add(plane);
        return true;
    }
}
