package hiber.dao;
import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class CarDaoImp implements CarDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user, Car car) {
      sessionFactory.getCurrentSession().save(car);
      user.setCar(car);
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   public List<User> listUsers() {
      String hql = "SELECT u FROM User u WHERE u.car IS NOT NULL";
      Query<User> query = sessionFactory.getCurrentSession().createQuery(hql, User.class);
      return query.getResultList();
   }

   @Override
   public User getUserByCarModelAndSeries(String model, int series) {
      String hql = "SELECT u FROM User u JOIN u.car c WHERE c.model = :model AND c.series = :series";
      Query<User> query = sessionFactory.getCurrentSession().createQuery(hql, User.class);
      query.setParameter("model", model);
      query.setParameter("series", series);
      return query.getSingleResult();
   }
}
