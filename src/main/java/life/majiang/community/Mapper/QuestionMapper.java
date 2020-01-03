package life.majiang.community.Mapper;

import life.majiang.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QuestionMapper {
    @Insert("insert into QUESTION (title,description,creator,gmt_create,gmt_modified,tag) values (#{title},#{description},#{creator},#{gmt_create},#{gmt_modified},#{tag})")
    void create(Question question);
}
