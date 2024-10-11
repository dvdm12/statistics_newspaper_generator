package repository;


import java.sql.SQLException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;
import config.DatabaseConfig;
import dto.NewsPaperDTO;

public class NewsPaperRepository {

    public ArrayList<NewsPaperDTO> getNewsPapers()throws SQLException, NullPointerException {
        ArrayList<NewsPaperDTO> newsPapers = new ArrayList<>();

        try(Connection connection = DatabaseConfig.getConnection()){
            CallableStatement stmt = connection.prepareCall("{call get_newspapers()}");
            boolean hasResultSet = stmt.execute();

            if(hasResultSet){
                ResultSet rs = stmt.getResultSet();

                while(rs.next()){
                    NewsPaperDTO newsPaper = new NewsPaperDTO();
                    newsPaper.setId(rs.getInt("id"));
                    newsPaper.setName(rs.getString("name"));
                    newsPaper.setDate(rs.getDate("publication_date"));
                    newsPaper.setAmount(rs.getInt("amount"));

                    newsPapers.add(newsPaper);
                }
            }

            return (!newsPapers.isEmpty())? newsPapers : null;

        }
    }

}
