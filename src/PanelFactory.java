import javax.swing.*;
import java.util.List;

public class PanelFactory {
    public static JPanel createPanel(String panelType, List<DataModel> dataItems) {
        return switch (panelType.toLowerCase()) {
            case "table" -> new TablePanel(dataItems);
            case "detail" -> new DetailPanel();
            case "stats" -> new StatsPanel(dataItems);
            case "chart" -> new PokemonChartPanel(dataItems);
            default -> throw new IllegalArgumentException("Unknown panel type: " + panelType);
        };
    }
}

