package blog.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import blog.api.Dados;
import blog.erros.PostNotFoundException;
import blog.model.Comment;
import blog.model.Post;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/comment/create")
public class CreateCommentController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private Dados dados = new Dados();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		try {
			Post post = dados.getPost(Long.parseLong(id));
			req.setAttribute("post", post);
			req.getRequestDispatcher("/novocomment.jsp").forward(req, resp);
		} catch (NumberFormatException | PostNotFoundException e) {
			resp.sendError(400, e.getMessage());
			e.printStackTrace();
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String text = req.getParameter("text");		
		try {
			Post post = new Post();
			post.setId(Long.parseLong(id));
			Comment comment = new Comment();
			comment.setText(text);			
			dados.addComment(post,comment);
			resp.sendRedirect("/blog");
		} catch (NumberFormatException | PostNotFoundException e) {
			resp.sendError(400, e.getMessage());
			e.printStackTrace();
		}

		

	}

}
