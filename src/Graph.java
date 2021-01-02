import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Graph {

    private ArrayList<Node> nodeArrayList;

    public Graph(ArrayList<Node> nodeArrayList) {
        this.nodeArrayList = nodeArrayList;
    }

    public void DijkstraAlgorithm(){

        ArrayList<Node> nodeArrayList = this.nodeArrayList;
        PQ priorityQueue = new PQ();
        nodeArrayList.get(0).setMinDis(0);
        priorityQueue.addItem(nodeArrayList.get(0));

        while (!priorityQueue.isEmpty()){
            Node extractNode = priorityQueue.removeElement();
            ArrayList<Edge> edgeArrayList = extractNode.getEdgesArrayList();

            for (Edge edge: edgeArrayList
                 ) {
                int updateDistance = extractNode.getMinDis() + edge.getWeight();
                if (updateDistance < edge.getDst().getMinDis())
                    edge.getDst().setMinDis(updateDistance);
                priorityQueue.addItem(edge.getDst());
            }
        }
    }

    public void dijkstra() {
        ArrayList<Node> nodeArrayList = this.nodeArrayList;
        int nextChoosenNode = 0;
        nodeArrayList.get(0).setMinDis(0);

        for (int i = 0; i < nodeArrayList.size(); i++) {

            Node currentNode = nodeArrayList.get(nextChoosenNode);
            ArrayList<Edge> edgeArrayList = currentNode.getEdgesArrayList();
            for (int j = 0; j < edgeArrayList.size(); j++) {

                Edge edge = edgeArrayList.get(j);
                if (!edge.getDst().isAlreadyVisited()) {
                    int update = currentNode.getMinDis() + edge.getWeight();
                    if (update < edge.getDst().getMinDis())
                        edge.getDst().setMinDis(update);
                }
            }
            currentNode.setAlreadyVisited(true);
            nextChoosenNode = getShortestDistance();
        }
    }

    public int getShortestDistance(){
        int index = 0;
        int distanceInIndex = Integer.MAX_VALUE;
        ArrayList<Node> nodeArrayList = this.nodeArrayList;
        for (int i = 0; i <nodeArrayList.size() ; i++) {

            Node node = nodeArrayList.get(i);
            if (!node.isAlreadyVisited() && node.getMinDis() < distanceInIndex){
                distanceInIndex = node.getMinDis();
                index = i;
            }
        }
        return index;
    }

    public int calculateEdges(){
        int result = 0;
        ArrayList<Node> nodeArrayList = this.nodeArrayList;
        for (int i = 0; i <nodeArrayList.size() ; i++) {
            result += nodeArrayList.get(i).getEdgesArrayList().size();
        }
        return result;
    }

    public void displayResult() {
        //String output = "The number of Node is : " + this.nodeArrayList.size();
        //output += "\n number of Edges is : " + this.calculateEdges();
        String output = "";
        for (int i = 0; i < this.nodeArrayList.size(); i++) {
            output += "The shortest distance from node 0 to node " + i + " is : " + this.nodeArrayList.get(i).getMinDis() + "\n";
        }
        System.out.println(output);
    }
}