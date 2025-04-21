public class FireFilter implements FilterStrategy {
    @Override
    public boolean matches(DataModel dataModel) {
        return dataModel.getPrimaryType().equalsIgnoreCase("fire") ||
                dataModel.getSecondaryType().equalsIgnoreCase("fire");
    }
}
