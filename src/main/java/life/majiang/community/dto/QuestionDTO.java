package life.majiang.community.dto;

import life.majiang.community.model.User;
import lombok.Data;

@Data
public class QuestionDTO {
    private Integer id;
    private Integer creator;
    private String title;
    private String description;
    private Long gmtCreate;
    private Long gmtModified;
    private int likeAccount;
    private int viewAccount;
    private int commentAccount;
    private String tag;
    private User user;
}
