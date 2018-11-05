import java.util.Scanner;
class PageRank {
	Double[] pray;
	Digraph digr;
	Digraph reversedigr;
	PageRank(Digraph g) {
		digr = g;
		pray = new Double[g.V()];
		reversedigr = digr.reverse();
		for (int i = 0; i < digr.V(); i++) {
			if (digr.indegree(i) == 0) {
				pray[i] = 0.0;
			} else {
				pray[i] = 1 / (double)digr.V();
			}
		}
		prcalculation();
	}
	public void prcalculation() {
		Double pr = 0.0;

		double[] l = new double[digr.V()];
		for ( int j = 0; j < 1000; j++) {
			for ( int i = 0; i < digr.V(); i++) {
				pr = 0.0000;
				for (int each : reversedigr.adj(i)) {
					pr += ((double)pray[each] / (double)digr.outdegree(each));
				}
				l[i] = pr;
			}
			for (int i = 0; i < digr.V(); i++) {
				pray[i] = l[i];
			}
		}
	}
	double getPR(int v) {
		return pray[v];
	}
	public String toString() {
		String str = "";
		// str += digr.toString() + "\n";
		for ( int i = 0; i < pray.length; i++) {
			str += i + " - " + getPR(i) + "\n";
		}
		return str;
	}
}
/*class PageRank {
	Didigr digr;
	double[] pray;
	PageRank(Digraph df) {
		this.digr = df;
		pray = new double[digr.V()];
		for (int i = 0; i < pray.length; i++) {
			pray[i] = 1.0 / digr.V();
			// double temp = 0.0;
			// for (int j : digr.adj(i)) {
			// 	if (j == i) {
			// 		temp += (pray[j] / digr.outdegree(j));
			// 	}
			// }
			// pray[i] = temp;
			// temp = 0.0;

		}

	}
	double getPR(int v) {
		double temp = 0.0;
		for(int i:digr.adj(v)){
			temp += (pray[i]/digr.outdegree(i));
		}
		pray[v] =temp;
		temp = 0.0;
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


}*/

class WebSearch {

}


public class Solution {
	public static void main(String[] args) {
		// read the first line of the input to get the number of vertices
		Scanner sc = new Scanner(System.in);
		int vertices = Integer.parseInt(sc.nextLine());
		// iterate count of vertices times
		// to read the adjacency list from std input
		// and build the digr
		Digraph df = new Digraph(vertices);
		for (int i = 0; i < vertices; i++) {
			String[] k = sc.nextLine().split(" ");
			for (int j = 1; j < k.length; j++) {
				df.addEdge(Integer.parseInt(k[0]), Integer.parseInt(k[j]));
			}
		}
		System.out.println(df);
		for (int i = 0; i < vertices; i++) {
			if (df.outdegree(i) == 0) {
				for (int j = 0; j < vertices; j++) {
					if (i != j) {
						df.addEdge(i, j);
					}
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
