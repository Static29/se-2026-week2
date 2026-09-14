import java.util.ArrayList;
import java.util.List;

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
        public static void dfs(Node node) {
    System.out.println(node.label);

    if (!node.hasChild()) {
         return;
        }

    for (Node child : node.children) {
        dfs(child);
        }
    }
}
