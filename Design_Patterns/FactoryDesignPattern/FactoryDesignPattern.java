/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
interface Vehicle{
    void drive();
}
interface TwoWheeler extends Vehicle{
    void drive();
}
interface FourWheeler extends Vehicle{
    void drive();
}
class Bike implements TwoWheeler{
   public void drive(){
        System.out.println("Bike  Driving");
    }
}
class Scooty implements TwoWheeler{
    public void drive(){
        System.out.println("Scooty  Driving");
    }
}
class Car implements FourWheeler{
    public void drive(){
        System.out.println("Car Driving");
    }
}
class Taxi implements FourWheeler{
   public void drive(){
        System.out.println("Taxi Driving");
    }
}

interface VehicleFactory{
    Vehicle createVehicle(String type);
}
class TwoWheelerFactory implements VehicleFactory{
    public  TwoWheeler createVehicle(String type){
        if("Bike".equalsIgnoreCase(type))return new Bike();
        if("Scooty".equalsIgnoreCase(type))return new Scooty();
        return null;
    }
}
class FourWheelerFactory implements VehicleFactory{
    public  FourWheeler createVehicle(String type){
        if("Car".equalsIgnoreCase(type))return new Car();
        if("Taxi".equalsIgnoreCase(type))return new Taxi();
        return null;
    }
}

public class FactoryDesignPattern
{
	public static void main(String[] args) {
	 VehicleFactory twowheeler=new TwoWheelerFactory();
	  Vehicle bike=twowheeler.createVehicle("bike");
	  bike.drive();
	  
	  VehicleFactory fourwheeler=new FourWheelerFactory();
	  Vehicle car=fourwheeler.createVehicle("Car");
	  car.drive();
	  
	
	}
}