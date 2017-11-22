//Создать классы Студент, Преподаватель, Предмет. Самостоятельно определить
// какие поля будут у этих классов. У студента создать метод learn(…)
// который будет выводить на экран какие предметы изучает выбранный студент.
//у преподавателя создать метод teach(…) который будет выводить какие предметы
// преподает выбранный преподаватель. В главном классе создать 3 студентов,
// 2 преподавателей и 5 предметов. Ввести с клавиатуры имя студента и вывести
// на экран какие предметы он изучает. Ввести с клавиатуры имя преподавателя и
// вывести список дисциплин, которые он преподает

package Prog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Discipline> disciplines = createAllDisciplines();
        List<Professor> professors = createAllProfessors(disciplines);
        List<Student> students = createAllStudents(disciplines);

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Enter studentName");
            String studentName = br.readLine();
            Student studentFromConsole = getStudentByName(studentName, students);
            studentFromConsole.learn();

            System.out.println("Enter professorName");
            String professorName = br.readLine();
            Professor professorFromConsole = getProfessorByName(professorName, professors);
            professorFromConsole.teach();

        } catch ( IOException e){
            e.printStackTrace();
        }
    }

    private static Professor getProfessorByName(String professorName, List<Professor> professors) {
        for ( Professor student : professors ) {
            if ( professorName.equals(student.getName())) {
                return student;
            }
        }
        return null;
    }

    private static Student getStudentByName(String studentName, List<Student> students) {

        for ( Student student : students ) {
            if ( studentName.equals(student.getName())) {
                return student;
            }
        }
        return null;
    }

    private static List<Student> createAllStudents(List<Discipline> disciplines) {
        List<Student> students = new ArrayList<>();

        Student alex = new Student();
        alex.setName("Alex");
        alex.setSource(3);

        List<Discipline> alexDisciplineList = getDisciplinesByNames(
                disciplines,
                Arrays.asList("Math", "Biology")
        );
        alex.setDisciplines(alexDisciplineList);
        students.add(alex);

        //////////////

        Student mary = new Student();
        mary.setName("Mary");
        mary.setSource(1);

        List<Discipline> maryDisciplineList = getDisciplinesByNames(
                disciplines,
                Arrays.asList("Art")
        );
        mary.setDisciplines(maryDisciplineList);
        students.add(mary);

        ////////////////

        Student sam = new Student();
        sam.setName("Sam");
        sam.setSource(6);

        List<Discipline> samDisciplineList = getDisciplinesByNames(
                disciplines,
                Arrays.asList("Math", "Computer science")
        );
        sam.setDisciplines(samDisciplineList);
        students.add(mary);

        ////////////

        return students;
    }

    private static List<Professor> createAllProfessors(List<Discipline> disciplines) {

        List<Professor> professors = new ArrayList<>();

        Professor einstein = new Professor();
        einstein.setName("Eintein");//Albert Eintein
        einstein.setAge(75);

        List<Discipline> einsteinDisciplineList = getDisciplinesByNames(
                disciplines,
                Arrays.asList("Math", "Computer science")
        );
        einstein.setDisciplines(einsteinDisciplineList);
        professors.add(einstein);

        ///////////////

        Professor picasso = new Professor();
        picasso.setName("Picasso");//Pablo Picasso
        picasso.setAge(50);

        List<Discipline> picassoDisciplineList = getDisciplinesByNames(
                disciplines,
                Arrays.asList("Art")
        );
        einstein.setDisciplines(picassoDisciplineList);
        professors.add(picasso);

        ////////////

        return professors;
    }

    private static List<Discipline> getDisciplinesByNames(
            List<Discipline> disciplines,
            List<String> disciplineNames
    ) {
        List<Discipline> resultList = new ArrayList<>();

        for ( Discipline discipline : disciplines ) {
            if ( disciplineNames.contains(discipline.getName() ) ) {
                resultList.add(discipline);
            }
        }
        return resultList;
    }

    private static List<Discipline> createAllDisciplines() {
        List<Discipline> disciplines = new ArrayList<>();

        Discipline math = new Discipline();
        math.setName("Math");
        math.setComplexity(9);
        disciplines.add(math);

        Discipline art = new Discipline();
        art.setName("Art");
        art.setComplexity(8);
        disciplines.add(art);

        Discipline computerScience = new Discipline();
        computerScience.setName("Computer science");
        computerScience.setComplexity(9);
        disciplines.add(computerScience);

        Discipline biology = new Discipline();
        biology.setName("Biology");
        biology.setComplexity(10);
        disciplines.add(biology);

        Discipline chemistry = new Discipline();
        chemistry.setName("Chemistry");
        chemistry.setComplexity(6);
        disciplines.add(chemistry);

        return disciplines;
    }


}
