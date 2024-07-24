package com.projeto.projetobiblioteca.Servlet;

import com.projeto.projetobiblioteca.DAO.LivroDAO;
import com.projeto.projetobiblioteca.Model.Livro;
import com.projeto.projetobiblioteca.Model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/livros")
// Esta classe vai lidar com as requisições para a página de "/livros"
public class LivroServlet extends HttpServlet {
    private LivroDAO livroDAO;

    @Override
    public void init() {
        livroDAO = new LivroDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Verificando se a pessoa está logada.
        HttpSession session = request.getSession(false);
        Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");

        if (usuarioLogado == null) {
            request.setAttribute("mensagemErro", "Você precisa estar logado para realizar esta ação.");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }

        String action = request.getParameter("action");

        if ("inserir".equals(action)) {
            inserirLivro(request, response);
        } else if ("atualizar".equals(action)) {
            atualizarLivro(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
        // Aqui, pegamos a ação que a pessoa quer realizar (cadastrar, editar ou excluir um livro).
        String action = request.getParameter("action");

        if ("cadastro".equals(action) || "editar".equals(action) || "excluir".equals(action)) {
            // Se a pessoa não estiver logada, mostramos uma mensagem de erro e pedimos para ela fazer login
            if (usuarioLogado == null) {
                request.setAttribute("mensagemErro", "Você precisa estar logado para realizar esta ação.");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
                return;
            }
        }

        // Se não houver ação, listamos todos os livros
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

    // Este método lista todos os livros
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

    // Este método mostra o formulário para cadastrar um novo livro
    private void mostrarFormCadastro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/cadastroLivro.jsp").forward(request, response);
    }

    // Este método mostra o formulário para editar um livro existente
    private void mostrarFormEdicao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String isbn = request.getParameter("isbn");
        Livro livro = livroDAO.obterPorIsbn(isbn);
        request.setAttribute("livro", livro);
        request.getRequestDispatcher("/editarLivro.jsp").forward(request, response);
    }

    // Este método adiciona um novo livro
    private void inserirLivro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String isbn = request.getParameter("isbn");
        String titulo = request.getParameter("titulo");
        String categoria = request.getParameter("categoria");
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));

        // Verifica se o livro já existe pelo ISBN
        if (livroDAO.obterPorIsbn(isbn) != null) {
            request.setAttribute("mensagemErro", "Livro já existe!");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }

        Livro livro = new Livro(isbn, titulo, categoria, quantidade);
        livroDAO.inserir(livro);

        response.sendRedirect("livros");
    }


    // Este método atualiza um livro existente
    private void atualizarLivro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String isbn = request.getParameter("isbn");
        String titulo = request.getParameter("titulo");
        String categoria = request.getParameter("categoria");
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));

        Livro livro = new Livro(isbn, titulo, categoria, quantidade);
        livroDAO.atualizar(livro);

        response.sendRedirect("livros");
    }

    // Este método exclui um livro
    private void excluirLivro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String isbn = request.getParameter("isbn");
        livroDAO.excluir(isbn);
        response.sendRedirect("livros");
    }
}
