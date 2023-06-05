import java.util.ArrayList;
import java.util.HashMap;

public class AllReservation {
    private HashMap<String, Reservaiton> reservaitonHashMap = new HashMap<>();

    public HashMap<String, Reservaiton> getReservaitonHashMap() {
        return reservaitonHashMap;
    }

    public void setReservaitonHashMap(HashMap<String, Reservaiton> reservaitonHashMap) {
        this.reservaitonHashMap = reservaitonHashMap;
    }

    public AllReservation(HashMap<String, Reservaiton> reservaitonHashMap) {
        this.reservaitonHashMap = reservaitonHashMap;
    }

}
