import java.time.OffsetDateTime;
import java.util.ArrayList;

public class Hotel {

    private ArrayList<Room> rooms;
    private int asset;

    public ArrayList<Room> getRooms() {
        return rooms;
    }
    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    public int getAsset() {
        return asset;
    }
    public void setAsset(int asset) {
        this.asset = asset;
    }

    public Hotel() {} // 호텔 객체를 생성하기 쉽게 하기 위해서

    public Hotel(ArrayList<Room> rooms, int asset) {
        this.rooms = new ArrayList<>(rooms);
        this.asset = asset;
    }

}
