package org.mylearning.ds.algos;

/**
 * The whole idea here is to find the substring with a maximum length, and no
 * repeat of charecter's
 * 
 * 
 * @author sanjayms
 *
 */

public class LongestSubstringWORepeation {

	public static void main(String[] args) {
		String str = "abcabcbb";
		SubstringsImpl.findAllPossibleSubstrings(str);
//		findAllPossibleSubstrings(str);
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
