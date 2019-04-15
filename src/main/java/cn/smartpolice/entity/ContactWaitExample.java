package cn.smartpolice.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ContactWaitExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ContactWaitExample() {
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

        public Criteria andCwidIsNull() {
            addCriterion("cwid is null");
            return (Criteria) this;
        }

        public Criteria andCwidIsNotNull() {
            addCriterion("cwid is not null");
            return (Criteria) this;
        }

        public Criteria andCwidEqualTo(Integer value) {
            addCriterion("cwid =", value, "cwid");
            return (Criteria) this;
        }

        public Criteria andCwidNotEqualTo(Integer value) {
            addCriterion("cwid <>", value, "cwid");
            return (Criteria) this;
        }

        public Criteria andCwidGreaterThan(Integer value) {
            addCriterion("cwid >", value, "cwid");
            return (Criteria) this;
        }

        public Criteria andCwidGreaterThanOrEqualTo(Integer value) {
            addCriterion("cwid >=", value, "cwid");
            return (Criteria) this;
        }

        public Criteria andCwidLessThan(Integer value) {
            addCriterion("cwid <", value, "cwid");
            return (Criteria) this;
        }

        public Criteria andCwidLessThanOrEqualTo(Integer value) {
            addCriterion("cwid <=", value, "cwid");
            return (Criteria) this;
        }

        public Criteria andCwidIn(List<Integer> values) {
            addCriterion("cwid in", values, "cwid");
            return (Criteria) this;
        }

        public Criteria andCwidNotIn(List<Integer> values) {
            addCriterion("cwid not in", values, "cwid");
            return (Criteria) this;
        }

        public Criteria andCwidBetween(Integer value1, Integer value2) {
            addCriterion("cwid between", value1, value2, "cwid");
            return (Criteria) this;
        }

        public Criteria andCwidNotBetween(Integer value1, Integer value2) {
            addCriterion("cwid not between", value1, value2, "cwid");
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

        public Criteria andApplytimeIsNull() {
            addCriterion("applytime is null");
            return (Criteria) this;
        }

        public Criteria andApplytimeIsNotNull() {
            addCriterion("applytime is not null");
            return (Criteria) this;
        }

        public Criteria andApplytimeEqualTo(Date value) {
            addCriterion("applytime =", value, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeNotEqualTo(Date value) {
            addCriterion("applytime <>", value, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeGreaterThan(Date value) {
            addCriterion("applytime >", value, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeGreaterThanOrEqualTo(Date value) {
            addCriterion("applytime >=", value, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeLessThan(Date value) {
            addCriterion("applytime <", value, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeLessThanOrEqualTo(Date value) {
            addCriterion("applytime <=", value, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeIn(List<Date> values) {
            addCriterion("applytime in", values, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeNotIn(List<Date> values) {
            addCriterion("applytime not in", values, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeBetween(Date value1, Date value2) {
            addCriterion("applytime between", value1, value2, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeNotBetween(Date value1, Date value2) {
            addCriterion("applytime not between", value1, value2, "applytime");
            return (Criteria) this;
        }

        public Criteria andMessageIsNull() {
            addCriterion("message is null");
            return (Criteria) this;
        }

        public Criteria andMessageIsNotNull() {
            addCriterion("message is not null");
            return (Criteria) this;
        }

        public Criteria andMessageEqualTo(String value) {
            addCriterion("message =", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotEqualTo(String value) {
            addCriterion("message <>", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageGreaterThan(String value) {
            addCriterion("message >", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageGreaterThanOrEqualTo(String value) {
            addCriterion("message >=", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLessThan(String value) {
            addCriterion("message <", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLessThanOrEqualTo(String value) {
            addCriterion("message <=", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLike(String value) {
            addCriterion("message like", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotLike(String value) {
            addCriterion("message not like", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageIn(List<String> values) {
            addCriterion("message in", values, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotIn(List<String> values) {
            addCriterion("message not in", values, "message");
            return (Criteria) this;
        }

        public Criteria andMessageBetween(String value1, String value2) {
            addCriterion("message between", value1, value2, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotBetween(String value1, String value2) {
            addCriterion("message not between", value1, value2, "message");
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

        public Criteria andKindIsNull() {
            addCriterion("kind is null");
            return (Criteria) this;
        }

        public Criteria andKindIsNotNull() {
            addCriterion("kind is not null");
            return (Criteria) this;
        }

        public Criteria andKindEqualTo(String value) {
            addCriterion("kind =", value, "kind");
            return (Criteria) this;
        }

        public Criteria andKindNotEqualTo(String value) {
            addCriterion("kind <>", value, "kind");
            return (Criteria) this;
        }

        public Criteria andKindGreaterThan(String value) {
            addCriterion("kind >", value, "kind");
            return (Criteria) this;
        }

        public Criteria andKindGreaterThanOrEqualTo(String value) {
            addCriterion("kind >=", value, "kind");
            return (Criteria) this;
        }

        public Criteria andKindLessThan(String value) {
            addCriterion("kind <", value, "kind");
            return (Criteria) this;
        }

        public Criteria andKindLessThanOrEqualTo(String value) {
            addCriterion("kind <=", value, "kind");
            return (Criteria) this;
        }

        public Criteria andKindLike(String value) {
            addCriterion("kind like", value, "kind");
            return (Criteria) this;
        }

        public Criteria andKindNotLike(String value) {
            addCriterion("kind not like", value, "kind");
            return (Criteria) this;
        }

        public Criteria andKindIn(List<String> values) {
            addCriterion("kind in", values, "kind");
            return (Criteria) this;
        }

        public Criteria andKindNotIn(List<String> values) {
            addCriterion("kind not in", values, "kind");
            return (Criteria) this;
        }

        public Criteria andKindBetween(String value1, String value2) {
            addCriterion("kind between", value1, value2, "kind");
            return (Criteria) this;
        }

        public Criteria andKindNotBetween(String value1, String value2) {
            addCriterion("kind not between", value1, value2, "kind");
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