package hiber.service;
import hiber.model.Car;
import hiber.model.User;
import java.util.List;

public interface CarService {
    void add(User user, Car car);
    public User getUserByCar(String model, int series);
    List<User> listUsers();
}
