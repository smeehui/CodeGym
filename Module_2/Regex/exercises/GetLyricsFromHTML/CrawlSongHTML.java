package GetLyricsFromHTML;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CrawlSongHTML {
    public static void main(String[] args) {
        String url = "https://loibaihat.biz/lyric/yezbe/vietnamtrongtoila/";
        Document htmls;
        {
            try {
                htmls = Jsoup.connect(url).get();
                Element lyricDiv = htmls.getElementsByAttributeValue("class", "lyric-song").get(0);
                Element title = lyricDiv.getElementsByTag("h2").get(0);
                Pattern pattern = Pattern.compile("(<br>.*+)");
                String content = lyricDiv.html();
                Matcher matcher = pattern.matcher(content);
                List<String> lines = new ArrayList<>();
                lines.add(title.text());
                while (matcher.find()) {
                    lines = new ArrayList<>(List.of(matcher.group(1).split("<br>")));
                }
                for (String line : lines) {
                    System.out.println(line+"\n");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
