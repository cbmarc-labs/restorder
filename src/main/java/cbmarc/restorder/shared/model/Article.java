/**
 * 
 */
package cbmarc.restorder.shared.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Length;

/**
 * Article class
 * 
 * @author Marc
 */
@Entity
@Table(name = "ARTICLE")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Article extends Node {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "DESCRIPTION")
	protected String description;
	
	@Column(name = "FOLDER")
	protected Boolean folder;

	@Column(name = "IMAGE")
	@Length(max=100)
	protected String image;

	public Article() {}
	
	public Article(String name) {
		super(name);
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the folder
	 */
	public Boolean getFolder() {
		return folder;
	}

	/**
	 * @param folder the folder to set
	 */
	public void setFolder(Boolean folder) {
		this.folder = folder;
	}

	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}

	/**
	 * deHibernate() 
	 */
	@Override
	public void deHibernate() {
	}
	
	/**
	 * toString()
	 */
	@Override
	public String toString() { 
		StringBuilder build = new StringBuilder();
		
		return build.append("id: ").append(id).toString();
	}

}
