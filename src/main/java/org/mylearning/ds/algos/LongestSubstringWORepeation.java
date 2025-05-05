package org.mylearning.ds.algos;

/**
 * The whole idea here is to find the substring with a maximum length, and no
 * repeat of charecter's
 * 
 * Substring is similar to Subarray with a difference where Substring is to
 * String and Subarray to Array's. Longest substring for a give string is
 * itself, and shortest being with length or window size = 1;
 * 
 * Also substring has to be continuous, meaning for a given string 'abcd', abc,
 * and bcd are substrings and not 'acb' or 'adc'.
 * 
 * First task (or the challenge) here is to find all the possible substring for
 * a given string. I am saying it as a challenge is because there's no straight
 * forward way/method to find all the substrings.
 * 
 * One way to find all the possible substring is to use 'Sliding Window'
 * technique. Where you have a window with a size, sliding one element at a
 * time.
 * 
 * 
 * @author sanjayms
 *
 */

public class LongestSubstringWORepeation {

	public static void main(String[] args) {
		String str = "abcabcbb";

		findAllPossibleSubstrings(str);
	}

	/**
	 * Layer 3: where we are trying to find all the possible substring for the given
	 * string.
	 * 
	 * @param str
	 */
	private static void findAllPossibleSubstrings(String str) {
		int windowSize = 1;
		while (windowSize <= str.length()) {

			findSubstrings(str, windowSize);
			windowSize++;
		}
	}

	/**
	 * Layer 2: where we are trying to find all the possible substrings for the
	 * given window size
	 * 
	 * @param str
	 * @param windowSize
	 */
	private static void findSubstrings(String str, int windowSize) {

		int i = 0, j = windowSize;

		while (j <= str.length()) {
			String aSubstring = new String(getASubstring(str, i, j));
			System.out.println("\t" + aSubstring);
			i++;
			j++;
		}
	}

	/**
	 * Layer 1: where we are trying to find a substring based on the starting index
	 * and the last index.
	 * 
	 * @param str
	 * @param i
	 * @param j
	 * @return
	 */
	private static char[] getASubstring(String str, int i, int j) {

		char[] ss = new char[j - i];
		int x = 0;
		while (i < j) {
			System.out.print(str.charAt(i));
			ss[x] = str.charAt(i);
			i++;
			x++;
		}
		return ss;
	}
}
