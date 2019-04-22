package academit.kashirin.view;

import javax.swing.*;

public class View {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("My first GUI application");
                frame.setSize(300, 200); // размер окна
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                frame.setVisible(true);
            }
        });
    }
}