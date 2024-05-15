public abstract class SpecialEntity {
    private int start;
    private int end;

    SpecialEntity(int start,int end) {
        this.start =start;
        this.end =end;
    }

    public int getEndPosition() {
        return this.end;
    }
}
