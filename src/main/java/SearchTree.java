import java.util.ArrayList;

public class SearchTree {




    public Node makeNode(Node node, State state) {
        Node n = new Node();
        return n;
    }

    /**
     * TODO maybe re-define comparison principle later
     * @param state
     * @param goal
     * @return
     */
    public boolean goalTest(State state, State goal) {
        return state.position == goal.position;
    }

    public void treeSearch(Problem p, ArrayList<MapPosition> frontier) {
        Node root = makeNode(null, new State(p.ai_agent, p.ai_agent.position));
    }



}
