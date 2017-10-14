package com.why.Evaluation.dto;

import java.util.ArrayList;
import java.util.List;

public class BigquestionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BigquestionExample() {
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

        public Criteria andBigquestionIdIsNull() {
            addCriterion("bigquestion_id is null");
            return (Criteria) this;
        }

        public Criteria andBigquestionIdIsNotNull() {
            addCriterion("bigquestion_id is not null");
            return (Criteria) this;
        }

        public Criteria andBigquestionIdEqualTo(Integer value) {
            addCriterion("bigquestion_id =", value, "bigquestionId");
            return (Criteria) this;
        }

        public Criteria andBigquestionIdNotEqualTo(Integer value) {
            addCriterion("bigquestion_id <>", value, "bigquestionId");
            return (Criteria) this;
        }

        public Criteria andBigquestionIdGreaterThan(Integer value) {
            addCriterion("bigquestion_id >", value, "bigquestionId");
            return (Criteria) this;
        }

        public Criteria andBigquestionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("bigquestion_id >=", value, "bigquestionId");
            return (Criteria) this;
        }

        public Criteria andBigquestionIdLessThan(Integer value) {
            addCriterion("bigquestion_id <", value, "bigquestionId");
            return (Criteria) this;
        }

        public Criteria andBigquestionIdLessThanOrEqualTo(Integer value) {
            addCriterion("bigquestion_id <=", value, "bigquestionId");
            return (Criteria) this;
        }

        public Criteria andBigquestionIdIn(List<Integer> values) {
            addCriterion("bigquestion_id in", values, "bigquestionId");
            return (Criteria) this;
        }

        public Criteria andBigquestionIdNotIn(List<Integer> values) {
            addCriterion("bigquestion_id not in", values, "bigquestionId");
            return (Criteria) this;
        }

        public Criteria andBigquestionIdBetween(Integer value1, Integer value2) {
            addCriterion("bigquestion_id between", value1, value2, "bigquestionId");
            return (Criteria) this;
        }

        public Criteria andBigquestionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("bigquestion_id not between", value1, value2, "bigquestionId");
            return (Criteria) this;
        }

        public Criteria andPaperIdIsNull() {
            addCriterion("paper_id is null");
            return (Criteria) this;
        }

        public Criteria andPaperIdIsNotNull() {
            addCriterion("paper_id is not null");
            return (Criteria) this;
        }

        public Criteria andPaperIdEqualTo(Integer value) {
            addCriterion("paper_id =", value, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdNotEqualTo(Integer value) {
            addCriterion("paper_id <>", value, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdGreaterThan(Integer value) {
            addCriterion("paper_id >", value, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("paper_id >=", value, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdLessThan(Integer value) {
            addCriterion("paper_id <", value, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdLessThanOrEqualTo(Integer value) {
            addCriterion("paper_id <=", value, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdIn(List<Integer> values) {
            addCriterion("paper_id in", values, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdNotIn(List<Integer> values) {
            addCriterion("paper_id not in", values, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdBetween(Integer value1, Integer value2) {
            addCriterion("paper_id between", value1, value2, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdNotBetween(Integer value1, Integer value2) {
            addCriterion("paper_id not between", value1, value2, "paperId");
            return (Criteria) this;
        }

        public Criteria andBigquestionNIsNull() {
            addCriterion("bigquestion_n is null");
            return (Criteria) this;
        }

        public Criteria andBigquestionNIsNotNull() {
            addCriterion("bigquestion_n is not null");
            return (Criteria) this;
        }

        public Criteria andBigquestionNEqualTo(Integer value) {
            addCriterion("bigquestion_n =", value, "bigquestionN");
            return (Criteria) this;
        }

        public Criteria andBigquestionNNotEqualTo(Integer value) {
            addCriterion("bigquestion_n <>", value, "bigquestionN");
            return (Criteria) this;
        }

        public Criteria andBigquestionNGreaterThan(Integer value) {
            addCriterion("bigquestion_n >", value, "bigquestionN");
            return (Criteria) this;
        }

        public Criteria andBigquestionNGreaterThanOrEqualTo(Integer value) {
            addCriterion("bigquestion_n >=", value, "bigquestionN");
            return (Criteria) this;
        }

        public Criteria andBigquestionNLessThan(Integer value) {
            addCriterion("bigquestion_n <", value, "bigquestionN");
            return (Criteria) this;
        }

        public Criteria andBigquestionNLessThanOrEqualTo(Integer value) {
            addCriterion("bigquestion_n <=", value, "bigquestionN");
            return (Criteria) this;
        }

        public Criteria andBigquestionNIn(List<Integer> values) {
            addCriterion("bigquestion_n in", values, "bigquestionN");
            return (Criteria) this;
        }

        public Criteria andBigquestionNNotIn(List<Integer> values) {
            addCriterion("bigquestion_n not in", values, "bigquestionN");
            return (Criteria) this;
        }

        public Criteria andBigquestionNBetween(Integer value1, Integer value2) {
            addCriterion("bigquestion_n between", value1, value2, "bigquestionN");
            return (Criteria) this;
        }

        public Criteria andBigquestionNNotBetween(Integer value1, Integer value2) {
            addCriterion("bigquestion_n not between", value1, value2, "bigquestionN");
            return (Criteria) this;
        }

        public Criteria andQuestionIdsIsNull() {
            addCriterion("question_ids is null");
            return (Criteria) this;
        }

        public Criteria andQuestionIdsIsNotNull() {
            addCriterion("question_ids is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionIdsEqualTo(String value) {
            addCriterion("question_ids =", value, "questionIds");
            return (Criteria) this;
        }

        public Criteria andQuestionIdsNotEqualTo(String value) {
            addCriterion("question_ids <>", value, "questionIds");
            return (Criteria) this;
        }

        public Criteria andQuestionIdsGreaterThan(String value) {
            addCriterion("question_ids >", value, "questionIds");
            return (Criteria) this;
        }

        public Criteria andQuestionIdsGreaterThanOrEqualTo(String value) {
            addCriterion("question_ids >=", value, "questionIds");
            return (Criteria) this;
        }

        public Criteria andQuestionIdsLessThan(String value) {
            addCriterion("question_ids <", value, "questionIds");
            return (Criteria) this;
        }

        public Criteria andQuestionIdsLessThanOrEqualTo(String value) {
            addCriterion("question_ids <=", value, "questionIds");
            return (Criteria) this;
        }

        public Criteria andQuestionIdsLike(String value) {
            addCriterion("question_ids like", value, "questionIds");
            return (Criteria) this;
        }

        public Criteria andQuestionIdsNotLike(String value) {
            addCriterion("question_ids not like", value, "questionIds");
            return (Criteria) this;
        }

        public Criteria andQuestionIdsIn(List<String> values) {
            addCriterion("question_ids in", values, "questionIds");
            return (Criteria) this;
        }

        public Criteria andQuestionIdsNotIn(List<String> values) {
            addCriterion("question_ids not in", values, "questionIds");
            return (Criteria) this;
        }

        public Criteria andQuestionIdsBetween(String value1, String value2) {
            addCriterion("question_ids between", value1, value2, "questionIds");
            return (Criteria) this;
        }

        public Criteria andQuestionIdsNotBetween(String value1, String value2) {
            addCriterion("question_ids not between", value1, value2, "questionIds");
            return (Criteria) this;
        }

        public Criteria andBigquestionScoreIsNull() {
            addCriterion("bigquestion_score is null");
            return (Criteria) this;
        }

        public Criteria andBigquestionScoreIsNotNull() {
            addCriterion("bigquestion_score is not null");
            return (Criteria) this;
        }

        public Criteria andBigquestionScoreEqualTo(Double value) {
            addCriterion("bigquestion_score =", value, "bigquestionScore");
            return (Criteria) this;
        }

        public Criteria andBigquestionScoreNotEqualTo(Double value) {
            addCriterion("bigquestion_score <>", value, "bigquestionScore");
            return (Criteria) this;
        }

        public Criteria andBigquestionScoreGreaterThan(Double value) {
            addCriterion("bigquestion_score >", value, "bigquestionScore");
            return (Criteria) this;
        }

        public Criteria andBigquestionScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("bigquestion_score >=", value, "bigquestionScore");
            return (Criteria) this;
        }

        public Criteria andBigquestionScoreLessThan(Double value) {
            addCriterion("bigquestion_score <", value, "bigquestionScore");
            return (Criteria) this;
        }

        public Criteria andBigquestionScoreLessThanOrEqualTo(Double value) {
            addCriterion("bigquestion_score <=", value, "bigquestionScore");
            return (Criteria) this;
        }

        public Criteria andBigquestionScoreIn(List<Double> values) {
            addCriterion("bigquestion_score in", values, "bigquestionScore");
            return (Criteria) this;
        }

        public Criteria andBigquestionScoreNotIn(List<Double> values) {
            addCriterion("bigquestion_score not in", values, "bigquestionScore");
            return (Criteria) this;
        }

        public Criteria andBigquestionScoreBetween(Double value1, Double value2) {
            addCriterion("bigquestion_score between", value1, value2, "bigquestionScore");
            return (Criteria) this;
        }

        public Criteria andBigquestionScoreNotBetween(Double value1, Double value2) {
            addCriterion("bigquestion_score not between", value1, value2, "bigquestionScore");
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