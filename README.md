# Lab 4 - Design Patterns

##### The patterns that I have chosen to implement are the strategy patterns for the filtering and the factory patterns for handling the panels. 

### **Strategy Pattern**
   1. **Purpose:** The main achievement that I hope to complete with this is making it more accessible for adding more filters in the future. The main benefit will be that all you will have to do is create a new class for the filter type, besides having it hard coded into the tablepanel itself.
   2. **Classes Added/Changed and the Implementation of Each:** 
        1. FilterStrategy(Created): This file was created so it could be used as an interface for all of the current and future filters that are inside of the project. 
        2. FireFilter(Created): This takes the code that was from the MainApp and moved inside of their own file, so it could be seperated and more easily changed if needed. 
        3. GrassFilter(Created): Similar to the FireFilter class, but does the same thing for Grass types pokemon. 
        4. Waterfilter(Created): Never would guess, but also similar to the Grass and Fire filters, but this is for Water type pokemon now. 
        5. TablePanel(Modified): Before, there were if statements for each of the types of filters, which is always something you want to avoid when coding. So, now the filtering has moved to their own files and are controlled by a list called strategies inside of the file. Inside of applyFilters(), the class will check if the strategy matches the item chosen, and will then give the data associated to that type. 

                for (FilterStrategy strategy : strategies) {
                    if (strategy.matches(item)) {
                        filteredData.add(item);                    
                        break;
                    }
                }

### **Factory Pattern**
 1. **Purpose:** For the Factory Pattern, the main purpose was to hopefully make it where the object isn't together with the usage of that object. The different panels will then be created based on a string identifier inside of PanelFactory, and not instantiated inside of the TablePanel itself. The plan is to create the factory, and use the main app to call on which ones to make.
    2. **Classes Added/Changed and the Implementation of Each:**
        1. PanelFactory(Created): The PanelFactory class creates the GUI panels(TablePanel, DetailPanel, StatsPanel, and PokemonChartPanel) based on a string word that would then trigger the panels inside of the MainApp to be created dynamically. 
        2. MainApp(Modified): Inside of the main file, each of the files were previously created by doing this:
        
                TablePanel tablePanel = new TablePanel(dataItems);
                DetailPanel detailPanel = new DetailPanel(); 
                StatsPanel statsPanel = new StatsPanel(dataItems);
                PokemonChartPanel chartPanel = new PokemonChartPanel(dataItems); 
            This was the main thing that the factory set out to change, so the contruction if each panel is not manual but created by using a factory. Essentially, now each one calls upon PanelFactory.createPanel() to make these GUIs.
                    
                TablePanel tablePanel = (TablePanel) PanelFactory.createPanel("table", dataItems);
                DetailPanel detailPanel = (DetailPanel) PanelFactory.createPanel("detail", dataItems);                
                StatsPanel statsPanel = (StatsPanel) PanelFactory.createPanel("stats", dataItems);
                PokemonChartPanel chartPanel = (PokemonChartPanel) PanelFactory.createPanel("chart", dataItems);

###### Link to the Repository: https://github.com/Sezy07/Pokedex