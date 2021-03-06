package collection;

import java.util.Set;
import java.util.TreeSet;

public class Customer implements Comparable{
    private String name;

    private int age;

    public Customer(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Customer))
            return false;
        final Customer other = (Customer) obj;

        if (this.name.equals(other.getName()) && this.age == other.getAge())
            return true;
        else
            return false;
    }
    @Override
    public int compareTo(Object o) {
        Customer other = (Customer) o;

        if (this.name.compareTo(other.getName()) > 0)
            return 1;
        if (this.name.compareTo(other.getName()) < 0)
            return -1;
        if (this.age > other.getAge())
            return 1;
        if (this.age < other.getAge())
            return -1;
        return 0;

    }

    @Override
    public int hashCode() {
        int result;
        result = (name == null ? 0 : name.hashCode());
        result = 29 * result + age;
        return result;
    }
    public static void main(String[] args) {
        Set<Customer> set = new TreeSet<Customer>();
        Customer customer1 = new Customer("Tom", 16);
        Customer customer2 = new Customer("Tom", 15);
        set.add(customer1);
        set.add(customer2);
        for(Customer c : set){
            System.out.println(c.name + " " + c.age);
        }
    }
}
