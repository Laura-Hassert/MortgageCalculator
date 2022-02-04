package com.codewithmosh;

public class MortgageCalculator {
    private final static int PERCENT = 100;
    private final static int MONTHS_IN_YEAR = 12;

    private int principal;
    private float annualInterest;
    private byte years;

    public MortgageCalculator(int principal, float annualInterest, byte years) {
        this.principal = principal;
        this.annualInterest = annualInterest;
        this.years = years;
    }

    public double calculateMortgage() {
        short numberOfPayments = getNumberOfPayments();
        float monthlyInterest = getMonthlyInterest();

        return principal *
                (((Math.pow((1 + monthlyInterest), numberOfPayments)) * monthlyInterest)
                        / ((Math.pow((1 + monthlyInterest), numberOfPayments)) - 1));
    }

    public double calculateBalance(short numberOfPaymentsMade) {
        short numberOfPayments = getNumberOfPayments();
        float monthlyInterest = getMonthlyInterest();

        return principal * (Math.pow((1 + monthlyInterest), numberOfPayments) - Math.pow((1 + monthlyInterest), numberOfPaymentsMade))
                / (Math.pow((1 + monthlyInterest), numberOfPayments) - 1);
    }

    public double[] getRemainingBalances() {
        var balances = new double[getNumberOfPayments()];
        for (short month = 1; month <= balances.length; month++)
            balances[month - 1] = calculateBalance(month);
        return balances;
    }

    private short getNumberOfPayments() {
        return (short) (years * MONTHS_IN_YEAR);
    }

    private float getMonthlyInterest() {
        return annualInterest / PERCENT / MONTHS_IN_YEAR;
    }
}
