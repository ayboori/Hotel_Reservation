import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class GuestManagement {
    public void doReservation() {
        Main main = new Main();
        main.displayRoom();
        System.out.println("\n------------------------------------------------\n");

        Hotel hotel = new Hotel();
        ArrayList<Room> hotelRooms = hotel.getRoom();

        Scanner sc = new Scanner(System.in);
        System.out.println("예약할 객실 번호를 입력해 주세요.");
        int roomNumber = sc.nextInt() - 1;

        System.out.println("이름을 입력해 주세요.");
        String guestName = sc.next();

        System.out.println("전화번호를 입력해 주세요.");
        String phoneNum = sc.next();

        //소지금 숙박비 비교
        System.out.println("소지금을 입력해 주세요.");
        int money = sc.nextInt();

        Guest guest = new Guest(guestName, phoneNum, money);

        String reservationId = UUID.randomUUID().toString();
        Reservation reservation = new Reservation(guest, roomNumber, "", "");

        if (money < hotelRooms.get(roomNumber).getPrice()) {
            System.out.println("소지금 보다 비싼 방은 예약할 수 없습니다.");
            return;
        }
        // 예약 성공 시 호텔보유자산 추가, 예약된 방 예약 불가, 예약 날짜, 예약번호 반환
        OffsetDateTime now = OffsetDateTime.now();
        System.out.println("예약이 완료되었습니다.");
        hotel.setAsset(hotel.getAsset() + hotelRooms.get(roomNumber).getPrice());
//        hotelRooms.getAsset() + hotelRooms.get(roomNumber).getPrice();
        reservation.setReservationDate(String.valueOf(now.withNano(0)));
        reservation.setReservationId(reservationId);
    }
}
