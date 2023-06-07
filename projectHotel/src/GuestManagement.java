import java.time.OffsetDateTime;
import java.util.UUID;

public class GuestManagement implements Management {

	AllReservation allReservation;
	Reservation reservation;
	
	GuestManagement(AllReservation allReservation){
		this.allReservation = allReservation;
	}
    
	@Override
	public void showReservationList() {
		// TODO Auto-generated method stub
	}
	
	public void cancelReservation(String ReservationNumber) {
		
	}
	
	public void doReservation(Guest guest, Room room, Hotel hotel) {
		// 예약 번호 UUID 생성
		String reservationId = UUID.randomUUID().toString();

        // 현재 날짜
        OffsetDateTime now = OffsetDateTime.now();
        String nowString = String.valueOf(now.withNano(0));
        
        
        // 손님 소지금 > 방 가격 이어야 예약
      //   int roomPrice = hotel.getRooms().get(room.getRoomNumber()).getPrice();       
        
//        if (guest.getMoney() < roomPrice) {
//            System.out.println("소지금 보다 비싼 방은 예약할 수 없습니다.");
//            return;
//        }
        
        // 손님 소지금 방 가격만큼 마이너스        
        
     //   hotel.setAsset(hotel.getAsset() + roomPrice);	
        
        Reservation reservation = new Reservation(guest, room.getRoomNumber(), nowString, reservationId);
        
        // 전체 에약 목록에 방금 생성한 예약 객체 추가
        allReservation.getReservaitonHashMap().put(reservationId,reservation);
        
        System.out.println("예약이 완료되었습니다.");
	}
}
