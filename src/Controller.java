package learning;

import java.io.*;
import java.util.*;
import java.util.function.*;

class Controller {
	static void outputDirectoryCheck(String path) throws IOException {
		File outputDirectory = new File(path).getParentFile();
		if (!outputDirectory.exists()) {
			boolean created = outputDirectory.mkdirs();
            if (!created) {
            	IOException e = new IOException("Unable to create directory - " + outputDirectory.getAbsolutePath());
                throw e;
            }
		}
	}
	
	private static <T> T readInput(Scanner scanner, String prompt, Function<Scanner, T> read) {
	    while (true) {
	        System.out.print(prompt);
	        try {
	            return read.apply(scanner);
	        } catch (Exception e) {
	            System.out.println("Invalid input! Try again.");
	        } finally {
	            scanner.nextLine();
	        }
	    }
	}
	
	static int readIntInput(Scanner scanner, String prompt) {
	    return Controller.readInput(scanner, prompt, (Scanner s) -> scanner.nextInt());
	}
	
	static Double readDoubleInput(Scanner scanner, String prompt) {
		return Controller.readInput(scanner, prompt, (Scanner s) -> scanner.nextDouble());
	}
	
	static String readStringInput(Scanner scanner, String prompt) {
		return Controller.readInput(scanner, prompt, (Scanner s) -> scanner.next());
	}
	
	static Double readYaw(Scanner scanner) {
		return (-1 * Controller.readDoubleInput(scanner, "yaw - ")) * 0.017453292519943295;
	}
	
	static void waitForQuit(Scanner scanner) {
		System.out.print("Task finished. Press Enter to quit...");
		scanner.nextLine();
	}
}