package com.projeto.projetobiblioteca.DAO;

import com.projeto.projetobiblioteca.Model.Usuario;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import com.projeto.projetobiblioteca.Util.HibernateUtil;

import java.util.List;

// Classe responsável por realizar operações no banco de dados para a entidade Usuario
public class UsuarioDAO {

    // Método para adicionar um novo usuário ao banco de dados
    public void inserir(Usuario usuario) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Inicia uma transação
            transaction = session.beginTransaction();
            session.save(usuario);
            // Comita a transação
            transaction.commit();
        } catch (Exception e) {
            // Se ocorrer um erro, desfaz a transação
            if (transaction != null) {
                transaction.rollback();
            }
            // Imprime o erro
            e.printStackTrace();
        }
    }


    // Método para obter um usuário pelo email
    public Usuario obterPorEmail(String email) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Usuario> query = session.createQuery("FROM Usuario WHERE email = :email", Usuario.class);
            query.setParameter("email", email);
            return query.uniqueResult();
        }
    }


    // Método para obter um usuário pelo ID
    public Usuario obterPorId(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Usuario.class, id);
        }
    }

    // Método para listar todos os usuários no banco de dados
    public List<Usuario> listarTodos() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Usuario> query = session.createQuery("FROM Usuario", Usuario.class);
            return query.list();
        }
    }

    // Método para atualizar um usuário
    public void atualizar(Usuario usuario) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(usuario);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    // Método para excluir um usuário pelo ID
    public void excluir(Long id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            // Busca o usuário pelo ID
            Usuario usuario = session.get(Usuario.class, id);
            // Se o usuário existir, exclui do banco de dados
            if (usuario != null) {
                session.delete(usuario);
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

