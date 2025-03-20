import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.util.*;
import java.util.List;

public class TablePanel extends JPanel {
    private JTable table;
    private DefaultTableModel model;
    private List<DataModel> originalData;
    private List<DataModel> filteredData;
    private TableRowSorter<DefaultTableModel> sorter;

    public TablePanel(List<DataModel> dataItems) {
        setLayout(new BorderLayout());

        // Store the original data and create a filtered copy for display
        this.originalData = dataItems;
        this.filteredData = new ArrayList<>(dataItems);

        // Define columns for the table, including units for height and weight
        String[] columns = {
                "ID", "Name", "Height (dm)", "Weight (hg)", "HP", "Attack", "Defense", "Special Attack",
                "Special Defense", "Speed", "Primary Type", "Secondary Type", "Evo Set"
        };

        // Create the table model with the columns
        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);
        updateTableData(filteredData);

        // Enable column sorting by default (JTable handles this automatically)
        table.setAutoCreateRowSorter(true);
        sorter = new TableRowSorter<>(model);
        table.setRowSorter(sorter);

        // Explicit comparators for numeric sorting
        sorter.setComparator(0, Comparator.comparingInt(o -> Integer.parseInt(o.toString()))); // ID
        sorter.setComparator(2, Comparator.comparingInt(o -> Integer.parseInt(o.toString()))); // Height
        sorter.setComparator(3, Comparator.comparingInt(o -> Integer.parseInt(o.toString()))); // Weight
        sorter.setComparator(4, Comparator.comparingInt(o -> Integer.parseInt(o.toString()))); // HP
        sorter.setComparator(5, Comparator.comparingInt(o -> Integer.parseInt(o.toString()))); // Attack
        sorter.setComparator(6, Comparator.comparingInt(o -> Integer.parseInt(o.toString()))); // Defense
        sorter.setComparator(7, Comparator.comparingInt(o -> Integer.parseInt(o.toString()))); // Special Attack
        sorter.setComparator(8, Comparator.comparingInt(o -> Integer.parseInt(o.toString()))); // Special Defense
        sorter.setComparator(9, Comparator.comparingInt(o -> Integer.parseInt(o.toString()))); // Speed
        sorter.setComparator(12, Comparator.comparingInt(o -> Integer.parseInt(o.toString()))); // Evo Set

        // Adjust column widths
        TableColumn nameColumn = table.getColumnModel().getColumn(1);
        nameColumn.setPreferredWidth(150);
        TableColumn primaryTypeColumn = table.getColumnModel().getColumn(10);
        primaryTypeColumn.setPreferredWidth(120);
        TableColumn secondaryTypeColumn = table.getColumnModel().getColumn(11);
        secondaryTypeColumn.setPreferredWidth(120);

        // Add the table to a scroll pane
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Create a panel for the filter controls (checkboxes)
        JPanel filterPanel = new JPanel(new FlowLayout());
        JCheckBox grassFilter = new JCheckBox("Grass Type");
        JCheckBox fireFilter = new JCheckBox("Fire Type");
        JCheckBox waterFilter = new JCheckBox("Water Type");

        // Add filters to the panel
        filterPanel.add(grassFilter);
        filterPanel.add(fireFilter);
        filterPanel.add(waterFilter);

        // Add action listeners for the filters
        grassFilter.addActionListener(e -> applyFilters(grassFilter, fireFilter, waterFilter));
        fireFilter.addActionListener(e -> applyFilters(grassFilter, fireFilter, waterFilter));
        waterFilter.addActionListener(e -> applyFilters(grassFilter, fireFilter, waterFilter));

        // Add the filter panel to the top
        add(filterPanel, BorderLayout.NORTH);
    }

    // Method to update the table data based on the filters
    private void updateTableData(List<DataModel> data) {
        model.setRowCount(0); // Clear the current table data
        for (DataModel item : data) {
            model.addRow(new Object[]{
                    item.getId(),
                    item.getName(),
                    item.getHeight(),
                    item.getWeight(),
                    item.getHp(),
                    item.getAttack(),
                    item.getDefense(),
                    item.getS_attack(),
                    item.getS_defense(),
                    item.getSpeed(),
                    item.getPrimaryType(),
                    item.getSecondaryType().isEmpty() ? "" : item.getSecondaryType(),
                    item.getEvo_set()
            });
        }
        table.repaint(); // Force UI to refresh
        table.revalidate(); // Ensure updates are reflected
    }

    // Method to apply filters
    private void applyFilters(JCheckBox grassFilter, JCheckBox fireFilter, JCheckBox waterFilter) {
        filteredData = new ArrayList<>();
        boolean noFiltersSelected = !grassFilter.isSelected() && !fireFilter.isSelected() && !waterFilter.isSelected();

        // Iterate over original data and apply filters
        for (DataModel item : originalData) {
            String primaryType = item.getPrimaryType().trim().toLowerCase();
            String secondaryType = item.getSecondaryType().trim().toLowerCase();

            boolean matchesGrass = grassFilter.isSelected() && (primaryType.equals("grass") || secondaryType.equals("grass"));
            boolean matchesFire = fireFilter.isSelected() && (primaryType.equals("fire") || secondaryType.equals("fire"));
            boolean matchesWater = waterFilter.isSelected() && (primaryType.equals("water") || secondaryType.equals("water"));

            // If no filters are selected, show all data
            if (noFiltersSelected || matchesGrass || matchesFire || matchesWater) {
                filteredData.add(item);
            }
        }

        // Update the table with the filtered data
        updateTableData(filteredData);
    }

    // Add the getTable() method to allow access to the JTable
    public JTable getTable() {
        return table;
    }
}