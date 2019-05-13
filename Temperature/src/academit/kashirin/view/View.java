package academit.kashirin.view;

import academit.kashirin.InterfaceScale;
import academit.kashirin.InterfaceTemperatureView;
import academit.kashirin.controller.Controller;
import academit.kashirin.scale.Celsius;
import academit.kashirin.scale.Fahrenheit;
import academit.kashirin.scale.Kelvin;

import java.awt.*;
import javax.swing.*;

public class View extends JFrame implements InterfaceTemperatureView {
    private JTextField input = new JTextField("", 1);
    private String[] items = {"Цельсий", "Кельвин", "Фаренгейт"};
    private JComboBox<String> comboBoxInput = new JComboBox<>(items);
    private JComboBox<String> comboBoxOutput = new JComboBox<>(items);
    private JLabel output = new JLabel("");

    public View() {
        JFrame frame = new JFrame("Перевод температуры");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = 900;
        int height = 100;
        int locationX = (screenSize.width - width) / 2;
        int locationY = (screenSize.height - height) / 2;
        frame.setBounds(locationX, locationY, width, height);
        frame.setMinimumSize(new Dimension(900, 100));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = frame.getContentPane();
        container.setLayout(new GridLayout(0, 3));
        JLabel labelInput = new JLabel("Введите значение температуры:");
        container.add(labelInput);
        container.add(input);
        container.add(comboBoxInput);
        JLabel labelOutput = new JLabel("Конвертированное значение температуры:");
        container.add(labelOutput);
        container.add(output);
        container.add(comboBoxOutput);
        JButton button = new JButton("Расчет");
        button.addActionListener(new Controller(this, new InterfaceScale[]{new Celsius(), new Kelvin(), new Fahrenheit()}));
        frame.add(button);
        frame.setVisible(true);
    }

    @Override
    public Double getInputTemperature() {
        try {
            return Double.parseDouble(input.getText());
        } catch (NumberFormatException e) {
            final JPanel panel = new JPanel();
            JOptionPane.showMessageDialog(panel, "Enter valid data", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    @Override
    public void setOutputTemperature(Double temperature) {
        if (temperature == null) {
            output.setText("");
        } else {
            output.setText(Double.toString(temperature));
        }
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