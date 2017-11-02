public class Main {

    public static void main(String[] args) {

        Main obj = new Main();

        char[][] test = new char[][] {
                {'I', 'O', 'O', 'O'},
                {'O', 'X', 'X', 'O'},
                {'O', 'O', 'B', 'O'},
                {'O', 'O', 'O', 'G'},
        };

        Problem problem = obj.parseMap(test);
        System.out.println();

    }


    public Problem parseMap(char[][] map) {
        if (map == null) return null;

        Problem p = new Problem();
        int rows = map.length;
        int cols = map[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                switch (map[i][j]) {
                    case 'I':   p.ai_agent = new Agent(i, j);
                                break;
                    case 'B':   p.victim = new Victim(i, j);
                                break;
                    case 'X':   p.obstacles.add(new MapPosition(i, j));
                                break;
                    case 'G':   p.exit = new MapPosition(i, j);
                                break;
                    default:    break;
                }
            }
        }
        return p;
    }


}
