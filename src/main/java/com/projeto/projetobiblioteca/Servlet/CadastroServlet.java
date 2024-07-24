package com.projeto.projetobiblioteca.Servlet;

import com.projeto.projetobiblioteca.DAO.UsuarioDAO;
import com.projeto.projetobiblioteca.Model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

//Esta classe vai lidar com as requisições para a página de "/cadastro"
@WebServlet("/cadastro")
public class CadastroServlet extends HttpServlet {
    private UsuarioDAO usuarioDAO;

    @Override
    public void init() {
        usuarioDAO = new UsuarioDAO();
    }

    @Override
    // Sobrescreve o método doPost da classe HttpServlet para lidar com requisições HTTP POST
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtém o valor do parâmetro "nome" da requisição e o armazena na variável nome
        String nome = request.getParameter("nome");
        // Obtém o valor do parâmetro "email" da requisição e o armazena na variável email
        String email = request.getParameter("email");
        // Obtém o valor do parâmetro "senha" da requisição e o armazena na variável senha
        String senha = request.getParameter("senha");

        // Verifica se o usuário já existe pelo email
        if (usuarioDAO.obterPorEmail(email) != null) {
            // Se já existir, mostra uma mensagem de erro e volta para a página de login
            request.setAttribute("mensagemErro", "Email já cadastrado!");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }

        // Se o email não existir, cria um novo usuário com as informações fornecidas
        Usuario usuario = new Usuario(nome, email, senha);
        usuarioDAO.inserir(usuario);

        // Adiciona uma mensagem de sucesso à sessão
        HttpSession session = request.getSession();
        session.setAttribute("mensagemSucessoCadastro", "Cadastro realizado com sucesso!");

        // Redireciona para a página de login
        response.sendRedirect("login.jsp");
    }
}
