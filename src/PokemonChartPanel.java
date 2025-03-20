import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.SpiderWebPlot;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.plot.SpiderWebPlot;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PokemonChartPanel extends JPanel {  // Updated class name
    private JFreeChart chart;

    public PokemonChartPanel(List<DataModel> dataItems) {
        setLayout(new BorderLayout());

        // Calculate average stats
        int totalHp = 0, totalAttack = 0, totalDefense = 0, totalSAttack = 0, totalSDefense = 0, totalSpeed = 0;
        for (DataModel item : dataItems) {
            totalHp += item.getHp();
            totalAttack += item.getAttack();
            totalDefense += item.getDefense();
            totalSAttack += item.getS_attack();
            totalSDefense += item.getS_defense();
            totalSpeed += item.getSpeed();
        }

        int size = dataItems.size();
        double avgHp = size > 0 ? (double) totalHp / size : 0;
        double avgAttack = size > 0 ? (double) totalAttack / size : 0;
        double avgDefense = size > 0 ? (double) totalDefense / size : 0;
        double avgSAttack = size > 0 ? (double) totalSAttack / size : 0;
        double avgSDefense = size > 0 ? (double) totalSDefense / size : 0;
        double avgSpeed = size > 0 ? (double) totalSpeed / size : 0;

        // Create dataset for the Radar Chart (Average stats)
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(avgHp, "Avg Stats", "HP");
        dataset.addValue(avgAttack, "Avg Stats", "Attack");
        dataset.addValue(avgDefense, "Avg Stats", "Defense");
        dataset.addValue(avgSAttack, "Avg Stats", "Special Attack");
        dataset.addValue(avgSDefense, "Avg Stats", "Special Defense");
        dataset.addValue(avgSpeed, "Avg Stats", "Speed");

        // Create a chart using SpiderWebPlot (Radar Chart)
        chart = new JFreeChart(
                "Average Pokémon Stats",  // Chart title
                JFreeChart.DEFAULT_TITLE_FONT,
                new SpiderWebPlot(dataset),  // Use SpiderWebPlot for radar chart
                false  // No legend
        );

        // Customize the SpiderWebPlot
        SpiderWebPlot plot = (SpiderWebPlot) chart.getPlot();
        plot.setWebFilled(true);

        // Add the chart to the panel
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(600, 400));  // Set the size of the radar chart
        add(chartPanel, BorderLayout.CENTER);  // Add the chart to the panel
    }
}



