package interfaces.defaults;

public class CompanyEmployee implements Company, Employee{
    private String first;
    private String last;

    @Override
    public String getFirst() {
         return first;
    }

    @Override
    public String getLast() {
        return last;
    }

    @Override
    public void doWork() {

    }

    @Override
    public String getName() {
        return String.format("%s working for %s", Employee.super.getName(), Company.super.getName());
    }
}
