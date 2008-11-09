package net.sf.brightside.travelsystem.core.command;


public interface SaveEntity extends Command<Boolean> {
	
	public void setObject(Object object);
	public Object getObject ();

}
