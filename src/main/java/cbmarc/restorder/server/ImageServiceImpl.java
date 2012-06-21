/**
 * 
 */
package cbmarc.restorder.server;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import cbmarc.restorder.client.rpc.ImageService;
import cbmarc.restorder.shared.ServerException;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * @author Marc
 *
 */
@SuppressWarnings("serial")
public class ImageServiceImpl
	extends RemoteServiceServlet implements ImageService {
	
	private static final String DIRECTORY = "img";
	
	public List<String> getAll() throws ServerException {
		List<String> list = new ArrayList<String>();
		
		String dirName = getServletContext().getRealPath("/") + DIRECTORY;
				
		File dir = new File(dirName);
		File[] files = dir.listFiles();
		
		if(files != null) {			
			for (int it = 0; it < files.length; it++) {
				list.add(files[it].getName());
			}
		}
		
		return list;
		
	}
	
}
