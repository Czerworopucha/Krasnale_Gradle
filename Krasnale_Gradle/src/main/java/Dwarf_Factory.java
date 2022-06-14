import java.util.ArrayList;
import java.util.Random;

public class Dwarf_Factory {


    public static ArrayList<Dwarf> Dwarf_Generator(int Production){
        var Dwarf_List=new ArrayList<Dwarf>();
        Random random = new Random();

        int workers = 60 + random.nextInt(15);
        workers = (workers * Production)/100;

        int elders = 15 + random.nextInt(10);
        elders = (elders*Production) /100;

        int children = Production - workers - elders;

        for(int n=0; n<children; n++){
            Sex sex = Randomizers.RandomSex();
            Dwarf New_Dwarf = new Dwarf(Randomizers.RandomName(sex), Randomizers.RandomAge(Maturity.CHILD), sex, Status.SOBER, Randomizers.RandomBeard(Maturity.CHILD), Randomizers.RandomBeers(Maturity.CHILD), Vital.ALIVE);
            Dwarf_List.add(New_Dwarf);
        }

        for(int n=0; n<elders; n++){
            Sex sex = Randomizers.RandomSex();
            Dwarf New_Dwarf = new Dwarf(Randomizers.RandomName(sex), Randomizers.RandomAge(Maturity.ELDER), sex, Status.SOBER, Randomizers.RandomBeard(Maturity.ELDER), Randomizers.RandomBeers(Maturity.ELDER), Vital.ALIVE);
            Dwarf_Worker New_Worker = new Dwarf_Worker(New_Dwarf, 0,0);
            Dwarf_Elder New_Elder = new Dwarf_Elder(New_Worker, 5 + random.nextInt(5));

            if(n < elders/2){
                Dwarf_Council New_Council = new Dwarf_Council(New_Elder, (int)New_Elder.age - 250, 0);
                Dwarf_List.add(New_Council);
            }
            else{
                Dwarf_BabySitter New_Sitter = new Dwarf_BabySitter(New_Elder, 5+random.nextInt(5), 5+ random.nextInt(5) );
                Dwarf_List.add(New_Sitter);
            }
        }

            int miners = 65 + random.nextInt(15);
                miners = (miners*workers) /100;

            int overseers = (20*miners) /100;

            int innovators = 10 + random.nextInt(10);
                innovators = (innovators*workers) /100;

            int innkeepers = workers - miners - innovators;

            for(int m=0; m<miners; m++){
                Sex sex = Randomizers.RandomSex();
                Dwarf New_Dwarf = new Dwarf(Randomizers.RandomName(sex), Randomizers.RandomAge(Maturity.ADULT), sex, Status.SOBER, Randomizers.RandomBeard(Maturity.ADULT), Randomizers.RandomBeers(Maturity.ADULT), Vital.ALIVE);
                Dwarf_Worker New_Worker = new Dwarf_Worker(New_Dwarf, 8 + random.nextInt(4), 5 + random.nextInt(5));
                Dwarf_Miner New_Miner = new Dwarf_Miner(New_Worker, 0, 0);
                    if(m<overseers){
                        Dwarf_Overseer New_Overseer = new Dwarf_Overseer(New_Miner, miners/overseers, 5+ random.nextInt(5));
                        Dwarf_List.add(New_Overseer);
                    } else
                Dwarf_List.add(New_Miner);
            }

            for(int m=0; m<innovators; m++){
                Sex sex = Randomizers.RandomSex();
                Dwarf New_Dwarf = new Dwarf(Randomizers.RandomName(sex), Randomizers.RandomAge(Maturity.ADULT), sex, Status.SOBER, Randomizers.RandomBeard(Maturity.ADULT), Randomizers.RandomBeers(Maturity.ADULT), Vital.ALIVE);
                Dwarf_Worker New_Worker = new Dwarf_Worker(New_Dwarf, 8 + random.nextInt(4), 5 + random.nextInt(5));
                Dwarf_Innovator New_Innovator = new Dwarf_Innovator(New_Worker, 0, 0);
                Dwarf_List.add(New_Innovator);
            }

            for(int m=0; m<innkeepers; m++){
                Sex sex = Randomizers.RandomSex();
                Dwarf New_Dwarf = new Dwarf(Randomizers.RandomName(sex), Randomizers.RandomAge(Maturity.ADULT), sex, Status.SOBER, Randomizers.RandomBeard(Maturity.ADULT), Randomizers.RandomBeers(Maturity.ADULT), Vital.ALIVE);
                Dwarf_Worker New_Worker = new Dwarf_Worker(New_Dwarf, 8 + random.nextInt(4), 5 + random.nextInt(5));
                Dwarf_Innkeeper New_Innkeeper = new Dwarf_Innkeeper();
                Dwarf_List.add(New_Innkeeper);
            }

        return Dwarf_List;
    }

/*    public static void Add_Dwarf(ArrayList Dwarf_List){
        Dwarf New_Dwarf = new Dwarf();
        Dwarf_List.add(New_Dwarf);
    }*/


}
