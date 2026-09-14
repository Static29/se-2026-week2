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
        child.parent = this;
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
    // bfs 
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
  
    // dfs 메서드 
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

