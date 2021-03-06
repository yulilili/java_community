package life.majiang.community.model;

import lombok.Data;

@Data
public class Question {
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
}
