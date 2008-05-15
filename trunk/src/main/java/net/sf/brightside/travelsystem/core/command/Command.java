package net.sf.brightside.travelsystem.core.command;

import net.sf.brightside.travelsystem.core.persistence.GenericDAO;

    public interface Command<ReturnType, ManagerType> {

	public GenericDAO<ManagerType> getDao();

	public void setDao(GenericDAO<ManagerType> dao);

	public ReturnType execute() throws CommandException;

}
