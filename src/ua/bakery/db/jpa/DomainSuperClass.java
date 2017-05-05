package ua.bakery.db.jpa;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.MappedSuperclass;

/**
 * ВНИМАНИЕ! Необходимо принудительно вставить суперкласс
 * ua.bakery.db.jpa.DomainSuperClass в persistence.xml 
 */

@MappedSuperclass
public abstract  class DomainSuperClass implements Serializable {
	/** */
	private static final long serialVersionUID = -7653593705919221387L;
	/** Суррогатный уникальный первичный ключ */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected int id = 0;

	public DomainSuperClass() {

	}

	public DomainSuperClass(java.lang.Integer id) {
		this.id = id;
	}

	/**
	 * 	ДРУГИЕ ОБЩИЕ ПОЛЯ ДОМЕНОВ И ИХ Get и Set
	 */

	/**
	 * Gets the id value for this DomainSuperClass. 
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id value for this DomainSuperClass. 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (new Integer(id));
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) 
			return true;
		if (obj == null) 
			return false;
		if (!DomainSuperClass.class.isAssignableFrom(obj.getClass())) 
			return false;
		DomainSuperClass other = (DomainSuperClass) obj;
		
		return id == other.id;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	/*
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
	*/
}
