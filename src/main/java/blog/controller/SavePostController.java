package blog.controller;

import java.io.IOException;

import blog.api.Dados;
import blog.model.Post;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/posts/save")
public class SavePostController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String title = req.getParameter("title");
		String text = req.getParameter("text");
		String publish = req.getParameter("publish");

		Post post = new Post();
		post.setTitle(title);
		post.setText(text);
		post.setPublish(publish != null);
		Dados dados = new Dados();
		dados.savePost(post);
		
		resp.sendRedirect("/blog/posts");
	}
	
	
}
