package repository;


import java.sql.*;
import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;
import config.DatabaseConfig;
import dto.NewsPaperDTO;

public class NewsPaperRepository {

    public ArrayList<NewsPaperDTO> getNewsPapersByDate(Date date)throws SQLException, NullPointerException {
        ArrayList<NewsPaperDTO> newsPapers = new ArrayList<>();

        try(Connection connection = DatabaseConfig.getConnection()){
            CallableStatement stmt = connection.prepareCall("{call get_newspapers_by_date(?)}");
            stmt.setDate(1, date);
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

    public String createNewsPaper(NewsPaperDTO newsPaper)throws SQLException, NullPointerException {
        try(Connection connection = DatabaseConfig.getConnection()){

            CallableStatement stmt = connection.prepareCall("{call create_newspaper(?,?,?)}");

            stmt.setString(1, newsPaper.getName());
            stmt.setDate(2, newsPaper.getDate());
            stmt.setInt(3, newsPaper.getAmount());
            stmt.registerOutParameter(4, Types.VARCHAR);

            stmt.execute();

            return stmt.getString(4);
        }
    }

}
