package app.services;

import org.springframework.stereotype.Service;

import app.exception.AppException;

@Service
public class MockService {
	
	public void makeErrorHappen() throws AppException {
		throw new AppException("Service error/warning");
	}

}
