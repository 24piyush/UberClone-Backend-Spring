package com.geektrust.backend;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import com.geektrust.backend.appConfig.ApplicationConfig;
import com.geektrust.backend.commands.CommandInvoker;
import com.geektrust.backend.exceptions.NoSuchCommandException;

public class App {

    //     package com.example.geektrust;

    // public class Main {
    //     public static void main(String[] args)  {
    //         /*
    //         Sample code to read from file passed as command line argument
    //         try {
    //             // the file to be opened for reading
    //             FileInputStream fis = new FileInputStream(args[0]);
    //             Scanner sc = new Scanner(fis); // file to be scanned
    //             // returns true if there is another line to read
    //             while (sc.hasNextLine()) {
    //                //Add your code here to process input commands
    //             }
    //             sc.close(); // closes the scanner
    //         } catch (IOException e) {
    //         }
    //         */
    // 	}
    // }

    // To run the application  ./gradlew run --args="sample_input/input2.txt"
	public static void main(String[] args) {
		//System.out.println("Welcome to Geektrust Backend Challenge!");
		List<String> commandLineArgs = new LinkedList<>(Arrays.asList(args));
		// String expectedSequence = "INPUT_FILE";
		// String actualSequence = commandLineArgs.stream()
		// 		.map(a -> a.split("=")[0])
		// 		.collect(Collectors.joining("$"));
		// if(expectedSequence.equals(actualSequence)){
			run(commandLineArgs);
		//}
	}

	public static void run(List<String> commandLineArgs) {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        CommandInvoker commandInvoker = applicationConfig.getCommandInvoker();
        BufferedReader reader;
        //String inputFile = commandLineArgs.get(0).split("=")[1];
        //commandLineArgs.remove(0);
        String inputFile = commandLineArgs.get(0);
        try {
            reader = new BufferedReader(new FileReader(inputFile));
            String line = reader.readLine();
            while (line != null) {
                List<String> tokens = Arrays.asList(line.split(" "));
                commandInvoker.executeCommand(tokens.get(0),tokens);
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException | NoSuchCommandException e) {
            e.printStackTrace();
        }

   }
}
