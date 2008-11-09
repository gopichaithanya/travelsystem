package net.sf.brightside.travelsystem.core.command;
 
public interface GetByExample<ReturnType,ExampleType> extends Command<ReturnType> {
	
	public ExampleType getExample();
	
	public void setExample(ExampleType example);

}
