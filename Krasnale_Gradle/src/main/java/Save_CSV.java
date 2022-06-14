public class Save_CSV {

    public static void SaveStats(String Time){
        CSV_Writer writer = new CSV_Writer("output.csv");
        writer.saveSimulationData(new String[] {Time});
        writer.saveSimulationData(new String[] {"Name " , "Age " , "Beard_Length " , "Beer " , "Sex " , "Status " , "Vital "});
        for (Dwarf dwarf:main.Dwarf_List) {
            writer.saveSimulationData(dwarf.print());
        }
    }
}
