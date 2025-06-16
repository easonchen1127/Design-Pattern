package com.patterns.behavioral.template;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DatabaseDataProcessorTest {

    @Test
    void processData_callsStepsInOrderAndHooks() {
        TestableDbDataProcessor testableProcessor = new TestableDbDataProcessor("test_conn_string");
        testableProcessor.processData();

        assertTrue(testableProcessor.loadDataCalled);
        assertTrue(testableProcessor.transformDataCalled);
        assertTrue(testableProcessor.saveDataCalled);
        assertTrue(testableProcessor.hookBeforeSaveCalled); // DatabaseDataProcessor overrides this
        // hookAfterSave is not overridden by DatabaseDataProcessor, so its default from DataProcessor runs.
    }

    static class TestableDbDataProcessor extends DatabaseDataProcessor {
        boolean loadDataCalled = false;
        boolean transformDataCalled = false;
        boolean saveDataCalled = false;
        boolean hookBeforeSaveCalled = false;
        boolean hookAfterSaveCalled = false; // To check if super's hook is called

        public TestableDbDataProcessor(String connectionString) {
            super(connectionString);
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
            super.hookBeforeSave();
            hookBeforeSaveCalled = true;
        }
        @Override
        protected void hookAfterSave() {
            super.hookAfterSave(); // Call super to check its execution if needed
            hookAfterSaveCalled = true;
        }
    }
}
