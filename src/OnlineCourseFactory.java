// Factory Pattern

public class OnlineCourseFactory implements CourseFactory {
    @Override
    public Course createCourse(String type) {
        if ("basic".equalsIgnoreCase(type)) {
            return new BasicCourse();
        } else if ("advanced".equalsIgnoreCase(type)) {
            return new AdvancedCourseDecorator(new BasicCourse());
        }
        return null;
    }
}
