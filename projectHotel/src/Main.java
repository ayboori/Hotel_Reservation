import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // 방 정보 입력 및 목록 명시
        Scanner scanner = new Scanner(System.in);
        AllReservation allReservation = new AllReservation(new HashMap<>());
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

        // 로그인 할 때 정해진 게스트를 세팅
        // Guest guest = 로그인함수() ;
        
        // �샇�뀛 �뿉�빟 愿��젴 硫붿꽌�뱶
        while (true) {
            Main main = new Main();
            main.displayRoom(); // 호출 방식 생각해보기
            System.out.println("\n------------------------------------------------\n");

            System.out.println("1. 예약 하기     2. 예약 조회      3. 예약 취소      4. 종료");

            int choiceNum = scanner.nextInt();
            switch (choiceNum) {
                case 1:
                    // �삁�빟�븯湲� 硫붿꽌�뱶 (�삁�빟�븷 �븣留덈떎 �옄�궛 異붽�)
                    break;
                case 2:
                    // �삁�빟議고쉶 硫붿꽌�뱶
                    break;
                case 3:
                    // 怨좉컼 �뿉�빟 痍⑥냼
                    break;
                case 4:
                    // 醫낅즺
                    return;
                case 0:
                    // 愿�由ъ옄 紐⑤뱶 => 紐⑤뱺 �삁�빟 議고쉶
                    break;
                default:
                    System.out.println("�옒紐삳맂 踰덊샇�엯�땲�떎. �떎�떆 �엯�젰�빐二쇱꽭�슂.");
            }
        }
    }

    public void displayRoom() {
        // 諛� �젙蹂� �궫�엯
        ArrayList<Room> roomList = new ArrayList<>();
        roomList.add(new Room(300, 3000000, 1));
        roomList.add(new Room(400, 4000000, 2));
        roomList.add(new Room(250, 2000000, 3));

        // Hotel �씤�뒪�꽩�뒪 �깮�꽦
        Hotel hotel = new Hotel(roomList, 0);
        ArrayList<Room> hotelRooms = hotel.getRooms();

        // �샇�뀛 諛� 紐⑸줉
        for (Room room : hotelRooms) { // 異뷀썑 �뵒�옄�씤 �닔�젙
            String roomInfo = String.format("�궗�씠利�: %s      媛�寃�: %d      媛앹떎 踰덊샇: %d",
                    room.getSize(), room.getPrice(), room.getRoomNumber());
            System.out.println(roomInfo);
        }
    }
}


