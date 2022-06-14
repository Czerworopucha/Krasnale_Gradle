import java.util.Random;

public class Randomizers {

    static Random random = new Random();
    static String[] NamesMale =
            { "Rafgrim", "Thorgrim", "Charbek", "Oin", "Gloin", "Thorin", "Baldin", "Gimli", "Bardin", "Kili", "Fili", "Fargrim", "Okri"};

    static String[] NamesFemale =
            {  "Gimkum", "Gemnera", "Hargurn", "Brylwaen", "Dwosteada", "Tyshnys", "Grilrigg", "Tymor", "Kardan", "Daerkom", "Marmyl", "Ragrim", "Lutraelin"};

    public static String RandomName(Sex sex){
        int randomId = random.nextInt(13);
        String name="";
        if(sex == Sex.MALE){
            name = NamesMale[randomId];
        }
        else {
            name = NamesFemale[randomId];
        }
        return name;
    }

    public static Sex RandomSex(){
        Sex sex;
        int randomSex = random.nextInt(100);
        if(randomSex <= 50) sex = Sex.MALE;
        else sex = Sex.FEMALE;
        return sex;
    }

    public static int RandomAge(Maturity maturity){
        int age = 0;
        if(maturity == Maturity.CHILD) age = random.nextInt(50);
        if(maturity == Maturity.ADULT) age = 50 + random.nextInt(200);
        if(maturity == Maturity.ELDER) age = 250 + random.nextInt(100);
        return age;
    }

    public static int RandomBeard(Maturity maturity){
        int beardLength=0;
        if(maturity == Maturity.CHILD) beardLength = random.nextInt(20);
        if(maturity == Maturity.ADULT) beardLength = 15 + random.nextInt(30);
        if(maturity == Maturity.ELDER) beardLength = 30 + random.nextInt(60);
        return beardLength;
    }

    public static int RandomBeers(Maturity maturity){
        int beers=0;
        if(maturity == Maturity.CHILD) beers = random.nextInt(500);
        if(maturity == Maturity.ADULT) beers = 700 + random.nextInt(5000);
        if(maturity == Maturity.ELDER) beers = 7000 + random.nextInt(1000);
        return beers;
    }


}
