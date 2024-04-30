package servlet;

import dao.LivroDAO;
import model.Livro;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/BuscarLivroServlet")
public class BuscarLivroServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String titulo = request.getParameter("titulo");
        
        LivroDAO livroDAO = new LivroDAO();
        Livro livro = livroDAO.buscarPorTitulo(titulo);

        request.setAttribute("livroEncontrado", livro);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
