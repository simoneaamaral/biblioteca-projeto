package com.projeto.projetobiblioteca.Servlet;

import com.projeto.projetobiblioteca.DAO.LivroDAO;
import com.projeto.projetobiblioteca.Model.Livro;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/livros")
public class LivroServlet extends HttpServlet {
    private LivroDAO livroDAO;

    @Override
    public void init() {
        livroDAO = new LivroDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            listarLivros(request, response);
        } else {
            switch (action) {
                case "cadastro":
                    mostrarFormCadastro(request, response);
                    break;
                case "editar":
                    mostrarFormEdicao(request, response);
                    break;
                case "excluir":
                    excluirLivro(request, response);
                    break;
                default:
                    listarLivros(request, response);
                    break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("inserir".equals(action)) {
            inserirLivro(request, response);
        } else if ("atualizar".equals(action)) {
            atualizarLivro(request, response);
        }
    }

    private void listarLivros(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Livro> livros = livroDAO.listarTodos();
        if (livros == null || livros.isEmpty()) {
            System.out.println("Nenhum livro encontrado.");
        } else {
            System.out.println("Número de livros encontrados: " + livros.size());
        }
        request.setAttribute("livros", livros);
        request.getRequestDispatcher("/listagem.jsp").forward(request, response);
    }

    private void mostrarFormCadastro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/cadastro.jsp").forward(request, response);
    }

    private void mostrarFormEdicao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String isbn = request.getParameter("isbn");
        Livro livro = livroDAO.obterPorIsbn(isbn);
        request.setAttribute("livro", livro);
        request.getRequestDispatcher("/editarLivro.jsp").forward(request, response);
    }

    private void inserirLivro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String isbn = request.getParameter("isbn");
        String titulo = request.getParameter("titulo");
        String categoria = request.getParameter("categoria");
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));

        // Verifica se o livro já existe pelo ISBN
        if (livroDAO.obterPorIsbn(isbn) != null) {
            request.setAttribute("mensagemErro", "Livro já existe!");
            request.getRequestDispatcher("/cadastro.jsp").forward(request, response);
            return;
        }

        Livro livro = new Livro(isbn, titulo, categoria, quantidade);
        livroDAO.inserir(livro);

        response.sendRedirect("livros");
    }


    private void atualizarLivro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String isbn = request.getParameter("isbn");
        String titulo = request.getParameter("titulo");
        String categoria = request.getParameter("categoria");
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));

        Livro livro = new Livro(isbn, titulo, categoria, quantidade);
        livroDAO.atualizar(livro);

        response.sendRedirect("livros");
    }

    private void excluirLivro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String isbn = request.getParameter("isbn");
        livroDAO.excluir(isbn);
        response.sendRedirect("livros");
    }
}
