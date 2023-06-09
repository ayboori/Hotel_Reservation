import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Main implements AllObjects {

    public static void main(String[] args) {

        // 방 정보 입력 및 목록 명시 - 인터페이스로 분리했음
        Scanner scanner = new Scanner(System.in);
        
        Guest guest = new Guest(); // main에서 로그인하면서 초기화해야해서 어쩔 수 없이 main에 작성함
        
        System.out.println("안녕하십니까? 최상의 서비스로 여러분을 맞이합니다.");
        System.out.println("기존 저희 호텔 회원이라면 로그인을 해주십시오.");
        System.out.println("처음이신가요? 회원가입을 통해 최상의 서비스를 누려보세요 !");

        main.createRoom(hotel);

        // 로그인 의사결정
        while (true) {
            System.out.println("1. 로그인     2. 회원가입     3. 나가기");
            int choiceNum = scanner.nextInt();
            switch (choiceNum) {
                case 1:
                    // 로그인 메서드
                    System.out.println("로그인 하실 아이디를 입력해주세요.");
                    String inputId = scanner.next();
                    guest = allGuests.logIN(inputId);
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
        
        // 호텔 에약 관련 메서드
        while (true) {
            System.out.println("\n------------------------------------------------\n");
            System.out.println("1. 예약 하기     2. 예약 조회  / 취소   3. 종료");

            int choiceNum = scanner.nextInt();
            switch (choiceNum) {
                case 1:
                    // 예약하기 메서드 (예약할 때마다 자산 추가)
                	scanner.nextLine(); // nextInt 다음에 nextLine 호출해서 처음에 값이 제대로 되지 않았다고 출력되는 문제 수정함
                    main.displayRoom(hotel);
                    guestManagement.doReservation(guest);
                    break;
                case 2:
                    // 예약조회 메서드
                	scanner.nextLine(); // nextInt 다음에 nextLine 호출해서 처음에 값이 제대로 되지 않았다고 출력되는 문제 수정함
                	guestManagement.showReservationList(guest);
                	//예약 취소 메소드 이어서 실행됨
                    break;
                case 3:
                    // 종료
                    scanner.close();
                    return;
                case 0:
                    // 관리자 모드 => 모든 예약 조회
                	hotelManagement.showReservationList(guest);
                    break;
                default:
                    System.out.println("잘못된 번호입니다. 다시 입력해주세요.");
            }
        }        
    }

    public void createRoom(Hotel hotel) {
        // 방 정보 삽입
        ArrayList<Room> roomList = new ArrayList<>();
        roomList.add(new Room(500, 5000000, 1));
        roomList.add(new Room(400, 4000000, 2));
        roomList.add(new Room(350, 3000000, 3));
        roomList.add(new Room(300, 2500000, 4));
        roomList.add(new Room(250, 2000000, 5));
        roomList.add(new Room(200, 1500000, 6));
        roomList.add(new Room(100, 1000000, 7));

        // Hotel 인스턴스 생성
        hotel.setRooms(roomList);
    }
      
    public void displayRoom(Hotel hotel) {
        // 방 가격 절사 인스턴스 생성
        DecimalFormat df = new DecimalFormat("###,###");
        // 호텔 방 목록
        for (Room room : hotel.getRooms()) {
            int amount = room.getPrice();
            String isAvailable;
            if(room.isAvailable()) {
                isAvailable = "\u001B[32m"+ "[ 빈방입니다 ]" + "\u001B[0m";
            } else {
                isAvailable = "\u001B[31m" + "[ 이미 예약된 방입니다 ]" + "\u001B[0m";
            }

            String roomPrice = df.format(amount);
            String roomInfo = String.format("사이즈: %s      가격: %s      객실 번호: %d      %s",
                    room.getSize(), roomPrice + " 원", room.getRoomNumber(), isAvailable);
            System.out.println(roomInfo);
        }
    }
}
