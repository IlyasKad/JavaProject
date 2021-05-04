package com.travelset.laba3.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "orderItems",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"ItemId", "OrderId"})})
public class OrderItem {
    private int id;
    private int quantity;
    private Item item;
    private Order order;

    public OrderItem() {
    }

    public OrderItem(Order order, Item item, int quantity) {
        this.quantity = quantity;
        this.item = item;
        this.order = order;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Quantity")
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderItem that = (OrderItem) o;

        if (id != that.id) return false;
        if (quantity != that.quantity) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + quantity;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "ItemId", referencedColumnName = "Id", nullable = false)
    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @ManyToOne
    @JoinColumn(name = "OrderId", referencedColumnName = "Id", nullable = false)
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
