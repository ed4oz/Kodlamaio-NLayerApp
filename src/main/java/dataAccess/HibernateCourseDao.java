package dataAccess;

import entities.Course;

public class HibernateCourseDao implements CourseDao{
    @Override
    public void add(Course course) {
        System.out.println("Kurs hibernate ile veritabanına eklendi: " + course.getName());
    }
}