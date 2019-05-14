package academit.kashirin;

public interface TemperatureView {
    Double getInputTemperature();

    void setOutputTemperature(Double temperature);

    int getInputScale();

    int getOutputScale();
}
