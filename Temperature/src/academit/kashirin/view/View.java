package academit.kashirin.view;

import academit.kashirin.Interface;
import academit.kashirin.controller.Controller;

import java.awt.*;
import javax.swing.*;

public class View extends JFrame implements Interface {
    private JButton button = new JButton("Расчет");
    private JTextField input = new JTextField("", 1);
    private JLabel labelInput = new JLabel("Введите значение температуры:");
    String[] items = {"Цельсий", "Кельвин", "Фаренгейт"};
    private JComboBox comboBoxInput = new JComboBox(items);
    private JComboBox comboBoxOutput = new JComboBox(items);
    private JLabel output = new JLabel("");
    private JLabel labelOutput = new JLabel("Конвертированное значение температуры:");

    public View() {
        JFrame frame = new JFrame("Перевод температуры");
        frame.setSize(900, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = frame.getContentPane();
        container.setLayout(new GridLayout(0, 3));
        container.add(labelInput);
        container.add(input);
        container.add(comboBoxInput);
        container.add(labelOutput);
        container.add(output);
        container.add(comboBoxOutput);
        button.addActionListener(new Controller(this));
        frame.add(button);
        frame.setVisible(true);
    }

    @Override
    public double getInputTemperature() {
        return Double.parseDouble(input.getText());
    }

    @Override
    public void setOutputTemperature(double temperature) {
        output.setText(Double.toString(temperature));
    }

    @Override
    public int getInputScale() {
        return comboBoxInput.getSelectedIndex();
    }

    @Override
    public int getOutputScale() {
        return comboBoxOutput.getSelectedIndex();
    }


}