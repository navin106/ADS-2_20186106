import java.util.Scanner;
public final class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LSD lsd = new LSD();
		int k = 0;
		int n = Integer.parseInt(sc.nextLine());
		String[] words = new String[n];
		for (int i = 0; i < n; i++) {
			words[i] = sc.nextLine();
			k = words[i].length();
		}
		lsd.sort(words, k);
	}
}