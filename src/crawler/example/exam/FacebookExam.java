package crawler.example.exam;

import com.github.abola.crawler.CrawlerPack;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


/**
 * 練習：取得任一篇或多篇文章的 Reactions 總數
 *
 *
 * 重點
 * 1. 先利用Graph Api調整出需要的資料
 * 2. 修改程式，使用爬蟲包取得資料
 * 3. 上傳至GitHub
 *
 * @author Abola Lee
 *
 */
public class FacebookExam {

	public static void main(String[] args) {

		// 遠端資料路徑

		String uri =
				"https://graph.facebook.com/v2.8"
						+ "/TechOrange/feed?limit=10&fields=id,message,likes.limit(0).summary(total_count),reactions.limit(0).summary(total_count)"
						+ "&access_token=118580478686560%7COf5Y7jVzJx_qbhiLKWc1v7qD9cM";


		Elements elems =
				CrawlerPack.start()
						.getFromJson(uri)
						.select("data");

		String output = "id,讚總數,心情總數" + "\n";

		// 遂筆處理
		for( Element data: elems ){
			String id = data.select("id").text();

			// FIXIT
			String likes = data.select("likes").text();
			String reactions = data.select("reactions").text();

			output += id + ","+ likes + "," + (Integer.parseInt(reactions)-Integer.parseInt(likes)) + "\n";
		}

		System.out.println( output );
	}
}