package com.ccffee.demo.mbg.mapper;

import com.ccffee.demo.mbg.model.Demo;
import com.ccffee.demo.mbg.model.DemoExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface DemoMapper {
    @SelectProvider(type=DemoSqlProvider.class, method="countByExample")
    int countByExample(DemoExample example);

    @DeleteProvider(type=DemoSqlProvider.class, method="deleteByExample")
    int deleteByExample(DemoExample example);

    @Delete({
        "delete from demo",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into demo (name)",
        "values (#{name,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(Demo record);

    @InsertProvider(type=DemoSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(Demo record);

    @SelectProvider(type=DemoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    List<Demo> selectByExample(DemoExample example);

    @Select({
        "select",
        "id, name",
        "from demo",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    Demo selectByPrimaryKey(Integer id);

    @UpdateProvider(type=DemoSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Demo record, @Param("example") DemoExample example);

    @UpdateProvider(type=DemoSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Demo record, @Param("example") DemoExample example);

    @UpdateProvider(type=DemoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Demo record);

    @Update({
        "update demo",
        "set name = #{name,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Demo record);
}