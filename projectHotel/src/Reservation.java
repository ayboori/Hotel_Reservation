public class Reservation {

	private String guestName;
	private String phoneNum;
    private int roomNum;
    private String reservationDate;
    private String reservationId;
    
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

    public Reservation(Guest guest, int roomNum, String reservationDate, String reservationId) {
        this.guestName = guest.getGuestName();
        this.phoneNum = guest.getPhoneNum();
        this.roomNum = roomNum;
        this.reservationDate = reservationDate;
        this.reservationId = reservationId;
    }
}
