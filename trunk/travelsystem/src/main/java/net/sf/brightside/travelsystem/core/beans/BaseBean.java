package net.sf.brightside.travelsystem.core.beans;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class BaseBean implements Serializable, Identifiable {

	/**
	 * 
	 */

	private Long _id;
	private String _uuid = UUID.randomUUID().toString();

	private static final long serialVersionUID = 1435675432198656708L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long get_id() {
		return _id;
	}
	
	@Override
	public void set_id(Serializable id) {
		this.set_id((Long)id);
		
	}

	@Override
	public String get_uuid() {
		// TODO Auto-generated method stub
		return _uuid;
	}

	public void set_id(Long _id) {
		this._id = _id;
	}

	public void set_uuid(String _uuid) {
		this._uuid = _uuid;
	}

	@Override
	public int hashCode() {
		if (get_uuid() != null) {
			return get_uuid().hashCode();
		} else {
			return super.hashCode();
		}
	}

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



}
