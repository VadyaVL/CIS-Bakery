package ua.bakery.db.DAO;

import java.util.Collection;

import ua.bakery.db.jpa.WriteOff;

/**
* @author vadym
* @since 0.12
*/
public interface IWriteOffDAO {
	public void saveWriteOff(WriteOff writeoff);
	public void updateWriteOff(WriteOff writeoff);
	public WriteOff getWriteOffById(Integer writeoff_id);
	public Integer getAllWriteOffCount();
	public Collection<WriteOff> getAllWriteOff();
	public void deleteWriteOff(WriteOff writeoff);
}