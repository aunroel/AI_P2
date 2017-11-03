public class Node {

    public State state;
    public Node parent;
    public int depth;
    public int path_cost;

    public Node() {}

    public Node(State state, Node parent, int depth, int path_cost) {
        this.state = state;
        this.parent = parent;
        this.depth = depth;
        this.path_cost = path_cost;
    }

}
