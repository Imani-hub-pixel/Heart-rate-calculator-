import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

class HeartRates {
    private String firstName;
    private String lastName;
    private int birthYear;
    private int birthMonth;
    private int birthDay;

    // Constructor
    public HeartRates(String firstName, String lastName, int birthYear, int birthMonth, int birthDay) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.birthMonth = birthMonth;
        this.birthDay = birthDay;
    }

    // Getters and Setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public int getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(int birthMonth) {
        this.birthMonth = birthMonth;
    }

    public int getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(int birthDay) {
        this.birthDay = birthDay;
    }

    // Method to calculate age using Period.between()
    public int getAge() {
        return calculateAge(birthYear, birthMonth, birthDay);
    }

    // Method to calculate maximum heart rate
    public int getMaxHeartRate() {
        return 220 - getAge();
    }

    // Method to calculate target heart rate range (50-85% of max heart rate)
    public String getTargetHeartRateRange() {
        int maxHeartRate = getMaxHeartRate();
        double lowerBound = maxHeartRate * 0.50;
        double upperBound = maxHeartRate * 0.85;
        return String.format("%.2f - %.2f bpm", lowerBound, upperBound);
    }

    // Static method to calculate age using LocalDate and Period
    public static int calculateAge(int birthYear, int birthMonth, int birthDay) {
        if (birthYear > 0 && birthMonth > 0 && birthDay > 0) {
            LocalDate birthDate = LocalDate.of(birthYear, birthMonth, birthDay);
            LocalDate currentDate = LocalDate.now(); // Automatically gets the current date
            return Period.between(birthDate, currentDate).getYears();
        } else {
            return 0; // If invalid inputs are given
        }
    }
}

public class HeartRateCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter birth year: ");
        int birthYear = scanner.nextInt();

        System.out.print("Enter birth month: ");
        int birthMonth = scanner.nextInt();

        System.out.print("Enter birth day: ");
        int birthDay = scanner.nextInt();

        // Create HeartRates object
        HeartRates person = new HeartRates(firstName, lastName, birthYear, birthMonth, birthDay);

        // Display results
        System.out.println("\n--- Heart Rate Information ---");
        System.out.println("Name: " + person.getFirstName() + " " + person.getLastName());
        System.out.println("Age: " + person.getAge() + " years"); // Uses Period.between()
        System.out.println("Maximum Heart Rate: " + person.getMaxHeartRate() + " bpm");
        System.out.println("Target Heart Rate Range: " + person.getTargetHeartRateRange());

        scanner.close();
    }
}
    
  
    
  

