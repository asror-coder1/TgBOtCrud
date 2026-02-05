package asror_uz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

    String url = "jdbc:postgresql://localhost:5432/tgbotcrud";
    String username = "postgres";
    String password = "root";



    public void createUser(Person person){
        try {
            Connection connection = DriverManager.getConnection(url , username  ,password);
            Statement statement = connection.createStatement();

            String query = "insert into person (chatid , firstname , lastname, username) values ("+
            person.getChatId() +
                    ",'" + person.getFirstname() +
                    "','" + person.getLastname() +
                    "','" + person.getUsername() + "');";

            statement.execute(query);
            System.out.println("User Saqlandi...");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
