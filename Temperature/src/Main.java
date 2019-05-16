import academit.kashirin.Scale;
import academit.kashirin.controller.Controller;
import academit.kashirin.scale.Celsius;
import academit.kashirin.scale.Fahrenheit;
import academit.kashirin.scale.Kelvin;
import academit.kashirin.view.View;

public class Main {
    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view, new Scale[]{new Celsius(), new Kelvin(), new Fahrenheit()});
        view.setController(controller);
        view.initialize();
    }
}
