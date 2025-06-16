package com.patterns.behavioral.chain;

public class ApprovalRequest {
    private final int id;
    private final double amount;
    private final String purpose;
    private boolean approved = false; // Track approval status
    private String approvedBy;     // Track who approved it

    public ApprovalRequest(int id, double amount, String purpose) {
        this.id = id;
        this.amount = amount;
        this.purpose = purpose;
    }

    public int getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public String getPurpose() {
        return purpose;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    @Override
    public String toString() {
        return "ApprovalRequest{" +
                "id=" + id +
                ", amount=" + String.format("%.2f", amount) +
                ", purpose='" + purpose + '\'' +
                ", approved=" + approved +
                (approvedBy != null ? ", approvedBy='" + approvedBy + '\'' : "") +
                '}';
    }
}
