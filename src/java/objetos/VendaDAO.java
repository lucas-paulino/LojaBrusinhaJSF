package objetos;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.GenericDAO;
import util.HibernateUtil;

public class VendaDAO extends GenericDAO<Venda> {
    
    public VendaDAO(Class<Venda> entityClass) {
        super(entityClass);
    }
    
    public Venda getById(int id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
                
        Criteria criteria = session.createCriteria(Venda.class);
        criteria.add(Restrictions.eq("id", id));
        List<Venda> list = criteria.list();
        
        transaction.commit();
        session.close();
        
        Venda cat = null;
        if(list.size()>0){
           cat =(Venda) list.get(0);
        }
        return cat;
    }
}
