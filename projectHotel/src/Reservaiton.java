public class Reservaiton {

    private Guest guest;
    private int roomNum;
    private String reservationDate;
    private String reservationId;

    public Guest getGuest() {
        return guest;
    }
    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public int getRoomNum() {
        return roomNum;
    }
    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }

    public String getReservationDate() {
        return reservationDate;
    }
    public void setReservationDate(String reservationDate) {
        this.reservationDate = reservationDate;
    }

    public String getReservationId() {
        return reservationId;
    }
    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public Reservaiton(Guest guest, int roomNum, String reservationDate, String reservationId) {
        this.guest = guest;
        this.roomNum = roomNum;
        this.reservationDate = reservationDate;
        this.reservationId = reservationId;
    }
}
