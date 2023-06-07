import java.util.HashMap;
import java.util.Map;

public class HotelManagement implements Management {
	AllReservation allReservation;
   
	HotelManagement(AllReservation allReservation){
		this.allReservation = allReservation;
	}
	
    @Override
    public void showReservationList() {
//        Scanner sc = new Scanner(System.in);
//        String UserId = sc.nextLine();
//        Reservation.get(UserId)

        for (Map.Entry<String, Reservation> allReservation : allReservation.getReservaitonHashMap().entrySet()) {
            String reservationId = allReservation.getKey();
            Reservation reservation = allReservation.getValue();
            System.out.println(reservationId + " : " + reservation);
        }
    }
}

