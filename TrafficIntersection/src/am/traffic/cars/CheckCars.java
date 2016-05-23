package am.traffic.cars;

import am.traffic.cars.Car;
import am.traffic.light.TrafficLight;
import am.traffic.light.TrafficLight1;

import java.util.ArrayList;

public class CheckCars extends Thread {

    ArrayList<Car> cars1 ;
    ArrayList<Car> cars2 ;

    public CheckCars(ArrayList<Car> cars1,ArrayList<Car> cars2) {
        this.cars1 = cars1;
        this.cars2 =cars2;
    }

    /*public void checkCars(Car car){

        for (int i = 0; i < cars.size() - 1; i++) {
            if (car.equals(cars.get(i)) && ((car.getX()+120)>cars.get(i+1).getX())){
                System.out.println("STOP");
                cars.get(i).stoping();
            }
        }
    }*/

    public void checking1(Car car1,Car car2){
        if (((car1.getX()==730)  && (car1.getX()+130>car2.getX()))){
            for (int i = 0; i < cars1.size(); i++) {
                cars1.get(i).stoping();
            }
        }
        if (TrafficLight1.isGreen){
            for (int i = 0; i < cars1.size(); i++) {
                cars1.get(i).going();
            }
        }
    }

    public void checking2(Car car1,Car car2){
        if (((car1.getX()==340)  && (car1.getX()-130<car2.getX()))){
            for (int i = 0; i < cars2.size(); i++) {
                cars2.get(i).stoping();
            }
        }
        if (TrafficLight1.isGreen){
            for (int i = 0; i < cars2.size(); i++) {
                cars2.get(i).going();
            }
        }
    }

    @Override
    public void run() {
        currentThread().setPriority(10);
        while (true){
            if (!TrafficLight1.isGreen){
                for (int i = 0; i < cars1.size()-1; i++) {
                    checking1(cars1.get(i),cars1.get(i+1));
                }
                for (int i = 0; i < cars2.size()-1; i++) {
                    checking2(cars2.get(i),cars2.get(i+1));
                }
            }

        }
    }
}
