package finalTFExam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PracticalQuestion2 {

	// Method to check if the file exists at the given path
	private static boolean doesFileExist(String path) {
		Path filePath = Paths.get(path);

		try {
			return Files.exists(filePath);
		} catch (Exception e) {
			// Catching the exception if any issues occur
			return false;
		}
	}

	// Method to read and print word meanings from the file
	private static void readDictionary(String path) {
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line;
			String currentWord = null;

			while ((line = br.readLine()) != null) {
				// Assuming each line follows the format: Word - Meaning1, Meaning2, ...
				String[] parts = line.split(" - ");

				if (parts.length > 1) {
					// Extracting word and meanings
					currentWord = parts[0];
					String[] meanings = parts[1].split(", ");

					// Printing word
					System.out.println(currentWord);

					// Printing meanings
					for (String meaning : meanings) {
						System.out.println("  " + meaning);
					}
				} else if (currentWord != null) {
					// If line doesn't follow the expected format, treat it as a continuation of
					// meanings
					String[] meanings = line.split(", ");
					for (String meaning : meanings) {
						System.out.println("  " + meaning);
					}
				}
			}
		} catch (IOException e) {
			// Handle IO exceptions
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		String filePath = "C:\\Users\\parve\\OneDrive\\Desktop\\Dictionary.txt";

		// Checking if the file exists
		if (doesFileExist(filePath)) {
			// Reading and printing word meanings
			readDictionary(filePath);
		} else {
			System.out.println("The file does not exist at the specified path.");
		}
	}
}
