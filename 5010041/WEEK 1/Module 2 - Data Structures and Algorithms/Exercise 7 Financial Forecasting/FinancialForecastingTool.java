public class FinancialForecastingTool {

    // Recursive method to calculate future value
    public static double calculateFutureValue(double presentValue, double growthRate, int years) {
        // Base case: no more years to predict
        if (years == 0) {
            return presentValue;
        }
        // Recursive case: calculate the future value for the next year
        return calculateFutureValue(presentValue * (1 + growthRate), growthRate, years - 1);
    }

    // Iterative method to calculate future value
    public static double calculateFutureValueIterative(double presentValue, double growthRate, int years) {
        double futureValue = presentValue;
        for (int i = 0; i < years; i++) {
            futureValue *= (1 + growthRate);
        }
        return futureValue;
    }

    public static void main(String[] args) {
        double presentValue = 10000; // Initial amount
        double annualGrowthRate = 0.05; // 5% growth rate
        int years = 5; // Number of years to predict

        double futureValue = calculateFutureValue(presentValue, annualGrowthRate, years);
        System.out.println("Future Value after " + years + " years (Recursive): $" + futureValue);

        double futureValueIterative = calculateFutureValueIterative(presentValue, annualGrowthRate, years);
        System.out.println("Future Value after " + years + " years (Iterative): $" + futureValueIterative);
    }
}
