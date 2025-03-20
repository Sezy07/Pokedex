import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class MainApp extends JFrame {

    public MainApp(List<DataModel> dataItems) {
        setTitle("Data Visualization Tool");
        setSize(1000, 600);  // Adjust the size for the larger chart
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create instances of the panels
        TablePanel tablePanel = new TablePanel(dataItems);
        DetailPanel detailPanel = new DetailPanel();
        StatsPanel statsPanel = new StatsPanel(dataItems);
        PokemonChartPanel chartPanel = new PokemonChartPanel(dataItems);  // Use Radar Chart Panel

        // Create the split pane to display the table and detail panel
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, tablePanel, detailPanel);
        splitPane.setDividerLocation(600);  // Adjust the divider to make the table wider

        // Create another split pane to add the stats panel below the table and detail
        JSplitPane mainSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, splitPane, statsPanel);
        mainSplitPane.setDividerLocation(450);  // Adjust the position of the main split
        add(mainSplitPane, BorderLayout.CENTER);

        // Add the radar chart panel at the bottom of the window
        add(chartPanel, BorderLayout.SOUTH);

        // Add a selection listener for the table
        tablePanel.getTable().getSelectionModel().addListSelectionListener(e -> {
            int selectedRow = tablePanel.getTable().getSelectedRow();
            if (selectedRow >= 0) {
                // Update the detail panel when a row is selected
                DataModel selectedItem = dataItems.get(selectedRow);
                detailPanel.updateDetails(selectedItem);
            }
        });

        setVisible(true);  // Make the frame visible
    }

    public static void main(String[] args) {
        try {
            // Load the data from the CSV file
            DataLoader dataLoader = new DataLoader();
            List<DataModel> dataItems = dataLoader.loadDataFromFile("pokedex.csv");  // Adjust the file name as needed

            // Launch the GUI with the loaded data
            new MainApp(dataItems);

        } catch (IOException e) {
            System.err.println("Error loading data: " + e.getMessage());
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to load data from the file. Please check the file and try again.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}


