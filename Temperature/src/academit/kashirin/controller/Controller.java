package academit.kashirin.controller;

import academit.kashirin.Interface;
import academit.kashirin.model.Model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
    private Interface view;
    private Model model = new Model();

    public Controller(Interface view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        model.setInput(view.getInputTemperature());
        view.setOutputTemperature(model.getOutput());
    }
}
