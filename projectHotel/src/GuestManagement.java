import java.time.OffsetDateTime;
import java.util.Scanner;
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
    	System.out.println("예약을 취소하시겠습니까? y/n");
    	Scanner scanner = new Scanner(System.in);
    	

    	//예약 취소 여부를 무한 루프로 받음 (잘못된 값은 다시 입력받도록)    	
    	try {
    		while(true) {
        	String answer = scanner.nextLine();
	    	switch (answer) {
	    		case "y":
	    			allReservation.getReservaitonHashMap().remove(ReservationNumber);
	    			System.out.println("예약이 취소되었습니다.\n 3초 뒤 메인 화면으로 연결됩니다.");
	    			Thread.sleep(3000);
	    			break;
	    		case "n":
	    			System.out.println("예약을 취소하지 않습니다.\n 3초 뒤 메인 화면으로 연결됩니다.");
	    			Thread.sleep(3000);
	    			break;
	    		default:
	    			System.out.println("잘못된 문자입니다. 예약을 취소하려면 y, 아니면 n을 입력해주세요");
	    		}
    		}
    	}catch (InterruptedException e){
        	throw new RuntimeException(e);
    	}    	
    }

    public void doReservation(Guest guest, Room room, Hotel hotel) {
        // 예약 번호 UUID 생성
        String reservationId = UUID.randomUUID().toString();

        // 현재 날짜
        OffsetDateTime now = OffsetDateTime.now();
        String nowString = String.valueOf(now.withNano(0));


        // 손님 소지금 > 방 가격 이어야 예약
        int roomPrice = hotel.getRooms().get(room.getRoomNumber()).getPrice();

        if (guest.getMoney() < roomPrice) {
            System.out.println("소지금 보다 비싼 방은 예약할 수 없습니다.");
            return;
        }

        // 손님 소지금 방 가격만큼 마이너스 - 추후 구현
      
      
        // 호텔텔 전체 잔액에 현재 방 가격 추가
        hotel.setAsset(hotel.getAsset() + roomPrice);

        Reservation reservation = new Reservation(guest, room.getRoomNumber(), nowString, reservationId);

        // 전체 에약 목록에 방금 생성한 예약 객체 추가
        allReservation.addReservation(reservation);

        System.out.println("예약이 완료되었습니다.");
    }
}
