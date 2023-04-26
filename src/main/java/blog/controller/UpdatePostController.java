package blog.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import blog.api.Dados;
import blog.erros.PostNotFoundException;
import blog.model.Post;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/posts/update")
public class UpdatePostController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private Dados dados = new Dados();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		try {
			Post post = dados.getPost(Long.parseLong(id));
			req.setAttribute("post", post);
			req.getRequestDispatcher("/editpost.jsp").forward(req, resp);
		} catch (NumberFormatException | PostNotFoundException e) {
			resp.sendError(400, e.getMessage());
			e.printStackTrace();
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String title = req.getParameter("title");
		String text = req.getParameter("text");
		String publish = req.getParameter("publish");
		
		try {
			Post post = new Post();
			post.setId(Long.parseLong(id));
			post.setTitle(title);
			post.setText(text);
			post.setPublish(publish != null);
			
			dados.updatePost(post);
			resp.sendRedirect("/blog/posts");
		} catch (NumberFormatException | PostNotFoundException e) {
			resp.sendError(400, e.getMessage());
			e.printStackTrace();
		}

		

	}

}
