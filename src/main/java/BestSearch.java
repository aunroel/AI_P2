import java.util.*;

public class BestSearch {

    LinkedList<State> state_space;
    PriorityQueue<Node> frontier_pq;
    ArrayList<Node> explored;
    SearchTree st = new SearchTree();
    int bsa_visits;

    public Node treeSearchBSA(Problem p) {
        state_space = new LinkedList<>();
        frontier_pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node node1, Node node2) {
                int res1 = Math.abs(p.goal.position.pos_x - node1.state.position.pos_x) +
                            Math.abs(p.goal.position.pos_y - node1.state.position.pos_y);
                int res2 = Math.abs(p.goal.position.pos_x - node2.state.position.pos_x) +
                        Math.abs(p.goal.position.pos_y - node2.state.position.pos_y);
                if (res1 == res2)
                    return 0;
                if (res1 > res2)
                    return res1;
                else
                    return res2;
            }

            @Override
            public boolean equals(Object o) {
                return false;
            }
        });

        explored = new ArrayList<>();
        Node root = st.makeNode(null, new State(p.ai_agent, p.ai_agent.position));
        bsa_visits = 0;

        insertPq(root);
        while (frontier_pq.isEmpty()) {
            Node nd = frontier_pq.poll();
            if (st.goalTest(nd.state, p.goal)) {
                return nd;
            } else {
                for (State state: st.successorFn(nd.state, p) ) {
                    if (!st.isVisited(nd)) {
                        insertPq(nd);
                    }
                    explored.add(nd);
                }
            }
        }
        return null;
    }

    public void insertPq(Node n) {
        frontier_pq.add(n);
    }

}
