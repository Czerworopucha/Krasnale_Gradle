public class Save_CSV {

    public static void SaveStats(String Time, CSV_Writer writer){
        writer.saveSimulationData(new String[] {Time});
        writer.saveSimulationData(new String[] {"Profession" ,"Name " , "Age " , "Beard_Length " , "Beer " , "Sex " , "Status " , "Vital "});
        for (Dwarf dwarf:main.Dwarf_List) {
            writer.saveSimulationData(dwarf.print());
        }
    }
    public static void FlushCSV(CSV_Writer writer){
        writer.flushCSVFile();
    }
}
