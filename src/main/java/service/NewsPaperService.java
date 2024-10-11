package service;


import dto.NewsPaperDTO;

import java.util.ArrayList;

public interface NewsPaperService {

   public ArrayList<NewsPaperDTO> getNewsPapersByDate(String stringDate);
   public String createNewsPaper(NewsPaperDTO newsPaperDTO);
}
