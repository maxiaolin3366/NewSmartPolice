package cn.smartpolice.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MsgChatExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MsgChatExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
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

        public Criteria andChatidIsNull() {
            addCriterion("chatid is null");
            return (Criteria) this;
        }

        public Criteria andChatidIsNotNull() {
            addCriterion("chatid is not null");
            return (Criteria) this;
        }

        public Criteria andChatidEqualTo(Integer value) {
            addCriterion("chatid =", value, "chatid");
            return (Criteria) this;
        }

        public Criteria andChatidNotEqualTo(Integer value) {
            addCriterion("chatid <>", value, "chatid");
            return (Criteria) this;
        }

        public Criteria andChatidGreaterThan(Integer value) {
            addCriterion("chatid >", value, "chatid");
            return (Criteria) this;
        }

        public Criteria andChatidGreaterThanOrEqualTo(Integer value) {
            addCriterion("chatid >=", value, "chatid");
            return (Criteria) this;
        }

        public Criteria andChatidLessThan(Integer value) {
            addCriterion("chatid <", value, "chatid");
            return (Criteria) this;
        }

        public Criteria andChatidLessThanOrEqualTo(Integer value) {
            addCriterion("chatid <=", value, "chatid");
            return (Criteria) this;
        }

        public Criteria andChatidIn(List<Integer> values) {
            addCriterion("chatid in", values, "chatid");
            return (Criteria) this;
        }

        public Criteria andChatidNotIn(List<Integer> values) {
            addCriterion("chatid not in", values, "chatid");
            return (Criteria) this;
        }

        public Criteria andChatidBetween(Integer value1, Integer value2) {
            addCriterion("chatid between", value1, value2, "chatid");
            return (Criteria) this;
        }

        public Criteria andChatidNotBetween(Integer value1, Integer value2) {
            addCriterion("chatid not between", value1, value2, "chatid");
            return (Criteria) this;
        }

        public Criteria andSendidIsNull() {
            addCriterion("sendid is null");
            return (Criteria) this;
        }

        public Criteria andSendidIsNotNull() {
            addCriterion("sendid is not null");
            return (Criteria) this;
        }

        public Criteria andSendidEqualTo(Integer value) {
            addCriterion("sendid =", value, "sendid");
            return (Criteria) this;
        }

        public Criteria andSendidNotEqualTo(Integer value) {
            addCriterion("sendid <>", value, "sendid");
            return (Criteria) this;
        }

        public Criteria andSendidGreaterThan(Integer value) {
            addCriterion("sendid >", value, "sendid");
            return (Criteria) this;
        }

        public Criteria andSendidGreaterThanOrEqualTo(Integer value) {
            addCriterion("sendid >=", value, "sendid");
            return (Criteria) this;
        }

        public Criteria andSendidLessThan(Integer value) {
            addCriterion("sendid <", value, "sendid");
            return (Criteria) this;
        }

        public Criteria andSendidLessThanOrEqualTo(Integer value) {
            addCriterion("sendid <=", value, "sendid");
            return (Criteria) this;
        }

        public Criteria andSendidIn(List<Integer> values) {
            addCriterion("sendid in", values, "sendid");
            return (Criteria) this;
        }

        public Criteria andSendidNotIn(List<Integer> values) {
            addCriterion("sendid not in", values, "sendid");
            return (Criteria) this;
        }

        public Criteria andSendidBetween(Integer value1, Integer value2) {
            addCriterion("sendid between", value1, value2, "sendid");
            return (Criteria) this;
        }

        public Criteria andSendidNotBetween(Integer value1, Integer value2) {
            addCriterion("sendid not between", value1, value2, "sendid");
            return (Criteria) this;
        }

        public Criteria andRecvidIsNull() {
            addCriterion("recvid is null");
            return (Criteria) this;
        }

        public Criteria andRecvidIsNotNull() {
            addCriterion("recvid is not null");
            return (Criteria) this;
        }

        public Criteria andRecvidEqualTo(Integer value) {
            addCriterion("recvid =", value, "recvid");
            return (Criteria) this;
        }

        public Criteria andRecvidNotEqualTo(Integer value) {
            addCriterion("recvid <>", value, "recvid");
            return (Criteria) this;
        }

        public Criteria andRecvidGreaterThan(Integer value) {
            addCriterion("recvid >", value, "recvid");
            return (Criteria) this;
        }

        public Criteria andRecvidGreaterThanOrEqualTo(Integer value) {
            addCriterion("recvid >=", value, "recvid");
            return (Criteria) this;
        }

        public Criteria andRecvidLessThan(Integer value) {
            addCriterion("recvid <", value, "recvid");
            return (Criteria) this;
        }

        public Criteria andRecvidLessThanOrEqualTo(Integer value) {
            addCriterion("recvid <=", value, "recvid");
            return (Criteria) this;
        }

        public Criteria andRecvidIn(List<Integer> values) {
            addCriterion("recvid in", values, "recvid");
            return (Criteria) this;
        }

        public Criteria andRecvidNotIn(List<Integer> values) {
            addCriterion("recvid not in", values, "recvid");
            return (Criteria) this;
        }

        public Criteria andRecvidBetween(Integer value1, Integer value2) {
            addCriterion("recvid between", value1, value2, "recvid");
            return (Criteria) this;
        }

        public Criteria andRecvidNotBetween(Integer value1, Integer value2) {
            addCriterion("recvid not between", value1, value2, "recvid");
            return (Criteria) this;
        }

        public Criteria andSendtimeIsNull() {
            addCriterion("sendtime is null");
            return (Criteria) this;
        }

        public Criteria andSendtimeIsNotNull() {
            addCriterion("sendtime is not null");
            return (Criteria) this;
        }

        public Criteria andSendtimeEqualTo(Date value) {
            addCriterion("sendtime =", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeNotEqualTo(Date value) {
            addCriterion("sendtime <>", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeGreaterThan(Date value) {
            addCriterion("sendtime >", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sendtime >=", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeLessThan(Date value) {
            addCriterion("sendtime <", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeLessThanOrEqualTo(Date value) {
            addCriterion("sendtime <=", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeIn(List<Date> values) {
            addCriterion("sendtime in", values, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeNotIn(List<Date> values) {
            addCriterion("sendtime not in", values, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeBetween(Date value1, Date value2) {
            addCriterion("sendtime between", value1, value2, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeNotBetween(Date value1, Date value2) {
            addCriterion("sendtime not between", value1, value2, "sendtime");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andColorIsNull() {
            addCriterion("color is null");
            return (Criteria) this;
        }

        public Criteria andColorIsNotNull() {
            addCriterion("color is not null");
            return (Criteria) this;
        }

        public Criteria andColorEqualTo(String value) {
            addCriterion("color =", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotEqualTo(String value) {
            addCriterion("color <>", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorGreaterThan(String value) {
            addCriterion("color >", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorGreaterThanOrEqualTo(String value) {
            addCriterion("color >=", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLessThan(String value) {
            addCriterion("color <", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLessThanOrEqualTo(String value) {
            addCriterion("color <=", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLike(String value) {
            addCriterion("color like", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotLike(String value) {
            addCriterion("color not like", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorIn(List<String> values) {
            addCriterion("color in", values, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotIn(List<String> values) {
            addCriterion("color not in", values, "color");
            return (Criteria) this;
        }

        public Criteria andColorBetween(String value1, String value2) {
            addCriterion("color between", value1, value2, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotBetween(String value1, String value2) {
            addCriterion("color not between", value1, value2, "color");
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
    }
}