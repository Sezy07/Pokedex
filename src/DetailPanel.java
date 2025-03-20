import javax.swing.*;
import java.awt.*;

public class DetailPanel extends JPanel {
    private JTextArea detailsTextArea;

    public DetailPanel() {
        setLayout(new BorderLayout());

        detailsTextArea = new JTextArea();
        detailsTextArea.setEditable(false);
        detailsTextArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(detailsTextArea);

        add(scrollPane, BorderLayout.CENTER);
    }

    public void updateDetails(DataModel item) {
        String details = "ID: " + item.getId() + "\n"
                + "Name: " + item.getName() + "\n"
                + "Height: " + item.getHeight() + "\n"
                + "Weight: " + item.getWeight() + "\n"
                + "HP: " + item.getHp() + "\n"
                + "Attack: " + item.getAttack() + "\n"
                + "Defense: " + item.getDefense() + "\n"
                + "Special Attack: " + item.getS_attack() + "\n"
                + "Special Defense: " + item.getS_defense() + "\n"
                + "Speed: " + item.getSpeed() + "\n"
                + "Primary Type: " + item.getPrimaryType() + "\n"  // Display Primary Type
                + "Secondary Type: " + (item.getSecondaryType().isEmpty() ? "None" : item.getSecondaryType()) + "\n"  // Display Secondary Type if available
                + "Evo Set: " + item.getEvo_set();

        detailsTextArea.setText(details);
    }
}


