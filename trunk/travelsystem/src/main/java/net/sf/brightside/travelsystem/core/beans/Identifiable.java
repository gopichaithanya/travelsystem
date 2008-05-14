package net.sf.brightside.travelsystem.core.beans;

import java.io.Serializable;

public interface Identifiable {

	public Serializable get_id();

	public void set_id(Serializable id);

	public String get_uuid();

}
