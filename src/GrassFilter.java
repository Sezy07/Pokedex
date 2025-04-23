public class GrassFilter implements FilterStrategy {
    @Override
    public boolean matches(DataModel dataModel) {
        // Filters DataModel objects to match if their type is "grass"
        return dataModel.getPrimaryType().equalsIgnoreCase("grass") ||
                dataModel.getSecondaryType().equalsIgnoreCase("grass");
    }
}
