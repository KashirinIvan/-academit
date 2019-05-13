package academit.kashirin.controller;

import academit.kashirin.InterfaceScale;
import academit.kashirin.InterfaceTemperatureView;
import academit.kashirin.view.View;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
    private InterfaceTemperatureView view;
    private InterfaceScale[] scales;

    public Controller(View view, InterfaceScale[] scale) {
        this.view = view;
        this.scales = scale;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        scales[view.getInputScale()].ConvertInCelsius(view.getInputTemperature());
        view.setOutputTemperature(scales[view.getOutputScale()].ConvertFromCelsius());
    }
}
