/**
 * 
 */
package cbmarc.restorder.shared.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Article implements Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	protected Long id;
	
	@Column(name = "NAME", nullable = false)
	@Length(min=1, max=50)
	protected String name;

	@Column(name = "DESCRIPTION")
	protected String description;
	
	@Column(name = "FOLDER")
	protected Boolean folder;

	@Column(name = "IMAGE")
	@Length(max=100)
	protected String image;
	
	@Column(name = "PARENT")
	protected Long parent;

	public Article() {}
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @return the parent
	 */
	public Long getParent() {
		return parent;
	}

	/**
	 * @param parent the parent to set
	 */
	public void setParent(Long parent) {
		this.parent = parent;
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
