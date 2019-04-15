package cn.smartpolice.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MsgNoticeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MsgNoticeExample() {
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

        public Criteria andNoticeidIsNull() {
            addCriterion("noticeid is null");
            return (Criteria) this;
        }

        public Criteria andNoticeidIsNotNull() {
            addCriterion("noticeid is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeidEqualTo(Integer value) {
            addCriterion("noticeid =", value, "noticeid");
            return (Criteria) this;
        }

        public Criteria andNoticeidNotEqualTo(Integer value) {
            addCriterion("noticeid <>", value, "noticeid");
            return (Criteria) this;
        }

        public Criteria andNoticeidGreaterThan(Integer value) {
            addCriterion("noticeid >", value, "noticeid");
            return (Criteria) this;
        }

        public Criteria andNoticeidGreaterThanOrEqualTo(Integer value) {
            addCriterion("noticeid >=", value, "noticeid");
            return (Criteria) this;
        }

        public Criteria andNoticeidLessThan(Integer value) {
            addCriterion("noticeid <", value, "noticeid");
            return (Criteria) this;
        }

        public Criteria andNoticeidLessThanOrEqualTo(Integer value) {
            addCriterion("noticeid <=", value, "noticeid");
            return (Criteria) this;
        }

        public Criteria andNoticeidIn(List<Integer> values) {
            addCriterion("noticeid in", values, "noticeid");
            return (Criteria) this;
        }

        public Criteria andNoticeidNotIn(List<Integer> values) {
            addCriterion("noticeid not in", values, "noticeid");
            return (Criteria) this;
        }

        public Criteria andNoticeidBetween(Integer value1, Integer value2) {
            addCriterion("noticeid between", value1, value2, "noticeid");
            return (Criteria) this;
        }

        public Criteria andNoticeidNotBetween(Integer value1, Integer value2) {
            addCriterion("noticeid not between", value1, value2, "noticeid");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andMsgIsNull() {
            addCriterion("msg is null");
            return (Criteria) this;
        }

        public Criteria andMsgIsNotNull() {
            addCriterion("msg is not null");
            return (Criteria) this;
        }

        public Criteria andMsgEqualTo(String value) {
            addCriterion("msg =", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgNotEqualTo(String value) {
            addCriterion("msg <>", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgGreaterThan(String value) {
            addCriterion("msg >", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgGreaterThanOrEqualTo(String value) {
            addCriterion("msg >=", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgLessThan(String value) {
            addCriterion("msg <", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgLessThanOrEqualTo(String value) {
            addCriterion("msg <=", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgLike(String value) {
            addCriterion("msg like", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgNotLike(String value) {
            addCriterion("msg not like", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgIn(List<String> values) {
            addCriterion("msg in", values, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgNotIn(List<String> values) {
            addCriterion("msg not in", values, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgBetween(String value1, String value2) {
            addCriterion("msg between", value1, value2, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgNotBetween(String value1, String value2) {
            addCriterion("msg not between", value1, value2, "msg");
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

        public Criteria andSetsIsNull() {
            addCriterion("sets is null");
            return (Criteria) this;
        }

        public Criteria andSetsIsNotNull() {
            addCriterion("sets is not null");
            return (Criteria) this;
        }

        public Criteria andSetsEqualTo(String value) {
            addCriterion("sets =", value, "sets");
            return (Criteria) this;
        }

        public Criteria andSetsNotEqualTo(String value) {
            addCriterion("sets <>", value, "sets");
            return (Criteria) this;
        }

        public Criteria andSetsGreaterThan(String value) {
            addCriterion("sets >", value, "sets");
            return (Criteria) this;
        }

        public Criteria andSetsGreaterThanOrEqualTo(String value) {
            addCriterion("sets >=", value, "sets");
            return (Criteria) this;
        }

        public Criteria andSetsLessThan(String value) {
            addCriterion("sets <", value, "sets");
            return (Criteria) this;
        }

        public Criteria andSetsLessThanOrEqualTo(String value) {
            addCriterion("sets <=", value, "sets");
            return (Criteria) this;
        }

        public Criteria andSetsLike(String value) {
            addCriterion("sets like", value, "sets");
            return (Criteria) this;
        }

        public Criteria andSetsNotLike(String value) {
            addCriterion("sets not like", value, "sets");
            return (Criteria) this;
        }

        public Criteria andSetsIn(List<String> values) {
            addCriterion("sets in", values, "sets");
            return (Criteria) this;
        }

        public Criteria andSetsNotIn(List<String> values) {
            addCriterion("sets not in", values, "sets");
            return (Criteria) this;
        }

        public Criteria andSetsBetween(String value1, String value2) {
            addCriterion("sets between", value1, value2, "sets");
            return (Criteria) this;
        }

        public Criteria andSetsNotBetween(String value1, String value2) {
            addCriterion("sets not between", value1, value2, "sets");
            return (Criteria) this;
        }

        public Criteria andRecvtypeIsNull() {
            addCriterion("recvtype is null");
            return (Criteria) this;
        }

        public Criteria andRecvtypeIsNotNull() {
            addCriterion("recvtype is not null");
            return (Criteria) this;
        }

        public Criteria andRecvtypeEqualTo(Integer value) {
            addCriterion("recvtype =", value, "recvtype");
            return (Criteria) this;
        }

        public Criteria andRecvtypeNotEqualTo(Integer value) {
            addCriterion("recvtype <>", value, "recvtype");
            return (Criteria) this;
        }

        public Criteria andRecvtypeGreaterThan(Integer value) {
            addCriterion("recvtype >", value, "recvtype");
            return (Criteria) this;
        }

        public Criteria andRecvtypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("recvtype >=", value, "recvtype");
            return (Criteria) this;
        }

        public Criteria andRecvtypeLessThan(Integer value) {
            addCriterion("recvtype <", value, "recvtype");
            return (Criteria) this;
        }

        public Criteria andRecvtypeLessThanOrEqualTo(Integer value) {
            addCriterion("recvtype <=", value, "recvtype");
            return (Criteria) this;
        }

        public Criteria andRecvtypeIn(List<Integer> values) {
            addCriterion("recvtype in", values, "recvtype");
            return (Criteria) this;
        }

        public Criteria andRecvtypeNotIn(List<Integer> values) {
            addCriterion("recvtype not in", values, "recvtype");
            return (Criteria) this;
        }

        public Criteria andRecvtypeBetween(Integer value1, Integer value2) {
            addCriterion("recvtype between", value1, value2, "recvtype");
            return (Criteria) this;
        }

        public Criteria andRecvtypeNotBetween(Integer value1, Integer value2) {
            addCriterion("recvtype not between", value1, value2, "recvtype");
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