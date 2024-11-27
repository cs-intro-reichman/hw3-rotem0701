/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {

		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
		 
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		String str1Fixed = preProcess(str1);
		String str2Fixed = preProcess(str2);
		str1Fixed = removeSpaces(str1Fixed);
		str2Fixed = removeSpaces(str2Fixed);
	
		for (int i = 0; i < str1Fixed.length(); i++) {
			boolean foundChar = false;
			
			for (int j = 0; j < str2Fixed.length(); j++) {
				if (str1Fixed.charAt(i) == str2Fixed.charAt(j)) {
					str2Fixed = str2Fixed.substring(0, j) + str2Fixed.substring(j + 1); 
					foundChar = true;
					break;
				}
			}
			
			if (!foundChar) {
				return false;
			}
		}
	
		return (str2Fixed.length() == 0);
	}
	
	
	public static String removeSpaces(String str) {
		String strNoSpaces = ""; 
		
        for (int i = 0; i < str.length(); i++) {
        	
			char letter = str.charAt(i);
				if (letter != ' ') {
					strNoSpaces += letter;
				}
		}
		return strNoSpaces;
	} 
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String strFixed = ""; 
        for (int i = 0; i < str.length(); i++) {
            char letter = str.charAt(i);

            if (letter >= 'a' && letter <= 'z') {
                strFixed += letter;

            } else if (letter >= 'A' && letter <= 'Z') {
                strFixed += (char) (letter + 32);
            } else if (letter == ' ') {
				strFixed += " ";
			}
		}
		return strFixed;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String strRandom = "";
		while (str.length() > 0) {
			int index = (int) (Math.random() * str.length()); 
			char letter = str.charAt(index); 
			strRandom += letter; 
			str = str.substring(0, index) + str.substring(index + 1); 
			} 
		return strRandom;
	}
}