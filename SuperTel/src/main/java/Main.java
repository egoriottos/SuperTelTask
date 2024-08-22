import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Результаты");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        JPanel panel = new JPanel(new BorderLayout());
        JTextField inputField = new JTextField();
        panel.add(inputField, BorderLayout.NORTH);

        JTextArea outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        panel.add(scrollPane, BorderLayout.CENTER);
        JButton generateButton = new JButton("Посчитать");
        panel.add(generateButton, BorderLayout.SOUTH);
        frame.add(panel);

        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                PackOfIndexes packOfIndexes = new PackOfIndexes(input.split(","));

                List<Integer> indexes = packOfIndexes.generateIndexes();
                List<List<Integer>> combinations = packOfIndexes.generateAllCombinations(indexes);

                for (List<Integer> combination : combinations) {
                    outputArea.append(combination.toString() + "\n");
                }
            }
        });

        // Показываем окно
        frame.setVisible(true);
    }
}
