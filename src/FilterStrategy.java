public interface FilterStrategy {
    // Checks if the given DataModel matches the filtering criteria
    boolean matches(DataModel dataModel);
}

