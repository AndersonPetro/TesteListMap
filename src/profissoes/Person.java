package profissoes;

public class Person {
    private String name;
    private SexEnum sex;
    private Professional Professional;

    public Person(String name, SexEnum sex, Professional professional) {
        this.name = name;
        this.sex = sex;
        Professional = professional;
    }

    public String getName() {
        return name;
    }

    public SexEnum getSex() {
        return sex;
    }

    public Professional getProfessional() {
        return Professional;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", Professional=" + Professional +
                '}';
    }
}
    



