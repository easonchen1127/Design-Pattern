package com.patterns.behavioral.chain;

public class VicePresidentApprover extends Approver {
    // VP can approve any amount (for this example, effectively no limit or a very high one)
    private static final double APPROVAL_LIMIT = Double.MAX_VALUE;

    public VicePresidentApprover(String approverName) {
        super(approverName);
    }

    @Override
    public void processRequest(ApprovalRequest request) {
        if (request.getAmount() <= APPROVAL_LIMIT) { // Or simply always approve
            System.out.println(approverName + " (Vice President) approved request #" + request.getId() +
                    " for amount " + String.format("%.2f", request.getAmount()) + ".");
            request.setApproved(true);
            request.setApprovedBy(approverName);
        } else {
            // Should not happen if VP is the last in chain with a high limit
            passToNext(request);
        }
    }
}
