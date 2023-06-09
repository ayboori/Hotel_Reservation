import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class HotelManagement implements Management,AllObjects {
	AllReservation allReservation;
   
	HotelManagement(AllReservation allReservation){
		this.allReservation = allReservation;
	}
	
    @Override
    public void showReservationList() {
        while (true) {
            if (allReservation.getReservaitonHashMap().isEmpty()) { // 예약 목록이 없으면
                System.out.println("현재 예약이 없습니다.");
            } else {
                for (Map.Entry<String, Reservation> allReservation : allReservation.getReservaitonHashMap().entrySet()) {
                    String reservationId = allReservation.getKey();
                    Reservation reservation = allReservation.getValue();
                    System.out.println(reservationId + "\n" + reservation.toString());
                }
            }
            System.out.println("\n---------------------------------------------\n");
            System.out.println("현재 예약된 방의 수 : " + allReservation.getReservaitonHashMap().size());
            // 에러??              System.out.println("현재 호텔 예상 매출 : " + hotel.getAsset());
            while (true) {
                System.out.println("\n---------------------------------------------\n");
                System.out.println("1. 프로그램 종료하기     2. 예약 취소하기\n");
                System.out.println("숫자를 입력해주세요. : ");
                Scanner sc = new Scanner(System.in);
                int check = sc.nextInt();
                try {
                    if (check == 1) {
                        System.out.println("프로그램이 종료됩니다.");
                        Thread.sleep(3000); // 3초 정지 후 프로그램 종료
                        return;
                    } else if (check == 2) {
                        // 예약 목록 조회(취소) 메서드
                        break;
                    } else { // 다른 숫자를 입력받았을 때
                        System.out.println("잘못된 입력입니다.");
                        sc.nextLine(); // 버퍼 지우기
                    }
                } catch (InputMismatchException e) { // 숫자 외에 입력을 받았을 때
                    System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
                    sc.nextLine();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

