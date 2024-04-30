package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.LivroDAO;

@WebServlet("/ExcluirLivroServlet")
public class ExcluirLivroServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String titulo = request.getParameter("livro");

        LivroDAO livroDAO = new LivroDAO();

        if (titulo != null && !titulo.isEmpty()) {

            livroDAO.excluir(titulo);
            out.println("<h1>Livro excluído com sucesso!</h1>");
        } else {
            out.println("<h1>Erro ao excluir livro. Título do livro não fornecido.</h1>");
        }
    }
}
