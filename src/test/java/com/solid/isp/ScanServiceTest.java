package com.solid.isp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ScanServiceTest {
    @Mock
    private Scannable mockScannable;

    @Test
    void performScan_callsScanOnScannable() {
        ScanService scanService = new ScanService();
        scanService.performScan(mockScannable);
        verify(mockScannable, times(1)).scan();
    }
}
