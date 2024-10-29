package metier;

import dao.IDao;
import entities.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository("categoryDao")  // Marking the class as a Spring component
public class CategoryDaoImpl implements IDao<Category> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public boolean create(Category category) {
        Session session = sessionFactory.getCurrentSession();
        session.save(category);
        return true;
    }

    @Override
    @Transactional
    public boolean delete(Category category) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(category);
        return true;
    }

    @Override
    @Transactional
    public boolean update(Category category) {
        Session session = sessionFactory.getCurrentSession();
        session.update(category);
        return true;
    }

    @Override
    @Transactional
    public Category findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Category.class, id);
    }

    @Override
    @Transactional
    public List<Category> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Category", Category.class).getResultList();
    }
}
