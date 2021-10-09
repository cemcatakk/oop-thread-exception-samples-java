import java.util.ArrayList;

public class Apartment {
    private int id;
    private ArrayList<Room> rooms;
    private ArrayList<ParkingPlace> parkingPlaces;

    public Apartment(int id) {
        this.id = id;
        this.rooms = rooms;
        this.parkingPlaces = new ArrayList<ParkingPlace>();
        this.setRooms(new ArrayList<Room>());
        Main.apartmentID++;
    }

    public void addTenant(Person tenant) throws ProblematicTenantException {
        if (tenant.getLetters().size()<3){
            if (isThereEmptyRoom()){
                Room empty = getEmptyRoom();
                empty.setTenant(tenant);
                System.out.printf("Person with name: %s rented room with id: %d\n", tenant.getName(), empty.getId());
            }
        }
        else{
            throw new ProblematicTenantException("Person "+tenant.getName()+" had already renting rooms: "+tenant.getRooms().size());
        }
    }
    public boolean isThereEmptyRoom(){
        for (Room room: getRooms()){
            if (room.getTenant() ==null){
                return true;
            }
        }
        return false;
    }
    public Room getEmptyRoom(){
        for (Room room: getRooms()){
            if (room.getTenant() ==null){
                return room;
            }
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
class Room{
    private int id;
    private int volume;
    private Person tenant;
    private CustomDate leaseDate;
    private CustomDate endDate;
    public Room(int volume,int id){
        this.setId(id);
        this.setVolume(volume);
        setLeaseDate(DateUtil.getDate());
        setEndDate(DateUtil.getDate());
        getEndDate().addMonths(1);
        Main.roomID++;
    }
    public boolean rentExpired(){
        if (DateUtil.getDate().compareTo(getEndDate())>0){
            return true;
        }
        else return false;
    }
    public boolean isEmpty(){
        return getTenant() ==null?true:false;
    }
    public void sendLetter(){
        getTenant().getLetters().add(new TenantLetter(getTenant(),"You should pay the rent."));
    }
    public void removeTenant(){
        if (tenant!=null){
            if (tenant.getRooms().contains(this)){
                System.out.printf("Tenant named %s removed from room id: %d\n",getId(),getTenant().getName());
                tenant.getRooms().remove(this);
            }
            tenant=null;
        }
        else{
            System.out.printf("Room with id %d is already empty.\n",getId());
        }
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public Person getTenant() {
        return tenant;
    }

    public void setTenant(Person tenant) {
        this.tenant = tenant;
        getTenant().getRooms().add(this);
    }

    public CustomDate getLeaseDate() {
        return leaseDate;
    }

    public void setLeaseDate(CustomDate leaseDate) {
        this.leaseDate = leaseDate;
    }

    public CustomDate getEndDate() {
        return endDate;
    }

    public void setEndDate(CustomDate endDate) {
        this.endDate = endDate;
    }
}
class ParkingPlace extends Room {
    ArrayList<Vehicle> items = new ArrayList<Vehicle>();

    public ParkingPlace(int id,int volume) {
        super(id,volume);
    }
    public boolean isFits(Vehicle vehicle){
        if (getVolume()>=vehicle.volume){
            return true;
        }
        return false;
    }
}