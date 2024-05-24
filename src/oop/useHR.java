package oop;

public class useHR {
    public static void main(String[] args) {
        HR hr = new HR();

        hr.hire(new Salaried("Fred"));
        hr.hire(new Hourly("Fred"));
        hr.hire(new Salaried());
        hr.hire(new Hourly());
        hr.printEverybody();
        hr.payEverybody();
        hr.sortEmployees();
        hr.printEverybody();
    }
}
