import java.util.ArrayList;
import java.util.Random;

public class Dwarf_Council extends Dwarf_Elder{

    int yearsOfService=0;
    int lawsEstablished=0;
    Random random=new Random();

    public Dwarf_Council(Dwarf_Elder dwarf_elder, int yearsOfService, int lawsEstablished){
        super(dwarf_elder);
        this.yearsOfService=yearsOfService;
        this.lawsEstablished=lawsEstablished;
    }
    public Dwarf_Council(){}

    public void Update(ArrayList<Dwarf> Dwarf_List){
        super.Update(Dwarf_List);
        if(vital == Vital.ALIVE){
            if(random.nextInt(100) < 1)
                lawsEstablished += random.nextInt(2);
        }
    }
}
