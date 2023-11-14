// Adapter Pattern

public class LearningManagementSystemAdapter implements OnlineLearningSystem {
    private LearningManagementSystem lms;

    public LearningManagementSystemAdapter(LearningManagementSystem lms) {
        this.lms = lms;
    }

    @Override
    public void accessCourse(String courseId) {
        // Adapter logic to access course in the desired format
        lms.openCourse(courseId);
    }
}