import java.util.ArrayList;

public class Hotel {

    private ArrayList<Room> room;
    private int asset;

    public ArrayList<Room> getRoom() {
        return room;
    }
    public void setRoom(ArrayList<Room> room) {
        this.room = room;
    }

    public int getAsset() {
        return asset;
    }
    public void setAsset(int asset) {
        this.asset = asset;
    }

    public Hotel() {} // 호텔 객체를 생성하기 쉽게 하기 위해서

    public Hotel(ArrayList<Room> room, int asset) {
        this.room = new ArrayList<>(room);
        this.asset = asset;
    }

}
