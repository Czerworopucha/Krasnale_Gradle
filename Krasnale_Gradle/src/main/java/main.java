import java.util.ArrayList;

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

    private static void Initialization() {
        Dwarf_List = Dwarf_Factory.Dwarf_Generator(Production);
    }

    public static void main(String[] args) {

        CSV_Writer writer = new CSV_Writer("output.csv");

        Save_CSV.FlushCSV(writer);
        Stats.Starting_Stats();
        Initialization();
        Stats.WriteStats();
        Save_CSV.SaveStats("STARTING_STATS", writer);
        Update.Week_Update(Max_Loops);
        Stats.WriteStats();
        Save_CSV.SaveStats("ENDING_STATS", writer);
    }
}