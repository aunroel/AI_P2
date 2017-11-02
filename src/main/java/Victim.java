public class Victim {

    public MapPosition position;
    public boolean saved;

    public Victim(int x, int y) {
        position = new MapPosition(x, y);
        saved = false;
    }

}
