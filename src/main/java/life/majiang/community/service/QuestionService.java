package life.majiang.community.service;

import life.majiang.community.Mapper.QuestionMapper;
import life.majiang.community.Mapper.UserMapper;
import life.majiang.community.dto.PaginationDTO;
import life.majiang.community.dto.QuestionDTO;
import life.majiang.community.model.Question;
import life.majiang.community.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private UserMapper userMapper;

    public PaginationDTO list(Integer page, Integer size) {
        PaginationDTO paginationDTO = new PaginationDTO();
        Integer totalCount = questionMapper.count();
        Integer totalPage;
        if (totalCount%size==0){
            totalPage=totalCount/size;
        }
        else{
            totalPage=totalCount/size+1;
        }

        if (page<1){
            page=1;
        }
        if (page>totalPage){
            page=totalPage;
        }
        Integer offset = (page-1)*size;
        List<Question> questions = questionMapper.list(size,offset);
        List<QuestionDTO> questionDTOList=new ArrayList<>();
        paginationDTO.setPagination(totalPage,page);

        for (Question question:questions){
            User user=userMapper.FindById(question.getCreator());
            QuestionDTO questionDTO=new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        paginationDTO.setQuestions(questionDTOList);

        return paginationDTO;
    }

    public PaginationDTO list(Integer userId, Integer page, Integer size) {
        PaginationDTO paginationDTO = new PaginationDTO();
        Integer totalCount = questionMapper.countById(userId);
        Integer totalPage;
        if (totalCount%size==0){
            totalPage=totalCount/size;
        }
        else{
            totalPage=totalCount/size+1;
        }

        if (page<1){
            page=1;
        }
        if (page>totalPage){
            page=totalPage;
        }
        if (page<1){
            page=1;
        }
        Integer offset = (page-1)*size;
        List<Question> questions = questionMapper.listById(userId,size,offset);

        List<QuestionDTO> questionDTOList=new ArrayList<>();
        paginationDTO.setPagination(totalPage,page);

        for (Question question:questions){
            User user=userMapper.FindById(userId);
            QuestionDTO questionDTO=new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        paginationDTO.setQuestions(questionDTOList);

        return paginationDTO;
    }
}
