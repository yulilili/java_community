package life.majiang.community.Mapper;

import life.majiang.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    @Insert("INSERT INTO USER (name,account_id,token,gmt_create,gmt_modified) values (#{name},#{account_id},#{token},#{gmtCreate},#{gmtModified})")
    void insert(User user);

}