public class FinancialForecast {

    // Step 2 & 3: Recursive method to predict future value
    public static double predictValue(double initialValue, double growthRate, int years) {
        // Base Case: If 0 years are left, stop and return the current value
        if (years == 0) {
            return initialValue;
        }
        
        // Recursive Step: Calculate next year's value
        double nextYearValue = initialValue * (1 + growthRate);
        
        // Call the method again for the remaining years
        return predictValue(nextYearValue, growthRate, years - 1);
    }

    public static void main(String[] args) {
        double startingRevenue = 10000.0;
        double annualGrowthRate = 0.05; // 5% growth based on past data
        int forecastYears = 5;

        double futureValue = predictValue(startingRevenue, annualGrowthRate, forecastYears);
        System.out.printf("Predicted value in %d years: $%.2f%n", forecastYears, futureValue);
    }
}