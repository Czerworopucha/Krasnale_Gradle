public class Dwarf_Council extends Dwarf_Elder{

    int yearsOfService=0;
    int lawsEstablished=0;

    public Dwarf_Council(Dwarf_Elder dwarf_elder, int yearsOfService, int lawsEstablished){
        super(dwarf_elder);
        this.yearsOfService=yearsOfService;
        this.lawsEstablished=lawsEstablished;
    }
    public Dwarf_Council(){}

}
