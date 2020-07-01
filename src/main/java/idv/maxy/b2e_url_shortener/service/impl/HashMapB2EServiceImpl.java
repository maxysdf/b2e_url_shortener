package idv.maxy.b2e_url_shortener.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import idv.maxy.b2e_url_shortener.service.B2EService;

/**
 * B2E服務 - HashMap實作
 * @author Max Chen
 *
 */
@Service
public class HashMapB2EServiceImpl implements B2EService {
	
	/** 存放短網址 -> 原網址 對應 */
	private Map<String, String> store = new HashMap<String, String>();

	/** 短網址可用之字元集合 */
	private static final char[] TABLE = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray(); 
	
	@Value("${shorten.length}")
	private int shortenLength;

	/**
	 * @see idv.maxy.b2e_url_shortener.service.B2EService#shorten(java.lang.String)
	 */
	@Override
	public String shorten(String url) throws Exception {
		if(url == null) { return null; }
		
		// TODO: normalize
		String inStr = url;
		if(store.containsKey(inStr)) {
			return store.get(inStr);
		}
		
		// 產生短網址
		// 1. 取得URL所有字元
		// 2. 準備目標陣列(int)
		// 3. 依序將字元遞增到目標陣列各元素 (重覆N次以避免pattern太過固定, 也避免URL太短造成問題)
		char[] in = inStr.toCharArray();
		int[] arr = new int[shortenLength];
		int r = 0;
		for(int i = 0; i < 5; i++) {
			for(char c : in) {
				arr[r % arr.length] += c;
				r++;
			}
		}
		
		// 4. 對目標陣列取可用字元數量之餘數, 取得對應的字元
		// 5. 合併為結果
		String outStr = IntStream.of(arr)
			.mapToObj(i->""+TABLE[i%TABLE.length])
			.collect(Collectors.joining(""));
		
		// 存入結果對應
		store.put(outStr, inStr);
		
		return outStr;
	}
	
	/**
	 * @see idv.maxy.b2e_url_shortener.service.B2EService#getUrl(java.lang.String)
	 */
	@Override
	public String getUrl(String srt) {
		return store.get(srt);
	}
}
