package idv.maxy.b2e_url_shortener.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import idv.maxy.b2e_url_shortener.service.B2EService;

/**
 * B2E控制器
 * @author Max Chen
 *
 */
@Controller
public class B2EController {
	private static final Log logger = LogFactory.getLog(B2EController.class);
	
	@Autowired
	private B2EService b2eService;
	
	/**
	 * 取得短網址
	 * @param url 網址
	 * @return 短網址
	 */
	@ResponseBody
	@PostMapping(path="/s")
	public String shorten(@RequestBody String url ) {
		String srt = null;
		try {
			srt = b2eService.shorten(url);	
		} catch(Exception ex) {
			logger.error("shorten failed", ex);
		}
		return srt;
	}
	
	/**
	 * 短網址重導
	 * @param srt 短網址
	 * @return 若找到對應網址, 則發出重導(a.k.a. 302); 未找到則發出未找到網頁 (404)  
	 */
	@GetMapping(path="/{srt:......}")
	public ResponseEntity<String> go(@PathVariable(name="srt") String srt) {
		String url = b2eService.getUrl(srt);
		ResponseEntity<String> re = null;
		
		if(url != null) {
			HttpHeaders hdrs = new HttpHeaders();
			hdrs.add("Location", url);
			re = ResponseEntity
					.status(HttpStatus.FOUND)
					.headers(hdrs)
			.build();
		}
		
		if(url == null) {
			re = ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body("Oops, we can not found this page!");
		}
		
		return re;
	}
}
