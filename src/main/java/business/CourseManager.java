package business;

import core.logging.Logger;
import dataAccess.CourseDao;
import entities.Course;

import java.util.List;

public class CourseManager {
    private CourseDao courseDao;
    private Logger[] loggers;
    private List<Course> courses;

    public CourseManager(CourseDao courseDao, Logger[] loggers, List<Course> courses) {
        this.courseDao = courseDao;
        this.loggers = loggers;
        this.courses = courses;
    }

    public void add(Course course)  {
        for (Course c : courses) {
            if (c.getName()==(course.getName())) {
                System.out.println("Kurs ismi tekrar edemez");;
            }
        }
        if (course.getPrice() < 0) {
            System.out.println("Kurs fiyatı 0'dan küçük olamaz");
        }


        courseDao.add(course);

        for (Logger l : loggers) {
            l.log(course.getName());
        }

    }
}
