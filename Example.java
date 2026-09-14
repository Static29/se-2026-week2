public class Example {

    public static void main(String[] args) {
        Node root = new Node("Root");
        Node child1 = new Node("Child 1");
        Node child2 = new Node("Child 2");

        root.addChild(child1);
        root.addChild(child2);

        System.out.println("Root label: " + root.label);
        System.out.println("Children of Root:");
        for (Node child : root.children) {
            System.out.println("- " + child.label);
        }

        Node child3 = new Node("Child 3");
        Node child4 = new Node("Child 4");
        Node child5 = new Node("Child 5");
        Node child6 = new Node("Child 6");
        Node child7 = new Node("Child 7");


        child1.addChild(child3);
        child1.addChild(child4);
        child2.addChild(child5);
        child2.addChild(child6);
        child6.addChild(child7);

        //BFS 실행 테스트
        System.out.println("BFS 방문 순서:");
        root.bfs("none");  // "Child 7"을 찾기 위해 BFS 실행
        root.bfs("Child 7");  // "Child 7"을 찾기 위해 BFS 실행

        //DFS 실행 테스트
        System.out.println("DFS 방문 순서:");
        Node.dfs(root);

    }
}
