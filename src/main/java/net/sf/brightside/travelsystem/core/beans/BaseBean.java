package net.sf.brightside.travelsystem.core.beans;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import net.sf.brightside.travelsystem.core.Base;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class BaseBean implements Serializable, Identifiable, Base {

	/**
	 * 
	 */

	private Long _id;
	private String _uuid = UUID.randomUUID().toString();

	private static final long serialVersionUID = 1435675432198656708L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.sf.brightside.travelsystem.core.beans.Base#get_id()
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long get_id() {
		return _id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.sf.brightside.travelsystem.core.beans.Base#set_id(java.io.Serializable)
	 */
	@Override
	public void set_id(Serializable id) {
		this.set_id((Long) id);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.sf.brightside.travelsystem.core.beans.Base#get_uuid()
	 */
	@Override
	@Basic
	public String get_uuid() {
		// TODO Auto-generated method stub
		return _uuid;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.sf.brightside.travelsystem.core.beans.Base#set_id(java.lang.Long)
	 */
	public void set_id(Long _id) {
		this._id = _id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.sf.brightside.travelsystem.core.beans.Base#set_uuid(java.lang.String)
	 */
	public void set_uuid(String _uuid) {
		this._uuid = _uuid;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.sf.brightside.travelsystem.core.beans.Base#hashCode()
	 */
	@Override
	public int hashCode() {
		if (get_uuid() != null) {
			return get_uuid().hashCode();
		} else {
			return super.hashCode();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.sf.brightside.travelsystem.core.beans.Base#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || !(o instanceof Identifiable)) {
			return false;
		}
		Identifiable other = (Identifiable) o;
		if (get_id() != null) {
			return get_id().equals(other.get_id());
		}
		if (get_uuid() == null)
			return false;
		return get_uuid().equals(other.get_uuid());
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getClass().getName() + " id=" + get_id();
	}

}
