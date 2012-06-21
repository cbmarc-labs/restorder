/**
 * 
 */
package cbmarc.restorder.shared.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Length;

/**
 * Node class
 * 
 * @author Marc
 */
@Entity
@Table(name = "NODE")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public abstract class Node implements Model {

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

	@ManyToOne
	protected Node parent;

	public Node() {}
	
	public Node(String name) {
		this.name = name;
	}

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
	 * @return the parent
	 */
	public Node getParent() {
		return parent;
	}

	/**
	 * @param parent the parent to set
	 */
	public void setParent(Node parent) {
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
