// Singleton Pattern

public class CourseManager {
    private static CourseManager instance;

    private CourseManager() {
        // private constructor to prevent instantiation
    }

    public static CourseManager getInstance() {
        if (instance == null) {
            instance = new CourseManager();
        }
        return instance;
    }
}
