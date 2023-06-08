import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class GuestManagement implements Management {

    AllReservation allReservation;
    Reservation reservation;

    GuestManagement(AllReservation allReservation) {
        this.allReservation = allReservation;
    }
    Scanner sc = new Scanner(System.in);

    @Override
    public void showReservationList() {
        // TODO Auto-generated method stub
    }

    public void cancelReservation(String ReservationNumber) {

    }

    public void doReservation(Guest guest, Room room, Hotel hotel) {
        // 객실 목록 출력
        ArrayList<Room> hotelRooms = hotel.getRooms();
        for (Room roomList : hotelRooms) {
            String roomInfo = String.format("사이즈: %s      가격: %d      객실 번호: %d",
                    roomList.getSize(), roomList.getPrice(), roomList.getRoomNumber());
            System.out.println(roomInfo);
        }

        // 예약받기
        System.out.println("예약할 객실 번호를 입력해 주세요.");
        int selectedRoomNum = sc.nextInt();
        room.setRoomNumber(selectedRoomNum);


        // 고객이 선택한 객실 가격
        int roomPrice = hotel.getRooms().get(room.getRoomNumber()).getPrice();

        // 객실 목록 출력으로 돌아가기
        if (guest.getMoney() < roomPrice) { // (고객 소지금 < 숙박비) 예약 불가
            System.out.println("소지금 보다 비싼 방은 예약할 수 없습니다.");
            return;
        } else if (!room.isAvailable()) { // 객실 예약 불가 상태
            System.out.println("선택하신 객실은 예약 불가 상태입니다.");
            return;
        }

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
    }
}