import GUI.*;
import TankThreads.*;
public class Main {
public static void main(String[] args) {
        GUI gui = new GUI();
        gui.createGUI();

        ThreadTank backend = new ThreadTank();
        backend.starting();

    }
}