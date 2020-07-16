package jsoup;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.File;
import java.net.URL;

public class first {
    @Test
    public  void TestUrl() throws  Exception{
        Document doc = Jsoup.parse(new URL("http://www.itcast.cn/"), 1000);
        String title = doc.getElementsByTag("title").first().text();
        System.out.println(title);
    }
    @Test
    public void TestString() throws  Exception{
        String content = FileUtils.readFileToString(new File("C:\\Users\\Administrator\\Desktop\\text.html"), "UTF-8");

        Document doc = Jsoup.parse(content);
        String title = doc.getElementsByTag("title").first().text();
        System.out.println(title);
    }
    @Test
    public void TestFile() throws  Exception{
        Document document = Jsoup.parse(new File("C:\\Users\\Administrator\\Desktop\\text.html"), "utf8");
        String title = document.getElementsByTag("title").first().text();
        System.out.println(title);
    }
}
