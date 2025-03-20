import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.List;

public class TablePanel extends JPanel {
    private JTable table;

    public TablePanel(List<DataModel> dataItems) {
        setLayout(new BorderLayout());

        // Define columns for the table
        String[] columns = {
                "ID", "Name", "Height", "Weight", "HP", "Attack", "Defense", "Special Attack",
                "Special Defense", "Speed", "Primary Type", "Secondary Type", "Evo Set"
        };

        // Create the table model with the columns
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        table = new JTable(model);

        // Populate the table with data from the list of DataModels
        for (DataModel item : dataItems) {
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
                    item.getPrimaryType(),  // Primary Type
                    item.getSecondaryType().isEmpty() ? "" : item.getSecondaryType(),  // Secondary Type (empty if not available)
                    item.getEvo_set()
            });
        }

        // Adjust column widths
        TableColumn nameColumn = table.getColumnModel().getColumn(1);
        nameColumn.setPreferredWidth(150);  // Set a preferred width for the 'Name' column

        TableColumn primaryTypeColumn = table.getColumnModel().getColumn(10);
        primaryTypeColumn.setPreferredWidth(120);  // Adjust width for Primary Type column
        TableColumn secondaryTypeColumn = table.getColumnModel().getColumn(11);
        secondaryTypeColumn.setPreferredWidth(120);  // Adjust width for Secondary Type column

        // Add the table to a scroll pane
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
    }

    // Method to get the table component for future use
    public JTable getTable() {
        return table;
    }
}


