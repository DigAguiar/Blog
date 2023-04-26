package blog.controller;

import java.io.IOException;

import blog.api.Dados;
import blog.erros.PostNotFoundException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/posts/delete")
public class DeletePostController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	Dados dados = new Dados();


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");


		try {
			dados.removePost(Long.parseLong(id));
			//FIX: 3. AO EXCLUIR ESTA INDO PARA UMA TELA EM BRANCO? (RESOLVIDO)
			doPost(req, resp);
		} catch (NumberFormatException | PostNotFoundException e) {
			resp.sendError(400, e.getMessage());
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("posts", dados.getPosts());
		req.getRequestDispatcher("/admin.jsp").forward(req, resp);
	}

}
