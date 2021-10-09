import java.util.ArrayList;

public class Main {
    public static int estateID=1;
    public static int apartmentID=1;
    public static int roomID=1;
    public static int personID=1;
    public static ArrayList<HousingEstate> housingEstates;
    public static void checkAll(){
        for (HousingEstate estate:housingEstates){
            for (Apartment apartment: estate.getApartments()){
                for (Room room: apartment.getRooms()){
                    if (room.rentExpired()&&!room.isEmpty()){
                        room.sendLetter();
                    }
                }
            }
        }
        printAllLetters();
    }
    public static void printAllLetters(){
        System.out.println("Printing Letters");
        for (Apartment apartment:housingEstates.get(0).getApartments()){
            for (Room room:apartment.getRooms()){
                if (!room.isEmpty()){
                    for (TenantLetter TenantLetter :room.getTenant().getLetters()){
                        System.out.println(TenantLetter);
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws ProblematicTenantException, TooManyThingsException {
        housingEstates = new ArrayList<HousingEstate>();
        Thread thread = new Thread(new Timer());
        thread.start();
        housingEstates.add(new HousingEstate(new ArrayList<Apartment>(),estateID));
        HousingEstate activeEstate=  housingEstates.get(0);
        Person person1 = new Person("Jack","Brown","24. st. NY",personID);
        Person person2 = new Person("Marlyn","Monroe","41. st LA",personID);
        Vehicle vehicle = new Boat("Jack's boat",20,2);
        ParkingPlace parkingPlace1 = new ParkingPlace(roomID,19);
        ParkingPlace parkingPlace2 = new ParkingPlace(roomID,15);
        Room room1 = new Room(10,roomID);
        Room room2 = new Room(20,roomID);
        Room room3 = new Room(30,roomID);
        Room room4 = new Room(50,roomID);
        Room room5 = new Room(20,roomID);
        Apartment apartment1 = new Apartment(apartmentID);
        Apartment apartment2 = new Apartment(apartmentID);
        apartment1.getRooms().add(room1);
        apartment1.getRooms().add(room2);
        apartment1.getRooms().add(room3);
        apartment1.addTenant(person1);
        person1.addPerson(apartment1.getEmptyRoom(),person2);
        person1.payAllRents();
        person1.addVehicle(parkingPlace1,vehicle);
    }
}
 class Timer implements Runnable {
    CustomDate date = DateUtil.getDate();
     @Override
     public void run() {
         int counter=0;
         while (true){
             try {
                 Thread.sleep(1000);
                 counter++;
                 if (counter%5==0){
                     date.addDays(1);
                     System.out.printf("Current date is: %s\n",date.toString());
                 }
                 if (counter%10==0){
                    Main.checkAll();
                 }
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }
     }
 }
