import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Node node0 = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        node0.addEdge(new Edge(node0,node1,8));
        node0.addEdge(new Edge(node0,node2,11));

        node1.addEdge(new Edge(node1,node2,7));
        node1.addEdge(new Edge(node1,node3,3));
        node1.addEdge(new Edge(node1,node4,8));

        node2.addEdge(new Edge(node2,node4,9));

        node3.addEdge(new Edge(node3,node5,2));
        node3.addEdge(new Edge(node3,node4,5));

        node4.addEdge(new Edge(node4,node6,6));

        node5.addEdge(new Edge(node5,node4,1));
        node5.addEdge(new Edge(node5,node6,8));

        ArrayList<Node> nodeArrayList = new ArrayList<>();
        nodeArrayList.add(node0);
        nodeArrayList.add(node1);
        nodeArrayList.add(node2);
        nodeArrayList.add(node3);
        nodeArrayList.add(node4);
        nodeArrayList.add(node5);
        nodeArrayList.add(node6);

        Graph graph = new Graph(nodeArrayList);
        graph.dijkstra();         //Without PriorityQueue.using the attribute alreadyVisited and the method getShortestDistance().
        //graph.DijkstraAlgorithm();  //Using PriorityQueue.
        graph.displayResult();
        //Output is:
        // The shortest distance from node 0 to node 0 is : 0
        // The shortest distance from node 0 to node 1 is : 8
        // The shortest distance from node 0 to node 2 is : 11
        // The shortest distance from node 0 to node 3 is : 11
        // The shortest distance from node 0 to node 4 is : 14
        // The shortest distance from node 0 to node 5 is : 13
        // The shortest distance from node 0 to node 6 is : 20

    }
}
