import java.util.ArrayList;
import java.util.Random;

public class Dwarf_Innovator extends Dwarf_Worker{

    int ideas=0;
    int explosionsInLab=0;
    int idea;
    int explosions;

    public Dwarf_Innovator(Dwarf_Worker dwarf_worker, int ideas, int explosionsInLab){
        super(dwarf_worker);
        this.ideas=ideas;
        this.explosionsInLab=explosionsInLab;
    }

    public Dwarf_Innovator(){}

    @Override
    public void Update(ArrayList<Dwarf> Dwarf_List){
        super.Update(Dwarf_List);
        if(vital == Vital.ALIVE){
        Random random=new Random();
        idea = random.nextInt(10)+2;
        ideas+= idea;
        main.Technology_Progress+=idea*(100/(main.Production*((-1)/(2*main.Technology_Progress-1)+2)))*0.001;

        if(status==Status.DRUNK)
            explosions= random.nextInt(20);

        else
            explosions= random.nextInt(200);

        if(explosions<1){
            explosionsInLab++;
            main.Technology_Progress-=0.005;
            if(explosions<1){
                vital = Vital.DEAD;
                main.Dead_Week++;
            }
        }
        }
    }
}