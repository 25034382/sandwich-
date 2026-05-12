/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package gundo.jsandwich;

/**
 *
 * @author 25034382
 */
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class    Jsandwich {
    public static void main(String[] args) {
        JFrame frame = new JFrame("SUBLIME SANDWICH SHOP");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        // Main panel with vertical layout
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(new Color(230, 240, 250)); // soft blue background

        // Title
        JLabel title = new JLabel("SUBLIME SANDWICH SHOP", SwingConstants.CENTER);
        title.setFont(new Font("Verdana", Font.BOLD, 26));
        title.setForeground(new Color(128, 0, 128)); // purple text
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(title);

        // Bread section (3 types only)
        JPanel breadPanel = new JPanel();
        breadPanel.setBorder(new TitledBorder("Choose Your Bread"));
        breadPanel.setBackground(new Color(255, 228, 196)); // bisque
        String[] breads = {"White Bread", "Brown Bread", "Multigrain"};
        JComboBox<String> breadBox = new JComboBox<>(breads);
        breadBox.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
        breadPanel.add(breadBox);

        // Sandwich section (3 types only)
        JPanel sandwichPanel = new JPanel();
        sandwichPanel.setBorder(new TitledBorder("Choose Your Sandwich"));
        sandwichPanel.setBackground(new Color(224, 255, 224)); // light green
        String[] sandwiches = {"Beef", "Chicken", "Veggie"};
        JComboBox<String> sandwichBox = new JComboBox<>(sandwiches);
        sandwichBox.setFont(new Font("Georgia", Font.BOLD, 14));
        sandwichPanel.add(sandwichBox);

        // Price section
        JPanel pricePanel = new JPanel();
        pricePanel.setBackground(new Color(240, 255, 255)); // light cyan
        JButton priceButton = new JButton("TOTAL PRICE");
        priceButton.setFont(new Font("Arial Black", Font.BOLD, 16));
        priceButton.setBackground(new Color(255, 69, 0)); // orange-red button
        priceButton.setForeground(Color.WHITE);

        JLabel priceLabel = new JLabel("Price will appear here");
        priceLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
        priceLabel.setForeground(new Color(0, 100, 0)); // dark green text

        pricePanel.add(priceButton);
        pricePanel.add(priceLabel);

        // Button logic
        priceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bread = (String) breadBox.getSelectedItem();
                String sandwich = (String) sandwichBox.getSelectedItem();

                int price = 0;
                switch (sandwich) {
                    case "Beef": price = 50; break;
                    case "Chicken": price = 40; break;
                    case "Veggie": price = 30; break;
                }

                if (bread.equals("Multigrain")) {
                    price += 10;
                } else if (bread.equals("Brown Bread")) {
                    price += 5;
                }

                priceLabel.setText("Total Price: R" + price);
            }
        });

        // Add sections to main panel
        mainPanel.add(breadPanel);
        mainPanel.add(sandwichPanel);
        mainPanel.add(pricePanel);

        frame.add(mainPanel);
        frame.setVisible(true);
    }
}
