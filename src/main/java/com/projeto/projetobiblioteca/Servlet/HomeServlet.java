package com.projeto.projetobiblioteca.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/home")
// Esta classe vai lidar com as requisições para a página de "/home"
public class HomeServlet extends HttpServlet {

    @Override
    // Sobrescreve o método doGet da classe HttpServlet para lidar com requisições HTTP GET
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Encaminha a requisição e a resposta para a página "home.jsp"
        request.getRequestDispatcher("/home.jsp").forward(request, response);
    }
}
