package objetos;

import util.GenericDAO;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

public class CategoriaDAO extends GenericDAO<Categoria>{
    
    public CategoriaDAO(Class<Categoria> entityClass) {
        super(entityClass);
    }
    
    public Categoria getById(int id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
                
        Criteria criteria = session.createCriteria(Categoria.class);
        criteria.add(Restrictions.eq("id", id));
        List<Categoria> list = criteria.list();
        
        transaction.commit();
        session.close();
        
        Categoria cat = null;
        if(list.size()>0){
           cat =(Categoria) list.get(0);
        }
        return cat;
    }
}
