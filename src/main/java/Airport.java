import java.util.ArrayList;

public class Airport {

    private ArrayList<Plane> planeArrayList = new ArrayList();

    public int GetNumberOfPlanes() {
        return planeArrayList.size();
    }

    public boolean land(Plane plane) {
        planeArrayList.add(plane);
        return true;
    }
}
