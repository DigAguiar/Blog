package blog.model;

import java.io.Serializable;

public class Comment implements Serializable{

	
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String text;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
	
	
	
}
