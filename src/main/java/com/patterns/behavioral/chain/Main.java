package com.patterns.behavioral.chain;

public class Main {

    // Helper method to create the chain
    private static Approver buildApprovalChain() {
        Approver manager = new ManagerApprover("Alice (Manager)");
        Approver director = new DirectorApprover("Bob (Director)");
        Approver vp = new VicePresidentApprover("Carol (VP)");

        // Set up the chain: Manager -> Director -> VP
        manager.setNextApprover(director);
        director.setNextApprover(vp);
        // vp is the end of the chain, its nextApprover remains null

        return manager; // Return the start of the chain
    }

    public static void main(String[] args) {
        Approver approvalChain = buildApprovalChain();

        System.out.println("--- Processing Approval Requests ---");

        ApprovalRequest request1 = new ApprovalRequest(101, 500.00, "Office Supplies");
        System.out.println("\nSubmitting request: " + request1);
        approvalChain.processRequest(request1);
        System.out.println("Request final status: " + request1);

        ApprovalRequest request2 = new ApprovalRequest(102, 3500.00, "New Server Hardware");
        System.out.println("\nSubmitting request: " + request2);
        approvalChain.processRequest(request2);
        System.out.println("Request final status: " + request2);

        ApprovalRequest request3 = new ApprovalRequest(103, 15000.00, "Company Retreat Budget");
        System.out.println("\nSubmitting request: " + request3);
        approvalChain.processRequest(request3);
        System.out.println("Request final status: " + request3);

        ApprovalRequest request4 = new ApprovalRequest(104, 200000.00, "Acquisition Proposal");
        System.out.println("\nSubmitting request: " + request4);
        approvalChain.processRequest(request4); // VP has no upper limit in this example
        System.out.println("Request final status: " + request4);

        System.out.println("\n--- Example of a request that might not be approved by anyone ---");
        // If VP also had a limit, e.g., 50000
        // VicePresidentApprover vpWithLimit = new VicePresidentApprover("David (Limited VP)");
        // // set APPROVAL_LIMIT to 50000 in vpWithLimit
        // // Rebuild chain...
        // ApprovalRequest request5 = new ApprovalRequest(105, 75000.00, "Very Large Expenditure");
        // approvalChain.processRequest(request5);
        // System.out.println("Request final status: " + request5);
    }
}
