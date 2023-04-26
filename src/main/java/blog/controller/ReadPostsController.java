package blog.controller;

import java.io.IOException;

import blog.api.Dados;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/posts")
public class ReadPostsController extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
	
	private Dados dados = new Dados();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("posts", dados.getPosts());
		req.getRequestDispatcher("./admin.jsp").forward(req, resp);
	}

}
