package com.thoughtworks.tdd;

import java.util.UUID;

public class Receipt {
    private String ReceiptId;

    public String getReceiptId() {
        return ReceiptId;
    }

    public void setReceiptId(String receiptId) {
        ReceiptId = receiptId;
    }

    public Receipt() {
        this.ReceiptId = UUID.randomUUID().toString();

    }
    public Receipt(String ReceiptId) {
        this.ReceiptId = ReceiptId;

    }
}
