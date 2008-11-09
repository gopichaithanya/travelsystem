package net.sf.brightside.travelsystem.core.command;

public interface GetAllEntities<ReturnType, ClassType> extends Command<ReturnType>{
	
	public void setClassType(Class<ClassType> clazz);
	
	public Class<ClassType> getClassType ();

}
