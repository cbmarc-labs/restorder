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
	
	@Prefix("edit")
	public static class Tokenizer implements PlaceTokenizer<ArticleEditPlace>
	{

		@Override
		public String getToken(ArticleEditPlace place)
		{
			return "";
		}

		@Override
		public ArticleEditPlace getPlace(String token)
		{
			return new ArticleEditPlace();
		}

	}
}
