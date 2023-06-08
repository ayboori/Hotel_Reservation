import java.util.ArrayList;
import java.util.HashMap;

public class AllReservation {
    private HashMap<String, Reservation> reservaitonHashMap = new HashMap<>();

    public HashMap<String, Reservation> getReservaitonHashMap() {
        return reservaitonHashMap;
    }

    public void setReservaitonHashMap(HashMap<String, Reservation> reservaitonHashMap) {
        this.reservaitonHashMap = reservaitonHashMap;
    }

    public AllReservation(HashMap<String, Reservation> reservaitonHashMap) {
        this.reservaitonHashMap = reservaitonHashMap;
    }

}
