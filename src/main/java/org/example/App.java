package org.example;

import repository.NewsPaperRepository;

import java.sql.SQLException;
import java.util.List;
import dto.NewsPaperDTO;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        NewsPaperRepository newsPaperRepository = new NewsPaperRepository();

        try{
            List<NewsPaperDTO>listNewsPaper = newsPaperRepository.getNewsPapers();

            listNewsPaper.stream().forEach(System.out::println);

        }catch (SQLException e){
            e.printStackTrace();
        } catch (NullPointerException e) {
            throw new RuntimeException(e);
        }

    }
}
