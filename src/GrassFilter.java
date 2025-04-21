public class GrassFilter implements FilterStrategy {
    @Override
    public boolean matches(DataModel dataModel) {
        return dataModel.getPrimaryType().equalsIgnoreCase("grass") ||
                dataModel.getSecondaryType().equalsIgnoreCase("grass");
    }
}
