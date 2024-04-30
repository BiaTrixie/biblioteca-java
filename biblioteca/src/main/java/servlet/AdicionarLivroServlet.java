package servlet;

import model.Livro;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.annotation.WebServlet;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


@WebServlet("/AdicionarLivroServlet")
public class AdicionarLivroServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca"); 
        EntityManager em = emf.createEntityManager();

        String titulo = request.getParameter("titulo");
        String autor = request.getParameter("autor");
        int ano = Integer.parseInt(request.getParameter("ano"));
        int nota = Integer.parseInt(request.getParameter("nota"));
        String categoria = request.getParameter("categoria");
        String subcategoria = request.getParameter("subcategoria");

        Livro livro = new Livro(titulo, autor, ano, nota, categoria, subcategoria);

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(livro);
        tx.commit();

        em.close();
        emf.close();

        response.sendRedirect("cadastroLivro.jsp"); 
    }
}
