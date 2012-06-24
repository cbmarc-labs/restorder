/**
 * 
 */
package cbmarc.restorder.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

/**
 * @author marc
 *
 */
public class ArticleEditPlace extends Place {
	
	private final String token;
	
	public ArticleEditPlace(String token) {
		this.token = token==null?"":token;
	}
	
	public String getToken() {
		return token;
	}
	
	@Prefix("edit")
	public static class Tokenizer implements PlaceTokenizer<ArticleEditPlace>
	{

		@Override
		public String getToken(ArticleEditPlace place)
		{
			return place.getToken();
		}

		@Override
		public ArticleEditPlace getPlace(String token)
		{
			return new ArticleEditPlace(token);
		}

	}
}
