import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;
import java.util.Scanner;

public class GuestManagement implements Management, AllObjects {

    GuestManagement() {}

    Scanner sc = new Scanner(System.in);

    @Override
    public void showReservationList(Guest guest) {
        if (allReservation.getReservaitonHashMap().isEmpty()) {
            System.out.println("현재 예약이 없습니다.");
            return;
        }
        sc.nextLine();
        System.out.println("예약 번호를 입력하세요:");
        String reservationId = sc.nextLine();

        if (allReservation.getReservaitonHashMap().containsKey(reservationId)) {
            System.out.println("\n==================================================");
            System.out.println("선택한 예약 정보:");
            Reservation selectedReservation = allReservation.getReservaitonHashMap().get(reservationId);
            // System.out.println(selectedReservation.toString(guest, selectedReservation.getRoomNum(), selectedReservation.getReservationDate()));
            System.out.println("예약자 분 성함: " + selectedReservation.getGuestName());
            System.out.println("예약자 분 전화번호: " + selectedReservation.getPhoneNum());
            System.out.println("예약한 방 번호: " + selectedReservation.getRoomNum());
            System.out.println("예약일자: " + selectedReservation.getReservationDate());  // 수정본
            System.out.println("==================================================");
            //System.out.println(selectedReservation.toString()); // 수정하기
            cancelReservation(reservationId,guest);
        } else {
            System.out.println("예약 번호가 올바르지 않습니다.");
        }
    }

    public void cancelReservation(String reservationId,Guest guest) {
        System.out.println("예약을 취소하시겠습니까? y/n");

        // 고객이 선택한 객실
        int roomNum = allReservation.getReservation(reservationId).getRoomNum();
        Room selectedRoom = hotel.getRooms().get(roomNum-1);

        // 선택한 객실 가격
        int roomPrice = selectedRoom.getPrice();
      
        //예약 취소 여부를 무한 루프로 받음 (잘못된 값은 다시 입력받도록)
        try {
            while(true) {
                String answer = sc.nextLine();
                switch (answer) {
                    case "y":
                        allReservation.getReservaitonHashMap().remove(reservationId);
                        guest.setMoney(guest.getMoney() + roomPrice); // 손님 소지금 방 가격만큼 플러스
                        hotel.setAsset(hotel.getAsset() - roomPrice); // 호텔 보유자산에 방 가격 마이너스
                        System.out.println("예약이 취소되었습니다.\n 3초 뒤 메인 화면으로 연결됩니다.");
                        Thread.sleep(3000);
                        return;
                    case "n":
                        System.out.println("예약을 취소하지 않습니다.\n 3초 뒤 메인 화면으로 연결됩니다.");
                        Thread.sleep(3000);
                        return;
                    default:
                        System.out.println("잘못된 문자입니다. 예약을 취소하려면 y, 아니면 n을 입력해주세요");
                }
            }
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }

    public void doReservation(Guest guest) {
        while (true) {
            // 예약할 객실 입력받기
            System.out.println("예약할 객실 번호를 입력해 주세요.");
            int roomNum = sc.nextInt();
            if (roomNum < 1 || roomNum > hotel.getRooms().size()) {
                System.out.println("올바른 객실 번호를 입력해 주세요.\n");
                continue;
            }
            // 고객이 선택한 객실
            Room selectedRoom = hotel.getRooms().get(roomNum - 1);
            // 객실 예약 불가 상태
            if (!selectedRoom.isAvailable()) {
                System.out.println("선택하신 객실은 예약 불가 상태입니다.\n");
                continue;
            }
            // 선택한 객실 가격
            int roomPrice = selectedRoom.getPrice();
            if (guest.getMoney() < roomPrice) { // (고객 소지금 < 숙박비) 예약 불가
                System.out.println("소지금 보다 비싼 방은 예약할 수 없습니다.");
                return;
            }

            try {
                guest.setMoney(guest.getMoney() - roomPrice); // 손님 소지금 방 가격만큼 마이너스
                hotel.setAsset(hotel.getAsset() + roomPrice); // 호텔 보유자산에 방 가격 추가

                // 현재 날짜
                OffsetDateTime now = OffsetDateTime.now();
                String nowString = String.valueOf(now.withNano(0));
                // 예약 번호 UUID 생성
                String reservationId = UUID.randomUUID().toString();

                Reservation reservation = new Reservation(guest, selectedRoom.getRoomNumber(), nowString, reservationId);

                // 예약된 객실 이용 불가로 변경
                selectedRoom.setAvailable(false);

                // 전체 에약 목록에 방금 생성한 예약 객체 추가
                allReservation.getReservaitonHashMap().put(reservationId, reservation);

                // 전체 에약 목록에 방금 생성한 예약 객체 추가 // 의사결정
                System.out.println("예약 가능한 방입니다. 예약을 하시겠습니까 ?");
                System.out.println("1. 예약 하기     2. 돌아가기");
                int confirmNum = sc.nextInt();
                if (confirmNum == 1) {
                    allReservation.getReservaitonHashMap().put(reservationId, reservation);
                    System.out.println("예약이 완료되었습니다.\n예약 번호는 : " + reservationId + "입니다." );
                } else if (confirmNum == 2) {
                    System.out.println("예약이 취소되었습니다.");
                }

                System.out.println("\n3초 뒤 메인 화면으로 돌아갑니다.");
                Thread.sleep(3000);
                break;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}