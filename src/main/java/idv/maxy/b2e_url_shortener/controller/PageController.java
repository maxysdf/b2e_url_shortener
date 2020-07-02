package idv.maxy.b2e_url_shortener.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 頁面處理器
 * @author Max Chen
 *
 */
@Controller
public class PageController {
	/**
	 * 首頁
	 * @return
	 */
	@GetMapping("/")
	public String index() {
		return "index";
	}
}
