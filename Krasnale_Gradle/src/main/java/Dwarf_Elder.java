import java.util.ArrayList;

public class Dwarf_Elder extends Dwarf{

    int reputationLevel=0;

    public Dwarf_Elder(Dwarf_Worker dwarf_worker, int reputationLevel){
    super((Dwarf)dwarf_worker);
    this.reputationLevel=reputationLevel;

    }
    public Dwarf_Elder(){}

    public Dwarf_Elder(Dwarf_Elder dwarf_elder){
        super((Dwarf)dwarf_elder);
        this.reputationLevel=dwarf_elder.reputationLevel;
    }

    public void Update(ArrayList<Dwarf> Dwarf_List){
        super.Update(Dwarf_List);
        if(vital == Vital.ALIVE){
            if(main.Technology_Progress>3){
                main.Common_Wealth -= 0.5 *reputationLevel * ((-1)/(2*main.Technology_Progress-1)+2);
            }
        }
    }
}
