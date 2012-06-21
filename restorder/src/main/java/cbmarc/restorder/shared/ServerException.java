/**
 * 
 */
package cbmarc.restorder.shared;

import java.io.Serializable;
import java.util.logging.Logger;

/**
 * @author Marc
 *
 */
public class ServerException extends Exception implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private static Logger logger =
		    Logger.getLogger(ServerException.class.getName());

	public ServerException() {
	}
	
	public ServerException(Exception e) {
		super(e.getMessage());
		
		StackTraceElement stack[] = e.getStackTrace();
		String result = e.toString() + "\n";
		
		for (int i=0; i<stack.length; i++) {
			result += stack[i].toString() + "\n";
		}
				
		logger.severe(result);
		
	}

}
