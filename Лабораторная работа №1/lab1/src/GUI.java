import javax.swing.*;
import javax.swing.border.Border;
//import TankThreads.*;
import java.awt.event.*;
import java.awt.*;
public class GUI{
    void createGUI(){
        int BOR = 10;

        JFrame frame = new JFrame("example");

        frame.setSize(600,600);
        frame.setLayout(null);
        frame.setVisible(true);

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(BOR, BOR, BOR*4, BOR));
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        panel.add(Box.createHorizontalGlue());

        final JProgressBar progressBar1 = new JProgressBar();
        progressBar1.setOrientation(SwingConstants.VERTICAL);
        progressBar1.setStringPainted(true);
        progressBar1.setMinimum(0);
        progressBar1.setMaximum(1000);
        panel.add(progressBar1);

        final JProgressBar progressBar2 = new JProgressBar();
        progressBar2.setOrientation(SwingConstants.VERTICAL);
        progressBar2.setStringPainted(true);
        progressBar2.setMinimum(0);
        progressBar2.setMaximum(1000);
        panel.add(progressBar2);

        final JProgressBar progressBar3 = new JProgressBar();
        progressBar3.setOrientation(SwingConstants.VERTICAL);
        progressBar3.setStringPainted(true);
        progressBar3.setMinimum(0);
        progressBar3.setMaximum(1000);
        panel.add(progressBar3);

        panel.add(Box.createVerticalGlue());

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.X_AXIS));

        buttonsPanel.add(Box.createHorizontalGlue());

        JButton increment = new JButton("+10%");
        increment.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int value = progressBar2.getValue() + 10;
                int maximum = progressBar2.getMaximum();
                if(value > maximum) {
                    value = maximum;
                }
                progressBar2.setValue(value);
            }
        });

        buttonsPanel.add(increment);
        buttonsPanel.add(Box.createHorizontalGlue());

        JButton decrement = new JButton("-10%");
        decrement.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int value = progressBar2.getValue() - 10;
                int minimum = progressBar2.getMinimum();
                if(value < minimum) {
                    value = minimum;
                }
                progressBar2.setValue(value);
            }
        });
        buttonsPanel.add(decrement);
        buttonsPanel.add(Box.createHorizontalGlue());

        panel.add(buttonsPanel);

        panel.add(Box.createVerticalGlue());

        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(panel, BorderLayout.CENTER);

        frame.setPreferredSize(new Dimension(260, 225));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        GUI gui = new GUI();
        gui.createGUI();

        //Back backend = new Back();
        //backend.starting();

    }
}