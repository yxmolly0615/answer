package com.woniu.answer.entity;

import java.util.Date;

public class Report {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_report.reportid
     *
     * @mbggenerated Wed Feb 12 21:50:13 CST 2020
     */
    private Integer reportid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_report.reportcontent
     *
     * @mbggenerated Wed Feb 12 21:50:13 CST 2020
     */
    private String reportcontent;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_report.questionid
     *
     * @mbggenerated Wed Feb 12 21:50:13 CST 2020
     */
    private Integer questionid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_report.userid
     *
     * @mbggenerated Wed Feb 12 21:50:13 CST 2020
     */
    private Integer userid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_report.status
     *
     * @mbggenerated Wed Feb 12 21:50:13 CST 2020
     */
    private String status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_report.answerid
     *
     * @mbggenerated Wed Feb 12 21:50:13 CST 2020
     */
    private Integer answerid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_report.createDate
     *
     * @mbggenerated Wed Feb 12 21:50:13 CST 2020
     */
    private Date createdate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_report.commentid
     *
     * @mbggenerated Wed Feb 12 21:50:13 CST 2020
     */
    private Integer commentid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_report.reportid
     *
     * @return the value of t_report.reportid
     *
     * @mbggenerated Wed Feb 12 21:50:13 CST 2020
     */
    private String username;
    private String content;
	private String answercontent;
	private String title;
    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getReportid() {
        return reportid;
    }
	
    public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getanswercontent() {
		return answercontent;
	}

	public void setanswercontent(String answercontent) {
		this.answercontent = answercontent;
	}
	
	/**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_report.reportid
     *
     * @param reportid the value for t_report.reportid
     *
     * @mbggenerated Wed Feb 12 21:50:13 CST 2020
     */
    public void setReportid(Integer reportid) {
        this.reportid = reportid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_report.reportcontent
     *
     * @return the value of t_report.reportcontent
     *
     * @mbggenerated Wed Feb 12 21:50:13 CST 2020
     */
    public String getreportcontent() {
        return reportcontent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_report.reportcontent
     *
     * @param reportcontent the value for t_report.reportcontent
     *
     * @mbggenerated Wed Feb 12 21:50:13 CST 2020
     */
    public void setreportcontent(String reportcontent) {
        this.reportcontent = reportcontent == null ? null : reportcontent.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_report.questionid
     *
     * @return the value of t_report.questionid
     *
     * @mbggenerated Wed Feb 12 21:50:13 CST 2020
     */
    public Integer getQuestionid() {
        return questionid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_report.questionid
     *
     * @param questionid the value for t_report.questionid
     *
     * @mbggenerated Wed Feb 12 21:50:13 CST 2020
     */
    public void setQuestionid(Integer questionid) {
        this.questionid = questionid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_report.userid
     *
     * @return the value of t_report.userid
     *
     * @mbggenerated Wed Feb 12 21:50:13 CST 2020
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_report.userid
     *
     * @param userid the value for t_report.userid
     *
     * @mbggenerated Wed Feb 12 21:50:13 CST 2020
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_report.status
     *
     * @return the value of t_report.status
     *
     * @mbggenerated Wed Feb 12 21:50:13 CST 2020
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_report.status
     *
     * @param status the value for t_report.status
     *
     * @mbggenerated Wed Feb 12 21:50:13 CST 2020
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_report.answerid
     *
     * @return the value of t_report.answerid
     *
     * @mbggenerated Wed Feb 12 21:50:13 CST 2020
     */
    public Integer getAnswerid() {
        return answerid;
    }

    @Override
	public String toString() {
		return "Report [reportid=" + reportid + ", reportcontent=" + reportcontent + ", questionid=" + questionid
				+ ", userid=" + userid + ", status=" + status + ", answerid=" + answerid + ", createdate=" + createdate
				+ ", commentid=" + commentid + ", username=" + username + ", content=" + content + ", answercontent="
				+ answercontent + ", title=" + title + "]";
	}

	/**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_report.answerid
     *
     * @param answerid the value for t_report.answerid
     *
     * @mbggenerated Wed Feb 12 21:50:13 CST 2020
     */
    public void setAnswerid(Integer answerid) {
        this.answerid = answerid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_report.createDate
     *
     * @return the value of t_report.createDate
     *
     * @mbggenerated Wed Feb 12 21:50:13 CST 2020
     */
    public Date getCreatedate() {
        return createdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_report.createDate
     *
     * @param createdate the value for t_report.createDate
     *
     * @mbggenerated Wed Feb 12 21:50:13 CST 2020
     */
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_report.commentid
     *
     * @return the value of t_report.commentid
     *
     * @mbggenerated Wed Feb 12 21:50:13 CST 2020
     */
    public Integer getCommentid() {
        return commentid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_report.commentid
     *
     * @param commentid the value for t_report.commentid
     *
     * @mbggenerated Wed Feb 12 21:50:13 CST 2020
     */
    public void setCommentid(Integer commentid) {
        this.commentid = commentid;
    }
}