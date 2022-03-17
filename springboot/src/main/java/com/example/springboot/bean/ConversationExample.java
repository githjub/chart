package com.example.springboot.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ConversationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ConversationExample() {
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

        public Criteria andNickNameIsNull() {
            addCriterion("nick_name is null");
            return (Criteria) this;
        }

        public Criteria andNickNameIsNotNull() {
            addCriterion("nick_name is not null");
            return (Criteria) this;
        }

        public Criteria andNickNameEqualTo(String value) {
            addCriterion("nick_name =", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotEqualTo(String value) {
            addCriterion("nick_name <>", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameGreaterThan(String value) {
            addCriterion("nick_name >", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameGreaterThanOrEqualTo(String value) {
            addCriterion("nick_name >=", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLessThan(String value) {
            addCriterion("nick_name <", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLessThanOrEqualTo(String value) {
            addCriterion("nick_name <=", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLike(String value) {
            addCriterion("nick_name like", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotLike(String value) {
            addCriterion("nick_name not like", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameIn(List<String> values) {
            addCriterion("nick_name in", values, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotIn(List<String> values) {
            addCriterion("nick_name not in", values, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameBetween(String value1, String value2) {
            addCriterion("nick_name between", value1, value2, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotBetween(String value1, String value2) {
            addCriterion("nick_name not between", value1, value2, "nickName");
            return (Criteria) this;
        }

        public Criteria andCountIdIsNull() {
            addCriterion("count_id is null");
            return (Criteria) this;
        }

        public Criteria andCountIdIsNotNull() {
            addCriterion("count_id is not null");
            return (Criteria) this;
        }

        public Criteria andCountIdEqualTo(String value) {
            addCriterion("count_id =", value, "countId");
            return (Criteria) this;
        }

        public Criteria andCountIdNotEqualTo(String value) {
            addCriterion("count_id <>", value, "countId");
            return (Criteria) this;
        }

        public Criteria andCountIdGreaterThan(String value) {
            addCriterion("count_id >", value, "countId");
            return (Criteria) this;
        }

        public Criteria andCountIdGreaterThanOrEqualTo(String value) {
            addCriterion("count_id >=", value, "countId");
            return (Criteria) this;
        }

        public Criteria andCountIdLessThan(String value) {
            addCriterion("count_id <", value, "countId");
            return (Criteria) this;
        }

        public Criteria andCountIdLessThanOrEqualTo(String value) {
            addCriterion("count_id <=", value, "countId");
            return (Criteria) this;
        }

        public Criteria andCountIdLike(String value) {
            addCriterion("count_id like", value, "countId");
            return (Criteria) this;
        }

        public Criteria andCountIdNotLike(String value) {
            addCriterion("count_id not like", value, "countId");
            return (Criteria) this;
        }

        public Criteria andCountIdIn(List<String> values) {
            addCriterion("count_id in", values, "countId");
            return (Criteria) this;
        }

        public Criteria andCountIdNotIn(List<String> values) {
            addCriterion("count_id not in", values, "countId");
            return (Criteria) this;
        }

        public Criteria andCountIdBetween(String value1, String value2) {
            addCriterion("count_id between", value1, value2, "countId");
            return (Criteria) this;
        }

        public Criteria andCountIdNotBetween(String value1, String value2) {
            addCriterion("count_id not between", value1, value2, "countId");
            return (Criteria) this;
        }

        public Criteria andLatestMessageIsNull() {
            addCriterion("latest_message is null");
            return (Criteria) this;
        }

        public Criteria andLatestMessageIsNotNull() {
            addCriterion("latest_message is not null");
            return (Criteria) this;
        }

        public Criteria andLatestMessageEqualTo(String value) {
            addCriterion("latest_message =", value, "latestMessage");
            return (Criteria) this;
        }

        public Criteria andLatestMessageNotEqualTo(String value) {
            addCriterion("latest_message <>", value, "latestMessage");
            return (Criteria) this;
        }

        public Criteria andLatestMessageGreaterThan(String value) {
            addCriterion("latest_message >", value, "latestMessage");
            return (Criteria) this;
        }

        public Criteria andLatestMessageGreaterThanOrEqualTo(String value) {
            addCriterion("latest_message >=", value, "latestMessage");
            return (Criteria) this;
        }

        public Criteria andLatestMessageLessThan(String value) {
            addCriterion("latest_message <", value, "latestMessage");
            return (Criteria) this;
        }

        public Criteria andLatestMessageLessThanOrEqualTo(String value) {
            addCriterion("latest_message <=", value, "latestMessage");
            return (Criteria) this;
        }

        public Criteria andLatestMessageLike(String value) {
            addCriterion("latest_message like", value, "latestMessage");
            return (Criteria) this;
        }

        public Criteria andLatestMessageNotLike(String value) {
            addCriterion("latest_message not like", value, "latestMessage");
            return (Criteria) this;
        }

        public Criteria andLatestMessageIn(List<String> values) {
            addCriterion("latest_message in", values, "latestMessage");
            return (Criteria) this;
        }

        public Criteria andLatestMessageNotIn(List<String> values) {
            addCriterion("latest_message not in", values, "latestMessage");
            return (Criteria) this;
        }

        public Criteria andLatestMessageBetween(String value1, String value2) {
            addCriterion("latest_message between", value1, value2, "latestMessage");
            return (Criteria) this;
        }

        public Criteria andLatestMessageNotBetween(String value1, String value2) {
            addCriterion("latest_message not between", value1, value2, "latestMessage");
            return (Criteria) this;
        }

        public Criteria andLatestTimeIsNull() {
            addCriterion("latest_time is null");
            return (Criteria) this;
        }

        public Criteria andLatestTimeIsNotNull() {
            addCriterion("latest_time is not null");
            return (Criteria) this;
        }

        public Criteria andLatestTimeEqualTo(Date value) {
            addCriterion("latest_time =", value, "latestTime");
            return (Criteria) this;
        }

        public Criteria andLatestTimeNotEqualTo(Date value) {
            addCriterion("latest_time <>", value, "latestTime");
            return (Criteria) this;
        }

        public Criteria andLatestTimeGreaterThan(Date value) {
            addCriterion("latest_time >", value, "latestTime");
            return (Criteria) this;
        }

        public Criteria andLatestTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("latest_time >=", value, "latestTime");
            return (Criteria) this;
        }

        public Criteria andLatestTimeLessThan(Date value) {
            addCriterion("latest_time <", value, "latestTime");
            return (Criteria) this;
        }

        public Criteria andLatestTimeLessThanOrEqualTo(Date value) {
            addCriterion("latest_time <=", value, "latestTime");
            return (Criteria) this;
        }

        public Criteria andLatestTimeIn(List<Date> values) {
            addCriterion("latest_time in", values, "latestTime");
            return (Criteria) this;
        }

        public Criteria andLatestTimeNotIn(List<Date> values) {
            addCriterion("latest_time not in", values, "latestTime");
            return (Criteria) this;
        }

        public Criteria andLatestTimeBetween(Date value1, Date value2) {
            addCriterion("latest_time between", value1, value2, "latestTime");
            return (Criteria) this;
        }

        public Criteria andLatestTimeNotBetween(Date value1, Date value2) {
            addCriterion("latest_time not between", value1, value2, "latestTime");
            return (Criteria) this;
        }

        public Criteria andHeadimgIsNull() {
            addCriterion("headImg is null");
            return (Criteria) this;
        }

        public Criteria andHeadimgIsNotNull() {
            addCriterion("headImg is not null");
            return (Criteria) this;
        }

        public Criteria andHeadimgEqualTo(String value) {
            addCriterion("headImg =", value, "headimg");
            return (Criteria) this;
        }

        public Criteria andHeadimgNotEqualTo(String value) {
            addCriterion("headImg <>", value, "headimg");
            return (Criteria) this;
        }

        public Criteria andHeadimgGreaterThan(String value) {
            addCriterion("headImg >", value, "headimg");
            return (Criteria) this;
        }

        public Criteria andHeadimgGreaterThanOrEqualTo(String value) {
            addCriterion("headImg >=", value, "headimg");
            return (Criteria) this;
        }

        public Criteria andHeadimgLessThan(String value) {
            addCriterion("headImg <", value, "headimg");
            return (Criteria) this;
        }

        public Criteria andHeadimgLessThanOrEqualTo(String value) {
            addCriterion("headImg <=", value, "headimg");
            return (Criteria) this;
        }

        public Criteria andHeadimgLike(String value) {
            addCriterion("headImg like", value, "headimg");
            return (Criteria) this;
        }

        public Criteria andHeadimgNotLike(String value) {
            addCriterion("headImg not like", value, "headimg");
            return (Criteria) this;
        }

        public Criteria andHeadimgIn(List<String> values) {
            addCriterion("headImg in", values, "headimg");
            return (Criteria) this;
        }

        public Criteria andHeadimgNotIn(List<String> values) {
            addCriterion("headImg not in", values, "headimg");
            return (Criteria) this;
        }

        public Criteria andHeadimgBetween(String value1, String value2) {
            addCriterion("headImg between", value1, value2, "headimg");
            return (Criteria) this;
        }

        public Criteria andHeadimgNotBetween(String value1, String value2) {
            addCriterion("headImg not between", value1, value2, "headimg");
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