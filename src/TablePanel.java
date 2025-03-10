import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.List;

public class TablePanel extends JPanel {
    private JTable table;

    public TablePanel(List<DataModel> dataItems) {
        setLayout(new BorderLayout());

        // Define columns for the table, now including 'ID' and 'Name'
        String[] columns = {
                "ID", "Name", "Height", "Weight", "HP", "Attack", "Defense", "Special Attack",
                "Special Defense", "Speed", "Type", "Evo Set"
        };

        // Create the table model with the columns
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        table = new JTable(model);

        // Populate the table with data from the list of DataModels
        for (DataModel item : dataItems) {
            model.addRow(new Object[]{
                    item.getId(),          // ID
                    item.getName(),        // Name
                    item.getHeight(),
                    item.getWeight(),
                    item.getHp(),
                    item.getAttack(),
                    item.getDefense(),
                    item.getS_attack(),
                    item.getS_defense(),
                    item.getSpeed(),
                    item.getType(),
                    item.getEvo_set()
            });
        }

        // Adjust the width of the 'Name' column
        TableColumn nameColumn = table.getColumnModel().getColumn(1);  // Index 1 is for the 'Name' column
        nameColumn.setPreferredWidth(150);  // Set a preferred width for the 'Name' column (you can adjust the value)

        // Add the table to a scroll pane
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
    }

    // Method to get the table component for future use
    public JTable getTable() {
        return table;
    }
}

