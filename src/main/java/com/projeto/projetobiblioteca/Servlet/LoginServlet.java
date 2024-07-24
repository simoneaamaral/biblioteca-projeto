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

@WebServlet("/login")
//Esta classe vai lidar com as requisições para a página de "/login"
public class LoginServlet extends HttpServlet {
    private UsuarioDAO usuarioDAO;

    @Override
    public void init() {
        usuarioDAO = new UsuarioDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Pegamos o email e a senha que a pessoa enviou
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        // Procuramos o usuário no banco de dados usando o emai
        Usuario usuario = usuarioDAO.obterPorEmail(email);

        // Se o usuário for encontrado e a senha estiver correta, a pessoa está logada
        if (usuario != null && usuario.getSenha().equals(senha)) {
            HttpSession session = request.getSession();
            session.setAttribute("usuarioLogado", usuario);
            session.setAttribute("mensagemSucesso", "Login realizado com sucesso, " + usuario.getNome() + "!");
            response.sendRedirect("/home.jsp");
        } else {
            // Se o email ou a senha estiverem errados, mostramos uma mensagem de erro
            request.setAttribute("mensagemErro", "Email ou senha inválidos!");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}
