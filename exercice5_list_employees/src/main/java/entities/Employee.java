package entities;

public class Employee {
    private Integer id;
    private String name;
    private Double salary;

    public Employee(Integer id, String nome, Double salary) {
        this.id = id;
        this.name = nome;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return name;
    }

    public void setNome(String nome) {
        this.name = nome;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double percentage) {
        this.salary = salary*(1+percentage/100);
    }

    @Override
    public String toString() {
        return  id + ", " + name + ", " + String.format("%.2f",salary);
    }
}
