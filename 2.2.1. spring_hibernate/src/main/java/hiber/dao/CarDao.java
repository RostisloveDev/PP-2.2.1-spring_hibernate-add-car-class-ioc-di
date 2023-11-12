package hiber.dao;
import hiber.model.Car;
import hiber.model.User;
import java.util.List;

public interface CarDao {
   void add(User user, Car car);
   public User getUserByCarModelAndSeries(String model, int series);
   List<User> listUsers();
}
