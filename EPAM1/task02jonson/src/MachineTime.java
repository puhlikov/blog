import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MachineTime {

    public String workmachine(List<?> details) {
        int nonWorkingMachineTime = getNonWorkingMachine(details);
        int workingMachineTime = getWorkingMachine(details);
        int allWorkTime = getAllWorkTime(nonWorkingMachineTime, workingMachineTime);
        return "Простой оборудования: " + nonWorkingMachineTime + "\n Вся работа оборудования: " + allWorkTime + "\n";
    }

    private int getNonWorkingMachine(List<?> details){
        List<Detail> listDetails = new ArrayList<>((Collection<? extends Detail>) details);
        int nonWorkingMachineTime = 0;
        nonWorkingMachineTime = listDetails.get(0).getT2();

        for (int i=0; i < listDetails.size() - 1; i++){

            nonWorkingMachineTime -= (listDetails.get(i).getT2() - listDetails.get(i+1).getT1());
        }
        return nonWorkingMachineTime;

    }

    private int getWorkingMachine (List<?> details) {
        List<Detail> listDetails = new ArrayList<>((Collection<? extends Detail>) details);
        int workingMachineTime = 0;
        for (Detail detail : listDetails){
            workingMachineTime += detail.getT2();
        }
        return workingMachineTime;
    }

    private int getAllWorkTime (int nonWorkingMachineTime, int workingMachineTime){

        return   nonWorkingMachineTime + workingMachineTime;

    }

}
