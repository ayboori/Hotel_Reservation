import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // 방 정보 입력 및 목록 명시
        Main main = new Main();
        main.displayRoom();

        // 호텔 에약 관련 메서드
        while (true) {
            System.out.println("\n------------------------------------------------\n");
            System.out.println("1. 예약 하기     2. 예약 조회      3. 예약 취소      4. 종료");
            Scanner scanner = new Scanner(System.in);
            int choiceNum = scanner.nextInt();
            switch (choiceNum) {
                case 1:
                    // 예약하기 메서드 (예약할 때마다 자산 추가)
                    break;
                case 2:
                    // 예약조회 메서드
                    break;
                case 3:
                    // 고객 에약 취소
                    break;
                case 4:
                    // 종료
                    return;
                case 0:
                    // 관리자 모드 => 모든 예약 조회
                    break;
                default:
                    System.out.println("잘못된 번호입니다. 다시 입력해주세요.");
            }
        }
    }
    public void displayRoom() {
        // 방 정보 삽입
        ArrayList<Room> roomList = new ArrayList<>();
        roomList.add(new Room(300, 3000000, 1));
        roomList.add(new Room(400, 4000000, 2));
        roomList.add(new Room(250, 2000000, 3));

        // Hotel 인스턴스 생성
        Hotel hotel = new Hotel(roomList, 0);
        ArrayList<Room> hotelRooms = hotel.getRoom();

        // 호텔 방 목록
        for (Room room : hotelRooms) { // 추후 디자인 수정
            String roomInfo = String.format("사이즈: %s      가격: %d      객실 번호: %d",
                    room.getSize(), room.getPrice(), room.getRoomNumber());
            System.out.println(roomInfo);
        }
    }
}


