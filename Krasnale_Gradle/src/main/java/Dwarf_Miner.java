import java.util.ArrayList;
import java.util.Random;

public class Dwarf_Miner extends Dwarf_Worker{

    int minedOre=0;
    int tunnelsDwelved=0; //tunnels dwelved [km]
    int Digging=0;
    int Accident_Chance=100;

    public Dwarf_Miner(Dwarf_Worker dwarf_worker, int minedOre, int tunnelsDwelved){
        super(dwarf_worker);
        this.minedOre=minedOre;
        this.tunnelsDwelved=tunnelsDwelved;
    }
    public Dwarf_Miner(){}

    public Dwarf_Miner(Dwarf_Miner dwarf_miner){
        super((Dwarf_Worker)dwarf_miner);
        this.minedOre=dwarf_miner.minedOre;
        this.tunnelsDwelved=dwarf_miner.tunnelsDwelved;
    }

    @Override
    public void Update(ArrayList<Dwarf> Dwarf_List) {
        super.Update(Dwarf_List);
        if (vital == Vital.ALIVE) {
            Random random = new Random();
            Digging = random.nextInt(10);
            if (status == Status.DRUNK) Digging /= 2;
            tunnelsDwelved += Digging;
            minedOre += (Digging / 2);
            main.Common_Wealth += (Digging * 30 * ((-1)/(2*main.Technology_Progress-1)+2));

            Accident_Chance = random.nextInt(200);
            if (status == Status.DRUNK) {
                if (Accident_Chance <= 10) {
                    vital = Vital.DEAD;
                    main.Dead_Week++;
                }
            }
            else {
                    if (Accident_Chance <= 1) {
                        vital = Vital.DEAD;
                        main.Dead_Week++;
                    }
                }
            }
        }
    }
