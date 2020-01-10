package life.majiang.community.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PaginationDTO {
    private List<QuestionDTO> questions;
    private Integer page;
    private List<Integer> pages=new ArrayList<>();
    private boolean showPrevious;
    private boolean showNext;
    private boolean showFirstPage;
    private boolean showEndPage;
    private Integer totalPage;


    public void setPagination(Integer totalPage,  Integer page) {
        this.totalPage=totalPage;
        this.page=page;
//      是否显示跳转第一页
        //      显示的可跳转的页数
        pages.add(page);
        for (int i=1;i<=3;i++){
            if (page-i>0){
                pages.add(0,page-i);
            }
            if (page+i<=totalPage){
                pages.add(page+i);
            }
        }
        if (pages.contains(1)){
            showFirstPage=false;
        }
        else {
            showFirstPage=true;
        }
//      是否显示跳转最后一页
        if (pages.contains(totalPage)){
            showEndPage=false;
        }
        else {
            showEndPage=true;
        }

//      是否显示跳转上一页
        if (page==1){
            showPrevious=false;
        }
        else {
            showPrevious=true;
        }
//      是否显示跳转下一页
        if (page==totalPage){
            showNext=false;
        }
        else {
            showNext=true;
        }



    }
}
