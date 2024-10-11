package service;

import dto.NewsPaperDTO;
import repository.NewsPaperRepository;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

public class NewsPaperServiceImpl implements NewsPaperService {
    private NewsPaperRepository newsPaperRepository;

    public NewsPaperServiceImpl(NewsPaperRepository newsPaperRepository) {
        this.newsPaperRepository = newsPaperRepository;
    }

    @Override
    public String createNewsPaper(NewsPaperDTO newsPaperDTO) {
        return "";
    }

    @Override
    public ArrayList<NewsPaperDTO> getNewsPapersByDate(String stringDate) {

        try{
            Date date = NewsPaperDateValidator.validateAndConvertDate(stringDate);
            return newsPaperRepository.getNewsPapersByDate(date);

        }catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }
}
