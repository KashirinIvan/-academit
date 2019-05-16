package academit.kashirin;

import academit.kashirin.controller.Controller;

import java.awt.event.ActionListener;

public interface TemperatureView {
    Double getInputTemperature();

    void setOutputTemperature(Double temperature);

    int getInputScale();

    int getOutputScale();

    ActionListener setController(Controller controller);

}
