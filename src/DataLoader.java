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

            // Ensure that we have enough fields (you can adjust based on your CSV)
            if (fields.length < 11) {
                continue;
            }

            // Parse the fields to try and get the types (WIP, only can read one as of now)
            int id = parseInteger(fields[0].replace("\"", "").trim());  // ID field
            String name = fields[1].replace("\"", "").trim();  // Name field
            int height = parseInteger(fields[2].replace("\"", "").trim());
            int weight = parseInteger(fields[3].replace("\"", "").trim());
            int hp = parseInteger(fields[4].replace("\"", "").trim());
            int attack = parseInteger(fields[5].replace("\"", "").trim());
            int defense = parseInteger(fields[6].replace("\"", "").trim());
            int s_attack = parseInteger(fields[7].replace("\"", "").trim());
            int s_defense = parseInteger(fields[8].replace("\"", "").trim());
            int speed = parseInteger(fields[9].replace("\"", "").trim());
            String type = fields[10].replace("\"", "").replace("{", "").replace("}", "").trim();  // Clean up the 'type' field
            int evo_set = parseInteger(fields[11].replace("\"", "").trim());

            // Create a new DataModel object and add it to the list
            dataItems.add(new DataModel(id, name, height, weight, hp, attack, defense, s_attack, s_defense, speed, type, evo_set));
        }
        reader.close();
        return dataItems;
    }

    // Helper method to safely parse integers, handling invalid input
    private int parseInteger(String value) {
        try {
            // Attempt to parse the value into an integer
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            // If parsing fails, return a default value (e.g., 0)
            System.out.println("Invalid number format for value: '" + value + "', using default value 0.");
            return 0;  // Return a default value in case of error
        }
    }

    // Method to print the details of an item at a specific index
    public void printItemDetails(List<DataModel> dataItems, int index) {
        if (index < dataItems.size()) {
            System.out.println("Item at index " + index + ": " + dataItems.get(index).toString());
        } else {
            System.out.println("Index out of bounds.");
        }
    }

    // Method to print the total number of entries
    public void printTotalEntries(List<DataModel> dataItems) {
        System.out.println("Total number of entries: " + dataItems.size());
    }
}

