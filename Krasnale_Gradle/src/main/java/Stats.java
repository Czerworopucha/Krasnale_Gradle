import java.util.Scanner;

public class Stats {

    public static void Starting_Stats() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ile Krasnoludow ma zamieszkiwac kolonie? : ");
        main.Production = scanner.nextInt();
        System.out.println();
        System.out.print("Ile tygodni z zycia kolonii chcesz zasymulowac : ");
        main.Max_Loops = scanner.nextInt();
        System.out.println();
        main.Common_Wealth = main.Production*Math.floor(791492*Math.pow(main.Production,-1.775));
    }

    public static void WriteStats() {
        System.out.println("---------------------------------------------------------------------------------------------------");
        System.out.println("Skarb panstwa wynosi: " + (int)main.Common_Wealth + " zlotych monet.");
        System.out.print("Technologia jest na poziomie: ");
        switch ((int) (Math.floor(main.Technology_Progress))) {
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
        System.out.println("Zyjace krasnoludy: " + main.Dwarf_List.stream().filter(x->x.vital==Vital.ALIVE).count());
        System.out.println("Dzieci: " + main.Dwarf_List.stream().filter(x->x.age < 50).count());
        System.out.println("Starszyzna: " + main.Dwarf_List.stream().filter(x->x.age > 250).filter(x->x.vital==Vital.ALIVE).count());
        System.out.println("Gornicy: " + main.Dwarf_List.stream().filter(x->x instanceof Dwarf_Miner).filter(x->x.vital==Vital.ALIVE).count());
        System.out.println("Nadzorcy: " + main.Dwarf_List.stream().filter(x->x instanceof Dwarf_Overseer).filter(x->x.vital==Vital.ALIVE).count());
        System.out.println("Wynalazcy: " + main.Dwarf_List.stream().filter(x->x instanceof Dwarf_Innovator).filter(x->x.vital==Vital.ALIVE).count());
        System.out.println("Karczmarze: " + main.Dwarf_List.stream().filter(x->x instanceof Dwarf_Innkeeper).filter(x->x.vital==Vital.ALIVE).count());
        System.out.println("Wypite piwa w trakcie symulacji: " + main.Pints_All);
        System.out.println("Zmarli w wyniku wypadków: " + main.Dead_All);
        System.out.println("---------------------------------------------------------------------------------------------------");
    }
}
