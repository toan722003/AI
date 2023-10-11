package task6;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import task1_2.Edge;
import task1_2.Node;

public class DepthLimitedSearch {

	Stack<Node> frontier = new Stack<>();
	List<Node> explored = new ArrayList<>();

	public Node execute(Node root, String goal, int limit) {
		if (root.getLabel().equals(goal) && limit == 0)
			return root;
		int depth = 0;
		root.setDepth(depth);
		frontier.push(root);
		while (!frontier.isEmpty()) {
			Node currentNode = frontier.pop();
			if (currentNode.getLabel().equals(goal) && !(currentNode.getDepth() > limit))
				return currentNode;
			System.out.print(currentNode);
			if (currentNode.getDepth() <= limit)
				explored.add(currentNode);

			List<Node> nodes = currentNode.getChildrenNodes();
			for (Node e : nodes) {
				if (!explored.contains(e) && !frontier.contains(e)) {
					depth = currentNode.getDepth() + 1;
					e.setDepth(depth);
					e.setParent(currentNode);
					frontier.push(e);
				}
			}
			System.out.print(frontier.toString() + " ");
			System.out.println(depth);
		}
		return null;
	}

}
