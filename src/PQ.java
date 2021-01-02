public class PQ {

    private int max;
    private int numberItem;
    private Node [] arrayItem;

    public PQ(){
        this.max = 10;
        arrayItem = new Node[max];
        this.numberItem = 0;
    }

    public void addItem(Node node){
        int i = 0;
        if (numberItem == 0){
            arrayItem[0] = node;
            numberItem++;
            return;
        }
        for (i = numberItem - 1; i >= 0; i--) {
            if (node.getMinDis() > arrayItem[i].getMinDis()){
                arrayItem[i + 1] = arrayItem[i];
            }
            else
                break;
        }
        arrayItem[i + 1] = node;
        numberItem++;
    }

    public void printPQ(){
        for (int i = 0; i < numberItem; i++) {
            System.out.println("Node " + arrayItem[i].getId() + " with distance : " + arrayItem[i].getMinDis());
        }
    }

    public Node removeElement(){
        Node deleted = arrayItem[numberItem - 1];
        arrayItem[numberItem - 1] = null;
        numberItem--;
        return deleted;
    }

    public boolean isEmpty(){
        return numberItem == 0;
    }

    public boolean isFull(){
        return numberItem == max;
    }

    public Node getHighPriority(){
        return arrayItem[numberItem - 1];
    }

}
