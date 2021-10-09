import java.util.ArrayList;

abstract class Vehicle {
    int id;
    static int counter;
    String name;
    int volume;
    static ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();

    public Vehicle(String name, int volume) {
        id = counter;
        counter++;
        this.name = name;
        this.volume = volume;
        vehicles.add(this);
    }

    public Vehicle(String name, int h, int w, int l) {
        id = counter;
        counter++;
        this.name = name;
        this.volume = h*w*l;
        vehicles.add(this);
    }
}

class OffRoadCar extends Vehicle {
    String[] suspension_arr = {"IFS", "TTB"};
    String suspension_type;

    public OffRoadCar(String name, int volume, int susp_choice) {
        super(name, volume);
        suspension_type = suspension_arr[susp_choice];//suspension type choice: 0 for IFS ; 1 for TTB
    }
}

class CityCar extends Vehicle {
    String[] transmission_arr = {"Automatic", "Mechanical"};
    String transmission;

    public CityCar(String name, int volume, int trns_choice) {
        super(name, volume);
        transmission = transmission_arr[trns_choice];//transmission type choice: 0 for auto ; 1 for mech
    }
}

class Boat extends Vehicle {
    int pass_capacity;//passenger capacity

    public Boat(String name, int volume, int pass_capacity) {
        super(name, volume);
        this.pass_capacity = pass_capacity;
    }
}

class Motorcycle extends Vehicle {
    int weight;

    public Motorcycle(String name, int volume, int weight) {
        super(name, volume);
        this.weight = weight;
    }
}

class Amphibious extends Vehicle {
    int carrying_capacity;

    public Amphibious(String name, int volume, int carrying_capacity) {
        super(name, volume);
        this.carrying_capacity = carrying_capacity;
    }
}