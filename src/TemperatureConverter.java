import javax.swing.*;
import java.awt.*;

public class TemperatureConverter {

    public static void createScreen(){

        JFrame frame = new JFrame ("Converter");
        JTextField celsiusTextField = new JTextField(10);
        JLabel celsiusLabel = new JLabel("ºc");
        JButton convertButton = new JButton("Convert");
        JLabel convertedValueLabel = new JLabel();
        Container contentPane = frame.getContentPane();
        contentPane.setLayout (new GridLayout (2, 4, 2, 4));
        contentPane.add(celsiusTextField);
        contentPane.add(celsiusLabel);
        contentPane.add(convertButton);
        contentPane.add(convertedValueLabel);

        convertButton.addActionListener((e) -> {
            try {
            double celsius = Double.parseDouble(celsiusTextField.getText());
            double fahrenheit = celsius / 5 * 9 + 32;
            convertedValueLabel.setText(String.format("%.2f°F", fahrenheit));
            } catch (NumberFormatException ex) {
                convertedValueLabel.setText("Invalid input");
            }
        });

        //adjusts width, and height
        frame.pack();

        //centers
        frame.setLocationRelativeTo(null);

        //shows frame
        frame.setVisible(true);

        //defines behavior of close button
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TemperatureConverter::createScreen);
    }
}
