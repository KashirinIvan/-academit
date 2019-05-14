package academit.kashirin.controller;

import academit.kashirin.Scale;
import academit.kashirin.TemperatureView;
import academit.kashirin.view.View;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
    private TemperatureView view;
    private Scale[] scales;

    public Controller(View view, Scale[] scale) {
        this.view = view;
        this.scales = scale;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        view.setOutputTemperature(scales[view.getOutputScale()].convertFromCelsius(scales[view.getInputScale()].convertToCelsius(view.getInputTemperature())));
    }
}
