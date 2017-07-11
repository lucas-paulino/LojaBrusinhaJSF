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

public class UsuarioDAO extends GenericDAO<Usuario> {
    
    public UsuarioDAO(Class<Usuario> entityClass) {
        super(entityClass);
    }
    
    public Usuario getByLoginSenha(String login, String senha) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
                
        Criteria criteria = session.createCriteria(Usuario.class);
        criteria.add(Restrictions.eq("login", login.toLowerCase()));
        criteria.add(Restrictions.eq("senha", senha));
        List<Usuario> list = criteria.list();
        
        transaction.commit();
        session.close();
        
        Usuario user = null;
        if(list.size()>0){
           user =(Usuario) list.get(0);
        }
        return user;
    }
    
}
