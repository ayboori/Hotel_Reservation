import java.time.OffsetDateTime;
import java.util.UUID;

public class GuestManagement implements Management {

	AllReservation allReservation;
	Reservation reservation;
	
	GuestManagement(AllReservation allReservation){
		this.allReservation = allReservation;
	}
    
	@Override
	public void showReservationList() {
		// TODO Auto-generated method stub
	}
	
	public void cancelReservation(String ReservationNumber) {
		
	}
	
	public void doReservation(Guest guest, Room room, Hotel hotel) {
		// ���� ��ȣ UUID ��
		String reservationId = UUID.randomUUID().toString();

        // ���� ��¥
        OffsetDateTime now = OffsetDateTime.now();
        String nowString = String.valueOf(now.withNano(0));
        
        
        // �մ� ����� > �� ���� �̾�� ����
      //   int roomPrice = hotel.getRooms().get(room.getRoomNumber()).getPrice();       
        
//        if (guest.getMoney() < roomPrice) {
//            System.out.println("����� ���� ��� ��� ������ �� ���ϴ�.");
//            return;
//        }
        
        // �մ� ����� �� ���ݸ�ŭ ���̳ʽ�        
        
     //   hotel.setAsset(hotel.getAsset() + roomPrice);	
        
        Reservation reservation = new Reservation(guest, room.getRoomNumber(), nowString, reservationId);
        
        // ��ü ���� ��Ͽ� ��� ���� ���� ��ü �߰�
        allReservation.getReservaitonHashMap().put(reservationId,reservation);
        
        System.out.println("������ �Ϸ�Ǿ��ϴ�.");
	}
}
