
import java.util.PriorityQueue;
import java.util.Queue;

public class HuffmanTree {
    Node root;
    int size;

    public HuffmanTree (String original){
        buildTree(frequency(original));
    }

    private PriorityQueue frequency(String original){
        PriorityQueue <Node> main = new PriorityQueue<Node>();
        String character = "";
        for (int i = 0; i< original.length(); i++){
            if(!character.contains(""+original.charAt(i))){
                character += "" + original.charAt(i);
                int count = 0;
                for(int j = 0; j< original.length(); j++){
                    if(original.charAt(j) == original.charAt(i)){
                        count ++;
                    }
                }
                Node frequency = new Node(count, original.charAt(i));
                size++;
                main.add(frequency);
            }
        }
        return main;
    }

    private void buildTree(PriorityQueue queue){
        while(queue.size() >=2){
            Node leaf1 = (Node)queue.poll();
            Node leaf2 = (Node)queue.poll();
            int count1 = (int)leaf1.getKey();
            int count2 = (int) leaf2.getKey();
            Node parent = new Node(count1+count2, "*");
            size ++;
            parent.setLeft(leaf1);
            parent.setRight(leaf2);

           queue.add(parent);
        }
        root = (Node)queue.poll();


    }

    private Node [] recursiveToString(Node n, int index, Node[] arr){
        if(n.isLeaf()){
            return arr;
        }
        if(n.getLeft()!= null){

            arr[2*index+1] = n.getLeft();
            arr = recursiveToString(n.getLeft(), 2*index+1, arr);

        }
        if(n.getRight() != null){
            arr[2*index+2] = n.getRight();
            arr = recursiveToString(n.getRight(), 2*index+2, arr);

        }
        return arr;
    }

    public int getSize(){
        return size;
    }

    public String toString(){
        //System.out.println("in toString");
        int size = 0;
        int sizeTree = this.getSize();
        int j = 0;
        int sizePower = (int)Math.pow(2, (sizeTree-3)/2+1);
        size = sizePower-1;
        Node [] toString = new Node[size];
        toString[0] = root;
        toString = recursiveToString(root, 0, toString);

        String whole = "";

        for(int i =0; i< toString.length; i++){
            if(toString[i] != null){
                whole+= toString[i].toString();
            }
        }

        return whole;

    }








}
