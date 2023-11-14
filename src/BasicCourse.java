// Decorator Pattern

public class BasicCourse implements Course {
    @Override
    public String getDescription() {
        return "Basic Course";
    }

    @Override
    public double getCost() {
        return 100.0;
    }
}