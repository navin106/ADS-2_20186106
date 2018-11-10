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
			sc.nextLine();
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
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			sc.nextLine();
			dusp = new DijkstraUndirectedSP(graph, a);
			if (dusp.hasPathTo(c) == false) {
				System.out.println("No Path Found.");
			} else {
				String str = "";
				double d = (dusp.distTo(b));
				String[] temp = (dusp.pathTo(b).toString()).split(" ");
				for (int f = 0; f < temp.length; f++) {
					if (f % 2 == 0) {
						String[] temp1 = temp[0].split("-");
						if (Integer.parseInt(temp1[0]) == a || Integer.parseInt(temp1[1]) == a) {
							str += a + " ";

						} else {
							if (f + 2 < temp.length) {
								String[] temp2 = temp[f].split("-");
								String[] temp3 = temp[f + 2].split("-");
								if (temp2[0].equals(temp3[0])) {
									str += temp2[1] + temp2[0] + temp3[1];

								} else if (temp2[0].equals(temp3[1])) {
									str += temp2[1] + temp2[0] + temp3[0];

								} else if (temp2[1].equals(temp3[0])) {
									str += temp2[0] + temp2[1] + temp3[1];

								} else if (temp2[1].equals(temp3[1])) {
									str += temp2[0] + temp2[1] + temp3[0];
								}

							}

						}

					}

				}
				dusp = new DijkstraUndirectedSP(graph, b);
				d += (dusp.distTo(c));
				String[] ntemp = (dusp.pathTo(b).toString()).split(" ");
				for (int e = 0; e < ntemp.length; e++) {
					if (e % 2 == 0) {
						String[] temp1 = ntemp[0].split("-");
						if (Integer.parseInt(temp1[0]) == b || Integer.parseInt(temp1[1]) == b) {
							str += b + " ";

						} else {
							if (e + 2 < ntemp.length) {
								String[] temp2 = ntemp[e].split("-");
								String[] temp3 = ntemp[e + 2].split("-");
								if (temp2[0].equals(temp3[0])) {
									str += temp2[1] + temp2[0] + temp3[1];

								} else if (temp2[0].equals(temp3[1])) {
									str += temp2[1] + temp2[0] + temp3[0];

								} else if (temp2[1].equals(temp3[0])) {
									str += temp2[0] + temp2[1] + temp3[1];

								} else if (temp2[1].equals(temp3[1])) {
									str += temp2[0] + temp2[1] + temp3[0];
								}

							}

						}

					}

				}
				System.out.println(d);
				System.out.println(dusp.pathTo(c));

			}
			break;

		default:
			break;
		}

	}
}