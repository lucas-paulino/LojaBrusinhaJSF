package objetos;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.GenericDAO;
import util.HibernateUtil;

public class EstoqueDAO extends GenericDAO<Estoque>{
    
    public EstoqueDAO(Class<Estoque> entityClass) {
        super(entityClass);
    }
    
    public Estoque getById(int id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
                
        Criteria criteria = session.createCriteria(Estoque.class);
        criteria.add(Restrictions.eq("id", id));
        List<Estoque> list = criteria.list();
        
        transaction.commit();
        session.close();
        
        Estoque estoque = null;
        if(list.size()>0){
           estoque =(Estoque) list.get(0);
        }
        return estoque;
    }    
}
