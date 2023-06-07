import java.util.HashMap;
import java.util.Scanner;
public class AllGuests {
	HashMap<String,Guest> guests = new HashMap<String,Guest>();
	
    public void makeGuest() {
        System.out.println("\n------------------------------------------------\n");
        Scanner sc = new Scanner(System.in);
        System.out.println("이름을 입력해 주세요.");
        String guestName = sc.next();
        System.out.println("전화번호를 입력해 주세요.");
        String phoneNum = sc.next();
        
        // uid 부분 추후 구현, 우선 임의의 값 삽입
        String guestId = "1";
        
        //소지금 입력 받기
        System.out.println("소지금을 입력해 주세요.");
        int money = sc.nextInt();
        Guest guest = new Guest(guestName, phoneNum, money,guestId);
        
        // 전체 게스트 목록에 추가
        guests.put(guestId,guest);
    }
    
    // 로그인 기능 구현해보기
    // 사용자가 id 입력하면 Guest 객체를 return하여 로그인하는 함수 추후 작성
}