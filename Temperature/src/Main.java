import academit.kashirin.view.View;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                new View();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
