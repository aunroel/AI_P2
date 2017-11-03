public class Agent {

    public MapPosition position;
    public Victim victim;
    public int route_length;

    public Agent(int x, int y) {
        position = new MapPosition(x,y);
        victim = null;
        route_length = 0;
    }
}
