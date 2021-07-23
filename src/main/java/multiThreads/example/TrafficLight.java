package multiThreads.example;

import java.util.concurrent.Semaphore;

/**
 * @author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @date: 2021/5/13 19:25
 */
public class TrafficLight {
    private Semaphore s;
    boolean isAGreen;

    public TrafficLight() {
        s = new Semaphore(1);
        isAGreen = true;
    }

    /**
     * @param carId     Id of the car
     * @param roadId    ID of the road the car travels on. Can be 1 (road A) or 2 (road B)
     * @param direction Direction of the car
     * @param turnGreen Use turnGreen.run() to turn light to green on current road
     * @param crossCar  Use crossCar.run() to make car cross the intersection
     */
    public void carArrived(int carId, int roadId, int direction, Runnable turnGreen, Runnable crossCar) throws InterruptedException {
        s.acquire();
        if (roadId == 2 && isAGreen == true || roadId == 1 && isAGreen == false) {
            turnGreen.run();
            isAGreen = !isAGreen;
        }
        crossCar.run();
        s.release();
    }
}
