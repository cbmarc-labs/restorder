/**
 * 
 */
package cbmarc.restorder.client.utils;

/**
 * @author marc
 *
 */
public class JQMUtils {

	/**
	 * jqmChangePage() is the native method for change page in jQuery Mobile
	 * 
	 * @param page
	 */
	public native static void popup(String msg) /*-{
	
		$wnd.$("<div style='text-align:center;height:20px;margin:0 auto;width:250px;'" +
		 	"class='ui-overlay-shadow ui-body-e ui-corner-bottom'>"+
			"&nbsp;&nbsp;&nbsp;" + msg + "&nbsp;&nbsp;&nbsp;</div>")
			.css({ 
				"opacity": 0.96
			})
  			.appendTo( $wnd.$.mobile.pageContainer )
  			.delay( 1500 )
  			.fadeOut( 400, function(){
    			$wnd.$(this).remove();
  			});
		
	}-*/;

	/**
	 * jqmChangePage() is the native method for change page in jQuery Mobile
	 * 
	 * @param page
	 */
	public native static void focus(String element) /*-{
	
		$wnd.$('#' + element).focus();
		
	}-*/;
	
	/**
	 * jqmChangePage() is the native method for change page in jQuery Mobile
	 * 
	 * @param page
	 */
	public native static void showPageLoading() /*-{
	
		$wnd.$.mobile.showPageLoadingMsg("");
		
	}-*/;
	
	/**
	 * jqmChangePage() is the native method for change page in jQuery Mobile
	 * 
	 * @param page
	 */
	public native static void hidePageLoading() /*-{
	
		$wnd.$.mobile.hidePageLoadingMsg();
		
	}-*/;
	
	/**
	 * jqmChangePage() is the native method for change page in jQuery Mobile
	 * 
	 * @param page
	 */
	public native static void triggerCreate(String id) /*-{
		
		$wnd.$('#' + id).trigger('pagecreate');
		
	}-*/;
	
	public static native void page(String id) /*-{
		
    	$wnd.$("#" + id).page();
    	
    }-*/;

	/**
	 * jqmChangePage() is the native method for change page in jQuery Mobile
	 * 
	 * @param page
	 */
	public native static void sliderRefresh(String id) /*-{
		
		$wnd.$('#' + id).slider('refresh');
		
	}-*/;

	/**
	 * jqmChangePage() is the native method for change page in jQuery Mobile
	 * 
	 * @param page
	 */
	public native static void changePage(String page) /*-{
		
		$wnd.$.mobile.changePage("#" + page, {changeHash:false});
		
	}-*/;
	
}
