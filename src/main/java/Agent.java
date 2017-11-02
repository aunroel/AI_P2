public class Agent {

    public MapPosition position;
    public Victim victim;

    public Agent(int x, int y) {
        position = new MapPosition(x,y);
        victim = null;
    }
}
