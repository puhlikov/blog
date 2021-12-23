import util.Util;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Detail> detailList = new ArrayList<>();

        MachineTime machineTime = new MachineTime();

        detailList.add(new Detail(1, 1, 5));
        detailList.add(new Detail(2, 6, 4));
        detailList.add(new Detail(3, 2, 3));
        detailList.add(new Detail(4, 6, 3));
        detailList.add(new Detail(5, 9, 1));
        detailList.add(new Detail(6, 4, 5));
        detailList.add(new Detail(7, 2, 2));
        detailList.add(new Detail(8, 7, 7));

        System.out.println("+++++++++++MachineTime+++++++++++++++");

        Util.printCollection(detailList);

        System.out.println(machineTime.workmachine(detailList));

        System.out.println("+++++++++MachineTime after SortJonson+++++++++++++++++");

        detailList.sort(new Jonson());

        Util.printCollection(detailList);

        System.out.println(machineTime.workmachine(detailList));

        System.out.println("===========================");
    }
}




