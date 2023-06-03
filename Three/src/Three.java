import com.ardic.three.BTree;
import com.ardic.three.Node;

public class Three {
    public static void main(String[] args) {
        BTree tree = new BTree(new Node(50));

        tree.add(25);
        tree.add(52);
        tree.add(12);
        tree.add(65);
        tree.add(97);
        tree.add(53);
        tree.add(27);


        tree.inOrder(tree.getRoot());

        Node node_25 = tree.find(25);
        Node node_65 = tree.find(65);

        System.out.println("\nIs Anomaly: " + tree.isAnomaly());

        // Introduce anomaly
        node_65.setLeft(node_25);

        System.out.println("\nIs Anomaly: " + tree.isAnomaly());


    }
}
