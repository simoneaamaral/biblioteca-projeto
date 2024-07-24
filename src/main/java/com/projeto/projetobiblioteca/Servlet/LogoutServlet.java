package com.projeto.projetobiblioteca.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/logout")
//Esta classe vai lidar com as requisições para a página de "/logout"
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtemos a sessão atual, se houver uma
        HttpSession session = request.getSession(false);
        // Se houver uma sessão, invalidamos (encerramos) a sessão
        if (session != null) {
            session.invalidate();
        }
        response.sendRedirect("login.jsp");
    }
}
