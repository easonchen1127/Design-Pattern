package com.patterns.behavioral.chain;

// Handler: Defines an interface for handling requests and optionally a link to the successor.
public abstract class Approver {
    protected Approver nextApprover; // The next handler in the chain
    protected String approverName;

    public Approver(String approverName) {
        this.approverName = approverName;
    }

    // Method to set the next handler in the chain
    public void setNextApprover(Approver nextApprover) {
        this.nextApprover = nextApprover;
    }

    // The core method to process the request
    public abstract void processRequest(ApprovalRequest request);

    // Helper method to pass to the next approver if current can't handle
    protected void passToNext(ApprovalRequest request) {
        if (nextApprover != null) {
            System.out.println(approverName + " cannot approve. Passing to " + nextApprover.approverName + "...");
            nextApprover.processRequest(request);
        } else {
            System.out.println("Request for amount " + String.format("%.2f", request.getAmount()) +
                    " could not be approved by anyone in the chain.");
        }
    }
}
