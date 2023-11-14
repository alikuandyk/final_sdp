import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Singleton Pattern: Creating an instance of the CourseManager
        CourseManager courseManager = CourseManager.getInstance();

        // Strategy Pattern: Allowing the user to choose a payment strategy
        System.out.println("Select payment strategy: (1) Credit Card, (2) PayPal");
        int paymentOption = scanner.nextInt();

        PaymentStrategy paymentStrategy;
        if (paymentOption == 1) {
            System.out.print("Enter Credit Card Number: ");
            String cardNumber = scanner.next();
            System.out.print("Enter Expiration Date: ");
            String expirationDate = scanner.next();
            paymentStrategy = new CreditCardPayment(cardNumber, expirationDate);
        } else if (paymentOption == 2) {
            System.out.print("Enter PayPal Email: ");
            String email = scanner.next();
            paymentStrategy = new PayPalPayment(email);
        } else {
            System.out.println("Invalid payment option. Exiting...");
            return;
        }

        // Decorator Pattern: Decorating the course with advanced features
        System.out.println("Do you want to add advanced features to the course? (y/n)");
        String addAdvancedFeatures = scanner.next().toLowerCase();
        Course basicCourse = new BasicCourse();
        Course decoratedCourse;
        if (addAdvancedFeatures.equals("y")) {
            decoratedCourse = new AdvancedCourseDecorator(basicCourse);
        } else {
            decoratedCourse = basicCourse;
        }

        // Adapter Pattern: Adapting the LearningManagementSystem to OnlineLearningSystem
        LearningManagementSystem lms = new LearningManagementSystemImpl(); // Assume this implementation exists
        OnlineLearningSystem onlineLearningSystem = new LearningManagementSystemAdapter(lms);

        // Observer Pattern: Observing course updates
        CourseSubject courseSubject = new CourseSubject();
        courseSubject.addObserver(new StudentObserver("Student1"));
        courseSubject.addObserver(new StudentObserver("Student2"));

        // Factory Pattern: Creating courses using the OnlineCourseFactory
        CourseFactory courseFactory = new OnlineCourseFactory();
        System.out.println("Select course type: (1) Basic, (2) Advanced");
        int courseType = scanner.nextInt();
        Course selectedCourse = courseFactory.createCourse((courseType == 1) ? "basic" : "advanced");

        // Use the patterns here
        System.out.println("Welcome to the Online Learning Management System!");
        System.out.println("Course Description: " + decoratedCourse.getDescription());
        System.out.println("Course Cost: $" + decoratedCourse.getCost());
        onlineLearningSystem.accessCourse("Java101"); // Assuming a course ID is provided

        // Notify observers about course updates
        courseSubject.notifyObservers("New content added to the course!");

        // Pay for the selected course using the chosen payment strategy
        System.out.println("Total Cost: $" + selectedCourse.getCost());
        paymentStrategy.pay(selectedCourse.getCost());

        // Close the scanner
        scanner.close();
    }
}

