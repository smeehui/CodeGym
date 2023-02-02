package com.huy.app.model;

import javax.persistence.*;

@Entity
@Table(name = "transfers")
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @PrimaryKeyJoinColumn(name = "senderId", foreignKey = @ForeignKey(name = "fk_sender_customer"))
    private Customer sentCustomer;

    @ManyToOne()
    @PrimaryKeyJoinColumn(name = "recipientId", foreignKey = @ForeignKey(name = "fk_recipient_customer"))
    private Customer receivedCustomer;


    private double feeRate;
    private double amount;
    private double feeAmount;
    private double totalAmount;

    public Transfer() {
    }

    public Transfer(Long id, Customer sentCustomer, Customer receivedCustomer, double feeRate, double amount, double feeAmount, double totalAmount) {
        this.id = id;
        this.sentCustomer = sentCustomer;
        this.receivedCustomer = receivedCustomer;
        this.feeRate = feeRate;
        this.amount = amount;
        this.feeAmount = feeAmount;
        this.totalAmount = totalAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getSentCustomer() {
        return sentCustomer;
    }

    public void setSentCustomer(Customer sentCustomer) {
        this.sentCustomer = sentCustomer;
    }

    public Customer getReceivedCustomer() {
        return receivedCustomer;
    }

    public void setReceivedCustomer(Customer receivedCustomer) {
        this.receivedCustomer = receivedCustomer;
    }

    public double getFeeRate() {
        return feeRate;
    }

    public void setFeeRate(double feeRate) {
        this.feeRate = feeRate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getFeeAmount() {
        return feeAmount;
    }

    public void setFeeAmount(double feeAmount) {
        this.feeAmount = feeAmount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
