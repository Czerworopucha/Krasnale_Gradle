import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.lang.Math;

public class main {

    static int Max_Loops = 10;
    static ArrayList<Dwarf> Dwarf_List;
    public static double Common_Wealth=0;
    public static float Technology_Progress=1;
    public static int Dead_Week;
    public static int Dead_All;
    public static int Production;
    public static int Pints_Week;
    public static int Pints_All;

    private static void Starting_Stats() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ile Krasnoludow ma zamieszkiwac kolonie? : ");
        Production = scanner.nextInt();
        System.out.println();
        System.out.print("Ile tygodni z zycia kolonii chcesz zasymulowac : ");
        Max_Loops = scanner.nextInt();
        System.out.println();
        /*
        if(Production <= 50) Common_Wealth = Production * 700;
        if(Production > 50 && Production <= 60) Common_Wealth = Production * 550;
        if(Production > 60 && Production <= 70) Common_Wealth = Production * 500;
        if(Production > 70 && Production <= 80) Common_Wealth = Production * 350;
        if(Production > 80 && Production <= 90) Common_Wealth = Production * 250;
        if(Production > 90 && Production <= 100) Common_Wealth = Production * 210;
        if(Production > 100){
            int money = 210;
            for(int x = Production ; x>100 ; x=x-10){
                money = money-10;
            }
            if(money < 30) money = 30;
            Common_Wealth = Production * money;
        }
        */
        Common_Wealth = Production*Math.floor(791492*Math.pow(Production,-1.775));
    }

    private static void Initialization() {
        Dwarf_List = Dwarf_Factory.Dwarf_Generator(Production);
    }

    private static void WriteStats() {
        System.out.println("---------------------------------------------------------------------------------------------------");
        System.out.println("Skarb panstwa wynosi: " + (int)Common_Wealth + " zlotych monet.");
        System.out.print("Technologia jest na poziomie: ");
        switch ((int) (Math.floor(Technology_Progress))) {
            case 1 -> {
                System.out.println("Prymitywnym.");
            }
            case 2 -> {
                System.out.println("Podstawowym.");
            }
            case 3 -> {
                System.out.println("Srednio rozwinietym.");
            }
            case 4 -> {
                System.out.println("Rozwinietym.");
            }
            case 5 -> {
                System.out.println("Zaawansowanym.");
            }
            case 6 -> {
                System.out.println("Zaawansowanym");
            }
        }
        System.out.println("Zyjace krasnoludy: " + Dwarf_List.stream().filter(x->x.vital==Vital.ALIVE).count());
        System.out.println("Dzieci: " + Dwarf_List.stream().filter(x->x.age < 50).count());
        System.out.println("Starszyzna: " + Dwarf_List.stream().filter(x->x.age > 250).filter(x->x.vital==Vital.ALIVE).count());
        System.out.println("Gornicy: " + Dwarf_List.stream().filter(x->x instanceof Dwarf_Miner).filter(x->x.vital==Vital.ALIVE).count());
        System.out.println("Nadzorcy: " + Dwarf_List.stream().filter(x->x instanceof Dwarf_Overseer).filter(x->x.vital==Vital.ALIVE).count());
        System.out.println("Wynalazcy: " + Dwarf_List.stream().filter(x->x instanceof Dwarf_Innovator).filter(x->x.vital==Vital.ALIVE).count());
        System.out.println("Karczmarze: " + Dwarf_List.stream().filter(x->x instanceof Dwarf_Innkeeper).filter(x->x.vital==Vital.ALIVE).count());
        System.out.println("Wypite piwa w trakcie symulacji: " + Pints_All);
        System.out.println("Zmarli w wyniku wypadków: " + Dead_All);
        System.out.println("---------------------------------------------------------------------------------------------------");
    }


    private static void Week_Update(int Max_Weeks){
        for(int week_count=1; week_count <= Max_Weeks; week_count++) {
            for (int Loop = 0; Loop < 7; Loop++) {
                Dwarf_List.forEach(
                        (Dwarf) ->
                        {
                            Dwarf.Update(Dwarf_List);
                        }
                );
            }
            System.out.println("Podsumowanie tygodnia: " + week_count + ":");
            System.out.println("Skarbiec koloni: " + (int)Common_Wealth + " Zlotych monet.");
            System.out.print("Technologia jest na poziomie: ");
            switch ((int) (Math.floor(Technology_Progress))) {
                case 1 -> {
                    System.out.println("Prymitywnym.");
                }
                case 2 -> {
                    System.out.println("Podstawowym.");
                }
                case 3 -> {
                    System.out.println("Srednio rozwinietym.");
                }
                case 4 -> {
                    System.out.println("Rozwinietym.");
                }
                case 5 -> {
                    System.out.println("Zaawansowanym.");
                }
            }
            if (Dead_Week > 0) {
                System.out.println("W wypadkach zginelo: " + Dead_Week + " krasnoludow.");
                Dead_All += Dead_Week;
                Dead_Week = 0;
            } else System.out.println("Brak smierci w tym tygodniu.");

            System.out.println("W tym tygodniu wypito: "+ Pints_Week + " kufli piwa w karczmach.");
                Pints_All += Pints_Week;
                Pints_Week = 0;

            System.out.println("---------------------------------------------------------------------------------------------------");

            if (Common_Wealth < 5 * (Production-Dead_All)) {
                System.out.println("Kolonia przertwala: " + week_count + " tygodni.");
                System.out.println("Kolonia nie poradzila sobie z kryzysem ekonomicznym w " + week_count + " tygodniu rozwoju.");
                System.out.println("Krasnoludy jeden po drugim padaja ofiarami smierci glodowej,");
                System.out.println("co prowadzi do zamieszek i calkowitego upadku kolonii");
                break;
            }
            if (Technology_Progress >= 5) {
                System.out.println("Kolonia przertwala: " + week_count + " tygodni.");
                System.out.println("Kolonia prosperuje i wszyscy jej mieszkancy wioda zycie na godnym poziomie.");
                System.out.println("Poziom rozwoju technologicznego zapewnia wszystkim bezpieczenstwo");
                System.out.println("i stale zrodla przychodu oraz pozywienia. Pokolenia Krasnoludow ja zamieszkujace");
                System.out.println("beda w stanie przezyc w tym miejscu na wieki.");
                break;
            }
            if (Dead_All == Production) {
                System.out.println("Kolonia przertwala: " + week_count + " tygodni.");
                System.out.println("Krasnoludy z całej kolonii spotykaja się przy jednym stole,");
                System.out.println("aby swietowac ich wlasny dobrobyt oraz bogactwo.");
                System.out.println("Niestety, dnia nastepnego ich zamilowanie do napojow alkoholowych nie dalo o sobie zapomniec.");
                System.out.println("Brak trzezwosci umyslu i koordynacji ruchowej,");
                System.out.println("przy tak ryzykownej pracy w kopalniach, byly powodem wielu wypadkow.");
                System.out.println("Tak nagle i znaczne zredukowanie populacji kolonii,");
                System.out.println("doprowadziło do załamania rownowagi spolecznej.");
                System.out.println("Pozostawionych na pastwe losu nieszczesników wykonczyly choroby i glod");
                break;
            }
            if (week_count==Max_Weeks){
                System.out.println("Kolonia przertwala: " + week_count + " tygodni.");
                System.out.println("I przetrwala probe czasu.");
                break;
            }
            if (Common_Wealth >= Dwarf_List.stream().filter(x->x.vital==Vital.ALIVE).count() * 360 * 5 * Technology_Progress){
                System.out.println("Kolonia przertwala: " + week_count + " tygodni.");
                System.out.println("Dzieki ciezkiej pracy i wielu wyrzeczeniom, skarbce sa przepelnione drogocennymi metalami.");
                System.out.println("Zebrane bogactwo jest gwarancja przetrwania kolonii i jej dalszego rozwoju.");
                System.out.println("Kolonia przertwała: " + week_count + " tygodni.");
                break;
            }

        }
    }
/*    private static void Array_Printer(){
        for (Dwarf str : Dwarf_List){
            System.out.println(Dwarf_List);
        }
    }*/


    public static void main(String[] args) {

        Starting_Stats();
        Initialization();
        WriteStats();
        Week_Update(Max_Loops);
        WriteStats();
        //zapis do pliku metoda
    }
}
/*
Common wealth - "skarb państwa, powiększa się o złoto wykopane w kopalniach oraz zarobione na sprzedarzy piwa
Każdy żyjący krasnolud wymaga 10sztuk złota z common wealth aby przeżyć

Technology progress - Postęp w technologii pozwala wydobywać złoto efektywniej

Warunki zakończenia symulacji:
Common wealth == 0 - śmierć głodowa koloni, brak środków do życia
Technology progress > 5 - kolonia stabilna i rozwinięta technicznie wystarczająco aby przeżyć
wszystkie dwarfy martwe?
koniec loopów.


Gradle - done
Statystyki końcowe - done
zapis do pliku
wywalić building - done
updaty elderów - done
adjustment cyferek - done
porzadek w kodzie
polskie znaki
zakończenie od pieniędzy - wystarczająco by przetrwac 200 dni? - done

*/
