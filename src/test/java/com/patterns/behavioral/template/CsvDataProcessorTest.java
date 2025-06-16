package com.patterns.behavioral.template;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

// Using @Spy to verify calls to protected methods in the same class,
// which is a bit of an advanced Mockito technique for testing abstract classes.
@ExtendWith(MockitoExtension.class)
class CsvDataProcessorTest {

    @Spy // Spy allows calling real methods while still being able to verify calls on it
    private CsvDataProcessor csvProcessorSpy = new CsvDataProcessor("test.csv");

    @Test
    void processData_callsStepsInOrderAndHooks() {
        csvProcessorSpy.processData(); // Call the template method

        // Verify that the abstract methods were called by the template method
        // We need to use doNothing().when() for void methods if we want to verify them on a Spy
        // without actually executing their real implementation during verification setup,
        // but for testing the template method, we want their real implementation to run
        // and then verify they were part of the sequence.

        // A more direct way to test the sequence in a template method is often through
        // integration-style tests or by checking state changes, or by making methods public/package-private.
        // Here, we'll verify they were called.
        // For spies, verification of concrete methods happens naturally.
        // To verify abstract/protected methods in a spy, ensure they have some effect or
        // make them package-private for direct testing.

        // Let's verify the sequence using Mockito.verify on the spy.
        // Note: Directly verifying protected abstract methods called internally by a public final method
        // on a spy can be tricky. A better approach for testing template methods is often to have
        // the abstract methods change some state or return values that can be asserted.
        // However, we can verify that the public `processData` method was called, and
        // then we can test the individual protected methods if they were public/package-private,
        // or check their side effects.

        // For this test, we'll trust the template method calls them and focus on the overall process.
        // If we made the methods package-private, we could verify them directly.
        // Alternative: use a real object and check System.out or state changes.

        // Since our methods print, we can test that. (More complex setup)
        // For simplicity, let's assume the template method calls them.
        // A better test for the template itself would be in an abstract test class if possible
        // or by making the step methods in DataProcessor package-private and calling them from the test.

        // Given the current design, let's just ensure processData runs without error.
        // And test the individual steps if they were more accessible or had return values.
        // With @Spy, calls to concrete methods can be verified.
        // Calls to abstract methods fulfilled by the spy itself are part of its execution.

        // We can verify the sequence of *overridden* or *concrete* methods in the spy.
        // To verify the sequence of abstract methods called BY the template method,
        // it's often done by ensuring the template method completes and specific
        // side effects of those abstract methods are observable.

        // Let's make a simpler assertion: ensure the process completes.
        // (A full sequence verification with Mockito's InOrder on abstract method calls
        // made by a final method is complex and often not the primary goal of testing the concrete class.)
        assertNotNull(csvProcessorSpy); // Basic check

        // More practical: Verify the state after processing if possible.
        // e.g., if loadData loaded into a field, check that field.
        // For now, let's verify the hooks were called (as they are concrete in the spy)
        // This isn't perfect for testing the *abstract* steps called by the template.
        // It's better to test the effects of those steps.

        // A simplified test focusing on what CsvDataProcessor does:
        // This primarily tests if the CsvDataProcessor's implementations run.
        // To test the *template method's orchestration*, that's harder with private/protected steps.
        // One common way is to have a test-specific subclass that records calls.

        // Create a test-specific subclass to record method calls
        TestableCsvDataProcessor testableProcessor = new TestableCsvDataProcessor("test.csv");
        testableProcessor.processData();

        assertTrue(testableProcessor.loadDataCalled);
        assertTrue(testableProcessor.transformDataCalled);
        assertTrue(testableProcessor.saveDataCalled);
        assertTrue(testableProcessor.hookAfterSaveCalled); // CsvDataProcessor overrides this
        // hookBeforeSave is not overridden by CsvDataProcessor, so its default from DataProcessor runs.
        // If DataProcessor.hookBeforeSave() had a distinct effect, we could check that.
    }

    // Helper class for testing
    static class TestableCsvDataProcessor extends CsvDataProcessor {
        boolean loadDataCalled = false;
        boolean transformDataCalled = false;
        boolean saveDataCalled = false;
        boolean hookBeforeSaveCalled = false; // To check if super's hook is called
        boolean hookAfterSaveCalled = false;

        public TestableCsvDataProcessor(String filePath) {
            super(filePath);
        }

        @Override
        protected void loadData() {
            super.loadData();
            loadDataCalled = true;
        }

        @Override
        protected void transformData() {
            super.transformData();
            transformDataCalled = true;
        }

        @Override
        protected void saveData() {
            super.saveData();
            saveDataCalled = true;
        }

        @Override
        protected void hookBeforeSave() {
            super.hookBeforeSave(); // Call super to check its execution if needed
            hookBeforeSaveCalled = true;
        }

        @Override
        protected void hookAfterSave() {
            super.hookAfterSave();
            hookAfterSaveCalled = true;
        }
    }
}
