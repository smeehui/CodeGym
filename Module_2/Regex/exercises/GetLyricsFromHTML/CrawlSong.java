package GetLyricsFromHTML;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrawlSong {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://loibaihat.biz/lyric/qoxlq/3107/");
            Scanner sc = new Scanner(new InputStreamReader(url.openStream()));
            sc.useDelimiter("\\Z");
            String content = sc.next();
            sc.close();
            //Regex pattern
//            Pattern pattern = Pattern.compile("(<div class=\"lyric-song\">)(\r\n.+)*\r\n+(</div>)");
            Pattern pattern = Pattern.compile("(<br \\/>)(\\n.+)+",Pattern.MULTILINE);
            Matcher matcher = pattern.matcher(content);
            StringBuilder   sb = new StringBuilder();
            System.out.println(matcher.find());
            while (matcher.find()) {
                matcher.group(1);
                System.out.println(matcher.group(1));

            }
            // Code here
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
