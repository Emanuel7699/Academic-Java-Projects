/**DupCount.
 * @author Emanuel Abraham
 * @version 28/04/2026 (2026b)
 */


package com.example.maman03;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class DupCountController {

    private DupCount<String> cart = new DupCount<>();


    @FXML
    private ListView<String> colProduct;

    @FXML
    private ListView<Integer> colQuantity;

    @FXML
    private Label maxProduct;

    @FXML
    private ListView<String> productsList;

    // Remove a product from the seleced list.
    @FXML
    void addToCart(ActionEvent event) {
        String selected = productsList.getSelectionModel().getSelectedItem();
        if (selected == null) return;
        cart.add(selected);
        updateScreen();
    }

    // Remove a product from the seleced list.
    @FXML
    void removeFromCart(ActionEvent event) {
        String selected = productsList.getSelectionModel().getSelectedItem();
        if (selected == null) return;
        cart.remove(selected);
        updateScreen();
    }

    // Screen the summary message.
    @FXML
    void showSummary(ActionEvent event) {

        String summary = "";

        for (Map.Entry<String, Integer> entry : cart.getMap().entrySet()) {
            summary += entry.getKey() + " -> " + entry.getValue() + "\n";
        }

        JOptionPane.showMessageDialog(null, summary, "Cart Summary", JOptionPane.INFORMATION_MESSAGE);
    }

    // Update the max product field and the selected products and quantity.
    private void updateScreen() {
        colProduct.getItems().clear();
        colQuantity.getItems().clear();

        for (Map.Entry<String, Integer> entry : cart.getMap().entrySet()) {
            colProduct.getItems().add(entry.getKey());
            colQuantity.getItems().add(entry.getValue());
        }
        maxProduct.setText("Most Frequent Product: " + cart.getMaxDup());
    }

    // Read the shopping list file to the ListView.
    @FXML
    public void initialize() {
        try {
            BufferedReader in = new BufferedReader(new FileReader("ShoppingList.txt"));
            String line;

            while ((line = in.readLine()) != null) {
                productsList.getItems().add(line);
            }

            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}