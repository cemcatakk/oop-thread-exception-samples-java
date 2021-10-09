import java.util.ArrayList;

public class HousingEstate {
    private ArrayList<Apartment> apartments;
    private int id;

    public HousingEstate(ArrayList<Apartment> apartments, int id) {
        this.apartments = apartments;
        this.id = id;
        Main.estateID++;
    }

    public ArrayList<Apartment> getApartments() {
        return apartments;
    }

    public void setApartments(ArrayList<Apartment> apartments) {
        this.apartments = apartments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
