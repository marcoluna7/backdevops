package com.udemy.component;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component("logComponent")
public class LogComponent {

	static final  Log Log = LogFactory.getLog(LogComponent.class);
	public void saveLog(String message)
	{
		LogComponent.Log.info(message);
	}
}
