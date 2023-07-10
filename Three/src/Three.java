import com.ardic.three.BTree;
import com.ardic.three.Node;

public class Three {
    public static void main(String[] args) {
        BTree tree = new BTree(new Node());

        tree.getRoot().add(true);
        tree.getRoot().add(false);

        tree.getRoot().getLeft().add(true);
        tree.getRoot().getLeft().add(false);

        tree.getRoot().getRight().add(true);
        tree.getRoot().getRight().add(false);

        System.out.println("Is Anomaly: " + tree.isAnomaly());

        // Introduce anomaly
        tree.getRoot().getLeft().setRight(tree.getRoot());
        System.out.println("Is Anomaly: " + tree.isAnomaly());

    }
}
