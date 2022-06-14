import java.util.ArrayList;
import java.util.Random;

public class Dwarf {

    String name = "Dwarf";
    float age = 0;
    float beardLength = 0; // beard length [cm]
    int beer = 0; // beers consumed [pints]
    Sex sex = Sex.MALE;
    Status status = Status.SOBER;
    Vital vital = Vital.ALIVE;

    public Dwarf(String name, float age, Sex sex, Status status, float beardLength, int beer, Vital vital) {
        this.name = name;
        this.age = age;
        this.beardLength = beardLength;
        this.beer=beer;
        this.sex = sex;
        this.status = status;
        this.vital = vital;
    }
    public Dwarf(){}

    public Dwarf(Dwarf dwarf){
        this.name= dwarf.name;
        this.age = dwarf.age;
        this.status = dwarf.status;
        this.beardLength = dwarf.beardLength;
        this.beer = dwarf.beer;
        this.sex = dwarf.sex;
        this.vital = dwarf.vital;
    }

    public void Update(ArrayList<Dwarf> Dwarf_List){
        status = Status.SOBER;
        if(vital == Vital.ALIVE){
        Random random=new Random();
        int x = random.nextInt(20);
        age+=0.01;
        beardLength+=0.1;
        if(x==0){beer++; status=Status.DRUNK;}
        main.Common_Wealth-=5*main.Technology_Progress;
    }}


}