// Decorator Pattern

public class AdvancedCourseDecorator extends CourseDecorator {
    public AdvancedCourseDecorator(Course decoratedCourse) {
        super(decoratedCourse);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Advanced Features";
    }

    @Override
    public double getCost() {
        return super.getCost() + 50.0;
    }
}