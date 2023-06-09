import java.util.HashMap;

public class AllReservation {
    private HashMap<String, Reservation> reservaitonHashMap = new HashMap<>();

    public HashMap<String, Reservation> getReservaitonHashMap() {
        return reservaitonHashMap;
    }

    // setter 필요 없을 것 같은데.. 구현해보다가 필요 없으면 삭제하기
    public void setReservaitonHashMap(HashMap<String, Reservation> reservaitonHashMap) {
        this.reservaitonHashMap = reservaitonHashMap;
    }

    public AllReservation(HashMap<String, Reservation> reservaitonHashMap) {
        this.reservaitonHashMap = reservaitonHashMap;
    }
    
    // 예약 id로 예약 객체 받아오는 함수
    public Reservation getReservation(String reservationId) {
    	return reservaitonHashMap.get(reservationId);
    }
    
    // 예약 한 건 추가하는 메소드 추가함
    public void addReservation(Reservation reservation) {
    	reservaitonHashMap.put(reservation.getReservationId(),reservation);
    }

}
