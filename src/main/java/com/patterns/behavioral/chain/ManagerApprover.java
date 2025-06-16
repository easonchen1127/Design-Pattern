package com.patterns.behavioral.chain;

// ConcreteHandler: Handles the request it is responsible for.
// Can access its successor. If it can't handle, passes to successor.
public class ManagerApprover extends Approver {
    private static final double APPROVAL_LIMIT = 1000.00;

    public ManagerApprover(String approverName) {
        super(approverName);
    }

    @Override
    public void processRequest(ApprovalRequest request) {
        if (request.getAmount() <= APPROVAL_LIMIT) {
            System.out.println(approverName + " (Manager) approved request #" + request.getId() +
                    " for amount " + String.format("%.2f", request.getAmount()) + ".");
            request.setApproved(true);
            request.setApprovedBy(approverName);
        } else {
            passToNext(request);
        }
    }
}
