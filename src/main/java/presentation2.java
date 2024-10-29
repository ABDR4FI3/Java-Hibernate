import dao.IDao;
import entities.Category;
import entities.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import util.hibernateConfig;

import java.util.List;

public class presentation2 {

    public static void main(String[] args) {
        ApplicationContext context = new
                AnnotationConfigApplicationContext(hibernateConfig.class);

        IDao<Product> productDao = context.getBean(IDao.class);
        IDao<Category> categoryDao = context.getBean(IDao.class);

        Product product = new Product();
        product.setName("Produit 1");
        product.setPrice(100.0);

        Category category = Category.builder()
                .name("Categorie 1")
                .products(List.of(product))
                .build();

        productDao.create(product);


        System.out.println("Produit sauvegarde :" + product.getName());
    }
}