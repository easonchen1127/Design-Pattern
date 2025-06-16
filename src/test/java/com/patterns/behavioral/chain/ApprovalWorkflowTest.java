package com.patterns.behavioral.chain;

import com.patterns.behavioral.chain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ApprovalWorkflowTest {

    private Approver manager;
    private Approver director;
    private Approver vp;

    @BeforeEach
    void setUpChain() {
        manager = new ManagerApprover("TestManager");
        director = new DirectorApprover("TestDirector");
        vp = new VicePresidentApprover("TestVP");

        manager.setNextApprover(director);
        director.setNextApprover(vp);
    }

    @Test
    void requestApprovedByManager() {
        ApprovalRequest request = new ApprovalRequest(1, 500.00, "Small purchase");
        manager.processRequest(request);

        assertTrue(request.isApproved());
        assertEquals("TestManager", request.getApprovedBy());
    }

    @Test
    void requestApprovedByDirector_whenManagerCannotApprove() {
        ApprovalRequest request = new ApprovalRequest(2, 2500.00, "Medium purchase");
        manager.processRequest(request); // Start with manager

        assertTrue(request.isApproved());
        assertEquals("TestDirector", request.getApprovedBy());
    }

    @Test
    void requestApprovedByVP_whenDirectorCannotApprove() {
        ApprovalRequest request = new ApprovalRequest(3, 10000.00, "Large purchase");
        manager.processRequest(request); // Start with manager

        assertTrue(request.isApproved());
        assertEquals("TestVP", request.getApprovedBy());
    }

    @Test
    void requestApprovedByVP_forVeryLargeAmount() {
        ApprovalRequest request = new ApprovalRequest(4, 100000.00, "Huge purchase");
        manager.processRequest(request);

        assertTrue(request.isApproved());
        assertEquals("TestVP", request.getApprovedBy());
    }

    @Test
    void requestNotApproved_ifNoOneCanApprove_andVpHasLimit() {
        // For this test, let's imagine a VP with a limit
        Approver limitedVP = new Approver("LimitedVP") { // Anonymous inner class for test
            private final double LIMIT = 20000;
            @Override
            public void processRequest(ApprovalRequest request) {
                if (request.getAmount() <= LIMIT) {
                    request.setApproved(true);
                    request.setApprovedBy(this.approverName);
                } else {
                    // No next approver to pass to for this specific test setup
                    System.out.println(this.approverName + " cannot approve. End of this test chain.");
                }
            }
        };
        Approver testManager = new ManagerApprover("M");
        Approver testDirector = new DirectorApprover("D");
        testManager.setNextApprover(testDirector);
        testDirector.setNextApprover(limitedVP); // Chain ends with limited VP

        ApprovalRequest request = new ApprovalRequest(5, 25000.00, "Exceeds limited VP");
        testManager.processRequest(request);

        assertFalse(request.isApproved(), "Request should not be approved if it exceeds all limits.");
        assertNull(request.getApprovedBy());
    }

    @Test
    void requestPassedAlongChainCorrectly() {
        // We can use Mockito to verify pass-through, but for simplicity here,
        // we rely on the state of the ApprovalRequest.
        // More detailed tests could mock each approver to verify `processRequest` calls.

        // Manager limit 1000, Director limit 5000
        ApprovalRequest requestForDirector = new ApprovalRequest(6, 1001.00, "Just over Manager limit");
        manager.processRequest(requestForDirector);
        assertTrue(requestForDirector.isApproved());
        assertEquals("TestDirector", requestForDirector.getApprovedBy());

        ApprovalRequest requestForVP = new ApprovalRequest(7, 5001.00, "Just over Director limit");
        manager.processRequest(requestForVP);
        assertTrue(requestForVP.isApproved());
        assertEquals("TestVP", requestForVP.getApprovedBy());
    }
}
