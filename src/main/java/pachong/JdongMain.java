package pachong;

import org.apache.commons.logging.LogFactory;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

import java.util.ArrayList;
import java.util.List;

public class JdongMain {
    private static final org.apache.commons.logging.Log logger = LogFactory.getLog(JdongMain.class);
    public static void main(String[] args) throws Exception {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("http://search.jd.com/Search?keyword=Python&enc=utf-8&qrst=1&rt=1&stop=1&book=y&vt=2&wq=Python&page=11&s=301&click=0");
        arrayList.add("http://search.jd.com/Search?keyword=Python&enc=utf-8&qrst=1&rt=1&stop=1&book=y&vt=2&wq=Python&page=15&s=421&click=0");
        arrayList.add("http://search.jd.com/Search?keyword=Python&enc=utf-8&qrst=1&rt=1&stop=1&book=y&vt=2&wq=Python&page=19&s=541&click=0");

        for (String url:arrayList){
            catchJingDong(url);
        }
    }

    public static void catchJingDong(String url)throws Exception{
        //初始化一个httpclient
        HttpClient client = new DefaultHttpClient();
        //我们要爬取的一个地址，这里可以从数据库中抽取数据，然后利用循环，可以爬取一个URL队列
        //抓取的数据
        List<JdModel> bookdatas=URLFecter.URLParser(client, url);
        //循环输出抓取的数据
        for (JdModel jd:bookdatas) {
            logger.info("bookID:"+jd.getBookID()+"\t"+"bookPrice:"+jd.getBookPrice()+"\t"+"bookName:"+jd.getBookName());
        }
        //将抓取的数据插入数据库
//        MYSQLControl.executeInsert(bookdatas);
        for (JdModel jd:bookdatas) {
            System.out.println(jd);
        }

    }
}