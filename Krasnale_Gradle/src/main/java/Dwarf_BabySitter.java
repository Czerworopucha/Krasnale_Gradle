import java.util.ArrayList;

public class Dwarf_BabySitter extends Dwarf_Elder{

    int babyCapacity=0;
    int knowledge=0;

    public Dwarf_BabySitter(Dwarf_Elder dwarf_elder, int babyCapacity, int knowledge){
        super(dwarf_elder);
        this.babyCapacity=babyCapacity;
        this.knowledge=knowledge;
    }
    public Dwarf_BabySitter(){}

/*    public Dwarf_BabySitter(Dwarf_BabySitter dwarf_babySitter){
        super((Dwarf_Elder)dwarf_babySitter);
        this.babyCapacity=babyCapacity;
        this.knowledge=knowledge;
    }*/

    public void Update(ArrayList<Dwarf> Dwarf_List){
        super.Update(Dwarf_List);
        if(vital == Vital.ALIVE){
            if(knowledge>0){
                knowledge-= Dwarf_List.stream().filter(x->x.age < 50).count();
            }
            if(knowledge==0) vital=Vital.DEAD;
        }
    }
}
