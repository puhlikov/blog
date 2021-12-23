import java.util.Comparator;

public class Jonson implements Comparator<Detail> {

    @Override
    public int compare(Detail a, Detail b) {
        if (a.getT1() <= a.getT2() && a.getT1()<b.getT1())
                    return -1;
        else if (b.getT1() > b.getT2() && a.getT2() > b.getT2())
            return -1;
        else
        return 0;

    }
}