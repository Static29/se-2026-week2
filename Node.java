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

    // 현재 노드에 자식노드가 있는지 확인하는 메서드
    public boolean hasChild() {
        return !this.children.isEmpty();
    }
    
    // 재귀를 통해 자식노드부터 루트까지 높이를 계산하는 메서드
    public int height() {
        if (!hasChild()) {
            return 1;
        } else {
            int maxHeight = 0;
            for (Node child : children) {
                int childHeight = child.height();
                if (childHeight > maxHeight) {
                    maxHeight = childHeight;
                }
            }
            return maxHeight + 1;
        }
    }

}
