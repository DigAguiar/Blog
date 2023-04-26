package blog.api;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;


import blog.erros.PostNotFoundException;
import blog.model.Comment;
import blog.model.Post;

/**
 * 
 * Não há a nececidade de alterar essa classe.
 * 
 * Classe de apoio para manter os dados em memoria.
 * 
 * @author mariojp
 *
 */
public class Dados {

	private static List<Post> posts = new ArrayList<Post>();

	private static AtomicLong indexPost = new AtomicLong();
	private static AtomicLong indexComment = new AtomicLong();

	public Dados() {
	}

	public List<Post> getPosts() {
		return posts;
	}

	/**
	 * 
	 * @param post
	 * @throws PostNotFoundException
	 */
	public void updatePost(Post post) throws PostNotFoundException {
		if (post.getId() == null) {
			post.setId(indexPost.incrementAndGet());
			posts.add(post);
		} else {
			Post orignal = getById(post.getId());
			orignal.setText(post.getText());
			orignal.setTitle(post.getTitle());
			orignal.setPublish(post.getPublish());
		}
	}

	/**
	 * 
	 * @param post
	 */
	public void savePost(Post post) {
		post.setId(indexPost.incrementAndGet());
		posts.add(post);
	}

	public Post getPost(Long id) throws PostNotFoundException {
		return getById(id);
	}

	public void removePost(Long id) throws PostNotFoundException {
		Post post = new Post();
		post.setId(id);
		Post deleted = getById(post.getId());
		posts.remove(deleted);
	}

	public void removePost(Post post) throws PostNotFoundException {
		Post deleted = getById(post.getId());
		posts.remove(deleted);
	}

	private Post getById(final Long id) throws PostNotFoundException {
		for (Post post : posts) {
			if (post.getId().equals(id)) {
				return post;
			}
		}
		throw new PostNotFoundException();
	}

	public void addComment(Post post, Comment comment) throws PostNotFoundException {
		Post original = getById(post.getId());
		comment.setId(indexComment.incrementAndGet());
		original.getComments().add(comment);
	}

	public void removeComment(Long id) throws PostNotFoundException {
		Optional<Post> post = posts.stream().filter(p -> {
			Optional<Comment> r = p.getComments().stream().filter(c -> c.getId().equals(id)).findAny();
			return r.isPresent();
		}).findAny();
		if (post.isPresent()) {
			Comment comment = new Comment();
			comment.setId(id);
			removeComment(post.get(), comment);
		}
	}

	public void removeComment(Post post, Comment comment) throws PostNotFoundException {
		Post original = getById(post.getId());
		int index = -1;
		for (int i = 0; i < original.getComments().size(); i++) {
			if (original.getComments().get(i).getId().equals(comment.getId())) {
				index = i;
			}
		}
		if (index != -1) {
			original.getComments().remove(index);
		}

	}

}
