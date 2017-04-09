package crawler.example.exam;

import com.github.abola.crawler.CrawlerPack;
import org.apache.commons.logging.impl.SimpleLog;
import org.jsoup.select.Elements;

/**
 * 爬蟲包程式的全貌，就只有這固定的模式
 * 
 * @author Abola Lee
 *
 */
public class BasicPttBoard {
	// commit test (yell test)
	public static void main(String[] args) {

		// set to debug level
		//CrawlerPack.setLoggerLevel(SimpleLog.LOG_LEVEL_DEBUG);

		// turn off logging
		CrawlerPack.setLoggerLevel(SimpleLog.LOG_LEVEL_OFF);

		// 遠端資料路徑
		String uri = "https://www.ptt.cc/man/Gossiping/D29E/D21D/D32E/M.1463010103.A.9B7.html";

		//System.out.println(
				Elements jsoup = CrawlerPack.start()
				
				// 參數設定
			    .addCookie("over18","1")	// 設定cookie
				//.setRemoteEncoding("big5")// 設定遠端資料文件編碼
				
				// 選擇資料格式 (三選一)
				//.getFromJson(uri)
			    .getFromHtml(uri)
			    //.getFromXml(uri)

			    // 這兒開始是 Jsoup Document 物件操作
			    //.select("div.push > span.hl.push-tag, div.push > span.f3.hl.push-userid"
				//.select("div.push:containsOwn(噓)")
				//.select("div.push:contains(噓)")
				.select("#main-content.bbs-screen.bbs-content");
		//);

		jsoup.select("div,span").remove();
		System.out.println(jsoup.text());
	}
}
