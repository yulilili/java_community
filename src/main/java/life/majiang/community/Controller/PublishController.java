package life.majiang.community.Controller;

import life.majiang.community.Mapper.QuestionMapper;
import life.majiang.community.model.Question;
import life.majiang.community.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PublishController {
    @Autowired
    public QuestionMapper questionMapper;

    @GetMapping("/publish")
    public String publish(){
        return "publish";
    }

    @PostMapping("/publish")
    public String doPublish(@Param("title")String title,
                            @Param("descritption") String description,
                            @Param("tag") String tag,
                            HttpServletRequest request,
                            Model model){
        model.addAttribute("title",title);
        model.addAttribute("description",description);
        model.addAttribute("tag",tag);
        if (title==null||title==""){
            model.addAttribute("error","标题不可为空");
            return "publish";
        }
        if (description == null || description == "") {
            model.addAttribute("error","描述不可为空");
            return "publish";
        }
        if (tag == null || tag == "") {

            model.addAttribute("error","标签不可为空");
            return "publish";
        }
        User user= (User) request.getSession().getAttribute("user");
        if (user==null){
            model.addAttribute("error","用户未登录成功");
            return "publish";
        }
        Question question=new Question();
        question.setTitle(title);
        question.setTag(tag);
        question.setDescription(description);
        question.setCreator(user.getId());
        question.setGmtCreate(System.currentTimeMillis());
        question.setGmtModified(question.getGmtCreate());
        questionMapper.create(question);
        return "redirect:/";

    }
}
