import java.util.Scanner;
import java.util.Arrays;
class PageRank {
	Digraph digr;
	double[] pray;
	PageRank(Digraph df) {
		this.digr = df;
		double temp = 0.0;
		pray = new double[digr.V()];
		for (int i = 0; i < pray.length; i++) {
			pray[i] = 1.0 / digr.V();
			for (int j = 0; j <= 100; j++) {
				for (int k : digr.adj(i)) {
					temp += (pray[k] / digr.outdegree(k));
				}
				pray[i] = temp;
				temp = 0.0;
			}

		}

		System.out.println(Arrays.toString(pray));
	}
	double getPR(int v) {
		/*double temp = 0.0;
		for (int i : digr.adj(v)) {
			temp += (pray[i] / digr.outdegree(i));
		}
		pray[v] = temp;
		temp = 0.0;*/
		return pray[v];
	}
	public String toString() {
		String str = "";
		str += digr + "\n";
		for (int i = 0; i < digr.V(); i++) {
			str += i + " - " + getPR(i) + "\n";
		}
		return str;
	}


}

class WebSearch {

}


public class Solution {
	public static void main(String[] args) {
		// read the first line of the input to get the number of vertices
		Scanner sc = new Scanner(System.in);
		int vertices = Integer.parseInt(sc.nextLine());
		// iterate count of vertices times
		// to read the adjacency list from std input
		// and build the graph
		Digraph df = new Digraph(vertices);
		for (int i = 0; i < vertices; i++) {
			String[] k = sc.nextLine().split(" ");
			for (int j = 1; j < k.length; j++) {
				df.addEdge(Integer.parseInt(k[0]), Integer.parseInt(k[j]));
			}
		}
		for (int i = 0; i < vertices; i++) {
			if (df.outdegree(i) == 0) {
				for (int j = 0; j < vertices; j++) {
					df.addEdge(j, i);
				}
			}

		}
		// Create page rank object and pass the graph object to the constructor
		PageRank pr = new PageRank(df);
		// print the page rank object
		System.out.println(pr);

		// This part is only for the final test case

		// File path to the web content
		String file = "WebContent.txt";

		// instantiate web search object
		// and pass the page rank object and the file path to the constructor

		// read the search queries from std in
		// remove the q= prefix and extract the search word
		// pass the word to iAmFeelingLucky method of web search
		// print the return value of iAmFeelingLucky

	}
}
