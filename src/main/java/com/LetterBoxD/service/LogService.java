package com.LetterBoxD.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LetterBoxD.interfaces.ILogService;
import com.LetterBoxD.model.Log;
import com.LetterBoxD.repository.LogRepository;

@Service
public class LogService implements ILogService {

	@Autowired
	LogRepository logRepository;

	@Override
	public Log findById(long id) {
		if ((logRepository.findById(id)).isEmpty())
			return null;
		return logRepository.findById(id).get();
	}

	@Override
	public List<Log> findAll() {
		return logRepository.findAll();
	}

	@Override
	public Log create(Log log) {
		return logRepository.save(log);
		// aggiungere logica FK per controllo
	}

	@Override
	public Log update(long id, Log newLog) {

		Optional<Log> optLog = logRepository.findById(id);
		Log oldLog;

		if (optLog.isEmpty())
			return null;

		else {
			oldLog = optLog.get();

			oldLog.setDoLog(newLog.getDoLog());
			oldLog.setVote(newLog.getVote());
			oldLog.setReview(newLog.getReview());
			oldLog.setUser(newLog.getUser());
			oldLog.setMovie(newLog.getMovie());
			oldLog.setActive(newLog.isActive());

			logRepository.save(oldLog);
		}

		return oldLog;
	}

	@Override
	public boolean delete(long id) {

		Optional<Log> optLog = logRepository.findById(id);
		Log oldLog;

		if (optLog.isEmpty())
			return false;

		else {
			oldLog = optLog.get();
			oldLog.setActive(false);
			logRepository.save(oldLog);
			return true;
		}
	}

}
