import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;
import java.util.Scanner;

public class GuestManagement implements Management {

    AllReservation allReservation;
    Reservation reservation;

    GuestManagement(AllReservation allReservation) {
        this.allReservation = allReservation;
    }

    Scanner sc = new Scanner(System.in);

    @Override
    public void showReservationList() {
        if (allReservation.getReservaitonHashMap().isEmpty()) {
            System.out.println("현재 예약이 없습니다.");
            return;
        }

        System.out.println("예약 번호를 입력하세요:");
        Scanner scanner = new Scanner(System.in);
        String reservationId = scanner.nextLine();

        if (allReservation.getReservaitonHashMap().containsKey(reservationId)) {//예약 번호가 존재하는 지 확인
            System.out.println("선택한 예약 정보:");
            Reservation selectedReservation = allReservation.getReservaitonHashMap().get(reservationId);
            System.out.println(selectedReservation.toString());
        } else {
            System.out.println("예약 번호가 올바르지 않습니다.");
        }
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
        while (true) {
            // 객실 목록 출력
            ArrayList<Room> hotelRooms = hotel.getRooms();
            for (Room roomList : hotelRooms) {
                String roomInfo = String.format("사이즈: %s      가격: %d      객실 번호: %d",
                        roomList.getSize(), roomList.getPrice(), roomList.getRoomNumber());
                System.out.println(roomInfo);
            }

            // 예약할 객실 입력받기
            System.out.println("예약할 객실 번호를 입력해 주세요.");
            int roomNum = sc.nextInt();

            // 고객이 선택한 객실 가격
            Room selectedRoom = hotel.getRooms().get(roomNum - 1);
            int roomPrice = selectedRoom.getPrice();

            // 객실 목록 출력으로 돌아가기
            if (roomNum < 1 || roomNum > hotelRooms.size()) {
                System.out.println("올바른 객실 번호를 입력해 주세요.");
                continue;
            } else if (!selectedRoom.isAvailable()) { // 객실 예약 불가 상태
                System.out.println("선택하신 객실은 예약 불가 상태입니다.");
                continue;
            } else if (guest.getMoney() < roomPrice) { // (고객 소지금 < 숙박비) 예약 불가
                System.out.println("소지금 보다 비싼 방은 예약할 수 없습니다.");
                continue;
            }

            try {
                guest.setMoney(guest.getMoney() - roomPrice); // 손님 소지금 방 가격만큼 마이너스
                hotel.setAsset(hotel.getAsset() + roomPrice); // 호텔 보유자산에 방 가격 추가

                // 현재 날짜
                OffsetDateTime now = OffsetDateTime.now();
                String nowString = String.valueOf(now.withNano(0));
                // 예약 번호 UUID 생성
                String reservationId = UUID.randomUUID().toString();

                Reservation reservation = new Reservation(guest, room.getRoomNumber(), nowString, reservationId);

                // 전체 에약 목록에 방금 생성한 예약 객체 추가
                allReservation.getReservaitonHashMap().put(reservationId, reservation);


                System.out.println("예약이 완료되었습니다.");
                Thread.sleep(3000);
                break;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}