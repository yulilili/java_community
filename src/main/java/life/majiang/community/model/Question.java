package life.majiang.community.model;

import lombok.Data;

@Data
public class Question {
    private Integer id;
    private Integer creator;
    private String title;
    private String description;
    private Long gmt_create;
    private Long gmt_modified;
    private int like_account;
    private int view_account;
    private int comment_account;
    private String tag;
}
