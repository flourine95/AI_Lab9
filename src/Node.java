import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Node {
    private List<Integer> data = new ArrayList<>();

    public void add(Integer val) {
        this.data.add(val);
    }

    public void set(int index, int value) {
        data.set(index, value);
    }

    public int get(int index) {
        return data.get(index);
    }

    public void addAll(List<Integer> data) {
        this.data.addAll(data);
    }

    // Get children of the current nodes
    public List<Node> getSuccessors() {
        List<Node> successors = new ArrayList<>();
        data.sort(DESCOMPARATOR);
        for (int i = 0; i < data.size(); i++) {
            int current = data.get(i);
            for (int j = 1; j <= current / 2; j++) {
                // same value
                if (j != current - j) {
                    Node node = new Node();
                    node.add(j);
                    node.add(current - j);
                    for (int k = 0; k < data.size(); k++) {
                        if (k != i) {
                            node.add(data.get(k));
                        }
                    }
                    if (!successors.contains(node)) {
                        successors.add(node);
                    }
                }
            }
        }
        return successors;
    }

    // Check whether a node is terminal or not
    public boolean isTerminal() {
        data.sort(DESCOMPARATOR);
        return data.get(0) <= 2;
    }

    public static final Comparator<Integer> DESCOMPARATOR = Comparator.reverseOrder();

    @Override
    public String toString() {
        this.data.sort(DESCOMPARATOR);
        return this.data.toString();
    }

}
