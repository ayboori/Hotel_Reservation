public class Room {

    private double size;
    private int price;
    private boolean available;
    private int roomNumber;

    public double getSize() {
        return size;
    }
    public void setSize(double size) {
        this.size = size;
    }

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public int getRoomNumber() {
        return roomNumber;
    }
    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public boolean isAvailable() {
        return available;
    }
    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Room(double size, int price, int roomNumber) {
        this.size = size;
        this.price = price;
        this.roomNumber = roomNumber;
        this.available = true;
    }
}
