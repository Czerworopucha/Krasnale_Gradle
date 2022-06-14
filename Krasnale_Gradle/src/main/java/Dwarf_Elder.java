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
}
