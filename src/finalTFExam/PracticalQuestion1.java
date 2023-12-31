//Here, I will Generate 500 RANDOM numbers using Java language.
//I will also find out the 1st Nth smallest number (range from 100 – 1000)
package finalTFExam;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
public class PracticalQuestion1 {
			public static void main(String[] args) {
			int N = 1; // I can change this to any desired Nth smallest number
			int minR = 100;
			int maxR = 1000;
			int totalN = 500;
			// To generate unique random numbers
			Set<Integer> uniqueN = generateUniqueRandomNumbers(minR, maxR, totalN);
			// To convert the set of unique numbers to a list
			List<Integer> numbersList = new ArrayList<>(uniqueN);
			// To sort the list
			Collections.sort(numbersList);
			// To find the Nth smallest number
			if (N >= 1 && N <= numbersList.size()) {
			int nthSmallest = numbersList.get(N - 1);
			System.out.println("The " + N + "th Nth smallest number is: " + nthSmallest);
			} else {
			System.out.println("Invalid value of N.");
			}
			}
			public static Set<Integer> generateUniqueRandomNumbers(int min, int max, int count) {
			if (count > (max - min + 1)) {
			throw new IllegalArgumentException("Cannot generate more unique numbers than the range allows.");
			}
			Set<Integer> uniqueNumbers = new HashSet<>();
			Random random = new Random();

			while (uniqueNumbers.size() < count) {
			int randomNumber = random.nextInt(max - min + 1) + min;
			uniqueNumbers.add(randomNumber);
			}
			return uniqueNumbers;
		}
	}



