package game_nim_student;

import java.util.Arrays;

public class TestNode {
	public static void main(String[] args) throws CloneNotSupportedException {
		Node node = new Node();
		Integer[] data = { 6 };
		node.addAll(Arrays.asList(data));
		MinimaxAlgo algo = new MinimaxAlgo();
		algo.execute(node);
	}
}