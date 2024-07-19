package com.projeto.projetobiblioteca.DAO;

import com.projeto.projetobiblioteca.Model.Livro;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import com.projeto.projetobiblioteca.Util.HibernateUtil;

import java.util.List;

public class LivroDAO {
    public void inserir(Livro livro) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(livro);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Livro obterPorIsbn(String isbn) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Livro.class, isbn);
        }
    }

    public List<Livro> listarTodos() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Livro> query = session.createQuery("FROM Livro", Livro.class);
            return query.list();
        }
    }

    public void atualizar(Livro livro) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(livro);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void excluir(String isbn) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Livro livro = session.get(Livro.class, isbn);
            if (livro != null) {
                session.delete(livro);
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
