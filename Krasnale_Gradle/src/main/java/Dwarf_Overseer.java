import javax.sound.midi.Soundbank;
import java.util.ArrayList;

public class Dwarf_Overseer extends Dwarf_Miner {

    int subordinates = 0;
    int productivityBonus = 5;

    public Dwarf_Overseer(Dwarf_Miner dwarf_miner, int subordinates, int productivityBonus) {
        super(dwarf_miner);
        this.subordinates = subordinates;
        this.productivityBonus = productivityBonus;
    }

    public Dwarf_Overseer() {
    }

    /*    public Dwarf_Overseer(Dwarf_Overseer dwarf_overseer){
            super((Dwarf_Miner)dwarf_overseer);
            this.subordinates=subordinates;
            this.productivityBonus=productivityBonus;
        }*/

    @Override
    public void Update(ArrayList<Dwarf> Dwarf_List) {
        super.Update(Dwarf_List);
        if(vital == Vital.ALIVE)
        main.Common_Wealth+=(subordinates*productivityBonus*main.Technology_Progress);
    }
}
