package cn.smartpolice.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ConnectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ConnectExample() {
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

        public Criteria andConnectIdIsNull() {
            addCriterion("connect_id is null");
            return (Criteria) this;
        }

        public Criteria andConnectIdIsNotNull() {
            addCriterion("connect_id is not null");
            return (Criteria) this;
        }

        public Criteria andConnectIdEqualTo(Integer value) {
            addCriterion("connect_id =", value, "connectId");
            return (Criteria) this;
        }

        public Criteria andConnectIdNotEqualTo(Integer value) {
            addCriterion("connect_id <>", value, "connectId");
            return (Criteria) this;
        }

        public Criteria andConnectIdGreaterThan(Integer value) {
            addCriterion("connect_id >", value, "connectId");
            return (Criteria) this;
        }

        public Criteria andConnectIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("connect_id >=", value, "connectId");
            return (Criteria) this;
        }

        public Criteria andConnectIdLessThan(Integer value) {
            addCriterion("connect_id <", value, "connectId");
            return (Criteria) this;
        }

        public Criteria andConnectIdLessThanOrEqualTo(Integer value) {
            addCriterion("connect_id <=", value, "connectId");
            return (Criteria) this;
        }

        public Criteria andConnectIdIn(List<Integer> values) {
            addCriterion("connect_id in", values, "connectId");
            return (Criteria) this;
        }

        public Criteria andConnectIdNotIn(List<Integer> values) {
            addCriterion("connect_id not in", values, "connectId");
            return (Criteria) this;
        }

        public Criteria andConnectIdBetween(Integer value1, Integer value2) {
            addCriterion("connect_id between", value1, value2, "connectId");
            return (Criteria) this;
        }

        public Criteria andConnectIdNotBetween(Integer value1, Integer value2) {
            addCriterion("connect_id not between", value1, value2, "connectId");
            return (Criteria) this;
        }

        public Criteria andConnectTimeIsNull() {
            addCriterion("connect_time is null");
            return (Criteria) this;
        }

        public Criteria andConnectTimeIsNotNull() {
            addCriterion("connect_time is not null");
            return (Criteria) this;
        }

        public Criteria andConnectTimeEqualTo(Date value) {
            addCriterion("connect_time =", value, "connectTime");
            return (Criteria) this;
        }

        public Criteria andConnectTimeNotEqualTo(Date value) {
            addCriterion("connect_time <>", value, "connectTime");
            return (Criteria) this;
        }

        public Criteria andConnectTimeGreaterThan(Date value) {
            addCriterion("connect_time >", value, "connectTime");
            return (Criteria) this;
        }

        public Criteria andConnectTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("connect_time >=", value, "connectTime");
            return (Criteria) this;
        }

        public Criteria andConnectTimeLessThan(Date value) {
            addCriterion("connect_time <", value, "connectTime");
            return (Criteria) this;
        }

        public Criteria andConnectTimeLessThanOrEqualTo(Date value) {
            addCriterion("connect_time <=", value, "connectTime");
            return (Criteria) this;
        }

        public Criteria andConnectTimeIn(List<Date> values) {
            addCriterion("connect_time in", values, "connectTime");
            return (Criteria) this;
        }

        public Criteria andConnectTimeNotIn(List<Date> values) {
            addCriterion("connect_time not in", values, "connectTime");
            return (Criteria) this;
        }

        public Criteria andConnectTimeBetween(Date value1, Date value2) {
            addCriterion("connect_time between", value1, value2, "connectTime");
            return (Criteria) this;
        }

        public Criteria andConnectTimeNotBetween(Date value1, Date value2) {
            addCriterion("connect_time not between", value1, value2, "connectTime");
            return (Criteria) this;
        }

        public Criteria andDisconnectTimeIsNull() {
            addCriterion("disconnect_time is null");
            return (Criteria) this;
        }

        public Criteria andDisconnectTimeIsNotNull() {
            addCriterion("disconnect_time is not null");
            return (Criteria) this;
        }

        public Criteria andDisconnectTimeEqualTo(Date value) {
            addCriterion("disconnect_time =", value, "disconnectTime");
            return (Criteria) this;
        }

        public Criteria andDisconnectTimeNotEqualTo(Date value) {
            addCriterion("disconnect_time <>", value, "disconnectTime");
            return (Criteria) this;
        }

        public Criteria andDisconnectTimeGreaterThan(Date value) {
            addCriterion("disconnect_time >", value, "disconnectTime");
            return (Criteria) this;
        }

        public Criteria andDisconnectTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("disconnect_time >=", value, "disconnectTime");
            return (Criteria) this;
        }

        public Criteria andDisconnectTimeLessThan(Date value) {
            addCriterion("disconnect_time <", value, "disconnectTime");
            return (Criteria) this;
        }

        public Criteria andDisconnectTimeLessThanOrEqualTo(Date value) {
            addCriterion("disconnect_time <=", value, "disconnectTime");
            return (Criteria) this;
        }

        public Criteria andDisconnectTimeIn(List<Date> values) {
            addCriterion("disconnect_time in", values, "disconnectTime");
            return (Criteria) this;
        }

        public Criteria andDisconnectTimeNotIn(List<Date> values) {
            addCriterion("disconnect_time not in", values, "disconnectTime");
            return (Criteria) this;
        }

        public Criteria andDisconnectTimeBetween(Date value1, Date value2) {
            addCriterion("disconnect_time between", value1, value2, "disconnectTime");
            return (Criteria) this;
        }

        public Criteria andDisconnectTimeNotBetween(Date value1, Date value2) {
            addCriterion("disconnect_time not between", value1, value2, "disconnectTime");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIsNull() {
            addCriterion("device_id is null");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIsNotNull() {
            addCriterion("device_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceIdEqualTo(Integer value) {
            addCriterion("device_id =", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotEqualTo(Integer value) {
            addCriterion("device_id <>", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdGreaterThan(Integer value) {
            addCriterion("device_id >", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("device_id >=", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLessThan(Integer value) {
            addCriterion("device_id <", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLessThanOrEqualTo(Integer value) {
            addCriterion("device_id <=", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIn(List<Integer> values) {
            addCriterion("device_id in", values, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotIn(List<Integer> values) {
            addCriterion("device_id not in", values, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdBetween(Integer value1, Integer value2) {
            addCriterion("device_id between", value1, value2, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("device_id not between", value1, value2, "deviceId");
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