package objetos;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.GenericDAO;
import util.HibernateUtil;

public class VendaProdutoDAO extends GenericDAO<VendaProduto>{
    
    public VendaProdutoDAO(Class<VendaProduto> entityClass) {
        super(entityClass);
    }
    
    public VendaProduto getByVendaProduto(Venda venda, Produto produto) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
                
        Criteria criteria = session.createCriteria(VendaProduto.class);
        criteria.add(Restrictions.eq("venda", venda));
        criteria.add(Restrictions.eq("produto", produto));
        List<VendaProduto> list = criteria.list();
        
        transaction.commit();
        session.close();
        
        VendaProduto cat = null;
        if(list.size()>0){
           cat =(VendaProduto) list.get(0);
        }
        return cat;
    }
    
    public VendaProduto getByVenda(Venda venda) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
                
        Criteria criteria = session.createCriteria(VendaProduto.class);
        criteria.add(Restrictions.eq("venda", venda));
        List<VendaProduto> list = criteria.list();
        
        transaction.commit();
        session.close();
        
        VendaProduto cat = null;
        if(list.size()>0){
           cat =(VendaProduto) list.get(0);
        }
        return cat;
    }
    
    public VendaProduto getByProduto(Produto produto) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
                
        Criteria criteria = session.createCriteria(VendaProduto.class);
        criteria.add(Restrictions.eq("produto", produto));
        List<VendaProduto> list = criteria.list();
        
        transaction.commit();
        session.close();
        
        VendaProduto cat = null;
        if(list.size()>0){
           cat =(VendaProduto) list.get(0);
        }
        return cat;
    }
    
}
