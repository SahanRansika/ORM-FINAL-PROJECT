package healthcarecenter.config;

import healthcarecenter.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfiguration;
    private SessionFactory sessionFactory;

    private FactoryConfiguration() {
//        Properties properties = new Properties();
//        try {
//            FileInputStream fis = new FileInputStream("src/main/resources/Hibernate.properties");
//            properties.load(fis);
//        } catch (IOException e) {
//            throw new RuntimeException("Failed to load Hibernate properties file", e);
//        }

        Configuration configuration = new Configuration();
//        configuration.setProperties(properties);

        configuration.addAnnotatedClass(Patient.class);
        configuration.addAnnotatedClass(Payment.class);
        configuration.addAnnotatedClass(Program.class);
        configuration.addAnnotatedClass(Registration.class);
        configuration.addAnnotatedClass(Sessions.class);
        configuration.addAnnotatedClass(Therapist.class);

        sessionFactory = configuration.buildSessionFactory();
    }

    public static FactoryConfiguration getInstance(){
        return factoryConfiguration==null ? new FactoryConfiguration() : factoryConfiguration;
    }
    public Session getSession(){
        return sessionFactory.openSession();
    }
}
















