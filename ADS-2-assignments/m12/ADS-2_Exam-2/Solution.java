import java.util.Scanner;
// import java.util.HashMap;
/**
 * Class for solution.
 */
public class Solution {

	/**
	 * Constructs the object.
	 */
	private Solution() {

	}

	/**
	 * { function_description }
	 *
	 * @param      args  The arguments
	 */
	public static void main(String[] args) {
		// Self loops are not allowed...
		// Parallel Edges are allowed...
		// Take the Graph input here..
		Scanner sc = new Scanner(System.in);
		// String caseToGo = null;
		int cities = sc.nextInt();
		int paths = sc.nextInt();
		sc.nextLine();
		EdgeWeightedGraph graph = new EdgeWeightedGraph(cities);
		for (int i = 0; i < paths; i++) {
			String[] distPath = sc.nextLine().split(" ");
			Edge e = new Edge(Integer.parseInt(distPath[0]),
			                  Integer.parseInt(distPath[1]),
			                  Double.parseDouble(distPath[2]));
			graph.addEdge(e);
		}

		DijkstraUndirectedSP dusp;
		String caseToGo = sc.nextLine();
		switch (caseToGo) {
		case "Graph":
			//Print the Graph Object.
			System.out.println(graph);
			break;

		case "DirectedPaths":
			// Handle the case of DirectedPaths, where two integers are given.
			// First is the source and second is the destination.
			// If the path exists print the distance between them.
			// Other wise print "No Path Found."
			int i = sc.nextInt();
			int j = sc.nextInt();

			dusp = new DijkstraUndirectedSP(graph, i);
			if ((dusp.distTo(j)) == Double.POSITIVE_INFINITY) {
				System.out.println("No Path Found.");
			} else {
				System.out.println(dusp.distTo(j));
			}
			break;

		case "ViaPaths":
			// Handle the case of ViaPaths, where three integers are given.
			// First is the source and second is the via is the one where path should pass throuh.
			// third is the destination.
			// If the path exists print the distance between them.
			// Other wise print "No Path Found."
			// int i = sc.nextInt();
			// sc.nextLine();
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			// sc.nextLine();sc.nextLine();
			dusp = new DijkstraUndirectedSP(graph, a);
			if (dusp.hasPathTo(c) == false) {
				System.out.println("No Path Found.");
			} else {
				String str = "";
				double d = (dusp.distTo(b));
				str += a +" ";
				for (Edge e1 : dusp.pathTo(b)) {
					str += e1.either() + " ";
				}
				dusp = new DijkstraUndirectedSP(graph, b);
				d += (dusp.distTo(c));
				int k = b;
				for (Edge e2 : dusp.pathTo(c)) {
					int temp = e2.either();
					if (k == temp) {
						str += e2.other(temp) + " ";
					} else {
						str += temp + " ";
					}
					i = temp;
				}
				System.out.println(d);
				System.out.println(str);

			}
			break;

		default:
			break;
		}

	}
}