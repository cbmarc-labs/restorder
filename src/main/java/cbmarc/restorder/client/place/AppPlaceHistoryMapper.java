package cbmarc.restorder.client.place;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

@WithTokenizers({
    DefaultPlace.Tokenizer.class,
    ArticleListPlace.Tokenizer.class,
    ArticleEditPlace.Tokenizer.class
})
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper {

}
