public class Dice {
    private int max;

    public Dice(int max) {
        this.max = max;
    }

    public int roll() {
        return (int) (Math.random()*max+1);
    }
}
