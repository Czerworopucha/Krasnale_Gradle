import java.util.ArrayList;
import java.util.Random;

public class Dwarf_Innkeeper extends Dwarf_Worker{

    int pintsServed=0;
    int barPolished=0; //distance
    int pintCost=3;
    int cleaning;

    public Dwarf_Innkeeper(Dwarf_Worker dwarf_worker, int pintsServed, int barPolished){
        super(dwarf_worker);
        this.pintsServed=pintsServed;
        this.barPolished=barPolished;
    }
    public Dwarf_Innkeeper(){}

    @Override
    public void Update(ArrayList<Dwarf> Dwarf_List){
        super.Update(Dwarf_List);
        if(vital == Vital.ALIVE){
        long pints=Dwarf_List.stream().filter(x->x.status==Status.DRUNK).count();
        pintsServed+=pints;
        main.Pints_Week+=pints;
        Random random=new Random();
        cleaning = random.nextInt(10);
        barPolished+=cleaning;
        main.Common_Wealth+=pints*pintCost;
     }
    }
}
