package oop;

import java.time.LocalDate;
import java.util.Objects;

/*TODO implement Comparable in proper way*/
public abstract class Employee implements Comparable {
    public static final String DEFAULT_NAME = "UNKNOWN";
    private static int nextId;

    private Integer id;
    private String name;
    private LocalDate hireDate;


    public Employee(String name) {
        this.id = nextId++;
        this.name = name;
        this.hireDate = LocalDate.now();
    }

    public Employee() {
        this(DEFAULT_NAME);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract double getPay();

    @Override
    public String toString() {
        return String.format("Employee{id=%d, name=%s, hireDate=%s}", id, name, hireDate);
    }

//    @Override
//    public int hashCode() {
//        int result = id != null ? id.hashCode() : 0;
//        result = 31 * result + (name != null ? name.hashCode() : 0);
//        result = 31 * result + (hireDate != null ? hireDate.hashCode() : 0);
//        return result;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return Objects.equals(getId(), employee.getId()) && Objects.equals(getName(), employee.getName()) && Objects.equals(hireDate, employee.hireDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), hireDate);
    }
}

