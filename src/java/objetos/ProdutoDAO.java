package objetos;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.GenericDAO;
import util.HibernateUtil;

public class ProdutoDAO extends GenericDAO<Produto> {
    
    public ProdutoDAO(Class<Produto> entityClass) {
        super(entityClass);
    }
    public Produto getById(int id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
                
        Criteria criteria = session.createCriteria(Produto.class);
        criteria.add(Restrictions.eq("id", id));
        List<Produto> list = criteria.list();
        
        transaction.commit();
        session.close();
        
        Produto produto = null;
        if(list.size()>0){
           produto =(Produto) list.get(0);
        }
        return produto;
    }
}
