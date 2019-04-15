package cn.smartpolice.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MsgRecvExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MsgRecvExample() {
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

        public Criteria andRecvuseridIsNull() {
            addCriterion("recvuserid is null");
            return (Criteria) this;
        }

        public Criteria andRecvuseridIsNotNull() {
            addCriterion("recvuserid is not null");
            return (Criteria) this;
        }

        public Criteria andRecvuseridEqualTo(Integer value) {
            addCriterion("recvuserid =", value, "recvuserid");
            return (Criteria) this;
        }

        public Criteria andRecvuseridNotEqualTo(Integer value) {
            addCriterion("recvuserid <>", value, "recvuserid");
            return (Criteria) this;
        }

        public Criteria andRecvuseridGreaterThan(Integer value) {
            addCriterion("recvuserid >", value, "recvuserid");
            return (Criteria) this;
        }

        public Criteria andRecvuseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("recvuserid >=", value, "recvuserid");
            return (Criteria) this;
        }

        public Criteria andRecvuseridLessThan(Integer value) {
            addCriterion("recvuserid <", value, "recvuserid");
            return (Criteria) this;
        }

        public Criteria andRecvuseridLessThanOrEqualTo(Integer value) {
            addCriterion("recvuserid <=", value, "recvuserid");
            return (Criteria) this;
        }

        public Criteria andRecvuseridIn(List<Integer> values) {
            addCriterion("recvuserid in", values, "recvuserid");
            return (Criteria) this;
        }

        public Criteria andRecvuseridNotIn(List<Integer> values) {
            addCriterion("recvuserid not in", values, "recvuserid");
            return (Criteria) this;
        }

        public Criteria andRecvuseridBetween(Integer value1, Integer value2) {
            addCriterion("recvuserid between", value1, value2, "recvuserid");
            return (Criteria) this;
        }

        public Criteria andRecvuseridNotBetween(Integer value1, Integer value2) {
            addCriterion("recvuserid not between", value1, value2, "recvuserid");
            return (Criteria) this;
        }

        public Criteria andMsgtypeIsNull() {
            addCriterion("msgtype is null");
            return (Criteria) this;
        }

        public Criteria andMsgtypeIsNotNull() {
            addCriterion("msgtype is not null");
            return (Criteria) this;
        }

        public Criteria andMsgtypeEqualTo(String value) {
            addCriterion("msgtype =", value, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeNotEqualTo(String value) {
            addCriterion("msgtype <>", value, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeGreaterThan(String value) {
            addCriterion("msgtype >", value, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeGreaterThanOrEqualTo(String value) {
            addCriterion("msgtype >=", value, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeLessThan(String value) {
            addCriterion("msgtype <", value, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeLessThanOrEqualTo(String value) {
            addCriterion("msgtype <=", value, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeLike(String value) {
            addCriterion("msgtype like", value, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeNotLike(String value) {
            addCriterion("msgtype not like", value, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeIn(List<String> values) {
            addCriterion("msgtype in", values, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeNotIn(List<String> values) {
            addCriterion("msgtype not in", values, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeBetween(String value1, String value2) {
            addCriterion("msgtype between", value1, value2, "msgtype");
            return (Criteria) this;
        }

        public Criteria andMsgtypeNotBetween(String value1, String value2) {
            addCriterion("msgtype not between", value1, value2, "msgtype");
            return (Criteria) this;
        }

        public Criteria andRecvtimeIsNull() {
            addCriterion("recvtime is null");
            return (Criteria) this;
        }

        public Criteria andRecvtimeIsNotNull() {
            addCriterion("recvtime is not null");
            return (Criteria) this;
        }

        public Criteria andRecvtimeEqualTo(Date value) {
            addCriterion("recvtime =", value, "recvtime");
            return (Criteria) this;
        }

        public Criteria andRecvtimeNotEqualTo(Date value) {
            addCriterion("recvtime <>", value, "recvtime");
            return (Criteria) this;
        }

        public Criteria andRecvtimeGreaterThan(Date value) {
            addCriterion("recvtime >", value, "recvtime");
            return (Criteria) this;
        }

        public Criteria andRecvtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("recvtime >=", value, "recvtime");
            return (Criteria) this;
        }

        public Criteria andRecvtimeLessThan(Date value) {
            addCriterion("recvtime <", value, "recvtime");
            return (Criteria) this;
        }

        public Criteria andRecvtimeLessThanOrEqualTo(Date value) {
            addCriterion("recvtime <=", value, "recvtime");
            return (Criteria) this;
        }

        public Criteria andRecvtimeIn(List<Date> values) {
            addCriterion("recvtime in", values, "recvtime");
            return (Criteria) this;
        }

        public Criteria andRecvtimeNotIn(List<Date> values) {
            addCriterion("recvtime not in", values, "recvtime");
            return (Criteria) this;
        }

        public Criteria andRecvtimeBetween(Date value1, Date value2) {
            addCriterion("recvtime between", value1, value2, "recvtime");
            return (Criteria) this;
        }

        public Criteria andRecvtimeNotBetween(Date value1, Date value2) {
            addCriterion("recvtime not between", value1, value2, "recvtime");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("state like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("state not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andMessageidIsNull() {
            addCriterion("messageid is null");
            return (Criteria) this;
        }

        public Criteria andMessageidIsNotNull() {
            addCriterion("messageid is not null");
            return (Criteria) this;
        }

        public Criteria andMessageidEqualTo(Integer value) {
            addCriterion("messageid =", value, "messageid");
            return (Criteria) this;
        }

        public Criteria andMessageidNotEqualTo(Integer value) {
            addCriterion("messageid <>", value, "messageid");
            return (Criteria) this;
        }

        public Criteria andMessageidGreaterThan(Integer value) {
            addCriterion("messageid >", value, "messageid");
            return (Criteria) this;
        }

        public Criteria andMessageidGreaterThanOrEqualTo(Integer value) {
            addCriterion("messageid >=", value, "messageid");
            return (Criteria) this;
        }

        public Criteria andMessageidLessThan(Integer value) {
            addCriterion("messageid <", value, "messageid");
            return (Criteria) this;
        }

        public Criteria andMessageidLessThanOrEqualTo(Integer value) {
            addCriterion("messageid <=", value, "messageid");
            return (Criteria) this;
        }

        public Criteria andMessageidIn(List<Integer> values) {
            addCriterion("messageid in", values, "messageid");
            return (Criteria) this;
        }

        public Criteria andMessageidNotIn(List<Integer> values) {
            addCriterion("messageid not in", values, "messageid");
            return (Criteria) this;
        }

        public Criteria andMessageidBetween(Integer value1, Integer value2) {
            addCriterion("messageid between", value1, value2, "messageid");
            return (Criteria) this;
        }

        public Criteria andMessageidNotBetween(Integer value1, Integer value2) {
            addCriterion("messageid not between", value1, value2, "messageid");
            return (Criteria) this;
        }

        public Criteria andSenduseridIsNull() {
            addCriterion("SENDUSERID is null");
            return (Criteria) this;
        }

        public Criteria andSenduseridIsNotNull() {
            addCriterion("SENDUSERID is not null");
            return (Criteria) this;
        }

        public Criteria andSenduseridEqualTo(Integer value) {
            addCriterion("SENDUSERID =", value, "senduserid");
            return (Criteria) this;
        }

        public Criteria andSenduseridNotEqualTo(Integer value) {
            addCriterion("SENDUSERID <>", value, "senduserid");
            return (Criteria) this;
        }

        public Criteria andSenduseridGreaterThan(Integer value) {
            addCriterion("SENDUSERID >", value, "senduserid");
            return (Criteria) this;
        }

        public Criteria andSenduseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("SENDUSERID >=", value, "senduserid");
            return (Criteria) this;
        }

        public Criteria andSenduseridLessThan(Integer value) {
            addCriterion("SENDUSERID <", value, "senduserid");
            return (Criteria) this;
        }

        public Criteria andSenduseridLessThanOrEqualTo(Integer value) {
            addCriterion("SENDUSERID <=", value, "senduserid");
            return (Criteria) this;
        }

        public Criteria andSenduseridIn(List<Integer> values) {
            addCriterion("SENDUSERID in", values, "senduserid");
            return (Criteria) this;
        }

        public Criteria andSenduseridNotIn(List<Integer> values) {
            addCriterion("SENDUSERID not in", values, "senduserid");
            return (Criteria) this;
        }

        public Criteria andSenduseridBetween(Integer value1, Integer value2) {
            addCriterion("SENDUSERID between", value1, value2, "senduserid");
            return (Criteria) this;
        }

        public Criteria andSenduseridNotBetween(Integer value1, Integer value2) {
            addCriterion("SENDUSERID not between", value1, value2, "senduserid");
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