import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Node {
    public String label;
    public Node parent;
    public List<Node> children;

    public Node(String label) {
        this.label = label;
        this.children = new ArrayList<>();
    }

    public void addChild(Node child) {
        this.children.add(child);
    }

    public void bfs(String targetLabel) {
        Queue<Node> queue = new ArrayDeque<>();
        List<String> visitedOrder = new ArrayList<>();

        this.parent = null;
        queue.offer(this);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            visitedOrder.add(current.label);

            if (current.label.equals(targetLabel)) {
                System.out.println("Found " + current.label);
                System.out.println("방문 순서: " + visitedOrder);

                List<Node> route = new ArrayList<>();
                Node temp = current;

                while (temp != null) {
                    route.add(temp);
                    temp = temp.parent;
                }

                System.out.print("경로: ");
                for (int i = route.size() - 1; i >= 0; i--) {
                    System.out.print(route.get(i).label + " ");
                }
                System.out.println();

                return;
            }

            for (Node child : current.children) {
                if (child.parent == null) {
                    child.parent = current;
                }
                queue.offer(child);
            }
        }

        System.out.println("Not found " + targetLabel);
    }


}

