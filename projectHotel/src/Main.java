import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // 방 정보 입력 및 목록 명시
        Scanner scanner = new Scanner(System.in);
        AllReservation allReservation = new AllReservation(new HashMap<>());
        GuestManagement guestManagement = new GuestManagement(allReservation);
        AllGuests allGuests = new AllGuests();

        System.out.println("안녕하십니까? 최상의 서비스로 여러분을 맞이합니다.");
        System.out.println("기존 저희 호텔 회원이라면 로그인을 해주십시오.");
        System.out.println("처음이신가요? 회원가입을 통해 최상의 서비스를 누려보세요 !");

        // 로그인 의사결정
        while (true) {
            System.out.println("1. 로그인     2. 회원가입     3. 나가기");
            int choiceNum = scanner.nextInt();
            switch (choiceNum) {
                case 1:
                    // 로그인 메서드
                    String inputId = scanner.next();
                    Guest guest = allGuests.logIN(inputId);
                    if (guest == null) {
                        continue;
                    }
                    break;
                case 2:
                    allGuests.makeGuest();
                    continue;
                case 3:
                    System.out.println("이용해주셔서 감사합니다. 다음에 더 나은 서비스로 기다리겠습니다.");
                    return;
                default:
                    System.out.println("잘못된 입력값입니다. 다시 입력해주세요.");
                    System.out.println("1. 돌아가기     2. 나가기");
                    int subChoiceNum = scanner.nextInt();
                    if (subChoiceNum == 1) {
                        continue;
                    } else if (subChoiceNum == 2) {
                        System.out.println("이용해주셔서 감사합니다. 다음에 더 나은 서비스로 기다리겠습니다.");
                        return;
                    }
            }
            break;
        }


        Main main = new Main(); // 무한루프로 객체 생성할 필요는 없어서 밖으로 뺐음
        
        // 호텔 에약 관련 메서드
        while (true) {
            main.displayRoom(); // 호출 방식 생각해보기
            System.out.println("\n------------------------------------------------\n");
            System.out.println("1. 예약 하기     2. 예약 조회  / 취소   3. 종료");
            int choiceNum = scanner.nextInt();
            switch (choiceNum) {
                case 1:
                    // 예약하기 메서드 (예약할 때마다 자산 추가)
                    break;
                case 2:
                    // 예약조회 메서드
                	
                	//예약 취소 메소드
                	
                    break;
                case 3:
                    // 종료
                    scanner.close();
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
        ArrayList<Room> hotelRooms = hotel.getRooms();

        // 호텔 방 목록
        for (Room room : hotelRooms) { // 추후 디자인 수정
            String roomInfo = String.format("사이즈: %s      가격: %d      객실 번호: %d",
                    room.getSize(), room.getPrice(), room.getRoomNumber());
            System.out.println(roomInfo);
        }
    }
}
