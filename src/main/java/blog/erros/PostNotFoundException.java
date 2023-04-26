package blog.erros;

public class PostNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public PostNotFoundException() {
		super("Post não Encontrado!");
	}

}
