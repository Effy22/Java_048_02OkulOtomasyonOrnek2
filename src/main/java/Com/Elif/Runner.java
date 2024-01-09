package Com.Elif;


import Com.Elif.entity.Contact;
import Com.Elif.entity.Lesson;
import Com.Elif.entity.Student;
import Com.Elif.entity.Teacher;
import Com.Elif.repository.LessonRepository;
import Com.Elif.repository.StudentRepository;
import Com.Elif.repository.TeacherRepository;

import java.util.List;

public class Runner {
    public static void main(String[] args) {

        Contact conn1 = Contact.builder()
                .city("Ankara")
                .zipcode("06342")
                .parent("Veli Görgülü")
                .build();


        Teacher teacher1 = Teacher.builder()
                .name("Ayşe")
                .surname("Şaşmaz")
                .build();


        Student student1 = Student.builder()
                .name("Alirıza")
                .surname("Görgülü")
                .build();

        conn1.setStudent(student1);


        Lesson lesson1= Lesson.builder()
                .name("Math")
                .studentList(List.of(student1))
                .build();
        lesson1.setTeacher(teacher1);

        student1.setContact(conn1);
        teacher1.setLesson(lesson1);
        student1.setLessonList(List.of(lesson1));
        new LessonRepository().save(lesson1);
        //TEK KAYIT İSTİYOSAK SIRALAMA BU

    }


}
