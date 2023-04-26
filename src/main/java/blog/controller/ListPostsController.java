package blog.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import blog.api.Dados;
import blog.model.Post;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/")
public class ListPostsController extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;

	private Dados dados = new Dados();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Post> posts = dados.getPosts();
		List<Post> publish = new ArrayList<Post>();
		
		
		//FIX 5. REMOVER OS POSTS QUE NÃO ESTÃO PUBLICADOS
		for (Post post : posts) {
			if(post.getPublish() == true) {
				publish.add(post);
			}
		}
		
		req.setAttribute("posts", publish);
		req.getRequestDispatcher("./principal.jsp").forward(req, resp);
	}


}
