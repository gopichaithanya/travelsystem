package net.sf.brightside.travelsystem.metamodel.beans;

import java.io.Serializable;

import javax.persistence.Entity;

import net.sf.brightside.travelsystem.core.beans.BaseBean;
import net.sf.brightside.travelsystem.core.beans.Identifiable;
import net.sf.brightside.travelsystem.metamodel.CabinClass;

@Entity
public class CabinClassBean extends BaseBean implements CabinClass,
		Serializable, Identifiable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8959082677510742521L;
	private String cabinClass;

	public String getCabinClass() {
		return cabinClass;
	}

	public void setCabinClass(String cabinClass) {
		this.cabinClass = cabinClass;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getCabinClass();
	}
}
