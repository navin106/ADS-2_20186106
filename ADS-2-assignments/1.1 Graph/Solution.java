import java.util.Scanner;
import java.util.Arrays;
interface Graph {
	public int V();
	public int E();
	public void addEdge(int v, int w);
	public Iterable<Integer> adj(int v);
	public boolean hasEdge(int v, int w);
}
public class Solution {
	private Solution() {
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String dc = sc.nextLine();
		int vertices = sc.nextInt();
		int edges = sc.nextInt();
		String[] keys = sc.nextLine().split(",");
		System.out.println(Arrays.toString(keys));
		/*for (int i = 0; i < edges; i++) {


		}*/
	}
}

