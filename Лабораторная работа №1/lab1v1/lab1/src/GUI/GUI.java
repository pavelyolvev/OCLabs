package GUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;
import java.awt.*;
public class GUI extends JFrame{
    JFrame frame;
    JPanel panel;
    JMenu menu;
    JMenuBar menuBar;
    JMenuItem thread1, thread2, thread3;
    JProgressBar progressBar;
    JProgressBar progressBar2;
    JProgressBar progressBar3;
    public void createGUI() {
        frame = new JFrame("Tanks");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(Box.createHorizontalGlue());

        progressBar = new JProgressBar(0, 1000);
        progressBar2 = new JProgressBar(0, 1000);
        progressBar3 = new JProgressBar(0, 1000);
        DropMenu();

        progressBars(progressBar);
        progressBars(progressBar2);
        progressBars(progressBar3);

        panel.add(progressBar);
        panel.add(progressBar2);
        panel.add(progressBar3);

        frame.setJMenuBar(menuBar);
        frame.setSize(800, 800);
        frame.add(panel);
        frame.setContentPane(panel);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    void DropMenu(){
        menu = new JMenu("Threads");
        menuBar = new JMenuBar();
        thread1 = new JMenuItem("thread 1");
        thread2 = new JMenuItem("thread 2");
        thread3 = new JMenuItem("thread 3");

        menu.add(thread1);
        menu.add(thread2);
        menu.add(thread3);
        menuBar.add(menu);
    }

    void progressBars(JProgressBar progressBar){

        progressBar.setOrientation(SwingConstants.VERTICAL);
        progressBar.setValue(0);
        progressBar.setStringPainted(true);
    }
}

