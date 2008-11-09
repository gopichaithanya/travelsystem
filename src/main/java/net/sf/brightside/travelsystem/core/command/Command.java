package net.sf.brightside.travelsystem.core.command;


    public interface Command<ReturnType> {

	public ReturnType execute() throws CommandException;

}
