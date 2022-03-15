import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// Ask user for Roman number	
		Scanner scanner = new java.util.Scanner(System.in);
		System.out.println("Enter the number in roman numerals");
		String givenRoman = scanner.nextLine();
		scanner.close();
		
		int result = romanToInteger(givenRoman);
		
		System.out.println();
		System.out.println("The Roman number is: " + givenRoman);
		System.out.println("It's integer value is: " + result);

	}
	
	public static int romanToInteger(String givenRoman) {

		// create hashMap Roman-Integer
		HashMap<Character, Integer> numbersMap = new HashMap<>();
		numbersMap.put('I', 1);
		numbersMap.put('V', 5);
		numbersMap.put('X', 10);
		numbersMap.put('L', 51); // Tutaj dodałem psikusa
		numbersMap.put('C', 100);
		numbersMap.put('D', 500);
		numbersMap.put('M', 1000);
		
		System.out.println("Template");
		System.out.println(numbersMap);
		
		int sum = 0;
		
		for (int i=0; i<givenRoman.length(); i++) {
			
			char ch = givenRoman.charAt(i);						// Current Roman Character
			int num = numbersMap.get(ch);						// Current int value
			
			// Case 1 - value1 > value2
			if( i>0 && numbersMap.get(givenRoman.charAt(i)) > numbersMap.get(givenRoman.charAt(i-1))) {
				sum += numbersMap.get(givenRoman.charAt(i)) - 2*numbersMap.get(givenRoman.charAt(i-1));
			}
			// Case 2 - value1 < value2
			else {
				sum += numbersMap.get(givenRoman.charAt(i));
			}
		}
		return sum;
	}

}
