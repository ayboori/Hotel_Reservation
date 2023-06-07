import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // 諛� �젙蹂� �엯�젰 諛� 紐⑸줉 紐낆떆
        Main main = new Main();
        main.displayRoom();
        
        AllReservation allReservation = new AllReservation(new HashMap<>());

        // 로그인 할 때 정해진 게스트를 세팅
        // Guest guest = 로그인함수() ;
        
        // �샇�뀛 �뿉�빟 愿��젴 硫붿꽌�뱶
        while (true) {
            System.out.println("\n------------------------------------------------\n");
            System.out.println("1. �삁�빟 �븯湲�     2. �삁�빟 議고쉶      3. �삁�빟 痍⑥냼      4. 醫낅즺");
            Scanner scanner = new Scanner(System.in);
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
        ArrayList<Room> hotelRooms = hotel.getRoom();

        // �샇�뀛 諛� 紐⑸줉
        for (Room room : hotelRooms) { // 異뷀썑 �뵒�옄�씤 �닔�젙
            String roomInfo = String.format("�궗�씠利�: %s      媛�寃�: %d      媛앹떎 踰덊샇: %d",
                    room.getSize(), room.getPrice(), room.getRoomNumber());
            System.out.println(roomInfo);
        }
    }
}


