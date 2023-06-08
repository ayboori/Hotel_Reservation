import java.util.HashMap;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.UUID;
public class AllGuests {
    HashMap<String,Guest> guests = new HashMap<String,Guest>();
    public void makeGuest() {
        System.out.println("\n------------------------------------------------\n");
        Scanner sc = new Scanner(System.in);
        System.out.println("이름을 입력해 주세요.");
        String guestName = sc.nextLine();
        System.out.println("전화번호를 입력해 주세요. ex) 010-1234-5678");
        String phoneNum = sc.nextLine();
        // id는 사용자 이름 + uuid 4글자
        String guestId = guestName + UUID.randomUUID().toString().substring(0, 4);
        //소지금 입력 받기
        System.out.println("소지금을 입력해 주세요.");
        int money = sc.nextInt();
        Guest guest = new Guest(guestName, phoneNum, money,guestId);
        // 아이디 명시
        System.out.println("회원가입을 축하합니다 !");
        System.out.println("고객님의 아이디는 " + "[ " +guest.getGuestId() +" ]"+ " 입니다.");
        System.out.println("이제 저희 호텔의 다양한 서비스를 이용하실 수 있습니다.");
        // 전체 게스트 목록에 추가
        guests.put(guestId,guest);
    }
    // 로그인 기능 구현해보기
    // 사용자가 id 입력하면 Guest 객체를 return하여 로그인하는 함수
    public Guest logIN(String guestId) {
        Guest guest = guests.get(guestId);
        if (guest != null) {
            System.out.println("로그인 되었습니다.");
        } else {
            System.out.println("id를 다시 확인해주세요.");
        }
        return guest;
    }
}