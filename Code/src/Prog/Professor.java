package Prog;

import java.util.List;

public class Professor extends Person {

    private int age;

    public Professor() {
    }

    public void teach() {
        if ( disciplines == null ) {
            System.out.println( "No Disciplines by professor " + name );
        } else {
            System.out.println( "Disciplines by professor " + name + ":");
            for (Discipline discipline : disciplines ) {
                System.out.println(discipline.getName());
            }
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
