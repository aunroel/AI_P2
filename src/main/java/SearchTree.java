import java.util.*;

public class SearchTree {

    LinkedList<State> state_space;
    Deque<Node> frontier;
    ArrayList<Node> explored;
    int bfs_search_visits;
    int dfs_search_visits;

    /**
     * BFS algorithm - uses FIFO for node exploration
     * @param p - problem to solve
     * @return end node with path or null if none found
     */
    public Node treeSearchBFS(Problem p) {
        state_space = new LinkedList<>();
        frontier = new LinkedList<>();
        explored = new ArrayList<>();
        Node root = makeNode(null, new State(p.ai_agent, p.ai_agent.position));
        bfs_search_visits = 0;

        insertInFrontier(root);
        while (!frontier.isEmpty()) {
            Node nd = removeFromFrontier();
            explored.add(nd);
            if (goalTest(nd.state, p.goal)) {
                return nd;
            } else {
                insertAllEnd(expandBFS(nd, p));
                bfs_search_visits++;
            }
        }
        return null;
    }

    /**
     * Expanding the nodes to visit for BFS algorithm - queue insertion
     * @param node node to explore neighbours of
     * @param p problem
     * @return Set of neighbouring nodes
     */
    public Set<Node> expandBFS(Node node, Problem p) {
        Set<State> next_states = successorFn(node.state, p);
        Set<Node> successors = new LinkedHashSet<>();
        for (State s: next_states) {
            Node nd = makeNode(node, s);
            if (!isVisited(nd))
                successors.add(nd);
        }
        return successors;
    }

    /**
     * BFS algorithm - uses LIFO for node exploration
     * @param p - problem to solve
     * @return end node with path or null if none found
     */
    public Node treeSearchDFS(Problem p) {
        state_space = new LinkedList<>();
        frontier = new LinkedList<>();
        explored = new ArrayList<>();
        Node root = makeNode(null, new State(p.ai_agent, p.ai_agent.position));
        dfs_search_visits = 0;

        insertInFrontier(root);
        while (!frontier.isEmpty()) {
            Node nd = removeFromFrontier();
            if (goalTest(nd.state, p.goal)) {
                return nd;
            }
            if (!isVisited(nd)) {
                explored.add(nd);
                insertAllFront(expandDFS(nd, p));
                dfs_search_visits++;
            }
        }
        return null;
    }

    /**
     * Expanding the nodes to visit for DFS algorithm - stack insertion
     * @param node node to explore neighbours of
     * @param problem problem
     * @return Stack of neighbouring nodes
     */
    public Stack<Node> expandDFS(Node node, Problem problem) {
        Set<State> next_states = successorFn(node.state, problem);
        Stack<Node> successors = new Stack<>();
        for (State st: next_states) {
            Node nd = makeNode(node, st);
            if (!isVisited(nd)) {
                successors.push(nd);
            }
        }
        return successors;
    }

    /**
     * Creation of new node in the trie wuth respect to parent and state
     * @param node
     * @param state
     * @return
     */
    public Node makeNode(Node node, State state) {
        Node n = new Node();
        state_space.add(state);
        n.state = state;
        n.parent = node;

        if (node == null) {
            n.path_cost = 0;
            n.depth = 0;
        } else {
            n.path_cost = node.path_cost + cost(node.state, state);
            n.depth = node.depth + 1;
        }
        return n;
    }

    /**
     * Getting the first value of the frontier
     * @return first Node in the frontier
     */
    public Node removeFromFrontier() {
        return frontier.removeFirst();
    }

    /**
     * Compare whether curr state position is same as goal state position
     * @param state
     * @param goal
     * @return true if same
     */
    public boolean goalTest(State state, State goal) {
        return state.position.pos_x == goal.position.pos_x
                && state.position.pos_y == goal.position.pos_y;
    }

    /**
     * Get the cost of the move between states
     * @param s1
     * @param s2
     * @return
     */
    public int cost(State s1, State s2) {
        return Math.abs(
                (s1.position.pos_x - s2.position.pos_x)
                        + (s1.position.pos_y - s2.position.pos_y)
        );
    }

    /**
     * Insert root in the frontier
     * @param node
     */
    public void insertInFrontier(Node node) {
        frontier.add(node);
    }

    /**
     * BFS addition to the frontier - expanded nodes are added to the end of frontier
     * @param set
     */
    public void insertAllEnd(Set<Node> set) {
        for (Node n : set) {
            frontier.addLast(n);
        }
    }

    /**
     * DFS addition to the frontier - expanded nodes are added to the front of frontier
     * @param stack
     */
    public void insertAllFront(Stack<Node> stack) {
        for (Node n : stack) {
            frontier.addFirst(n);
        }
    }

    /**
     * Get the set of possible states to move to from current one
     * @param state
     * @param problem
     * @return
     */
    public Set<State> successorFn(State state, Problem problem) {
        Set<State> valid_moves = new HashSet<>();
        int x = state.position.pos_x;
        int y = state.position.pos_y;
        if (x + 1 < problem.map.length && problem.map[x+1][y] != 'X') {
            valid_moves.add(new State(null,
                    new MapPosition(x + 1, y)));
        }
        if (x - 1 >= 0 && problem.map[x-1][y] != 'X') {
            valid_moves.add(new State(null,
                    new MapPosition(x - 1, y)));
        }
        if (y + 1 < problem.map[0].length && problem.map[x][y+1] != 'X') {
            valid_moves.add(new State(null,
                    new MapPosition(x, y + 1)));
        }
        if (y -1 >= 0 && problem.map[x][y-1] != 'X') {
            valid_moves.add(new State(null,
                    new MapPosition(x, y - 1)));
        }
        return valid_moves;
    }

    /**
     * Check if node is in the frontier or was already explored
     * @param nd
     * @return
     */
    public boolean isVisited(Node nd){
        Iterator it = frontier.iterator();
        while (it.hasNext()) {
            Node temp = (Node) it.next();
            if (nd.state.position.pos_x == temp.state.position.pos_x &&
                    nd.state.position.pos_y == temp.state.position.pos_y) {
                return true;
            }
        }
        return isExplored(nd);
    }

    /**
     * Check if the node is in the list of explored nodes
     * @param nd
     * @return
     */
    public boolean isExplored(Node nd) {
        for (int i = 0; i < explored.size(); i++) {
            if (explored.get(i).state.position.pos_x == nd.state.position.pos_x
                    && explored.get(i).state.position.pos_y == nd.state.position.pos_y)
                return true;
        }
        return false;
    }

}
