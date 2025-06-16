package com.patterns.behavioral.chain;

public class DirectorApprover extends Approver {
    private static final double APPROVAL_LIMIT = 5000.00;

    public DirectorApprover(String approverName) {
        super(approverName);
    }

    @Override
    public void processRequest(ApprovalRequest request) {
        if (request.getAmount() <= APPROVAL_LIMIT) {
            System.out.println(approverName + " (Director) approved request #" + request.getId() +
                    " for amount " + String.format("%.2f", request.getAmount()) + ".");
            request.setApproved(true);
            request.setApprovedBy(approverName);
        } else {
            passToNext(request);
        }
    }
}
