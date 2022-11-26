package dataAccess;

import entities.Instructor;

public class JdbcInstructorDao implements InstructorDao{
    @Override
    public void add(Instructor instructor) {
        System.out.println("Kategori JDBC ile veritabanına eklendi: "+  instructor.getName()+ " " + instructor.getSurName());
    }
}
