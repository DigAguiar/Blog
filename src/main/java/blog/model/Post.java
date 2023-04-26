package blog.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Post implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String title;
	
	private String text;
	
	private Boolean publish; 

	private List<Comment> comments = new ArrayList<Comment>();
	
	public Post() {
	}

	public Post(String title, String text) {
		super();
		this.title = title;
		this.text = text;
		this.publish = false;
	} 

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Boolean getPublish() {
		return publish;
	}

	public void setPublish(Boolean publish) {
		this.publish = publish;
	}
	
	
	
}
