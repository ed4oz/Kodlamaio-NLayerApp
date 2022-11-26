import business.CategoryManager;
import business.CourseManager;
import business.InstructorManager;
import core.logging.DatabaseLogger;
import core.logging.FileLogger;
import core.logging.Logger;
import core.logging.MailLogger;
import dataAccess.HibernateInstructorDao;
import dataAccess.JdbcCategoryDao;
import dataAccess.JdbcCourseDao;
import entities.Category;
import entities.Course;
import entities.Instructor;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Logger[] loggers = {new FileLogger(), new DatabaseLogger(), new MailLogger()};

        Instructor instructor1 = new Instructor(1, " Engin", "DEMIROG");

        InstructorManager instructorManager = new InstructorManager(new HibernateInstructorDao(), loggers);

        System.out.println("EGITMEN\n");
        instructorManager.add(instructor1);

        Category category = new Category(1, " YAZILIM");

        List<Category> categories = new ArrayList<>();

        CategoryManager categoryManager = new CategoryManager(new JdbcCategoryDao(), categories, loggers);

        System.out.println("KATEGORI\n");
        categoryManager.add(category);


        Course course = new Course(1, "Java", 10.000, instructor1, category, "Yazılım");

        List<Course> courses = new ArrayList<>();

        CourseManager courseManager = new CourseManager(new JdbcCourseDao(), loggers, courses);

        Course course1 = new Course(2, "Java", -1, instructor1, category, "Yazılım");

        System.out.println("KURS\n");
        courseManager.add(course);
        courses.add(course);
        courseManager.add(course1);

    }


}

