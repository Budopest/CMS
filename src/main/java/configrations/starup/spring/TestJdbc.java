package configrations.starup.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.*;

@Controller
@RequestMapping("jdbc")
public class TestJdbc {

    @RequestMapping("test")
    String connect(){

        String url = "jdbc:mysql://localhost:3306/web_customer_tracker";
        String username = "lrngsql";
        String password = "budopest513@W";

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try(Connection connection = DriverManager.getConnection(url,username,password)){
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("select * from customer");
            while(result.next()){
                System.out.println(
                        "user name:" +
                                result.getString(1) +
                                " " + result.getString(2)
                );
            }

        } catch (SQLException e) {
            System.out.println("failed to connect to the db");
            e.printStackTrace();
        }

        return "connected";

    }

}
