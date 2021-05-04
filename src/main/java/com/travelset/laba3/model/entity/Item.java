package com.travelset.laba3.model.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "items")
public class Item {
    private int id;
    private String description;
    private double weight;
    private double calories;
    private int quantity;
    private Itemtype itemtype;
    private Collection<OrderItem> orderItems;

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
    @Column(name = "Description", unique = true)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "Weight")
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Basic
    @Column(name = "Calories")
    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
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

        Item item = (Item) o;

        if (id != item.id) return false;
        if (Double.compare(item.weight, weight) != 0) return false;
        if (Double.compare(item.calories, calories) != 0) return false;
        if (quantity != item.quantity) return false;
        if (description != null ? !description.equals(item.description) : item.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        temp = Double.doubleToLongBits(weight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(calories);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + quantity;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "ItemtypeId", referencedColumnName = "Id", nullable = false)
    public Itemtype getItemtype() {
        return itemtype;
    }

    public void setItemtype(Itemtype itemtype) {
        this.itemtype = itemtype;
    }

    @OneToMany(mappedBy = "item")
    public Collection<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Collection<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
