package pachong;

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;

public class MyDataSource {
    public static DataSource getDataSource(String connectURI){
        BasicDataSource ds = new BasicDataSource();
        //MySQL的jdbc驱动
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUsername("root");              //所要连接的数据库名
        ds.setPassword("");                //MySQL的登陆密码
        ds.setUrl(connectURI);
        return ds;
    }
}
