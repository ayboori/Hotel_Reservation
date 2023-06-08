public class Guest {
    private String guestId;
    private String guestName;
    private String phoneNum;
    private int money;

    public String getGuestName() {return guestName;}
    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public int getMoney() {
        return money;
    }
    public void setMoney(int money) { this.money = money; }
    public String getGuestId() {
        return guestId;
    }
    public void setGuestId(String guestId) {
        this.guestId = guestId;
    }

    public Guest() {
    	
    }

    public Guest(String guestName, String phoneNum, int money, String guestId) {
        this.guestName = guestName;
        this.phoneNum = phoneNum;
        this.money = money;
        this.guestId = guestId;
    }
}
