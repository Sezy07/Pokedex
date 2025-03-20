import javax.swing.*;
import java.awt.*;
import java.util.List;

public class StatsPanel extends JPanel {
    private JLabel avgHpLabel;
    private JLabel avgAttackLabel;
    private JLabel avgDefenseLabel;
    private JLabel avgSpeedLabel;       // New label for average Speed
    private JLabel avgSAttackLabel;     // New label for average Special Attack

    public StatsPanel(List<DataModel> dataItems) {
        setLayout(new GridLayout(5, 1, 5, 5));  // Increased rows to 5 for the extra stats

        avgHpLabel = new JLabel("Average HP: ");
        avgAttackLabel = new JLabel("Average Attack: ");
        avgDefenseLabel = new JLabel("Average Defense: ");
        avgSpeedLabel = new JLabel("Average Speed: ");  // Initialize new label
        avgSAttackLabel = new JLabel("Average Special Attack: ");  // Initialize new label

        avgHpLabel.setFont(new Font("Arial", Font.PLAIN, 12));  // Smaller font size
        avgAttackLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        avgDefenseLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        avgSpeedLabel.setFont(new Font("Arial", Font.PLAIN, 12));  // Smaller font size
        avgSAttackLabel.setFont(new Font("Arial", Font.PLAIN, 12));  // Smaller font size

        add(avgHpLabel);
        add(avgAttackLabel);
        add(avgDefenseLabel);
        add(avgSpeedLabel);  // Add new label to panel
        add(avgSAttackLabel);  // Add new label to panel

        updateStats(dataItems);
    }

    public void updateStats(List<DataModel> dataItems) {
        int totalHp = 0, totalAttack = 0, totalDefense = 0, totalSpeed = 0, totalSAttack = 0;
        for (DataModel item : dataItems) {
            totalHp += item.getHp();
            totalAttack += item.getAttack();
            totalDefense += item.getDefense();
            totalSpeed += item.getSpeed();
            totalSAttack += item.getS_attack();
        }

        int size = dataItems.size();
        avgHpLabel.setText("Average HP: " + (size > 0 ? totalHp / size : 0));
        avgAttackLabel.setText("Average Attack: " + (size > 0 ? totalAttack / size : 0));
        avgDefenseLabel.setText("Average Defense: " + (size > 0 ? totalDefense / size : 0));
        avgSpeedLabel.setText("Average Speed: " + (size > 0 ? totalSpeed / size : 0));
        avgSAttackLabel.setText("Average Special Attack: " + (size > 0 ? totalSAttack / size : 0));
    }
}


