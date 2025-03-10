import javax.swing.*;
import java.io.IOException;
import java.util.List;

public class MainApp extends JFrame {
    public MainApp(List<DataModel> dataItems) {
        setTitle("Data Visualization Tool");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the table panel with the loaded data
        TablePanel tablePanel = new TablePanel(dataItems);
        add(tablePanel);

        setVisible(true);
    }

    public static void main(String[] args) throws IOException {
        // Load data from the CSV file
        DataLoader dataLoader = new DataLoader();
        List<DataModel> dataItems = dataLoader.loadDataFromFile("pokedex.csv");  // Changed file name here

        // Print details for testing
        dataLoader.printItemDetails(dataItems, 0);  // First item
        dataLoader.printItemDetails(dataItems, 9);  // Tenth item
        dataLoader.printTotalEntries(dataItems);   // Total entries

        // Launch the GUI with the loaded data
        new MainApp(dataItems);
    }
}

