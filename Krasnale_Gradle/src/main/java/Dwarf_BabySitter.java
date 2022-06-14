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
}
