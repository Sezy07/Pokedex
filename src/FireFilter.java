public class FireFilter implements FilterStrategy {
    @Override
    public boolean matches(DataModel dataModel) {
        // Filters DataModel objects to match if their type is "fire"
        return dataModel.getPrimaryType().equalsIgnoreCase("fire") ||
                dataModel.getSecondaryType().equalsIgnoreCase("fire");
    }
}
