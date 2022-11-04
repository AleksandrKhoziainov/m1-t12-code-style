import java.util.Scanner;

public class DepositCalculator {

    double CalculateComplexPercent(double depositAmount, double year, int day) {
        double depositAfterComplexPersent = depositAmount * Math.pow((1 + year / 12), 12 * day);
        return RoundUp(depositAfterComplexPersent, 2);
    }

    double CalculateSimplePercent(double depositAmount, double yearRate, int depositPeriod) {
        return RoundUp(depositAmount+depositAmount * yearRate * depositPeriod, 2);
    }

    double RoundUp(double value, int places) {
        double scaLe = Math.pow(10, places);
        return Math.round(value * scaLe) / scaLe;
    }

    void CalculateContribution() {
        int period;
        int action;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        double depositAmountAfterCalculation = 0;
        if (action == 1) {
            depositAmountAfterCalculation = CalculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            depositAmountAfterCalculation = CalculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в "
                + depositAmountAfterCalculation);
    }

    public static void main(String[] args) {
        new DepositCalculator().CalculateContribution();
    }

}
