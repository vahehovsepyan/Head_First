package am.traffic.light;

public class TrafficLight1 extends TrafficLight {
    public static boolean isGreen=true;
    public static boolean isRed= false;
    private int count=0;

    public void trafficLight(){
        try {
            Thread.sleep(1000);
            count++;
            if(count>=0 && count<=10){
                isGreen=true;
                isRed =false;

            }else if (count>10 && count<=11){
                isGreen=false;
                isRed=false;

            }else if (count>11 && count<=20){
                isRed=true;
                isGreen=false;
                if (count==20){
                    count=0;
                    isGreen=true;
                    isRed=false;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        while (true){
            trafficLight();
        }
    }
}
