import academit.kashirin.controller.Controller;
import academit.kashirin.view.View;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                View view = new View();
                Controller controller = new Controller(view);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
