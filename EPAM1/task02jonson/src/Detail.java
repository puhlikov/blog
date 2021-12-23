

public class Detail {
    private int numm;
    private int t1;
    private int t2;

    public Detail(int numm, int t1, int t2) {
        this.numm = numm;
        this.t1 = t1;
        this.t2 = t2;
    }

    public int getNumm() {
        return numm;
    }

    public void setNumm(int numm) {
        this.numm = numm;
    }

    public int getT1() {
        return t1;
    }

    public void setT1(int t1) {
        this.t1 = t1;
    }

    public int getT2() {
        return t2;
    }

    public void setT2(int t2) {
        this.t2 = t2;
    }

    @Override
    public String toString() {
        return "№" + numm + "(" + t1 + "," + t2 + ")";
    }
}
