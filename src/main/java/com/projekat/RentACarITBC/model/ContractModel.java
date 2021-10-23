package com.projekat.RentACarITBC.model;

import java.time.LocalDate;
import java.util.UUID;

public class ContractModel {
    private UUID contractId;
    private String userId;
    private String carId;
    private LocalDate startDate;
    private LocalDate endDate;
    private double totalPrice;
    private boolean signed;
    private boolean approved;

    public ContractModel(LocalDate startDate, LocalDate endDate, double totalPrice, boolean signed, boolean approved) {
        this.contractId = UUID.randomUUID();
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalPrice = totalPrice;
        this.signed = signed;
        this.approved = approved;
    }

    public UUID getContractId() {
        return contractId;
    }

    public void setContractId(UUID contractId) {
        this.contractId = contractId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public boolean isSigned() {
        return signed;
    }

    public void setSigned(boolean signed) {
        this.signed = signed;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }
}
