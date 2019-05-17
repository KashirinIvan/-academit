package academit.kashirin;

import java.awt.event.ActionListener;

public interface TemperatureView {
    Double getInputTemperature();

    void setOutputTemperature(Double temperature);

    int getInputScale();

    int getOutputScale();

    void setController(ActionListener controller);

}
