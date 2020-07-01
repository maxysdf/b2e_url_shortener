package idv.maxy.b2e_url_shortener.service;

/**
 * B2E服務
 * @author Max Chen
 *
 */
public interface B2EService {
	/**
	 * 取得短網址
	 * @param url 網址
	 * @return
	 * @throws Exception 無法取得短網址
	 */
	public String shorten(String url) throws Exception;
	
	/**
	 * 以短網址取得網址
	 * @param srt 短網址
	 * @return 網址
	 */
	public String getUrl(String srt);
}
