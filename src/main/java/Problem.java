import java.util.ArrayList;

public class Problem {

    public Agent ai_agent;
    public Victim victim;
    public MapPosition exit;
    public ArrayList<MapPosition> obstacles;


    public Problem() {
        this.obstacles = new ArrayList<>();
    }

    public Problem(Agent ai_agent, Victim victim, MapPosition exit) {
        this.ai_agent = ai_agent;
        this.victim = victim;
        this.exit = exit;
        this.obstacles = new ArrayList<>();
    }
}
