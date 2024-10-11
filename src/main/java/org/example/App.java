package org.example;

import repository.NewsPaperRepository;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
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
            Date date = Date.valueOf(LocalDate.of(2024,3,15));
            List<NewsPaperDTO>listNewsPaper = newsPaperRepository.getNewsPapers(date);

            listNewsPaper.stream().forEach(dates -> System.out.println(dates.getName()));

        }catch (SQLException e){
            e.printStackTrace();
        } catch (NullPointerException e) {
            throw new RuntimeException(e);
        }

    }
}
