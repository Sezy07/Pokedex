import java.io.*;
import java.util.*;

public class DataLoader {
    // Method to load data from CSV file
    public List<DataModel> loadDataFromFile(String filename) throws IOException {
        List<DataModel> dataItems = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;

        // Skip the header line (if present)
        reader.readLine();

        // Read each line of the file
        while ((line = reader.readLine()) != null) {
            String[] fields = line.split(",");

            // Ensure that we have enough fields (at least 12 for the stats and types)
            if (fields.length < 12) {
                continue;  // Skip rows that don't have enough columns
            }

            // Parse only the numeric fields
            int id = parseInteger(fields[0].trim());
            String name = fields[1].trim();
            int height = parseInteger(fields[2].trim());
            int weight = parseInteger(fields[3].trim());
            int hp = parseInteger(fields[4].trim());
            int attack = parseInteger(fields[5].trim());
            int defense = parseInteger(fields[6].trim());
            int s_attack = parseInteger(fields[7].trim());
            int s_defense = parseInteger(fields[8].trim());
            int speed = parseInteger(fields[9].trim());

            // Handle the type fields, split into primary and secondary
            String primaryType = fields[10].trim();
            // Check for "N/A" and treat it as an empty string for secondary type
            String secondaryType = fields[11].trim().equals("N/A") ? "" : fields[11].trim();

            // Parse evo_set (evolution set should always be the last field, if present)
            int evo_set = parseInteger(fields[fields.length - 1].trim());

            // Create a new DataModel object and add it to the list
            dataItems.add(new DataModel(id, name, height, weight, hp, attack, defense, s_attack, s_defense, speed, primaryType, secondaryType, evo_set));
        }

        reader.close();
        return dataItems;
    }

    // Helper method to safely parse integers
    private int parseInteger(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return 0;  // Default value if not a valid number
        }
    }
}
