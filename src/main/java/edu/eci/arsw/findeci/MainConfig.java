/**package edu.eci.arsw.findeci;

import com.zaxxer.hikari.*;
import java.net.URISyntaxException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

@Configuration
public class MainConfig {

    @Bean
    public BasicDataSource dataSource() throws URISyntaxException {
        boolean flag = true;
        if (flag) {
            String dbUrl = System.getenv("jdbc:postgresql://ec2-52-23-14-156.compute-1.amazonaws.com:5432/d5c5jentb34crd");
            String username = System.getenv("xwrmyhzlplbkuc");
            String password = System.getenv("e228c609a845fd721e3ae982beaf7917498a65065e85c476015e45947430e733");

            BasicDataSource basicDataSource = new BasicDataSource();
            basicDataSource.setUrl(dbUrl);
            basicDataSource.setUsername(username);
            basicDataSource.setPassword(password);
            System.out.println("conecto");
            return basicDataSource;

        } else {
            System.out.println("no conecto");
        }
        return null;
    }
}
**/