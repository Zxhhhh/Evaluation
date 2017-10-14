package com.why.Evaluation.dto;

import java.util.ArrayList;
import java.util.List;

public class ExamExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ExamExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andExamIdIsNull() {
            addCriterion("exam_id is null");
            return (Criteria) this;
        }

        public Criteria andExamIdIsNotNull() {
            addCriterion("exam_id is not null");
            return (Criteria) this;
        }

        public Criteria andExamIdEqualTo(Integer value) {
            addCriterion("exam_id =", value, "examId");
            return (Criteria) this;
        }

        public Criteria andExamIdNotEqualTo(Integer value) {
            addCriterion("exam_id <>", value, "examId");
            return (Criteria) this;
        }

        public Criteria andExamIdGreaterThan(Integer value) {
            addCriterion("exam_id >", value, "examId");
            return (Criteria) this;
        }

        public Criteria andExamIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("exam_id >=", value, "examId");
            return (Criteria) this;
        }

        public Criteria andExamIdLessThan(Integer value) {
            addCriterion("exam_id <", value, "examId");
            return (Criteria) this;
        }

        public Criteria andExamIdLessThanOrEqualTo(Integer value) {
            addCriterion("exam_id <=", value, "examId");
            return (Criteria) this;
        }

        public Criteria andExamIdIn(List<Integer> values) {
            addCriterion("exam_id in", values, "examId");
            return (Criteria) this;
        }

        public Criteria andExamIdNotIn(List<Integer> values) {
            addCriterion("exam_id not in", values, "examId");
            return (Criteria) this;
        }

        public Criteria andExamIdBetween(Integer value1, Integer value2) {
            addCriterion("exam_id between", value1, value2, "examId");
            return (Criteria) this;
        }

        public Criteria andExamIdNotBetween(Integer value1, Integer value2) {
            addCriterion("exam_id not between", value1, value2, "examId");
            return (Criteria) this;
        }

        public Criteria andExamNameIsNull() {
            addCriterion("exam_name is null");
            return (Criteria) this;
        }

        public Criteria andExamNameIsNotNull() {
            addCriterion("exam_name is not null");
            return (Criteria) this;
        }

        public Criteria andExamNameEqualTo(String value) {
            addCriterion("exam_name =", value, "examName");
            return (Criteria) this;
        }

        public Criteria andExamNameNotEqualTo(String value) {
            addCriterion("exam_name <>", value, "examName");
            return (Criteria) this;
        }

        public Criteria andExamNameGreaterThan(String value) {
            addCriterion("exam_name >", value, "examName");
            return (Criteria) this;
        }

        public Criteria andExamNameGreaterThanOrEqualTo(String value) {
            addCriterion("exam_name >=", value, "examName");
            return (Criteria) this;
        }

        public Criteria andExamNameLessThan(String value) {
            addCriterion("exam_name <", value, "examName");
            return (Criteria) this;
        }

        public Criteria andExamNameLessThanOrEqualTo(String value) {
            addCriterion("exam_name <=", value, "examName");
            return (Criteria) this;
        }

        public Criteria andExamNameLike(String value) {
            addCriterion("exam_name like", value, "examName");
            return (Criteria) this;
        }

        public Criteria andExamNameNotLike(String value) {
            addCriterion("exam_name not like", value, "examName");
            return (Criteria) this;
        }

        public Criteria andExamNameIn(List<String> values) {
            addCriterion("exam_name in", values, "examName");
            return (Criteria) this;
        }

        public Criteria andExamNameNotIn(List<String> values) {
            addCriterion("exam_name not in", values, "examName");
            return (Criteria) this;
        }

        public Criteria andExamNameBetween(String value1, String value2) {
            addCriterion("exam_name between", value1, value2, "examName");
            return (Criteria) this;
        }

        public Criteria andExamNameNotBetween(String value1, String value2) {
            addCriterion("exam_name not between", value1, value2, "examName");
            return (Criteria) this;
        }

        public Criteria andPaparIdIsNull() {
            addCriterion("papar_id is null");
            return (Criteria) this;
        }

        public Criteria andPaparIdIsNotNull() {
            addCriterion("papar_id is not null");
            return (Criteria) this;
        }

        public Criteria andPaparIdEqualTo(Integer value) {
            addCriterion("papar_id =", value, "paparId");
            return (Criteria) this;
        }

        public Criteria andPaparIdNotEqualTo(Integer value) {
            addCriterion("papar_id <>", value, "paparId");
            return (Criteria) this;
        }

        public Criteria andPaparIdGreaterThan(Integer value) {
            addCriterion("papar_id >", value, "paparId");
            return (Criteria) this;
        }

        public Criteria andPaparIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("papar_id >=", value, "paparId");
            return (Criteria) this;
        }

        public Criteria andPaparIdLessThan(Integer value) {
            addCriterion("papar_id <", value, "paparId");
            return (Criteria) this;
        }

        public Criteria andPaparIdLessThanOrEqualTo(Integer value) {
            addCriterion("papar_id <=", value, "paparId");
            return (Criteria) this;
        }

        public Criteria andPaparIdIn(List<Integer> values) {
            addCriterion("papar_id in", values, "paparId");
            return (Criteria) this;
        }

        public Criteria andPaparIdNotIn(List<Integer> values) {
            addCriterion("papar_id not in", values, "paparId");
            return (Criteria) this;
        }

        public Criteria andPaparIdBetween(Integer value1, Integer value2) {
            addCriterion("papar_id between", value1, value2, "paparId");
            return (Criteria) this;
        }

        public Criteria andPaparIdNotBetween(Integer value1, Integer value2) {
            addCriterion("papar_id not between", value1, value2, "paparId");
            return (Criteria) this;
        }

        public Criteria andExamStartTimeIsNull() {
            addCriterion("exam_start_time is null");
            return (Criteria) this;
        }

        public Criteria andExamStartTimeIsNotNull() {
            addCriterion("exam_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andExamStartTimeEqualTo(String value) {
            addCriterion("exam_start_time =", value, "examStartTime");
            return (Criteria) this;
        }

        public Criteria andExamStartTimeNotEqualTo(String value) {
            addCriterion("exam_start_time <>", value, "examStartTime");
            return (Criteria) this;
        }

        public Criteria andExamStartTimeGreaterThan(String value) {
            addCriterion("exam_start_time >", value, "examStartTime");
            return (Criteria) this;
        }

        public Criteria andExamStartTimeGreaterThanOrEqualTo(String value) {
            addCriterion("exam_start_time >=", value, "examStartTime");
            return (Criteria) this;
        }

        public Criteria andExamStartTimeLessThan(String value) {
            addCriterion("exam_start_time <", value, "examStartTime");
            return (Criteria) this;
        }

        public Criteria andExamStartTimeLessThanOrEqualTo(String value) {
            addCriterion("exam_start_time <=", value, "examStartTime");
            return (Criteria) this;
        }

        public Criteria andExamStartTimeLike(String value) {
            addCriterion("exam_start_time like", value, "examStartTime");
            return (Criteria) this;
        }

        public Criteria andExamStartTimeNotLike(String value) {
            addCriterion("exam_start_time not like", value, "examStartTime");
            return (Criteria) this;
        }

        public Criteria andExamStartTimeIn(List<String> values) {
            addCriterion("exam_start_time in", values, "examStartTime");
            return (Criteria) this;
        }

        public Criteria andExamStartTimeNotIn(List<String> values) {
            addCriterion("exam_start_time not in", values, "examStartTime");
            return (Criteria) this;
        }

        public Criteria andExamStartTimeBetween(String value1, String value2) {
            addCriterion("exam_start_time between", value1, value2, "examStartTime");
            return (Criteria) this;
        }

        public Criteria andExamStartTimeNotBetween(String value1, String value2) {
            addCriterion("exam_start_time not between", value1, value2, "examStartTime");
            return (Criteria) this;
        }

        public Criteria andExamEndTimeIsNull() {
            addCriterion("exam_end_time is null");
            return (Criteria) this;
        }

        public Criteria andExamEndTimeIsNotNull() {
            addCriterion("exam_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andExamEndTimeEqualTo(String value) {
            addCriterion("exam_end_time =", value, "examEndTime");
            return (Criteria) this;
        }

        public Criteria andExamEndTimeNotEqualTo(String value) {
            addCriterion("exam_end_time <>", value, "examEndTime");
            return (Criteria) this;
        }

        public Criteria andExamEndTimeGreaterThan(String value) {
            addCriterion("exam_end_time >", value, "examEndTime");
            return (Criteria) this;
        }

        public Criteria andExamEndTimeGreaterThanOrEqualTo(String value) {
            addCriterion("exam_end_time >=", value, "examEndTime");
            return (Criteria) this;
        }

        public Criteria andExamEndTimeLessThan(String value) {
            addCriterion("exam_end_time <", value, "examEndTime");
            return (Criteria) this;
        }

        public Criteria andExamEndTimeLessThanOrEqualTo(String value) {
            addCriterion("exam_end_time <=", value, "examEndTime");
            return (Criteria) this;
        }

        public Criteria andExamEndTimeLike(String value) {
            addCriterion("exam_end_time like", value, "examEndTime");
            return (Criteria) this;
        }

        public Criteria andExamEndTimeNotLike(String value) {
            addCriterion("exam_end_time not like", value, "examEndTime");
            return (Criteria) this;
        }

        public Criteria andExamEndTimeIn(List<String> values) {
            addCriterion("exam_end_time in", values, "examEndTime");
            return (Criteria) this;
        }

        public Criteria andExamEndTimeNotIn(List<String> values) {
            addCriterion("exam_end_time not in", values, "examEndTime");
            return (Criteria) this;
        }

        public Criteria andExamEndTimeBetween(String value1, String value2) {
            addCriterion("exam_end_time between", value1, value2, "examEndTime");
            return (Criteria) this;
        }

        public Criteria andExamEndTimeNotBetween(String value1, String value2) {
            addCriterion("exam_end_time not between", value1, value2, "examEndTime");
            return (Criteria) this;
        }

        public Criteria andExamDurationIsNull() {
            addCriterion("exam_duration is null");
            return (Criteria) this;
        }

        public Criteria andExamDurationIsNotNull() {
            addCriterion("exam_duration is not null");
            return (Criteria) this;
        }

        public Criteria andExamDurationEqualTo(Integer value) {
            addCriterion("exam_duration =", value, "examDuration");
            return (Criteria) this;
        }

        public Criteria andExamDurationNotEqualTo(Integer value) {
            addCriterion("exam_duration <>", value, "examDuration");
            return (Criteria) this;
        }

        public Criteria andExamDurationGreaterThan(Integer value) {
            addCriterion("exam_duration >", value, "examDuration");
            return (Criteria) this;
        }

        public Criteria andExamDurationGreaterThanOrEqualTo(Integer value) {
            addCriterion("exam_duration >=", value, "examDuration");
            return (Criteria) this;
        }

        public Criteria andExamDurationLessThan(Integer value) {
            addCriterion("exam_duration <", value, "examDuration");
            return (Criteria) this;
        }

        public Criteria andExamDurationLessThanOrEqualTo(Integer value) {
            addCriterion("exam_duration <=", value, "examDuration");
            return (Criteria) this;
        }

        public Criteria andExamDurationIn(List<Integer> values) {
            addCriterion("exam_duration in", values, "examDuration");
            return (Criteria) this;
        }

        public Criteria andExamDurationNotIn(List<Integer> values) {
            addCriterion("exam_duration not in", values, "examDuration");
            return (Criteria) this;
        }

        public Criteria andExamDurationBetween(Integer value1, Integer value2) {
            addCriterion("exam_duration between", value1, value2, "examDuration");
            return (Criteria) this;
        }

        public Criteria andExamDurationNotBetween(Integer value1, Integer value2) {
            addCriterion("exam_duration not between", value1, value2, "examDuration");
            return (Criteria) this;
        }

        public Criteria andExamScoreIsNull() {
            addCriterion("exam_score is null");
            return (Criteria) this;
        }

        public Criteria andExamScoreIsNotNull() {
            addCriterion("exam_score is not null");
            return (Criteria) this;
        }

        public Criteria andExamScoreEqualTo(Double value) {
            addCriterion("exam_score =", value, "examScore");
            return (Criteria) this;
        }

        public Criteria andExamScoreNotEqualTo(Double value) {
            addCriterion("exam_score <>", value, "examScore");
            return (Criteria) this;
        }

        public Criteria andExamScoreGreaterThan(Double value) {
            addCriterion("exam_score >", value, "examScore");
            return (Criteria) this;
        }

        public Criteria andExamScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("exam_score >=", value, "examScore");
            return (Criteria) this;
        }

        public Criteria andExamScoreLessThan(Double value) {
            addCriterion("exam_score <", value, "examScore");
            return (Criteria) this;
        }

        public Criteria andExamScoreLessThanOrEqualTo(Double value) {
            addCriterion("exam_score <=", value, "examScore");
            return (Criteria) this;
        }

        public Criteria andExamScoreIn(List<Double> values) {
            addCriterion("exam_score in", values, "examScore");
            return (Criteria) this;
        }

        public Criteria andExamScoreNotIn(List<Double> values) {
            addCriterion("exam_score not in", values, "examScore");
            return (Criteria) this;
        }

        public Criteria andExamScoreBetween(Double value1, Double value2) {
            addCriterion("exam_score between", value1, value2, "examScore");
            return (Criteria) this;
        }

        public Criteria andExamScoreNotBetween(Double value1, Double value2) {
            addCriterion("exam_score not between", value1, value2, "examScore");
            return (Criteria) this;
        }

        public Criteria andExamPassScoreIsNull() {
            addCriterion("exam_pass_score is null");
            return (Criteria) this;
        }

        public Criteria andExamPassScoreIsNotNull() {
            addCriterion("exam_pass_score is not null");
            return (Criteria) this;
        }

        public Criteria andExamPassScoreEqualTo(Double value) {
            addCriterion("exam_pass_score =", value, "examPassScore");
            return (Criteria) this;
        }

        public Criteria andExamPassScoreNotEqualTo(Double value) {
            addCriterion("exam_pass_score <>", value, "examPassScore");
            return (Criteria) this;
        }

        public Criteria andExamPassScoreGreaterThan(Double value) {
            addCriterion("exam_pass_score >", value, "examPassScore");
            return (Criteria) this;
        }

        public Criteria andExamPassScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("exam_pass_score >=", value, "examPassScore");
            return (Criteria) this;
        }

        public Criteria andExamPassScoreLessThan(Double value) {
            addCriterion("exam_pass_score <", value, "examPassScore");
            return (Criteria) this;
        }

        public Criteria andExamPassScoreLessThanOrEqualTo(Double value) {
            addCriterion("exam_pass_score <=", value, "examPassScore");
            return (Criteria) this;
        }

        public Criteria andExamPassScoreIn(List<Double> values) {
            addCriterion("exam_pass_score in", values, "examPassScore");
            return (Criteria) this;
        }

        public Criteria andExamPassScoreNotIn(List<Double> values) {
            addCriterion("exam_pass_score not in", values, "examPassScore");
            return (Criteria) this;
        }

        public Criteria andExamPassScoreBetween(Double value1, Double value2) {
            addCriterion("exam_pass_score between", value1, value2, "examPassScore");
            return (Criteria) this;
        }

        public Criteria andExamPassScoreNotBetween(Double value1, Double value2) {
            addCriterion("exam_pass_score not between", value1, value2, "examPassScore");
            return (Criteria) this;
        }

        public Criteria andExamPasswordIsNull() {
            addCriterion("exam_password is null");
            return (Criteria) this;
        }

        public Criteria andExamPasswordIsNotNull() {
            addCriterion("exam_password is not null");
            return (Criteria) this;
        }

        public Criteria andExamPasswordEqualTo(String value) {
            addCriterion("exam_password =", value, "examPassword");
            return (Criteria) this;
        }

        public Criteria andExamPasswordNotEqualTo(String value) {
            addCriterion("exam_password <>", value, "examPassword");
            return (Criteria) this;
        }

        public Criteria andExamPasswordGreaterThan(String value) {
            addCriterion("exam_password >", value, "examPassword");
            return (Criteria) this;
        }

        public Criteria andExamPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("exam_password >=", value, "examPassword");
            return (Criteria) this;
        }

        public Criteria andExamPasswordLessThan(String value) {
            addCriterion("exam_password <", value, "examPassword");
            return (Criteria) this;
        }

        public Criteria andExamPasswordLessThanOrEqualTo(String value) {
            addCriterion("exam_password <=", value, "examPassword");
            return (Criteria) this;
        }

        public Criteria andExamPasswordLike(String value) {
            addCriterion("exam_password like", value, "examPassword");
            return (Criteria) this;
        }

        public Criteria andExamPasswordNotLike(String value) {
            addCriterion("exam_password not like", value, "examPassword");
            return (Criteria) this;
        }

        public Criteria andExamPasswordIn(List<String> values) {
            addCriterion("exam_password in", values, "examPassword");
            return (Criteria) this;
        }

        public Criteria andExamPasswordNotIn(List<String> values) {
            addCriterion("exam_password not in", values, "examPassword");
            return (Criteria) this;
        }

        public Criteria andExamPasswordBetween(String value1, String value2) {
            addCriterion("exam_password between", value1, value2, "examPassword");
            return (Criteria) this;
        }

        public Criteria andExamPasswordNotBetween(String value1, String value2) {
            addCriterion("exam_password not between", value1, value2, "examPassword");
            return (Criteria) this;
        }

        public Criteria andExamTypeIsNull() {
            addCriterion("exam_type is null");
            return (Criteria) this;
        }

        public Criteria andExamTypeIsNotNull() {
            addCriterion("exam_type is not null");
            return (Criteria) this;
        }

        public Criteria andExamTypeEqualTo(String value) {
            addCriterion("exam_type =", value, "examType");
            return (Criteria) this;
        }

        public Criteria andExamTypeNotEqualTo(String value) {
            addCriterion("exam_type <>", value, "examType");
            return (Criteria) this;
        }

        public Criteria andExamTypeGreaterThan(String value) {
            addCriterion("exam_type >", value, "examType");
            return (Criteria) this;
        }

        public Criteria andExamTypeGreaterThanOrEqualTo(String value) {
            addCriterion("exam_type >=", value, "examType");
            return (Criteria) this;
        }

        public Criteria andExamTypeLessThan(String value) {
            addCriterion("exam_type <", value, "examType");
            return (Criteria) this;
        }

        public Criteria andExamTypeLessThanOrEqualTo(String value) {
            addCriterion("exam_type <=", value, "examType");
            return (Criteria) this;
        }

        public Criteria andExamTypeLike(String value) {
            addCriterion("exam_type like", value, "examType");
            return (Criteria) this;
        }

        public Criteria andExamTypeNotLike(String value) {
            addCriterion("exam_type not like", value, "examType");
            return (Criteria) this;
        }

        public Criteria andExamTypeIn(List<String> values) {
            addCriterion("exam_type in", values, "examType");
            return (Criteria) this;
        }

        public Criteria andExamTypeNotIn(List<String> values) {
            addCriterion("exam_type not in", values, "examType");
            return (Criteria) this;
        }

        public Criteria andExamTypeBetween(String value1, String value2) {
            addCriterion("exam_type between", value1, value2, "examType");
            return (Criteria) this;
        }

        public Criteria andExamTypeNotBetween(String value1, String value2) {
            addCriterion("exam_type not between", value1, value2, "examType");
            return (Criteria) this;
        }

        public Criteria andExamQcodeUrlIsNull() {
            addCriterion("exam_qcode_url is null");
            return (Criteria) this;
        }

        public Criteria andExamQcodeUrlIsNotNull() {
            addCriterion("exam_qcode_url is not null");
            return (Criteria) this;
        }

        public Criteria andExamQcodeUrlEqualTo(String value) {
            addCriterion("exam_qcode_url =", value, "examQcodeUrl");
            return (Criteria) this;
        }

        public Criteria andExamQcodeUrlNotEqualTo(String value) {
            addCriterion("exam_qcode_url <>", value, "examQcodeUrl");
            return (Criteria) this;
        }

        public Criteria andExamQcodeUrlGreaterThan(String value) {
            addCriterion("exam_qcode_url >", value, "examQcodeUrl");
            return (Criteria) this;
        }

        public Criteria andExamQcodeUrlGreaterThanOrEqualTo(String value) {
            addCriterion("exam_qcode_url >=", value, "examQcodeUrl");
            return (Criteria) this;
        }

        public Criteria andExamQcodeUrlLessThan(String value) {
            addCriterion("exam_qcode_url <", value, "examQcodeUrl");
            return (Criteria) this;
        }

        public Criteria andExamQcodeUrlLessThanOrEqualTo(String value) {
            addCriterion("exam_qcode_url <=", value, "examQcodeUrl");
            return (Criteria) this;
        }

        public Criteria andExamQcodeUrlLike(String value) {
            addCriterion("exam_qcode_url like", value, "examQcodeUrl");
            return (Criteria) this;
        }

        public Criteria andExamQcodeUrlNotLike(String value) {
            addCriterion("exam_qcode_url not like", value, "examQcodeUrl");
            return (Criteria) this;
        }

        public Criteria andExamQcodeUrlIn(List<String> values) {
            addCriterion("exam_qcode_url in", values, "examQcodeUrl");
            return (Criteria) this;
        }

        public Criteria andExamQcodeUrlNotIn(List<String> values) {
            addCriterion("exam_qcode_url not in", values, "examQcodeUrl");
            return (Criteria) this;
        }

        public Criteria andExamQcodeUrlBetween(String value1, String value2) {
            addCriterion("exam_qcode_url between", value1, value2, "examQcodeUrl");
            return (Criteria) this;
        }

        public Criteria andExamQcodeUrlNotBetween(String value1, String value2) {
            addCriterion("exam_qcode_url not between", value1, value2, "examQcodeUrl");
            return (Criteria) this;
        }

        public Criteria andExamUrlIsNull() {
            addCriterion("exam_url is null");
            return (Criteria) this;
        }

        public Criteria andExamUrlIsNotNull() {
            addCriterion("exam_url is not null");
            return (Criteria) this;
        }

        public Criteria andExamUrlEqualTo(String value) {
            addCriterion("exam_url =", value, "examUrl");
            return (Criteria) this;
        }

        public Criteria andExamUrlNotEqualTo(String value) {
            addCriterion("exam_url <>", value, "examUrl");
            return (Criteria) this;
        }

        public Criteria andExamUrlGreaterThan(String value) {
            addCriterion("exam_url >", value, "examUrl");
            return (Criteria) this;
        }

        public Criteria andExamUrlGreaterThanOrEqualTo(String value) {
            addCriterion("exam_url >=", value, "examUrl");
            return (Criteria) this;
        }

        public Criteria andExamUrlLessThan(String value) {
            addCriterion("exam_url <", value, "examUrl");
            return (Criteria) this;
        }

        public Criteria andExamUrlLessThanOrEqualTo(String value) {
            addCriterion("exam_url <=", value, "examUrl");
            return (Criteria) this;
        }

        public Criteria andExamUrlLike(String value) {
            addCriterion("exam_url like", value, "examUrl");
            return (Criteria) this;
        }

        public Criteria andExamUrlNotLike(String value) {
            addCriterion("exam_url not like", value, "examUrl");
            return (Criteria) this;
        }

        public Criteria andExamUrlIn(List<String> values) {
            addCriterion("exam_url in", values, "examUrl");
            return (Criteria) this;
        }

        public Criteria andExamUrlNotIn(List<String> values) {
            addCriterion("exam_url not in", values, "examUrl");
            return (Criteria) this;
        }

        public Criteria andExamUrlBetween(String value1, String value2) {
            addCriterion("exam_url between", value1, value2, "examUrl");
            return (Criteria) this;
        }

        public Criteria andExamUrlNotBetween(String value1, String value2) {
            addCriterion("exam_url not between", value1, value2, "examUrl");
            return (Criteria) this;
        }

        public Criteria andExamStatusIsNull() {
            addCriterion("exam_status is null");
            return (Criteria) this;
        }

        public Criteria andExamStatusIsNotNull() {
            addCriterion("exam_status is not null");
            return (Criteria) this;
        }

        public Criteria andExamStatusEqualTo(String value) {
            addCriterion("exam_status =", value, "examStatus");
            return (Criteria) this;
        }

        public Criteria andExamStatusNotEqualTo(String value) {
            addCriterion("exam_status <>", value, "examStatus");
            return (Criteria) this;
        }

        public Criteria andExamStatusGreaterThan(String value) {
            addCriterion("exam_status >", value, "examStatus");
            return (Criteria) this;
        }

        public Criteria andExamStatusGreaterThanOrEqualTo(String value) {
            addCriterion("exam_status >=", value, "examStatus");
            return (Criteria) this;
        }

        public Criteria andExamStatusLessThan(String value) {
            addCriterion("exam_status <", value, "examStatus");
            return (Criteria) this;
        }

        public Criteria andExamStatusLessThanOrEqualTo(String value) {
            addCriterion("exam_status <=", value, "examStatus");
            return (Criteria) this;
        }

        public Criteria andExamStatusLike(String value) {
            addCriterion("exam_status like", value, "examStatus");
            return (Criteria) this;
        }

        public Criteria andExamStatusNotLike(String value) {
            addCriterion("exam_status not like", value, "examStatus");
            return (Criteria) this;
        }

        public Criteria andExamStatusIn(List<String> values) {
            addCriterion("exam_status in", values, "examStatus");
            return (Criteria) this;
        }

        public Criteria andExamStatusNotIn(List<String> values) {
            addCriterion("exam_status not in", values, "examStatus");
            return (Criteria) this;
        }

        public Criteria andExamStatusBetween(String value1, String value2) {
            addCriterion("exam_status between", value1, value2, "examStatus");
            return (Criteria) this;
        }

        public Criteria andExamStatusNotBetween(String value1, String value2) {
            addCriterion("exam_status not between", value1, value2, "examStatus");
            return (Criteria) this;
        }

        public Criteria andExamCompletedIsNull() {
            addCriterion("exam_completed is null");
            return (Criteria) this;
        }

        public Criteria andExamCompletedIsNotNull() {
            addCriterion("exam_completed is not null");
            return (Criteria) this;
        }

        public Criteria andExamCompletedEqualTo(String value) {
            addCriterion("exam_completed =", value, "examCompleted");
            return (Criteria) this;
        }

        public Criteria andExamCompletedNotEqualTo(String value) {
            addCriterion("exam_completed <>", value, "examCompleted");
            return (Criteria) this;
        }

        public Criteria andExamCompletedGreaterThan(String value) {
            addCriterion("exam_completed >", value, "examCompleted");
            return (Criteria) this;
        }

        public Criteria andExamCompletedGreaterThanOrEqualTo(String value) {
            addCriterion("exam_completed >=", value, "examCompleted");
            return (Criteria) this;
        }

        public Criteria andExamCompletedLessThan(String value) {
            addCriterion("exam_completed <", value, "examCompleted");
            return (Criteria) this;
        }

        public Criteria andExamCompletedLessThanOrEqualTo(String value) {
            addCriterion("exam_completed <=", value, "examCompleted");
            return (Criteria) this;
        }

        public Criteria andExamCompletedLike(String value) {
            addCriterion("exam_completed like", value, "examCompleted");
            return (Criteria) this;
        }

        public Criteria andExamCompletedNotLike(String value) {
            addCriterion("exam_completed not like", value, "examCompleted");
            return (Criteria) this;
        }

        public Criteria andExamCompletedIn(List<String> values) {
            addCriterion("exam_completed in", values, "examCompleted");
            return (Criteria) this;
        }

        public Criteria andExamCompletedNotIn(List<String> values) {
            addCriterion("exam_completed not in", values, "examCompleted");
            return (Criteria) this;
        }

        public Criteria andExamCompletedBetween(String value1, String value2) {
            addCriterion("exam_completed between", value1, value2, "examCompleted");
            return (Criteria) this;
        }

        public Criteria andExamCompletedNotBetween(String value1, String value2) {
            addCriterion("exam_completed not between", value1, value2, "examCompleted");
            return (Criteria) this;
        }

        public Criteria andCheckAnsIsNull() {
            addCriterion("check_ans is null");
            return (Criteria) this;
        }

        public Criteria andCheckAnsIsNotNull() {
            addCriterion("check_ans is not null");
            return (Criteria) this;
        }

        public Criteria andCheckAnsEqualTo(String value) {
            addCriterion("check_ans =", value, "checkAns");
            return (Criteria) this;
        }

        public Criteria andCheckAnsNotEqualTo(String value) {
            addCriterion("check_ans <>", value, "checkAns");
            return (Criteria) this;
        }

        public Criteria andCheckAnsGreaterThan(String value) {
            addCriterion("check_ans >", value, "checkAns");
            return (Criteria) this;
        }

        public Criteria andCheckAnsGreaterThanOrEqualTo(String value) {
            addCriterion("check_ans >=", value, "checkAns");
            return (Criteria) this;
        }

        public Criteria andCheckAnsLessThan(String value) {
            addCriterion("check_ans <", value, "checkAns");
            return (Criteria) this;
        }

        public Criteria andCheckAnsLessThanOrEqualTo(String value) {
            addCriterion("check_ans <=", value, "checkAns");
            return (Criteria) this;
        }

        public Criteria andCheckAnsLike(String value) {
            addCriterion("check_ans like", value, "checkAns");
            return (Criteria) this;
        }

        public Criteria andCheckAnsNotLike(String value) {
            addCriterion("check_ans not like", value, "checkAns");
            return (Criteria) this;
        }

        public Criteria andCheckAnsIn(List<String> values) {
            addCriterion("check_ans in", values, "checkAns");
            return (Criteria) this;
        }

        public Criteria andCheckAnsNotIn(List<String> values) {
            addCriterion("check_ans not in", values, "checkAns");
            return (Criteria) this;
        }

        public Criteria andCheckAnsBetween(String value1, String value2) {
            addCriterion("check_ans between", value1, value2, "checkAns");
            return (Criteria) this;
        }

        public Criteria andCheckAnsNotBetween(String value1, String value2) {
            addCriterion("check_ans not between", value1, value2, "checkAns");
            return (Criteria) this;
        }

        public Criteria andExamPassTipsIsNull() {
            addCriterion("exam_pass_tips is null");
            return (Criteria) this;
        }

        public Criteria andExamPassTipsIsNotNull() {
            addCriterion("exam_pass_tips is not null");
            return (Criteria) this;
        }

        public Criteria andExamPassTipsEqualTo(String value) {
            addCriterion("exam_pass_tips =", value, "examPassTips");
            return (Criteria) this;
        }

        public Criteria andExamPassTipsNotEqualTo(String value) {
            addCriterion("exam_pass_tips <>", value, "examPassTips");
            return (Criteria) this;
        }

        public Criteria andExamPassTipsGreaterThan(String value) {
            addCriterion("exam_pass_tips >", value, "examPassTips");
            return (Criteria) this;
        }

        public Criteria andExamPassTipsGreaterThanOrEqualTo(String value) {
            addCriterion("exam_pass_tips >=", value, "examPassTips");
            return (Criteria) this;
        }

        public Criteria andExamPassTipsLessThan(String value) {
            addCriterion("exam_pass_tips <", value, "examPassTips");
            return (Criteria) this;
        }

        public Criteria andExamPassTipsLessThanOrEqualTo(String value) {
            addCriterion("exam_pass_tips <=", value, "examPassTips");
            return (Criteria) this;
        }

        public Criteria andExamPassTipsLike(String value) {
            addCriterion("exam_pass_tips like", value, "examPassTips");
            return (Criteria) this;
        }

        public Criteria andExamPassTipsNotLike(String value) {
            addCriterion("exam_pass_tips not like", value, "examPassTips");
            return (Criteria) this;
        }

        public Criteria andExamPassTipsIn(List<String> values) {
            addCriterion("exam_pass_tips in", values, "examPassTips");
            return (Criteria) this;
        }

        public Criteria andExamPassTipsNotIn(List<String> values) {
            addCriterion("exam_pass_tips not in", values, "examPassTips");
            return (Criteria) this;
        }

        public Criteria andExamPassTipsBetween(String value1, String value2) {
            addCriterion("exam_pass_tips between", value1, value2, "examPassTips");
            return (Criteria) this;
        }

        public Criteria andExamPassTipsNotBetween(String value1, String value2) {
            addCriterion("exam_pass_tips not between", value1, value2, "examPassTips");
            return (Criteria) this;
        }

        public Criteria andExamNopassTipsIsNull() {
            addCriterion("exam_nopass_tips is null");
            return (Criteria) this;
        }

        public Criteria andExamNopassTipsIsNotNull() {
            addCriterion("exam_nopass_tips is not null");
            return (Criteria) this;
        }

        public Criteria andExamNopassTipsEqualTo(String value) {
            addCriterion("exam_nopass_tips =", value, "examNopassTips");
            return (Criteria) this;
        }

        public Criteria andExamNopassTipsNotEqualTo(String value) {
            addCriterion("exam_nopass_tips <>", value, "examNopassTips");
            return (Criteria) this;
        }

        public Criteria andExamNopassTipsGreaterThan(String value) {
            addCriterion("exam_nopass_tips >", value, "examNopassTips");
            return (Criteria) this;
        }

        public Criteria andExamNopassTipsGreaterThanOrEqualTo(String value) {
            addCriterion("exam_nopass_tips >=", value, "examNopassTips");
            return (Criteria) this;
        }

        public Criteria andExamNopassTipsLessThan(String value) {
            addCriterion("exam_nopass_tips <", value, "examNopassTips");
            return (Criteria) this;
        }

        public Criteria andExamNopassTipsLessThanOrEqualTo(String value) {
            addCriterion("exam_nopass_tips <=", value, "examNopassTips");
            return (Criteria) this;
        }

        public Criteria andExamNopassTipsLike(String value) {
            addCriterion("exam_nopass_tips like", value, "examNopassTips");
            return (Criteria) this;
        }

        public Criteria andExamNopassTipsNotLike(String value) {
            addCriterion("exam_nopass_tips not like", value, "examNopassTips");
            return (Criteria) this;
        }

        public Criteria andExamNopassTipsIn(List<String> values) {
            addCriterion("exam_nopass_tips in", values, "examNopassTips");
            return (Criteria) this;
        }

        public Criteria andExamNopassTipsNotIn(List<String> values) {
            addCriterion("exam_nopass_tips not in", values, "examNopassTips");
            return (Criteria) this;
        }

        public Criteria andExamNopassTipsBetween(String value1, String value2) {
            addCriterion("exam_nopass_tips between", value1, value2, "examNopassTips");
            return (Criteria) this;
        }

        public Criteria andExamNopassTipsNotBetween(String value1, String value2) {
            addCriterion("exam_nopass_tips not between", value1, value2, "examNopassTips");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(String value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(String value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(String value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(String value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(String value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLike(String value) {
            addCriterion("create_time like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotLike(String value) {
            addCriterion("create_time not like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<String> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<String> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(String value1, String value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(String value1, String value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andAdminIdIsNull() {
            addCriterion("admin_id is null");
            return (Criteria) this;
        }

        public Criteria andAdminIdIsNotNull() {
            addCriterion("admin_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdminIdEqualTo(Integer value) {
            addCriterion("admin_id =", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotEqualTo(Integer value) {
            addCriterion("admin_id <>", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdGreaterThan(Integer value) {
            addCriterion("admin_id >", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("admin_id >=", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdLessThan(Integer value) {
            addCriterion("admin_id <", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdLessThanOrEqualTo(Integer value) {
            addCriterion("admin_id <=", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdIn(List<Integer> values) {
            addCriterion("admin_id in", values, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotIn(List<Integer> values) {
            addCriterion("admin_id not in", values, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdBetween(Integer value1, Integer value2) {
            addCriterion("admin_id between", value1, value2, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotBetween(Integer value1, Integer value2) {
            addCriterion("admin_id not between", value1, value2, "adminId");
            return (Criteria) this;
        }

        public Criteria andExamNoticeIsNull() {
            addCriterion("exam_notice is null");
            return (Criteria) this;
        }

        public Criteria andExamNoticeIsNotNull() {
            addCriterion("exam_notice is not null");
            return (Criteria) this;
        }

        public Criteria andExamNoticeEqualTo(String value) {
            addCriterion("exam_notice =", value, "examNotice");
            return (Criteria) this;
        }

        public Criteria andExamNoticeNotEqualTo(String value) {
            addCriterion("exam_notice <>", value, "examNotice");
            return (Criteria) this;
        }

        public Criteria andExamNoticeGreaterThan(String value) {
            addCriterion("exam_notice >", value, "examNotice");
            return (Criteria) this;
        }

        public Criteria andExamNoticeGreaterThanOrEqualTo(String value) {
            addCriterion("exam_notice >=", value, "examNotice");
            return (Criteria) this;
        }

        public Criteria andExamNoticeLessThan(String value) {
            addCriterion("exam_notice <", value, "examNotice");
            return (Criteria) this;
        }

        public Criteria andExamNoticeLessThanOrEqualTo(String value) {
            addCriterion("exam_notice <=", value, "examNotice");
            return (Criteria) this;
        }

        public Criteria andExamNoticeLike(String value) {
            addCriterion("exam_notice like", value, "examNotice");
            return (Criteria) this;
        }

        public Criteria andExamNoticeNotLike(String value) {
            addCriterion("exam_notice not like", value, "examNotice");
            return (Criteria) this;
        }

        public Criteria andExamNoticeIn(List<String> values) {
            addCriterion("exam_notice in", values, "examNotice");
            return (Criteria) this;
        }

        public Criteria andExamNoticeNotIn(List<String> values) {
            addCriterion("exam_notice not in", values, "examNotice");
            return (Criteria) this;
        }

        public Criteria andExamNoticeBetween(String value1, String value2) {
            addCriterion("exam_notice between", value1, value2, "examNotice");
            return (Criteria) this;
        }

        public Criteria andExamNoticeNotBetween(String value1, String value2) {
            addCriterion("exam_notice not between", value1, value2, "examNotice");
            return (Criteria) this;
        }

        public Criteria andProIdIsNull() {
            addCriterion("pro_id is null");
            return (Criteria) this;
        }

        public Criteria andProIdIsNotNull() {
            addCriterion("pro_id is not null");
            return (Criteria) this;
        }

        public Criteria andProIdEqualTo(Integer value) {
            addCriterion("pro_id =", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdNotEqualTo(Integer value) {
            addCriterion("pro_id <>", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdGreaterThan(Integer value) {
            addCriterion("pro_id >", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("pro_id >=", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdLessThan(Integer value) {
            addCriterion("pro_id <", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdLessThanOrEqualTo(Integer value) {
            addCriterion("pro_id <=", value, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdIn(List<Integer> values) {
            addCriterion("pro_id in", values, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdNotIn(List<Integer> values) {
            addCriterion("pro_id not in", values, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdBetween(Integer value1, Integer value2) {
            addCriterion("pro_id between", value1, value2, "proId");
            return (Criteria) this;
        }

        public Criteria andProIdNotBetween(Integer value1, Integer value2) {
            addCriterion("pro_id not between", value1, value2, "proId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}