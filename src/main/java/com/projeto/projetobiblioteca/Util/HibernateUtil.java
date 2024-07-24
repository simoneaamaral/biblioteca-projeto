package com.projeto.projetobiblioteca.Util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

// Esta classe é usada para configurar e obter a fábrica de sessões do Hibernate
public class HibernateUtil {
    // A variável sessionFactory é uma fábrica de sessões do Hibernate que será usada para criar sessões
    private static SessionFactory sessionFactory;

    // Bloco estático, que é executado quando a classe é carregada pela primeira vez
    static {
        try {
            // Configura a fábrica de sessões usando o arquivo de configuração padrão do Hibernate (hibernate.cfg.xml)
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Se houver erro durante a configuração, lançamos um erro de inicialização
            throw new ExceptionInInitializerError(ex);
        }
    }

    // Método estático para obter a fábrica de sessões
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    // Método estático para fechar a fábrica de sessões
    public static void shutdown() {
        getSessionFactory().close();
    }
}
