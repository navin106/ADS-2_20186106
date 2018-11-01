import java.util.Scanner;
interface Graph {
	public int V();
	public int E();
	public void addEdge(int v, int w);
	public Iterable<Integer> adj(int v);
	public boolean hasEdge(int v, int w);
}
/**
 * List of graphs.
 */
class GraphList implements Graph {
    /**
     * vertices.
     */
    private int vertices;
    /**
     * edges.
     */
    private int edge;
    /**
     * bag.
     */
    private Bag<Integer>[] adj;
    /**
     * Constructs the object.
     *
     * @param      v1    The v 1
     */
    GraphList(final int v1) {
        this.vertices = v1;
        this.edge = 0;
        this.adj = (Bag<Integer>[]) new Bag[vertices];
        for (int i = 0; i < vertices; i++) {
            adj[i] = new Bag<Integer>();
        }
    }
    /**
     * vertices.
     *
     * @retu rn     { description_of_the_return_value }
     */
    public int V() {
        return this.vertices;
    }
    /**
     * number of edges.
     *
     * @return     { description_of_the_return_value }
     */
    public int E() {
        return this.edge;
    }
    /**
     * Adds an edge.
     *
     * @param      v     { parameter_description }
     * @param      w     { parameter_description }
     */
    public void addEdge(final int v, final int w) {
        if (!hasEdge(v, w) && v != w) {
            edge++;
        }
        adj[v].add(w);
        adj[w].add(v);
    }
    /**
     * iterable.
     *
     * @param      v     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public Iterable<Integer> adj(final int v) {
        return adj[v];
    }
    /**
     * Determines if it has edge.
     *
     * @param      v     { parameter_description }
     * @param      w     { parameter_description }
     *
     * @return     True if has edge, False otherwise.
     */
    public boolean hasEdge(final int v, final int w) {
        int count = 0;
        for (int i : adj[v]) {
            if (i == w) {
                count += 1;
                break;
            }
        }
        for (int i : adj[w]) {
            if (i == v) {
                count += 1;
                break;
            }
        }
        if (count == 2) {
            return true;
        }
        return false;
    }
    /**
     * display.
     *
     * @param      data  The data
     *
     * @return     { description_of_the_return_value }
     */
    public String display(final String[] data) {
        String s = "";
        s += vertices + " vertices, " + edge + " edges" + '\n';
        if (edge == 0) {
            s += "No edges ";
        } else {
            for (int v = 0; v < vertices; v++) {
                s += data[v] + ": ";
                for (int w : adj[v]) {
                    s += data[w] + " ";
                }
                s += '\n';
            }
        }
        return s.substring(0, s.length() - 1);
    }

}
/**
 * Class for graph matrix.
 */
class GraphMatrix implements Graph {
    /**
     * number of vertices.
     */
    private int vertices;
    /**
     * number of edges.
     */
    private int edges;
    /**
     * matrix.
     */
    private int[][] matrix;
    /**
     * Constructs the object.
     *
     * @param      v1    The v1.
     */
    GraphMatrix(final int v1) {
        this.vertices = v1;
        this.edges = 0;
        this.matrix = new int[vertices][vertices];
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                matrix[i][j] = 0;
            }
        }
    }
    /**
     * Iterable.
     *
     * @param      v     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public Iterable<Integer> adj(final int v) {
        return null;
    }
    /**
     * number of vertices.
     *
     * @return     { description_of_the_return_value }
     */
    public int V() {
        return this.vertices;
    }
    /**
     * number of edges.
     *
     * @return     { description_of_the_return_value }
     */
    public int E() {
        return this.edges;
    }
    /**
     * Adds an edge.
     *
     * @param      v     { parameter_description }
     * @param      w     { parameter_description }
     */
    public void addEdge(final int v, final int w) {
        if (!hasEdge(v, w) && v != w) {
            edges++;
        }
        matrix[v][w] = 1;
        matrix[w][v] = 1;
    }
    /**
     * Determines if it has edge.
     *
     * @param      v     { parameter_description }
     * @param      w     { parameter_description }
     *
     * @return     True if has edge, False otherwise.
     */
    public boolean hasEdge(final int v, final int w) {
        return (matrix[v][w] == 1);
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String s = "";
        s += vertices + " vertices, " + edges + " edges" + '\n';
        if (edges == 0) {
            s += "No edges ";
        } else {
            for (int i = 0; i < vertices; i++) {
                for (int j = 0; j < vertices; j++) {
                    s += matrix[i][j] + " ";
                }
                s = s.substring(0, s.length());
                s += ('\n');
            }
        }
        return s.substring(0, s.length() -  1);
    }
}
/**
 * Class for solution.
 */
public final class Solution {
	/**
	 * constructor.
	 */
	private Solution() {
	}
	/**
	 * { function_description }
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner sc = new Scanner(System.in);
		String dc = sc.nextLine();
		int vertices = sc.nextInt();
		int edges = sc.nextInt();
		sc.nextLine();
		String[] keys = sc.nextLine().split(",");
		if (dc.equals("List")) {
			GraphList list = new GraphList(vertices);
			for (int i = 0; i < edges; i++) {
				String[] edgeInp = sc.nextLine().split(" ");
                list.addEdge(Integer.parseInt(edgeInp[0]),
                             Integer.parseInt(edgeInp[1]));
			}
			System.out.println(list.display(keys));
		}
		if (dc.equals("Matrix")) {
			GraphMatrix mat = new GraphMatrix(vertices);
			for (int i = 0; i < edges; i++) {
				String[] edgeInp = sc.nextLine().split(" ");
                mat.addEdge(Integer.parseInt(edgeInp[0]),
                             Integer.parseInt(edgeInp[1]));
			}
			System.out.println(mat);
		}
	}
}

