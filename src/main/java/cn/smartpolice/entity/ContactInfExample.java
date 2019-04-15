package cn.smartpolice.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ContactInfExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ContactInfExample() {
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

        public Criteria andContactidIsNull() {
            addCriterion("contactid is null");
            return (Criteria) this;
        }

        public Criteria andContactidIsNotNull() {
            addCriterion("contactid is not null");
            return (Criteria) this;
        }

        public Criteria andContactidEqualTo(Integer value) {
            addCriterion("contactid =", value, "contactid");
            return (Criteria) this;
        }

        public Criteria andContactidNotEqualTo(Integer value) {
            addCriterion("contactid <>", value, "contactid");
            return (Criteria) this;
        }

        public Criteria andContactidGreaterThan(Integer value) {
            addCriterion("contactid >", value, "contactid");
            return (Criteria) this;
        }

        public Criteria andContactidGreaterThanOrEqualTo(Integer value) {
            addCriterion("contactid >=", value, "contactid");
            return (Criteria) this;
        }

        public Criteria andContactidLessThan(Integer value) {
            addCriterion("contactid <", value, "contactid");
            return (Criteria) this;
        }

        public Criteria andContactidLessThanOrEqualTo(Integer value) {
            addCriterion("contactid <=", value, "contactid");
            return (Criteria) this;
        }

        public Criteria andContactidIn(List<Integer> values) {
            addCriterion("contactid in", values, "contactid");
            return (Criteria) this;
        }

        public Criteria andContactidNotIn(List<Integer> values) {
            addCriterion("contactid not in", values, "contactid");
            return (Criteria) this;
        }

        public Criteria andContactidBetween(Integer value1, Integer value2) {
            addCriterion("contactid between", value1, value2, "contactid");
            return (Criteria) this;
        }

        public Criteria andContactidNotBetween(Integer value1, Integer value2) {
            addCriterion("contactid not between", value1, value2, "contactid");
            return (Criteria) this;
        }

        public Criteria andMasteridIsNull() {
            addCriterion("masterid is null");
            return (Criteria) this;
        }

        public Criteria andMasteridIsNotNull() {
            addCriterion("masterid is not null");
            return (Criteria) this;
        }

        public Criteria andMasteridEqualTo(Integer value) {
            addCriterion("masterid =", value, "masterid");
            return (Criteria) this;
        }

        public Criteria andMasteridNotEqualTo(Integer value) {
            addCriterion("masterid <>", value, "masterid");
            return (Criteria) this;
        }

        public Criteria andMasteridGreaterThan(Integer value) {
            addCriterion("masterid >", value, "masterid");
            return (Criteria) this;
        }

        public Criteria andMasteridGreaterThanOrEqualTo(Integer value) {
            addCriterion("masterid >=", value, "masterid");
            return (Criteria) this;
        }

        public Criteria andMasteridLessThan(Integer value) {
            addCriterion("masterid <", value, "masterid");
            return (Criteria) this;
        }

        public Criteria andMasteridLessThanOrEqualTo(Integer value) {
            addCriterion("masterid <=", value, "masterid");
            return (Criteria) this;
        }

        public Criteria andMasteridIn(List<Integer> values) {
            addCriterion("masterid in", values, "masterid");
            return (Criteria) this;
        }

        public Criteria andMasteridNotIn(List<Integer> values) {
            addCriterion("masterid not in", values, "masterid");
            return (Criteria) this;
        }

        public Criteria andMasteridBetween(Integer value1, Integer value2) {
            addCriterion("masterid between", value1, value2, "masterid");
            return (Criteria) this;
        }

        public Criteria andMasteridNotBetween(Integer value1, Integer value2) {
            addCriterion("masterid not between", value1, value2, "masterid");
            return (Criteria) this;
        }

        public Criteria andContactedidIsNull() {
            addCriterion("contactedid is null");
            return (Criteria) this;
        }

        public Criteria andContactedidIsNotNull() {
            addCriterion("contactedid is not null");
            return (Criteria) this;
        }

        public Criteria andContactedidEqualTo(Integer value) {
            addCriterion("contactedid =", value, "contactedid");
            return (Criteria) this;
        }

        public Criteria andContactedidNotEqualTo(Integer value) {
            addCriterion("contactedid <>", value, "contactedid");
            return (Criteria) this;
        }

        public Criteria andContactedidGreaterThan(Integer value) {
            addCriterion("contactedid >", value, "contactedid");
            return (Criteria) this;
        }

        public Criteria andContactedidGreaterThanOrEqualTo(Integer value) {
            addCriterion("contactedid >=", value, "contactedid");
            return (Criteria) this;
        }

        public Criteria andContactedidLessThan(Integer value) {
            addCriterion("contactedid <", value, "contactedid");
            return (Criteria) this;
        }

        public Criteria andContactedidLessThanOrEqualTo(Integer value) {
            addCriterion("contactedid <=", value, "contactedid");
            return (Criteria) this;
        }

        public Criteria andContactedidIn(List<Integer> values) {
            addCriterion("contactedid in", values, "contactedid");
            return (Criteria) this;
        }

        public Criteria andContactedidNotIn(List<Integer> values) {
            addCriterion("contactedid not in", values, "contactedid");
            return (Criteria) this;
        }

        public Criteria andContactedidBetween(Integer value1, Integer value2) {
            addCriterion("contactedid between", value1, value2, "contactedid");
            return (Criteria) this;
        }

        public Criteria andContactedidNotBetween(Integer value1, Integer value2) {
            addCriterion("contactedid not between", value1, value2, "contactedid");
            return (Criteria) this;
        }

        public Criteria andGroupIsNull() {
            addCriterion("group is null");
            return (Criteria) this;
        }

        public Criteria andGroupIsNotNull() {
            addCriterion("group is not null");
            return (Criteria) this;
        }

        public Criteria andGroupEqualTo(String value) {
            addCriterion("group =", value, "group");
            return (Criteria) this;
        }

        public Criteria andGroupNotEqualTo(String value) {
            addCriterion("group <>", value, "group");
            return (Criteria) this;
        }

        public Criteria andGroupGreaterThan(String value) {
            addCriterion("group >", value, "group");
            return (Criteria) this;
        }

        public Criteria andGroupGreaterThanOrEqualTo(String value) {
            addCriterion("group >=", value, "group");
            return (Criteria) this;
        }

        public Criteria andGroupLessThan(String value) {
            addCriterion("group <", value, "group");
            return (Criteria) this;
        }

        public Criteria andGroupLessThanOrEqualTo(String value) {
            addCriterion("group <=", value, "group");
            return (Criteria) this;
        }

        public Criteria andGroupLike(String value) {
            addCriterion("group like", value, "group");
            return (Criteria) this;
        }

        public Criteria andGroupNotLike(String value) {
            addCriterion("group not like", value, "group");
            return (Criteria) this;
        }

        public Criteria andGroupIn(List<String> values) {
            addCriterion("group in", values, "group");
            return (Criteria) this;
        }

        public Criteria andGroupNotIn(List<String> values) {
            addCriterion("group not in", values, "group");
            return (Criteria) this;
        }

        public Criteria andGroupBetween(String value1, String value2) {
            addCriterion("group between", value1, value2, "group");
            return (Criteria) this;
        }

        public Criteria andGroupNotBetween(String value1, String value2) {
            addCriterion("group not between", value1, value2, "group");
            return (Criteria) this;
        }

        public Criteria andAliasIsNull() {
            addCriterion("alias is null");
            return (Criteria) this;
        }

        public Criteria andAliasIsNotNull() {
            addCriterion("alias is not null");
            return (Criteria) this;
        }

        public Criteria andAliasEqualTo(String value) {
            addCriterion("alias =", value, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasNotEqualTo(String value) {
            addCriterion("alias <>", value, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasGreaterThan(String value) {
            addCriterion("alias >", value, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasGreaterThanOrEqualTo(String value) {
            addCriterion("alias >=", value, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasLessThan(String value) {
            addCriterion("alias <", value, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasLessThanOrEqualTo(String value) {
            addCriterion("alias <=", value, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasLike(String value) {
            addCriterion("alias like", value, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasNotLike(String value) {
            addCriterion("alias not like", value, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasIn(List<String> values) {
            addCriterion("alias in", values, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasNotIn(List<String> values) {
            addCriterion("alias not in", values, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasBetween(String value1, String value2) {
            addCriterion("alias between", value1, value2, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasNotBetween(String value1, String value2) {
            addCriterion("alias not between", value1, value2, "alias");
            return (Criteria) this;
        }

        public Criteria andSettimeIsNull() {
            addCriterion("settime is null");
            return (Criteria) this;
        }

        public Criteria andSettimeIsNotNull() {
            addCriterion("settime is not null");
            return (Criteria) this;
        }

        public Criteria andSettimeEqualTo(Date value) {
            addCriterion("settime =", value, "settime");
            return (Criteria) this;
        }

        public Criteria andSettimeNotEqualTo(Date value) {
            addCriterion("settime <>", value, "settime");
            return (Criteria) this;
        }

        public Criteria andSettimeGreaterThan(Date value) {
            addCriterion("settime >", value, "settime");
            return (Criteria) this;
        }

        public Criteria andSettimeGreaterThanOrEqualTo(Date value) {
            addCriterion("settime >=", value, "settime");
            return (Criteria) this;
        }

        public Criteria andSettimeLessThan(Date value) {
            addCriterion("settime <", value, "settime");
            return (Criteria) this;
        }

        public Criteria andSettimeLessThanOrEqualTo(Date value) {
            addCriterion("settime <=", value, "settime");
            return (Criteria) this;
        }

        public Criteria andSettimeIn(List<Date> values) {
            addCriterion("settime in", values, "settime");
            return (Criteria) this;
        }

        public Criteria andSettimeNotIn(List<Date> values) {
            addCriterion("settime not in", values, "settime");
            return (Criteria) this;
        }

        public Criteria andSettimeBetween(Date value1, Date value2) {
            addCriterion("settime between", value1, value2, "settime");
            return (Criteria) this;
        }

        public Criteria andSettimeNotBetween(Date value1, Date value2) {
            addCriterion("settime not between", value1, value2, "settime");
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

        public Criteria andGroupnameIsNull() {
            addCriterion("GROUPNAME is null");
            return (Criteria) this;
        }

        public Criteria andGroupnameIsNotNull() {
            addCriterion("GROUPNAME is not null");
            return (Criteria) this;
        }

        public Criteria andGroupnameEqualTo(String value) {
            addCriterion("GROUPNAME =", value, "groupname");
            return (Criteria) this;
        }

        public Criteria andGroupnameNotEqualTo(String value) {
            addCriterion("GROUPNAME <>", value, "groupname");
            return (Criteria) this;
        }

        public Criteria andGroupnameGreaterThan(String value) {
            addCriterion("GROUPNAME >", value, "groupname");
            return (Criteria) this;
        }

        public Criteria andGroupnameGreaterThanOrEqualTo(String value) {
            addCriterion("GROUPNAME >=", value, "groupname");
            return (Criteria) this;
        }

        public Criteria andGroupnameLessThan(String value) {
            addCriterion("GROUPNAME <", value, "groupname");
            return (Criteria) this;
        }

        public Criteria andGroupnameLessThanOrEqualTo(String value) {
            addCriterion("GROUPNAME <=", value, "groupname");
            return (Criteria) this;
        }

        public Criteria andGroupnameLike(String value) {
            addCriterion("GROUPNAME like", value, "groupname");
            return (Criteria) this;
        }

        public Criteria andGroupnameNotLike(String value) {
            addCriterion("GROUPNAME not like", value, "groupname");
            return (Criteria) this;
        }

        public Criteria andGroupnameIn(List<String> values) {
            addCriterion("GROUPNAME in", values, "groupname");
            return (Criteria) this;
        }

        public Criteria andGroupnameNotIn(List<String> values) {
            addCriterion("GROUPNAME not in", values, "groupname");
            return (Criteria) this;
        }

        public Criteria andGroupnameBetween(String value1, String value2) {
            addCriterion("GROUPNAME between", value1, value2, "groupname");
            return (Criteria) this;
        }

        public Criteria andGroupnameNotBetween(String value1, String value2) {
            addCriterion("GROUPNAME not between", value1, value2, "groupname");
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