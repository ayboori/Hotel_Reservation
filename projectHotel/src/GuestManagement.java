import java.time.OffsetDateTime;
import java.util.UUID;
import java.util.Scanner;

public class GuestManagement implements Management {

    AllReservation allReservation;
    Reservation reservation;

    GuestManagement(AllReservation allReservation){
        this.allReservation = allReservation;
    }

    @Override
    public void showReservationList() {
        if (allReservation.getReservaitonHashMap().isEmpty()) {
            System.out.println("현재 예약이 없습니다.");
            return;
        }

        System.out.println("예약 목록:");

        for (Map.Entry<String, Reservation> allReservation : allReservation.getReservaitonHashMap().entrySet()) {
            String reservationId = allReservation.getKey();
            Reservation reservation = allReservation.getValue();
//            System.out.println(reservationId + "\n" + reservation.toString());
            System.out.println("예약 번호: " + reservationId);
            System.out.println(reservation.toString());
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
        allReservation.getReservaitonHashMap().put(reservationId,reservation);

        System.out.println("예약이 완료되었습니다.");
    }
}
