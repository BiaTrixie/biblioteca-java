package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import java.util.List;

import model.Livro;

public class LivroDAO {
    private EntityManagerFactory emf;

    public LivroDAO() {
        this.emf = Persistence.createEntityManagerFactory("biblioteca");
    }

    public void salvar(Livro livro) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(livro);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public boolean atualizarLivro(Livro livro) { 
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
    
        try {
            transaction.begin();

            em.merge(livro);
            transaction.commit();
            return true; 
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
        return false; 
    }


    public void excluir(String titulo) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
    
        try {
            transaction.begin();
            Livro livro = em.find(Livro.class, titulo);
            if (livro != null) {
                em.remove(livro);
                System.out.println("Livro removido: " + livro.getTitulo());
            } else {
                System.out.println("Livro não encontrado com título: " + titulo);
            }
            transaction.commit();
            System.out.println("Transação confirmada com sucesso.");
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
    

   public Livro buscarPorTitulo(String titulo) {
    EntityManager em = emf.createEntityManager();
    try {

        TypedQuery<Livro> query = em.createQuery("SELECT l FROM Livro l WHERE l.Titulo = :titulo", Livro.class);
        query.setParameter("titulo", titulo);

        return query.getSingleResult();
    } catch (NoResultException e) {

        return null;
    } finally {
        em.close();
    }
}

    public List<Livro> listarLivros() {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("SELECT l FROM Livro l");
            return query.getResultList();
        } finally {
            em.close();
        }
    }

}
