import java.util.Scanner;
class PageRank {
	Digraph digr;
	double[] pray;
	PageRank(Digraph df) {
		this.digr = df;
		pray = new double[digr.V()];
		for (int i = 0; i < pray.length; i++) {
			pray[i] = 1.0 / digr.V();
		}
		for (int i = 0; i < 1000; i++) {
			pray = pagerlist(pray, digr);
		}
	}
	public double[] pagerlist(double[] pray, Digraph digr) {
		double[] l = new double[pray.length];
		for (int i = 0; i < digr.V(); i++) {
			double temp = 0.0;
			// for (int j = 0; j < digr.V(); j++) {
				for (int each : digr.adj(i)) {
					if (each == i) {
						temp += pray[i] / (double)digr.outdegree(i);
					}
				}
			// }
			pray[i] = temp;
		}
		return l;
	}
	double getPR(int v) {
		// double pr = pray[v];
		double t = pray[v];
		// if (digr.indegree(v) == 0) {
		// 	return 0.0;

		// } else {
			// for (int j = 0; j < 1000; j++) {
			/*t = 0.0;
			for (int i : digr.adj(v)) {
				t += pray[i] / digr.outdegree(i);
				pray[i] = t;
			}*/
			// }
			return t;
		// }
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
