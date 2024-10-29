package metier;

import dao.IDao;
import entities.Product;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import  org.hibernate.SessionFactory;

import javax.transaction.Transactional;
import java.util.List;

@Repository("productDao")
public class ProductDaoImpl implements IDao<Product> {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    @Transactional
    public boolean create(Product t) {
        Session session = sessionFactory.getCurrentSession();
        session.save(t);
        return true;
    }

    @Override
    @Transactional
    public boolean delete(Product t) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(t);
        return true;
    }

    @Override
    @Transactional
    public boolean update(Product t) {
        Session session = sessionFactory.getCurrentSession();
        session.update(t);
        return true;
    }

    @Override
    @Transactional
    public Product findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Product product = session.get(Product.class, id);
        return product;
    }

    @Override
    @Transactional
    public List<Product> findAll() {
        Session session = sessionFactory.getCurrentSession();
        List<Product> products = session.createQuery("from Product").getResultList();
        return products;
    }


}
