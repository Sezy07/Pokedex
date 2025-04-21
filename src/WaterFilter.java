public class WaterFilter implements FilterStrategy {
    @Override
    public boolean matches(DataModel dataModel) {
        return dataModel.getPrimaryType().equalsIgnoreCase("water") ||
                dataModel.getSecondaryType().equalsIgnoreCase("water");
    }
}
