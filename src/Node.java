import java.util.ArrayList;

public class Node {

    private ArrayList<Edge> edgesArrayList;
    private int id;
    private int minDis = Integer.MAX_VALUE;
    private boolean alreadyVisited;

    public int getMinDis() {
        return minDis;
    }

    public void setMinDis(int minDis) {
        this.minDis = minDis;
    }

    public boolean isAlreadyVisited() {
        return alreadyVisited;
    }

    public void setAlreadyVisited(boolean alreadyVisited) {
        this.alreadyVisited = alreadyVisited;
    }

    public Node(int id) {
        this.id = id;
        this.edgesArrayList = new ArrayList<Edge>();
    }

    public ArrayList<Edge> getEdgesArrayList() {
        return edgesArrayList;
    }

    public int getId() {
        return id;
    }

    public void addEdge(Edge edge){
        edgesArrayList.add(edge);
    }

    public void removeEdge(Node dst){
        edgesArrayList.removeIf(edge -> edge.getDst().getId() == dst.getId());
    }

    public void toOutput(){
        edgesArrayList.forEach(edge -> {
            System.out.println("(" + edge.getSrc().getId() + " ," + edge.getDst().getId()+ ")" +
                    " => weight : " + edge.getWeight());
        });
    }

    @Override
    public String toString(){
        return "Node : " + this.getId();
    }

}
