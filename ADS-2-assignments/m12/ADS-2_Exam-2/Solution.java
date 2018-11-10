import java.util.Scanner;
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
			                  Integer.parseInt(distPath[0]),
			                  Integer.parseInt(distPath[0]));
			graph.addEdge(e);
		}
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
			break;

		case "ViaPaths":
			// Handle the case of ViaPaths, where three integers are given.
			// First is the source and second is the via is the one where path should pass throuh.
			// third is the destination.
			// If the path exists print the distance between them.
			// Other wise print "No Path Found."
			break;

		default:
			break;
		}

	}
}