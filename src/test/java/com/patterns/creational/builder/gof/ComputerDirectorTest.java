package com.patterns.creational.builder.gof;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ComputerDirectorTest {

    @Mock
    private ComputerBuilder mockBuilder;

    @Mock
    private Computer mockComputer; // To be returned by mockBuilder.getResult()

    @Test
    void constructGamingPC_callsBuilderMethodsInOrder() {
        ComputerDirector director = new ComputerDirector();
        director.setBuilder(mockBuilder);
        when(mockBuilder.getResult()).thenReturn(mockComputer); // Stub getResult

        Computer result = director.constructGamingPC();

        // Verify methods were called on the builder
        InOrder inOrder = inOrder(mockBuilder);
        inOrder.verify(mockBuilder).reset();
        inOrder.verify(mockBuilder).buildCpu("Intel Core i9 Extreme");
        inOrder.verify(mockBuilder).buildRam("64GB DDR5 RGB");
        inOrder.verify(mockBuilder).buildStorage("2TB NVMe Gen5 SSD");
        inOrder.verify(mockBuilder).buildGraphicsCard("NVIDIA RTX Titan NextGen");
        inOrder.verify(mockBuilder).buildOperatingSystem("Windows 11 Ultimate Gamer Edition");
        inOrder.verify(mockBuilder).getResult();

        assertSame(mockComputer, result, "Director should return the computer from the builder");
    }

    @Test
    void constructOfficePC_callsBuilderMethodsInOrder() {
        ComputerDirector director = new ComputerDirector();
        director.setBuilder(mockBuilder);
        when(mockBuilder.getResult()).thenReturn(mockComputer);

        director.constructOfficePC();

        InOrder inOrder = inOrder(mockBuilder);
        inOrder.verify(mockBuilder).reset();
        inOrder.verify(mockBuilder).buildCpu("Intel Core i5 Standard");
        inOrder.verify(mockBuilder).buildRam("16GB DDR4 Reliable");
        inOrder.verify(mockBuilder).buildStorage("1TB SATA SSD FastBoot");
        inOrder.verify(mockBuilder).buildGraphicsCard(null); // Or "Integrated" depending on logic
        inOrder.verify(mockBuilder).buildOperatingSystem("Windows 11 Business");
        inOrder.verify(mockBuilder).getResult();
    }

    @Test
    void construct_whenBuilderNotSet_throwsIllegalStateException() {
        ComputerDirector director = new ComputerDirector();
        assertThrows(IllegalStateException.class, director::constructGamingPC);
    }
}
