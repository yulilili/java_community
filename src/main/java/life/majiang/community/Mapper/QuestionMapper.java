package life.majiang.community.Mapper;

import life.majiang.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuestionMapper {
    @Insert("insert into QUESTION (title,description,creator,gmt_create,gmt_modified,tag) values (#{title},#{description},#{creator},#{gmtCreate},#{gmtModified},#{tag})")
    void create(Question question);

    @Select("select * from QUESTION limit #{size} offset #{offset}")
    List<Question> list(@Param("size") Integer size, @Param("offset") Integer offset);

    @Select("select count(1) from QUESTION")
    Integer count();

    @Select("select * from QUESTION where creator= #{userId} limit #{size} offset #{offset}")
//    @Select("select * from question where creator = #{userId} limit #{offset},#{size}")
    List<Question> listById(@Param("userId") Integer userId, @Param("size") Integer size, @Param("offset") Integer offset);

//    @Select("select count(1) from QUESTION where creator=#{userId)" )
    @Select("select count(1) from question where creator = #{userId}")
    Integer countById(@Param("userId") Integer userId);
}
