package com.projeto.projetobiblioteca.DAO;

import com.projeto.projetobiblioteca.Model.Livro;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import com.projeto.projetobiblioteca.Util.HibernateUtil;
import java.util.List;

// Classe responsável por realizar operações no banco de dados para a entidade Livro
public class LivroDAO {

    // Método para adicionar um novo livro ao banco de dados
    public void inserir(Livro livro) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Inicia uma transação
            transaction = session.beginTransaction();
            // Salva o livro no banco de dados
            session.save(livro);
            // Comita a transação, aplicando as mudanças
            transaction.commit();
        } catch (Exception e) {
            //Se ocorrer um erro, desfaz a transação
            if (transaction != null) {
                transaction.rollback();
            }
            //Imprime o erro
            e.printStackTrace();
        }
    }

    // Método para obter um livro pelo seu ISBN
    public Livro obterPorIsbn(String isbn) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Livro.class, isbn);
        }
    }

    // Método para listar todos os livros no banco de dados
    public List<Livro> listarTodos() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Livro> query = session.createQuery("FROM Livro", Livro.class);
            return query.list();
        }
    }

    // Método para atualizar um livro
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

    // Método para excluir um livro
    public void excluir(String isbn) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            // Busca o livro pelo ISBN
            Livro livro = session.get(Livro.class, isbn);
            // Se o livro existir, exclui do banco de dados
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
