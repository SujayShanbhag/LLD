public class Player {
    public String name;
    public int position;

    public Player(String name) {
        this.name = name;
        this.position=1;
    }

    public void setPosition(int endPosition) {
        this.position=endPosition;
    }
}
