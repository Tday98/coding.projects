public abstract class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        setName(name);
        setAge(age);
    }

    public abstract String act();

    private void setName(String name) {
        if (name != null) {
            this.name = name;
        }
    }

    private void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        }
    }

    public String toString() {
        return this.name;
    }
}
