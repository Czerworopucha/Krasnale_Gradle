public class Update {

    public static void Week_Update(int Max_Weeks){
        for(int week_count=1; week_count <= Max_Weeks; week_count++) {
            for (int Loop = 0; Loop < 7; Loop++) {
                main.Dwarf_List.forEach(
                        (Dwarf) ->
                        {
                            Dwarf.Update(main.Dwarf_List);
                        }
                );
            }
            System.out.println("Podsumowanie tygodnia: " + week_count + ":");
            System.out.println("Skarbiec koloni: " + (int)main.Common_Wealth + " Zlotych monet.");
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
            }
            if (main.Dead_Week > 0) {
                System.out.println("W wypadkach zginelo: " + main.Dead_Week + " krasnoludow.");
                main.Dead_All += main.Dead_Week;
                main.Dead_Week = 0;
            } else System.out.println("Brak smierci w tym tygodniu.");

            System.out.println("W tym tygodniu wypito: "+ main.Pints_Week + " kufli piwa w karczmach.");
            main.Pints_All += main.Pints_Week;
            main.Pints_Week = 0;

            System.out.println("---------------------------------------------------------------------------------------------------");

            if (main.Common_Wealth < 5 * (main.Production-main.Dead_All)) {
                System.out.println("Kolonia przertwala: " + week_count + " tygodni.");
                System.out.println("Kolonia nie poradzila sobie z kryzysem ekonomicznym w " + week_count + " tygodniu rozwoju.");
                System.out.println("Krasnoludy jeden po drugim padaja ofiarami smierci glodowej,");
                System.out.println("co prowadzi do zamieszek i calkowitego upadku kolonii");
                break;
            }
            if (main.Technology_Progress >= 5) {
                System.out.println("Kolonia przertwala: " + week_count + " tygodni.");
                System.out.println("Kolonia prosperuje i wszyscy jej mieszkancy wioda zycie na godnym poziomie.");
                System.out.println("Poziom rozwoju technologicznego zapewnia wszystkim bezpieczenstwo");
                System.out.println("i stale zrodla przychodu oraz pozywienia. Pokolenia Krasnoludow ja zamieszkujace");
                System.out.println("beda w stanie przezyc w tym miejscu na wieki.");
                break;
            }
            if (main.Dead_All == main.Production) {
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
            if (main.Common_Wealth >= main.Dwarf_List.stream().filter(x->x.vital==Vital.ALIVE).count() * 360 * 5 * main.Technology_Progress){
                System.out.println("Kolonia przertwala: " + week_count + " tygodni.");
                System.out.println("Dzieki ciezkiej pracy i wielu wyrzeczeniom, skarbce sa przepelnione drogocennymi metalami.");
                System.out.println("Zebrane bogactwo jest gwarancja przetrwania kolonii i jej dalszego rozwoju.");
                System.out.println("Kolonia przertwała: " + week_count + " tygodni.");
                break;
            }
        }
    }
}
