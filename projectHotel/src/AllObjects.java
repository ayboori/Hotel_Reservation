import java.util.HashMap;

public interface AllObjects{
    AllReservation allReservation = new AllReservation(new HashMap<>());
    GuestManagement guestManagement = new GuestManagement(allReservation);
    HotelManagement hotelManagement = new HotelManagement();

    AllGuests allGuests = new AllGuests();
    Hotel hotel = new Hotel(0);
    Main main = new Main(); // 무한루프로 객체 생성할 필요는 없어서 밖으로 뺐음
}