package com.woniu.answer.mapper;

import com.woniu.answer.entity.Question;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface QuestionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_question
     *
     * @mbggenerated Wed Feb 12 21:50:13 CST 2020
     */
    int deleteByPrimaryKey(Integer questionid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_question
     *
     * @mbggenerated Wed Feb 12 21:50:13 CST 2020
     */
    int insert(Question record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_question
     *
     * @mbggenerated Wed Feb 12 21:50:13 CST 2020
     */
    Question selectByPrimaryKey(Integer questionid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_question
     *
     * @mbggenerated Wed Feb 12 21:50:13 CST 2020
     */
    List<Question> selectAll();
    /**
     * 
     * @param title标题
     * @param status状态
     * @param cateid类型id
     * @return
     */
    List<Question> selectPage(@Param("title")String title,@Param("status")String status,@Param("cateid")int cateid);
    int updateStatusByKey(int id);
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_question
     *
     * @mbggenerated Wed Feb 12 21:50:13 CST 2020
     */
    int updateByPrimaryKey(Question record);
}