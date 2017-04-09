package crawler.example;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.github.abola.crawler.CrawlerPack;


/**
 * 資料探索練習 Facebook Graph Api Search 
 * 
 * 重點
 * 1. 利用Graph Api調整出需要的資料
 * 2. 取得一組Access Token (試著使用 long term token)
 * 3. 試著用『excel』或任何最簡易的方式，對資料進行探索
 * 
 * @author Abola Lee
 *
 */
public class FacebookExample {
	
	public static void main(String[] args) {
		
		// 遠端資料路徑
		// [query sample]
		// search?fields=name,id,likes,talking_about_count&limit=1000&q=靠北&type=page
		String uri = 
				"https://graph.facebook.com/v2.8"
				+ "/search?q=%E9%A4%90%E5%BB%B3&type=page&limit=1000&fields=name,id,fan_count,talking_about_count"
				+ "&access_token=EAABr2StPNWABAJw70G5NHGvrfHSIAOMqvvZCKtzwsXfY8S4tVlheLbTsp1OzI3cfENzCxjbjxrkw4NknlZA8G1rliIv7GfZBYHZBNh3QZBPa0tKMKHhePc6gIS6xd39ieB3bZBeZB3t8sGcZCRJl5gLRvkbfgHlOZAZAHRJC8ZBVvaZB8kWp0iv3CwEeXmnEuDu07n8ZD";



		// Jsoup select 後回傳的是  Elements 物件
//		[data sample]
//		----
//		{
//			"data": [
//			{
//				"name": "FEED ME美式餐廳-嘉義店",
//		        "id": "176276922442033",
//				"fan_count": 2910,
//				"talking_about_count": 3
//			}
//		}
		Elements elems =
				CrawlerPack.start()
				.getFromJson(uri)
				.select("data");
		
		String output = "id,名稱,按讚數,討論人數\n";
		
		// 遂筆處理
		for( Element data: elems ){
			String id = data.select("id").text();
			String name = data.select("name").text();
			String likes = data.select("fan_count").text();
			String talking_about_count = data.select("talking_about_count").text();
			
			output += id+",\""+name+"\","+likes+","+talking_about_count+"\n";
		}
		
		System.out.println( output );
	} 
}
