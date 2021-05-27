package nc.univ.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Component
public class Service {
    @Autowired
    private ApplicationContext context;

    public void printDatabaseDetail() throws SQLException {
        DataSource dataSource = (DataSource) context.getBean("dataSource");
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();

        ResultSet set = statement.executeQuery("SHOW TABLES;");

        while (set.next()) {
            String tableName = set.getString(1);
            System.out.println("-- TABLE : " + tableName + " --");
            Statement state = connection.createStatement();
            ResultSet stateResult = state.executeQuery("SELECT column_name, type_name FROM information_schema.columns WHERE table_name='" + tableName + "'");
            while (stateResult.next()) {
                System.out.println("Colonne " + stateResult.getString(1) + " de type " + stateResult.getString(2));
            }
        }
    }
}
