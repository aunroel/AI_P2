import java.util.ArrayList;

public class PathFinder {

    public static void main(String[] args) {

        PathFinder pf = new PathFinder();
        pf.processInput(pf);

    }

    /**
     * Put all the test maps into a list
     * @return list of test maps
     */
    public ArrayList<char[][]> addMaps() {
        char[][] map1 = new char [][] {
                {'I', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'X', 'O'},
                {'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'X', 'X', 'O', 'X', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'B', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'G'},
        };

        char[][] map2 = new char [][] {
                {'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'X'},
                {'O', 'X', 'O', 'X', 'O', 'O', 'B', 'O', 'O', 'X'},
                {'O', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'X', 'X', 'X', 'X', 'O', 'O', 'O'},
                {'O', 'O', 'X', 'X', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'X', 'X', 'X', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'G', 'O', 'I', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
        };

        char[][] map3 = new char [][] {
                {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O'},
                {'O', 'I', 'O', 'O', 'O', 'X', 'X', 'O', 'B', 'O'},
                {'O', 'O', 'O', 'X', 'X', 'X', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'X', 'X', 'X', 'X', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'G', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'}
        };

        char[][] map4 = new char [][] {
                {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'X', 'X', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O'},
                {'O', 'I', 'O', 'O', 'O', 'X', 'X', 'O', 'B', 'O'},
                {'O', 'O', 'O', 'X', 'X', 'X', 'O', 'X', 'X', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'X', 'X', 'O', 'O', 'X'},
                {'O', 'O', 'X', 'X', 'X', 'X', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'G', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'}
        };

        char[][] map5 = new char [][] {
                {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'B', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'X', 'X', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'X', 'X', 'X', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'X', 'X', 'O', 'O', 'X'},
                {'O', 'O', 'X', 'X', 'X', 'X', 'O', 'O', 'O', 'O'},
                {'O', 'X', 'O', 'O', 'G', 'O', 'X', 'O', 'I', 'O'},
                {'X', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O'}
        };

        char[][] map6 = new char [][] {
                {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X'},
                {'O', 'O', 'B', 'O', 'O', 'X', 'X', 'O', 'O', 'O'},
                {'O', 'X', 'X', 'X', 'O', 'O', 'X', 'O', 'O', 'I'},
                {'O', 'X', 'X', 'X', 'O', 'O', 'X', 'X', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'X', 'X', 'X', 'X', 'O'},
                {'X', 'O', 'O', 'X', 'X', 'X', 'X', 'O', 'O', 'O'},
                {'X', 'X', 'O', 'O', 'O', 'X', 'X', 'O', 'X', 'X'},
                {'O', 'O', 'O', 'X', 'X', 'X', 'O', 'X', 'O', 'X'},
                {'O', 'X', 'X', 'X', 'G', 'O', 'X', 'X', 'O', 'X'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O'}
        };
        ArrayList<char[][]> maps = new ArrayList<>();
        maps.add(map1);
        maps.add(map2);
        maps.add(map3);
        maps.add(map4);
        maps.add(map5);
        maps.add(map6);

        return maps;
    }

    /**
     * Parse map and store the location of victim, robot and exit.
     * @param map
     * @return Problem to solve or null if map is null
     */
    public Problem parseMap(char[][] map) {
        if (map == null) return null;

        Problem p = new Problem();
        int rows = map.length;
        int cols = map[0].length;
        p.map = map;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                switch (map[i][j]) {
                    case 'I':   p.ai_agent = new Agent(i, j);
                                break;
                    case 'B':   p.victim = new Victim(i, j);
                                break;
                    case 'G':   p.exit = new MapPosition(i, j);
                                break;
                    default:    break;
                }
            }
        }
        p.goal = new State(null, p.victim.position);
        return p;
    }

    /**
     * Execute the program on test maps
     * @param obj
     */
    public void processInput(PathFinder obj) {
        ArrayList<char[][]> maps = obj.addMaps();

        for (int i = 0; i < maps.size() ; i++) {
            System.out.println("Map" + (i+1) + ":");

            parseBFS(obj, maps, i);

            parseDFS(obj, maps, i);

            System.out.println();
        }
    }

    /**
     * Parse the test map using BFS algorithm
     * @param pf
     * @param maps
     * @param map_index
     */
    public void parseBFS(PathFinder pf, ArrayList<char[][]> maps, int map_index) {
        SearchTree st = new SearchTree();
        Problem problem = pf.parseMap(maps.get(map_index));
        Node bfs_victim = st.treeSearchBFS(problem);
        int bfs_steps = st.bfs_search_visits;
        int bfs_length;

        if (bfs_victim != null) {
            bfs_length = bfs_victim.path_cost;
            problem.goal = new State(null, problem.exit);
            problem.ai_agent.victim = problem.victim;
            problem.victim.saved = true;
            problem.ai_agent.position = bfs_victim.state.position;

            Node bfs_exit = st.treeSearchBFS(problem);
            bfs_steps += st.bfs_search_visits;
            System.out.println("BFS tree steps: " + bfs_steps);
            if (bfs_exit != null) {
                bfs_length += bfs_exit.path_cost;
                System.out.println("BFS length: " + bfs_length);
            }else
                System.out.println("No valid path to exit found");
        } else
            System.out.println("No valid path to victim was found");
    }

    /**
     * Parse the map using DFS algorithm
     * @param obj
     * @param maps
     * @param map_index
     */
    public void parseDFS(PathFinder obj, ArrayList<char[][]> maps, int map_index) {
        SearchTree st = new SearchTree();
        Problem problem = obj.parseMap(maps.get(map_index));
        Node dfs_victim = st.treeSearchDFS(problem);
        int dfs_steps = st.dfs_search_visits;
        int dfs_length;

        if (dfs_victim != null) {
            dfs_length = dfs_victim.path_cost;
            problem.goal = new State(null, problem.exit);
            problem.ai_agent.victim = problem.victim;
            problem.victim.saved = true;
            problem.ai_agent.position = dfs_victim.state.position;

            Node dfs_exit = st.treeSearchDFS(problem);
            dfs_steps += st.dfs_search_visits;
            System.out.println("DFS tree steps:" + dfs_steps);
            if (dfs_exit != null) {
                dfs_length += dfs_exit.path_cost;
                System.out.println("DFS length: " + dfs_length);
            }else
                System.out.println("No valid path to exit found");
        } else
            System.out.println("No valid path to victim was found");
    }


}
