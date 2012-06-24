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
public class ArticleListPlace extends Place {
	
	private final String token;
	
	public ArticleListPlace(String token) {
		this.token = token==null?"":token;
	}
	
	public String getToken() {
		return token;
	}
	
	@Prefix("list")
	public static class Tokenizer implements PlaceTokenizer<ArticleListPlace>
	{

		@Override
		public String getToken(ArticleListPlace place)
		{
			return place.getToken();
		}

		@Override
		public ArticleListPlace getPlace(String token)
		{
			return new ArticleListPlace(token);
		}

	}
}
