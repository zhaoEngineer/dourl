import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 *测试 Url
 */
public class UrlTest {
    public static void main(String[] args) throws IOException {
        //创建URL对象  protocol://host:port/path?query#fragment
        URL url = new URL("https://www.runoob.com");
        //创建URLConnection对象
        URLConnection uc = url.openConnection();
        //定义HttpURLConnection变量
        HttpURLConnection huc = null;
        if (uc instanceof HttpURLConnection){
            //向下转型——HttpURLConnection是URLConnection的子类
            huc = (HttpURLConnection)uc;
        }else{
            System.out.println("网址错误，请核对后再输入");
            return;
        }
        //创建字符缓冲输入流对象
        InputStream is = huc.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        //定义变量接收所有的数据
        String urlStr = "";
        //定义变量接收当前读到的数据
        String current;
        while ((current = br.readLine())!=null){
            urlStr = urlStr +"\n"+ current;
        }
        //释放资源
        br.close();
        //打印接收到的所有数据
        System.out.println(urlStr);
    }
}
