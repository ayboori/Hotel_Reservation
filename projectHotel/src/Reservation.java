public class Reservation {

    private String guestName;
    private String phoneNum;
    private int roomNum;
    private String reservationDate;
    private String reservationId;
    public String getGuestName() {return guestName;} //추가
    public String getPhoneNum() {return phoneNum;} //추가
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

    public String toString(Guest guest, int roomNum, String reservationDate) {
        return String.format("예약자 분 성함 : %s\n예약자 분 전화번호 : %s\n예약한 방 번호 : %d\n예약일자 : %s",
                guest.getGuestName(), guest.getPhoneNum(), roomNum, reservationDate);
    }
}
