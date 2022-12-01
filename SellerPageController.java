package com.example.anything;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SellerPageController {
    @FXML
    TextField name;

    @FXML
    TextField price;

    @FXML
    TextField email;

    @FXML
    public void Add(MouseEvent event)throws SQLException {
        ResultSet res = HelloApplication.connection.executeQuery("Select max(productID) from product");
        int productID = 0;
        if (res.next())
            productID = res.getInt("max(productID)") + 1;
        String query = String.format("Insert Into product values(%s,%s,%s,%s)", productID, name.getText(), price.getText(), email.getText());
        int response = HelloApplication.connection.executeUpdate(query);
        System.out.println(response);
    }
}
