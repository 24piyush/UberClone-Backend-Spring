package com.geektrust.backend;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("App Test")
class AppTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    

    @Test
    public void Application_Test_1() throws Exception{

        List<String> arguments = new ArrayList<>(Arrays.asList("sample_input/input1.txt"));

        String expectedOutput = "DRIVERS_MATCHED D1 D3\n"+
            "RIDE_STARTED RIDE-001\n"+
            "RIDE_STOPPED RIDE-001\n"+
            "BILL RIDE-001 D3 186.72";

        App.run(arguments);

        Assertions.assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }

    @Test
    public void Application_Test_2() throws Exception{

        List<String> arguments = new ArrayList<>(Arrays.asList("sample_input/input2.txt"));

        String expectedOutput = "DRIVERS_MATCHED D2 D3 D1\n"+
            "DRIVERS_MATCHED D1 D2 D3\n"+
            "RIDE_STARTED RIDE-101\n"+
            "RIDE_STARTED RIDE-102\n"+
            "RIDE_STOPPED RIDE-101\n"+
            "RIDE_STOPPED RIDE-102\n"+
            "BILL RIDE-101 D2 234.64\n"+
            "BILL RIDE-102 D1 258.00";

        App.run(arguments);

        Assertions.assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }

    @Test
    public void Application_Test_3() throws Exception{

        List<String> arguments = new ArrayList<>(Arrays.asList("sample_input/input3.txt"));

        String expectedOutput = "NO_DRIVERS_AVAILABLE\n"+
            "DRIVERS_MATCHED D13 D4 D2\n"+
            "RIDE_STARTED RIDE-001\n"+
            "RIDE_STOPPED RIDE-001\n"+
            "BILL RIDE-001 D13 268.36";

        App.run(arguments);

        Assertions.assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }

    @Test
    public void Application_Test_4() throws Exception{

        List<String> arguments = new ArrayList<>(Arrays.asList("sample_input/input4.txt"));

        String expectedOutput = "NO_DRIVERS_AVAILABLE\n"+
            "DRIVERS_MATCHED D1\n"+
            "DRIVERS_MATCHED D2 D1\n"+
            "DRIVERS_MATCHED D14 D15 D16 D1\n"+
            "DRIVERS_MATCHED D15 D2 D1\n"+
            "RIDE_STARTED RIDE-001\n"+
            "DRIVERS_MATCHED D14 D16 D17 D1\n"+
            "RIDE_STOPPED RIDE-001\n"+
            "BILL RIDE-001 D15 327.20\n"+
            "RIDE_STARTED RIDE-002\n"+
            "RIDE_STOPPED RIDE-002\n"+
            "INVALID_RIDE\n"+
            "BILL RIDE-002 D17 440.26\n"+
            "INVALID_RIDE\n"+
            "BILL RIDE-002 D17 440.26";

        App.run(arguments);

        Assertions.assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }

    @Test
    public void Application_Test_5() throws Exception{

        List<String> arguments = new ArrayList<>(Arrays.asList("sample_input/input5.txt"));

        String expectedOutput = "DRIVERS_MATCHED D1\n"+
            "DRIVERS_MATCHED D3 D1 D2\n"+
            "RIDE_STARTED RIDE-001\n"+
            "DRIVERS_MATCHED D6 D7 D5 D3 D4\n"+
            "DRIVERS_MATCHED D5 D6 D7 D3\n"+
            "RIDE_STOPPED RIDE-001\n"+
            "RIDE_STARTED RIDE-002\n"+
            "RIDE_STARTED RIDE-003\n"+
            "BILL RIDE-001 D1 96.67\n"+
            "RIDE_STOPPED RIDE-002\n"+
            "RIDE_STOPPED RIDE-003\n"+
            "BILL RIDE-003 D6 62.40\n"+
            "BILL RIDE-002 D7 79.80";

        App.run(arguments);

        Assertions.assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }

    @Test
    public void Application_Test_6() throws Exception{

        List<String> arguments = new ArrayList<>(Arrays.asList("sample_input/input6.txt"));

        String expectedOutput = "NO_DRIVERS_AVAILABLE\n"+
            "INVALID_RIDE\n"+
            "INVALID_RIDE\n"+
            "INVALID_RIDE";

        App.run(arguments);

        Assertions.assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }



    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

}
