import java.util.ArrayList;

public class Person {
    private ArrayList<Room> rooms;
    private ArrayList<ParkingPlace> parkingPlaces;
    private ArrayList<TenantLetter> TenantLetters;
    private String name;
    private String surname;
    private String address;
    private int id;

    public Person( String name, String surname, String address, int id) {
        this.rooms = new ArrayList<Room>();
        this.parkingPlaces = new ArrayList<ParkingPlace>();
        this.TenantLetters = new ArrayList<TenantLetter>();
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.id = id;
        Main.personID++;
    }
    public void addParkingPlace(ParkingPlace place){
        if (parkingPlaces.contains(place)==false){
            parkingPlaces.add(place);
        }
    }
    public void addVehicle(ParkingPlace place,Vehicle vehicle) throws TooManyThingsException {
        if (place.isFits(vehicle)&&!place.items.contains(vehicle)){
            place.items.add(vehicle);
        }
        else{
            throw new TooManyThingsException("Remove some old items to insert a new item.");
        }
    }
    public void payRent(Room room){
        if (room.getEndDate().compareTo(DateUtil.getDate())<=0){
            room.getEndDate().addMonths(1);
            System.out.printf("Person named %s paid the rent for room id %d",getName(),room.getId());
        }
    }
    public void payAllRents(){
        for (Room room:rooms){
            payRent(room);
        }
    }
    public void addPerson(Room room,Person tenant){
        if (room.isEmpty()){
            room.setTenant(tenant);
        }
    }
    public void removePerson(Room room,Person tenant){
        room.removeTenant();
    }
    int getPropertyCount(){
        return getRooms().size()+ getParkingPlaces().size();
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    public ArrayList<ParkingPlace> getParkingPlaces() {
        return parkingPlaces;
    }

    public void setParkingPlaces(ArrayList<ParkingPlace> parkingPlaces) {
        this.parkingPlaces = parkingPlaces;
    }

    public ArrayList<TenantLetter> getLetters() {
        return TenantLetters;
    }

    public void setLetters(ArrayList<TenantLetter> TenantLetters) {
        this.TenantLetters = TenantLetters;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
