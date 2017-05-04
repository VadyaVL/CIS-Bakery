package ua.bakery.db.DAO.dependInjection;

import java.util.Collection;
import java.util.List;

import ua.bakery.db.DAO.IWriteOffDAO;
import ua.bakery.db.jpa.WriteOff;

public class WriteOffDAO_DI {

	private IWriteOffDAO writeoffDAO;
	
	public WriteOffDAO_DI(IWriteOffDAO writeoffDAO) {
		this.writeoffDAO = writeoffDAO;
	}

    
	public void saveWriteOff(WriteOff writeoff) {
		writeoffDAO.saveWriteOff(writeoff);
	}

	public void updateWriteOff(WriteOff writeoff) {
		writeoffDAO.updateWriteOff(writeoff);
	}

	public void deleteWriteOff(WriteOff writeoff) {
		writeoffDAO.deleteWriteOff(writeoff);
	}

	public WriteOff getWriteOffById(Integer writeoff_id) {
		WriteOff writeoff = writeoffDAO.getWriteOffById(writeoff_id);
		return writeoff;
	}

	public Integer getAllWriteOffCount() {
		Integer cnt = writeoffDAO.getAllWriteOffCount();
		return cnt;
	}

	public Collection<WriteOff> getAllWriteOff() {
		List<WriteOff> writeoffs = (List<WriteOff>) writeoffDAO.getAllWriteOff();
		return writeoffs;
	}


}
