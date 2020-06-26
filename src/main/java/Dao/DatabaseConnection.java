package Dao;

import Model.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class DatabaseConnection {
    private SessionFactory sessionFactory;
    private static DatabaseConnection databaseConnection;

    private DatabaseConnection() {
        Configuration configuration = new Configuration();
        Properties properties = new Properties();
        properties.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
        properties.put(Environment.URL,
                "jdbc:mysql://localhost:3306/firstproject");
        properties.put(Environment.USER, "blabla");
        properties.put(Environment.PASS, "blabla");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
        properties.put(Environment.SHOW_SQL, "true");
        properties.put(Environment.HBM2DDL_AUTO, "update");
        properties.put(Environment.ENABLE_LAZY_LOAD_NO_TRANS, true);

        configuration.setProperties(properties);
        configuration.addAnnotatedClass(StudentModel.class);
        configuration.addAnnotatedClass(ProfessorModel.class);
        configuration.addAnnotatedClass(ClassModel.class);
        configuration.addAnnotatedClass(CourseModel.class);
        configuration.addAnnotatedClass(ScheduleModel.class);
        sessionFactory = configuration.buildSessionFactory();
    }

    public static DatabaseConnection getInstance() {
        if (databaseConnection == null) {
            databaseConnection = new DatabaseConnection();
        }
        return databaseConnection;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
