package hotelmanagerBO;

public class Chambre {
    private int room_id;
    private String room_no;
    private int bed_number;
    
    
    private ChambreType room_class;
    
    
    public Chambre(String roomNo)
    {
        room_no = roomNo;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public String getRoom_no() {
        return room_no;
    }

    public void setRoom_no(String room_no) {
        this.room_no = room_no;
    }

    public int getBed_number() {
        return bed_number;
    }

    public void setBed_number(int bed_number) {
        this.bed_number = bed_number;
    }


    public ChambreType getRoom_class() {
        return room_class;
    }

    public void setRoom_class(ChambreType room_class) {
        this.room_class = room_class;
    }
    
}
