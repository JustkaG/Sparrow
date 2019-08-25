package dao;

import model.User;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class UserDAO extends AbstractDAO {

    public List<User> list() {

        return entityManager.createQuery("select u from User u").getResultList();
    }

    public void createUser(User user) {
        hibernateUtil.save(user);
    }

    public void deleteUser(long userId) {
        hibernateUtil.delete(User.class, userId);
    }

    public List<User> getUserByLastName(String lastName) {
        Query query = entityManager.createQuery("select u from User u where u.lastName = :lastName", User.class);
         return query.setParameter("lastName", lastName).getResultList();
    }

    public User getUserByEmail(String email){
        TypedQuery<User> query = entityManager.createQuery("select u from User u where u.email = :email", User.class);
        return query.setParameter("email", email).getSingleResult();
    }
}
