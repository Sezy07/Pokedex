public class WaterFilter implements FilterStrategy {
    @Override
    public boolean matches(DataModel dataModel) {
        // Filters DataModel objects to match if their type is "water"
        return dataModel.getPrimaryType().equalsIgnoreCase("water") ||
                dataModel.getSecondaryType().equalsIgnoreCase("water");
    }
}
