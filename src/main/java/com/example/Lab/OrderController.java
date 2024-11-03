package com.example.Lab;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class OrderController {

    // Внутренний класс для представления блюда
    public static class Dish {
        private String name;
        private double price;

        public Dish(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return name + " (" + price + " руб.)";
        }
    }

    // Внутренний класс для представления элемента заказа
    public static class OrderItem {
        private String name;
        private int quantity;
        private double unitPrice;

        public OrderItem(String name, int quantity, double unitPrice) {
            this.name = name;
            this.quantity = quantity;
            this.unitPrice = unitPrice;
        }

        public String getName() {
            return name;
        }

        public int getQuantity() {
            return quantity;
        }

        public double getTotalPrice() {
            return quantity * unitPrice;
        }

        @Override
        public String toString() {
            return name + " x" + quantity + " = " + getTotalPrice() + " руб.";
        }
    }

    @FXML
    private ComboBox<Dish> dishComboBox;
    @FXML
    private Spinner<Integer> quantitySpinner;
    @FXML
    private TableView<OrderItem> orderTable;
    @FXML
    private TableColumn<OrderItem, String> dishColumn;
    @FXML
    private TableColumn<OrderItem, Integer> quantityColumn;
    @FXML
    private TableColumn<OrderItem, Double> totalColumn;
    @FXML
    private Label totalPriceLabel;

    private ObservableList<OrderItem> orderItems = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Инициализация блюд
        dishComboBox.setItems(FXCollections.observableArrayList(
                new Dish("Салат", 150.0),
                new Dish("Суп", 200.0),
                new Dish("Стейк", 500.0),
                new Dish("Десерт", 250.0)
        ));

        // Настройка Spinner для выбора количества
        quantitySpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1));

        // Настройка колонок таблицы
        dishColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        totalColumn.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));

        // Установка данных для таблицы
        orderTable.setItems(orderItems);
        updateTotalPrice();
    }

    @FXML
    public void addDishToOrder(MouseEvent event) {
        Dish selectedDish = dishComboBox.getSelectionModel().getSelectedItem();
        int quantity = quantitySpinner.getValue();

        if (selectedDish != null) {
            OrderItem orderItem = new OrderItem(selectedDish.getName(), quantity, selectedDish.getPrice());
            orderItems.add(orderItem);
            updateTotalPrice();
        }
    }

    private void updateTotalPrice() {
        double total = orderItems.stream().mapToDouble(OrderItem::getTotalPrice).sum();
        totalPriceLabel.setText("Общая стоимость: " + total + " руб.");
    }
}
