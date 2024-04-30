package servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.LivroDAO;
import model.Livro;

@WebServlet("/ListarLivrosServlet")
public class ListarLivrosServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LivroDAO livroDAO = new LivroDAO();
        List<Livro> livros = livroDAO.listarLivros();
        request.setAttribute("livros", livros);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
