package net.sf.brightside.travelsystem.core;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public interface Base {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public abstract Long get_id();

	public abstract void set_id(Serializable id);

	@Basic
	public abstract String get_uuid();

	public abstract void set_id(Long _id);

	public abstract void set_uuid(String _uuid);

	public abstract int hashCode();

	public abstract boolean equals(Object o);

}