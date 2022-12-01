package com.example.anything;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;

import java.sql.ResultSet;
import java.sql.SQLException;

public class productPage {
    ListView<HBox> products;
    ListView<HBox> showProductsbyName(String search) throws SQLException {
        ObservableList<HBox> productList= FXCollections.observableArrayList();
        ResultSet res=HelloApplication.connection.executeQuery("Select * from product");
        products=new ListView<>();
        Label name=new Label();
        Label price=new Label();
        Label id=new Label();
        HBox detials=new HBox();

        name.setMinWidth(50);
        price.setMinWidth(50);
        id.setMinWidth(50);

        name.setText(" Name ");
        price.setText(" price ");
        id.setText(" ID ");

        detials.getChildren().addAll(id,name,price);
        productList.add(detials);

        while(res.next()) {
            if (res.getString("productName").toLowerCase().contains(search)) {
                Label productName = new Label();
                Label productPrice = new Label();
                Label productID = new Label();
                Button buy = new Button();
                HBox productDetials = new HBox();

                productName.setMinWidth(50);
                productPrice.setMinWidth(50);
                productID.setMinWidth(50);
                buy.setText("Buy");
                buy.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        System.out.println("You press Buy Button");
                    }
                });

                productName.setText(res.getString("productName"));
                productPrice.setText(res.getString("price"));
                productID.setText("" + res.getInt("productID"));

                productDetials.getChildren().addAll(productID, productName, productPrice, buy);
                productList.add(productDetials);
            }
        }
        products.setItems(productList);
        return products;
    }

    ListView<HBox> showProducts() throws SQLException {
        ObservableList<HBox> productList= FXCollections.observableArrayList();
        ResultSet res=HelloApplication.connection.executeQuery("Select * from product");
        products=new ListView<>();
        Label name=new Label();
        Label price=new Label();
        Label id=new Label();
        HBox detials=new HBox();

        name.setMinWidth(50);
        price.setMinWidth(50);
        id.setMinWidth(50);

        name.setText(" Name ");
        price.setText(" price ");
        id.setText(" ID ");

        detials.getChildren().addAll(id,name,price);
        productList.add(detials);

        while(res.next()){
            Label productName=new Label();
            Label productPrice=new Label();
            Label productID=new Label();
            Button buy=new Button();
            HBox productDetials=new HBox();

            productName.setMinWidth(50);
            productPrice.setMinWidth(50);
            productID.setMinWidth(50);
            buy.setText("Buy");
            buy.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    System.out.println("You press Buy Button");
                }
            });

            productName.setText(res.getString("productName"));
            productPrice.setText(res.getString("price"));
            productID.setText(""+res.getInt("productID"));

            productDetials.getChildren().addAll(productID,productName,productPrice,buy);
            productList.add(productDetials);
        }
        products.setItems(productList);
        return products;
    }



}
