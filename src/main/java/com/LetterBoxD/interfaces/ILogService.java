package com.LetterBoxD.interfaces;

import java.util.List;

import com.LetterBoxD.model.Log;

public interface ILogService {

	public Log findById(long id);
	
	public List<Log> findAll();
	
	public Log create(Log log);
	
	public Log update(long id, Log newLog);
	
	public boolean delete(long id);

}
