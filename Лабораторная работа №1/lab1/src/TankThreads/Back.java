package TankThreads;

import java.util.Random;

public class Back {
    public void starting() {

        //Thread myThread = new Thread(new MyThread(), "t1");
        //myThread.start();
        Thread thread1 = new Thread(new TankThread(), "tank1");
        Thread thread2 = new Thread(new TankThread(), "tank2");
        Thread thread3 = new Thread(new TankThread(), "tank3");

        System.out.println(thread1.threadId());
        System.out.println(thread2.threadId());
        System.out.println(thread3.threadId());

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
class TankThread extends Thread{

    @Override
    public void run(){
        System.out.println("Hello, I'm " + Thread.currentThread());
        Tank tank = new Tank(1000);

        while (tank.getCurVolume()<=1000){
            tank.add();
            //tank.view();
            System.out.println(tank.getCurVolume());

        }
    }
}

class Tank{
    Random random = new Random();
    final int tankSize;
    int curVolume;
    public int[] cupsSize = {5, 7, 10};

    Tank(int Size){
        tankSize = Size;
    }
    void antiSort(){
        int buff;
        for(int j=0; j<cupsSize.length-1; j++){
            int rNum =random.nextInt(1,3);
            if(j != rNum){
                buff = cupsSize[j];
                cupsSize[j] = cupsSize[rNum];
                cupsSize[rNum] = buff;
            }

        }
    }
    void add(){
        antiSort();
        if(curVolume <= tankSize)
            curVolume+=cupsSize[1];
    }
    void view(){
        for(int i = 0; i < cupsSize.length; i++)
            System.out.print(cupsSize[i] + " ");
        System.out.println();
    }
    int getCurVolume(){
        return curVolume;
    }
    int getrandNum(){
        return random.nextInt(1,4);
    }

}