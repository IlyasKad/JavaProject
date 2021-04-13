package com.travelset.model.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "Orders")
public class Order {
    private int id;
    private String delivery;
    private String payment;
    private boolean isPaid;
    private Timestamp createdAt;
    private Timestamp datePaid;
    private Collection<Orderline> orderlines;
    private User user;
    private Status status;
    private Backpack backpack;

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
    @Column(name = "Delivery")
    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    @Basic
    @Column(name = "Payment")
    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    @Basic
    @Column(name = "IsPaid")
    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }



    @Basic
    @Column(name = "CreatedAt")
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Basic
    @Column(name = "DatePaid")
    public Timestamp getDatePaid() {
        return datePaid;
    }

    public void setDatePaid(Timestamp datePaid) {
        this.datePaid = datePaid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order orders = (Order) o;

        if (id != orders.id) return false;
        if (isPaid != orders.isPaid) return false;

        if (delivery != null ? !delivery.equals(orders.delivery) : orders.delivery != null) return false;
        if (payment != null ? !payment.equals(orders.payment) : orders.payment != null) return false;
        if (createdAt != null ? !createdAt.equals(orders.createdAt) : orders.createdAt != null) return false;
        if (datePaid != null ? !datePaid.equals(orders.datePaid) : orders.datePaid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (delivery != null ? delivery.hashCode() : 0);
        result = 31 * result + (payment != null ? payment.hashCode() : 0);
        result = 31 * result + (isPaid ? 1 : 0);

        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (datePaid != null ? datePaid.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "order")
    public Collection<Orderline> getOrderlines() {
        return orderlines;
    }

    public void setOrderlines(Collection<Orderline> orderlines) {
        this.orderlines = orderlines;
    }

    @ManyToOne
    @JoinColumn(name = "UserId", referencedColumnName = "Id", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name = "StatusId", referencedColumnName = "id", nullable = false)
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @ManyToOne
    @JoinColumn(name = "backpackId", referencedColumnName = "id", nullable = false)
    public Backpack getBackpack() {
        return backpack;
    }

    public void setBackpack(Backpack backpack) {
        this.backpack = backpack;
    }
}
