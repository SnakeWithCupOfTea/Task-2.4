package Prog;

import java.util.List;

public class Student extends Person {

    private int source;

    public Student() {
    }

    public void learn() {
        if ( disciplines == null ) {
            System.out.println( "No Disciplines for student " + name );
        } else {
            System.out.println( "Disciplines for student " + name + ":");
            for (Discipline discipline : disciplines ) {
                System.out.println(discipline.getName());
            }
        }
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

}

