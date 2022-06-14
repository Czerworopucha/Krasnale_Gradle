import java.util.ArrayList;

public class Dwarf_Worker extends Dwarf {

    int WorkingHours=8;
    int PayPerHour=0;

    public Dwarf_Worker(Dwarf dwarf, int WorkingHours, int PayPerHour){
        super(dwarf);
        this.WorkingHours=WorkingHours;
        this.PayPerHour=PayPerHour;
    }
    public Dwarf_Worker(){}

    public Dwarf_Worker(Dwarf_Worker dwarf_worker){
        super((Dwarf)dwarf_worker);
        this.WorkingHours=dwarf_worker.WorkingHours;
        this.PayPerHour=dwarf_worker.PayPerHour;
    }

    @Override
    public void Update(ArrayList<Dwarf> Dwarf_List){
        super.Update(Dwarf_List);
        if(vital== Vital.ALIVE)
        main.Common_Wealth-=(WorkingHours*PayPerHour*((-1)/(2*main.Technology_Progress-1)+2));
    }
}

