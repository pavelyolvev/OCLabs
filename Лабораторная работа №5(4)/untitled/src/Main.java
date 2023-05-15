import java.util.Scanner;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class DeadlockExample {
    private final Lock paper = new ReentrantLock();//Ресурс цветная бумана
    private final Lock scissors = new ReentrantLock(); //Ресурс ножницы
    public void mashaDo(){
        try {
            paper.lockInterruptibly();
            System.out.println("Маша взяла цветную бумагу");
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {}
        try {
            scissors.lockInterruptibly();
            System.out.println("Маша взяла ножницы");
            Thread.sleep(1000);
            System.out.println("Маша закончила аппликацию");
            scissors.unlock();
        } catch (InterruptedException ignored) {}

        paper.unlock();
        /*
        if(paper.tryLock()) {
            System.out.println("Маша взяла цветную бумагу");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {}
            if(scissors.tryLock()) {
                System.out.println("Маша взяла ножницы");
            }
        }

         */
    }
    public void dashaDo(){
        try {
            scissors.lockInterruptibly();
            System.out.println("Даша взяла ножницы");
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {}
        try {
            paper.lockInterruptibly();
            System.out.println("Даша взяла цветную бумагу");
            Thread.sleep(1000);
            System.out.println("Даша закончила аппликацию");
            paper.unlock();
        } catch (InterruptedException ignored) {}

        scissors.unlock();
        /*
        if(scissors.tryLock()) {
            System.out.println("Даша взяла ножницы");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {}
            if(paper.tryLock()) {
                System.out.println("Даша взяла цветную бумагу");
            }
        }

         */
    }
    public void mashaDoSync(){

        try {
            paper.lock();
            System.out.println("Маша взяла цветную бумагу");
            Thread.sleep(1000);
            scissors.lock();
            System.out.println("Маша взяла ножницы");
            Thread.sleep(1000);
            System.out.println("Маша закончила аппликацию");
            scissors.unlock();
            paper.unlock();
        } catch (InterruptedException ignored) {}

    }
    public void dashaDoSync(){

        try {
            paper.lock();
            System.out.println("Даша взяла цветную бумагу");
            Thread.sleep(1000);
            scissors.lock();
            System.out.println("Даша взяла ножницы");
            Thread.sleep(1000);
            System.out.println("Даша закончила аппликацию");
            scissors.unlock();
            paper.unlock();
        } catch (InterruptedException ignored) {}

    }
    public void unlockScissors(){

    }
    public void unlockPaper(){
        paper.unlock();
    }

}
public class Main{
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Даша и Маша хотят делать аппликации, но ножницы и бумага только 1");
        System.out.println("Вмешаться воспитательнице?");
        String choice = in.nextLine();
        switch (choice) {
            case "Да" -> {
                System.out.println("Воспитательница сказала Даше и Маше делать аппликацию по очереди");
                controlledWork();
            }
            case "Нет" -> {
                System.out.println("Даша и Маша не хотят делиться принадлежностями");
                uncontrolledWork();
            }
            default -> System.out.println("Маша и Даша будут вечно ждать друг друга");
        }
    }

    static void controlledWork(){
        DeadlockExample deadlock = new DeadlockExample();
        Thread mashaWork = new Thread(deadlock::mashaDoSync);
        Thread dashaWork = new Thread(deadlock::dashaDoSync);

        mashaWork.start();
        dashaWork.start();
    }
    static void uncontrolledWork(){
        DeadlockExample deadlock = new DeadlockExample();
        Thread mashaWork = new Thread(deadlock::mashaDo);
        Thread dashaWork = new Thread(deadlock::dashaDo);

        mashaWork.start();
        dashaWork.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {}


        System.out.println("Кажется Даша и Маша не хотят делиться принадлежностями друг с другом \nВмешаться воспитательнице? \n 1 - сказать Даше отдать цветную бумагу Маше \n 2 - сказать Маше отдать ножницы Даше");
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        switch (choice) {
            case 1 -> {
                System.out.println("Воспитательница сказала Даше отдать цветную бумагу Маше");
                dashaWork.interrupt();
                System.out.println("Даша расстроилась и убежала");
            }
            case 2 -> {
                System.out.println("Воспитательница сказала Маше отдать ножницы Даше");
                mashaWork.interrupt();
                System.out.println("Маша расстроилась и убежала");
            }
            default -> System.out.println("Маша и Даша будут вечно ждать друг друга");
        }
    }
}

