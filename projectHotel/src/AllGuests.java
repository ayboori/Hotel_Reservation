import java.util.*;
public class AllGuests {
    HashMap<String,Guest> guests = new HashMap<String,Guest>();
    public void addGusets() {
        guests.put("hotel", new Guest());
        guests.put("hjh3229", new Guest("한지훈", "010-3229-8290", 3000000));
        guests.put("sepang-pang", new Guest("오세창", "010-XXXX-XXXX", 4000000));
        guests.put("ayboori", new Guest("조아영", "010-XXXX-XXXX", 10000000));
        guests.put("canseeit", new Guest("이경원", "010-XXXX-XXXX", 6000000));
        guests.put("SH-Lee2023", new Guest("이승현", "010-XXXX-XXXX", 7000000));
    }
    public void makeGuest() {
        System.out.println("\n------------------------------------------------\n");
        Scanner sc = new Scanner(System.in);
        System.out.println("이름을 입력해 주세요.");
        String guestName = sc.nextLine();
        System.out.println("전화번호를 입력해 주세요. ex) 010-1234-5678");
        String phoneNum = sc.nextLine();
        //소지금 입력 받기
        System.out.println("소지금을 입력해 주세요. (단위 : 만원)");
        int money = sc.nextInt() * 10000;
        // id는 사용자 이름 + uuid 4글자
        String guestId = guestName + UUID.randomUUID().toString().substring(0, 4);

        Guest guest = new Guest(guestName, phoneNum, money);
        // 아이디 명시
        System.out.println("회원가입을 축하합니다 !");
        System.out.println("고객님의 아이디는 " + "[ " + guestId +" ]"+ " 입니다.");
        System.out.println("이제 저희 호텔의 다양한 서비스를 이용하실 수 있습니다.");
        // 전체 게스트 목록에 추가
        guests.put(guestId,guest);
    }
    // 로그인 기능 구현해보기
    // 사용자가 id 입력하면 Guest 객체를 return하여 로그인하는 함수
    public Guest logIN(String guestId) {
        addGusets(); // 로그인 전에 회원가입된 고객 리스트 저장
        Guest guest = guests.get(guestId);
        try {
            if (guest != null) {
                System.out.println("로그인 되었습니다.");
            } else {
                System.out.println("id를 다시 확인해주세요.");
            }
        } catch (InputMismatchException e) {
            throw new RuntimeException(e);
        }
        return guest;
    }
}