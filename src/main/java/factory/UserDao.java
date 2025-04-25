package factory;
import org.hibernate.Session;
import org.hibernate.Transaction;
public class UserDao {

        public void saveUser(String name, String email) {
            Transaction transaction = null;
            try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
                transaction = session.beginTransaction();
                User user = UserFactory.createUser(name, email); // Using Factory
                session.save(user);
                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }
    }
}
