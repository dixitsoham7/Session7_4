/*Java program to Print all anagram sets in a given array of strings
 * Anagrams are those words in which there are same characters jumbled.
 * Following program shows the anagram sets from input given in question
 * */
public class Anagrams
{
	static final int CHARS = 256;
	
	public static boolean areAnagram(String str1, String str2)      //function to check whether two strings are anagram of each other 
	{
		int[] count = new int[CHARS];      // Create two count arrays and initialize all values as 0
		int i;
	
		for (i = 0; i < str1.length() && i < str2.length();i++)
												
		{
			count[str1.charAt(i)]++;           // For each character in input strings increment count in the corresponding count array
			count[str2.charAt(i)]--;
		}

		// If both strings are of different length.
        // Removing this condition will make the program 
        // fail for strings like "hello" and "what"
		
		if (str1.length() != str2.length())
		return false;

		for (i = 0; i < CHARS; i++)
			if (count[i] != 0)
				return false;
		
		return true;
	}
	static void findAllAnagrams(String arr[], int n)           //function to print all anagram words in an array of strings 
	{
		for (int i = 0; i < n; i++)
			for (int j = i+1; j < n; j++)
				if (areAnagram(arr[i], arr[j]))
					System.out.println("{"+arr[i] +","+arr[j]+"}");
	}

	
	public static void main(String args[])         //main function
	{
		String arr[] = {"listen", "pot","part","opt","trap","silent","top","this","hello","hits","what","shit"};
		int n = arr.length;
		System.out.println("Output : \n");
		findAllAnagrams(arr, n);
	} //end of main
} //end of class
