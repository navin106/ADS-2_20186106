import java.util.Scanner;
import java.util.HashSet;


public class Solution {

	// Don't modify this method.
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String cases = scan.nextLine();

		switch (cases) {
		case "loadDictionary":
			// input000.txt and output000.txt
			BinarySearchST<String, Integer> hash = loadDictionary("/Files/t9.csv");
			while (scan.hasNextLine()) {
				String key = scan.nextLine();
				System.out.println(hash.get(key));
			}
			break;

		case "getAllPrefixes":
			// input001.txt and output001.txt
			T9 t9 = new T9(loadDictionary("/Files/t9.csv"));
			while (scan.hasNextLine()) {
				String prefix = scan.nextLine();
				for (String each : t9.getAllWords(prefix)) {
					System.out.println(each);
				}
			}
			break;

		case "potentialWords":
			// input002.txt and output002.txt
			t9 = new T9(loadDictionary("/Files/t9.csv"));
			int count = 0;
			while (scan.hasNextLine()) {
				String t9Signature = scan.nextLine();
				for (String each : t9.potentialWords(t9Signature)) {
					count++;
					System.out.println(each);
				}
			}
			if (count == 0) {
				System.out.println("No valid words found.");
			}
			break;

		case "topK":
			// input003.txt and output003.txt
			t9 = new T9(loadDictionary("/Files/t9.csv"));
			Bag<String> bag = new Bag<String>();
			int k = Integer.parseInt(scan.nextLine());
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				bag.add(line);
			}
			for (String each : t9.getSuggestions(bag, k)) {
				System.out.println(each);
			}

			break;

		case "t9Signature":
			// input004.txt and output004.txt
			t9 = new T9(loadDictionary("/Files/t9.csv"));
			bag = new Bag<String>();
			k = Integer.parseInt(scan.nextLine());
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				for (String each : t9.t9(line, k)) {
					System.out.println(each);
				}
			}
			break;

		default:
			break;

		}
	}

	// Don't modify this method.
	public static String[] toReadFile(String file) {
		In in = new In(file);
		return in.readAllStrings();
	}

	public static BinarySearchST<String, Integer> loadDictionary(String file) {
		BinarySearchST<String, Integer>  st = new BinarySearchST<String, Integer>();
		// your code goes here
		In in = new In(file);
		String[] dictionary = in.readAllStrings();
		for (int i = 0; i < dictionary.length; i++) {
			if (st.get(dictionary[i].toLowerCase()) == null) {
				st.put(dictionary[i].toLowerCase(), 1);
			} else {
				st.put(dictionary[i].toLowerCase(), st.get(dictionary[i].toLowerCase()) + 1);
			}
		}
		return st;
	}

}

class T9 {
	private TST dict;
	private BinarySearchST<String, Integer> tempst;

	public T9(BinarySearchST<String, Integer> st) {
		// your code goes here
		dict = new TST();
		this.tempst = st;
		for (String word : st.keys()) {
			dict.put(word, st.get(word));
		}

	}

	// get all the prefixes that match with given prefix.
	public Iterable<String> getAllWords(String prefix) {
		// your code goes here
		return dict.keysWithPrefix(prefix);
	}

	public Iterable<String> potentialWords(String t9Signature) {
		// your code goes here
		// System.out.println(t9Signature);
		// String[]
		return null;
	}

	// return all possibilities(words), find top k with highest frequency.
	public Iterable<String> getSuggestions(Iterable<String> words, int k) {
		// your code goes here
		Bag<String> tbag = new Bag<String>();
		Queue<String> queue = new Queue<String>();
		int count = 0;
		String temp = "";
		MaxPQ<Integer> freq = new MaxPQ<Integer>();
        for (String each : words) {
            freq.insert((Integer) dict.get(each));
        }
        for (String wo : words) {
			tbag.add(wo);
			// temp = wo;
			// for (String iwo : words) {
			// if (dict.keysWithPrefix(prefix)) {

			// }
			// if (tempst.get(wo) < tempst.get((String) iwo)) {
			// 	temp = iwo;
			// 	count++;
			// } else if (tempst.get(wo) == tempst.get((String) iwo)) {
			// 	if (wo.length() < iwo.length()) {
			// 		temp = iwo;
			// 		// count++;

			// 	} else if (wo.length() > iwo.length()) {
			// 		temp = wo;
			// 		count++;
			// 	}
			// }
			// if (count == k) {
			// 	return queue;

			// }
			// }

			// queue.enqueue((String) temp);
		}
        
        for (int i = 0; i < k; i++) {
            int value = freq.delMax();
            for (String word : words) {
                if (value == (Integer) dict.get(word)) {
                    tbag.add(word);
                }
            }
        }
        return tbag;
		
		// for (String wo : tbag) {
		// 	// for (String iwo : tbag) {

		// 	// }
		// 	for (Object s:dict.keysWithPrefix(wo)){
		// 		System.out.println(tempst.get((String)s));
		// 	}

		// 	}
		// return null;
	}

	// final output
	// Don't modify this method.
	public Iterable<String> t9(String t9Signature, int k) {
		return getSuggestions(potentialWords(t9Signature), k);
	}
}
