package net.sf.brightside.travelsystem.core.command;


public interface DeleteEntity extends Command<Boolean> {
	
	public void setObject(Object object);
	public Object getObject ();

}
