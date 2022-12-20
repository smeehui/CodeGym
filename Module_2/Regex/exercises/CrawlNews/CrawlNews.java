package CrawlNews;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrawlNews {
    public static void main(String[] args) throws IOException {
        String patternStr1 = "((<h3 class=\"article-title\"> <a href=\".*?>)(.*?)(?=<\\/a))";
        String patternStr2 = "(<h3 class=\"article-title\"> <a href=\".*?>)";
        URL url = new URL("https://dantri.com.vn/the-gioi.htm");
        Scanner sc = new Scanner(new InputStreamReader(url.openStream()));
        sc.useDelimiter("\\Z");
        String content = sc.next();
        sc.close();
        Pattern pattern1 = Pattern.compile(patternStr1);
        Matcher matcher = pattern1.matcher(content);
        while (matcher.find()) {
            String filterContent = matcher.group(1).replaceAll(patternStr2,"").replaceAll("&quot;","\"");
            System.out.println(filterContent+"\n");
        }
    }

}
