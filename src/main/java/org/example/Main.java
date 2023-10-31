package org.example;

import java.util.ArrayList;
import java.util.List;

class Customer {
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {return name;}
}

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {return name;}

    public double getPrice() {return price;}
}

class Order {
    private Customer customer;
    private Product product;
    private int quantity;

    public Order(Customer customer, Product product, int quantity) {
        this.customer = customer;
        this.product = product;
        this.quantity = quantity;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}

class OnlineShop {
    private static List<Customer> customers = new ArrayList<>();
    private static List<Product> products = new ArrayList<>();
    private static List<Order> orders = new ArrayList<>();

    public static void main(String[] args) {

        Customer cust1 = new Customer("Andrey");
        Customer cust2 = new Customer("Olga");
        customers.add(cust1 );
        customers.add(cust2);


        Product prod1 = new Product("Phone", 499.99);
        Product prod2 = new Product("Laptop", 999.99);
        products.add(prod1);
        products.add(prod2);


        try {
            makePurchase(cust1 , prod1, 2);
            makePurchase(cust2, prod2, 1);
            makePurchase(cust1 , prod2, -1);
        } catch (Exception e) {
            System.out.println("Ошибка при совершении покупки: " + e.getMessage());
        }

        System.out.println("Итоговое количество совершенных покупок: " + orders.size());
    }

    public static Order makePurchase(Customer customer, Product product, int quantity) throws Exception {
        if (!customers.contains(customer)) {
            throw new Exception("Несуществующий покупатель");
        }

        if (!products.contains(product)) {
            throw new Exception("Несуществующий товар");
        }

        if (quantity <= 0) {
            throw new Exception("Отрицательное количество товара");
        }

        Order order = new Order(customer, product, quantity);
        orders.add(order);
        return order;
    }
}