public class Edge {

    private Node src;
    private Node dst;
    private int weight;

    public Edge(Node src, Node dst, int weight) {
        if (weight > 0) {
            this.src = src;
            this.dst = dst;
            this.weight = weight;
        }
    }

    public Node getSrc() {

        return src;
    }

    public void setSrc(Node src) {

        this.src = src;
    }

    public Node getDst() {

        return dst;
    }

    public void setDst(Node dst) {

        this.dst = dst;
    }

    public int getWeight() {

        return weight;
    }

    public void setWeight(int weight) {

        this.weight = weight;
    }
}
