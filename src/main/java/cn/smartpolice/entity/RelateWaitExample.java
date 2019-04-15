package cn.smartpolice.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RelateWaitExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RelateWaitExample() {
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

        public Criteria andRwidIsNull() {
            addCriterion("rwid is null");
            return (Criteria) this;
        }

        public Criteria andRwidIsNotNull() {
            addCriterion("rwid is not null");
            return (Criteria) this;
        }

        public Criteria andRwidEqualTo(Integer value) {
            addCriterion("rwid =", value, "rwid");
            return (Criteria) this;
        }

        public Criteria andRwidNotEqualTo(Integer value) {
            addCriterion("rwid <>", value, "rwid");
            return (Criteria) this;
        }

        public Criteria andRwidGreaterThan(Integer value) {
            addCriterion("rwid >", value, "rwid");
            return (Criteria) this;
        }

        public Criteria andRwidGreaterThanOrEqualTo(Integer value) {
            addCriterion("rwid >=", value, "rwid");
            return (Criteria) this;
        }

        public Criteria andRwidLessThan(Integer value) {
            addCriterion("rwid <", value, "rwid");
            return (Criteria) this;
        }

        public Criteria andRwidLessThanOrEqualTo(Integer value) {
            addCriterion("rwid <=", value, "rwid");
            return (Criteria) this;
        }

        public Criteria andRwidIn(List<Integer> values) {
            addCriterion("rwid in", values, "rwid");
            return (Criteria) this;
        }

        public Criteria andRwidNotIn(List<Integer> values) {
            addCriterion("rwid not in", values, "rwid");
            return (Criteria) this;
        }

        public Criteria andRwidBetween(Integer value1, Integer value2) {
            addCriterion("rwid between", value1, value2, "rwid");
            return (Criteria) this;
        }

        public Criteria andRwidNotBetween(Integer value1, Integer value2) {
            addCriterion("rwid not between", value1, value2, "rwid");
            return (Criteria) this;
        }

        public Criteria andApplyidIsNull() {
            addCriterion("applyid is null");
            return (Criteria) this;
        }

        public Criteria andApplyidIsNotNull() {
            addCriterion("applyid is not null");
            return (Criteria) this;
        }

        public Criteria andApplyidEqualTo(Integer value) {
            addCriterion("applyid =", value, "applyid");
            return (Criteria) this;
        }

        public Criteria andApplyidNotEqualTo(Integer value) {
            addCriterion("applyid <>", value, "applyid");
            return (Criteria) this;
        }

        public Criteria andApplyidGreaterThan(Integer value) {
            addCriterion("applyid >", value, "applyid");
            return (Criteria) this;
        }

        public Criteria andApplyidGreaterThanOrEqualTo(Integer value) {
            addCriterion("applyid >=", value, "applyid");
            return (Criteria) this;
        }

        public Criteria andApplyidLessThan(Integer value) {
            addCriterion("applyid <", value, "applyid");
            return (Criteria) this;
        }

        public Criteria andApplyidLessThanOrEqualTo(Integer value) {
            addCriterion("applyid <=", value, "applyid");
            return (Criteria) this;
        }

        public Criteria andApplyidIn(List<Integer> values) {
            addCriterion("applyid in", values, "applyid");
            return (Criteria) this;
        }

        public Criteria andApplyidNotIn(List<Integer> values) {
            addCriterion("applyid not in", values, "applyid");
            return (Criteria) this;
        }

        public Criteria andApplyidBetween(Integer value1, Integer value2) {
            addCriterion("applyid between", value1, value2, "applyid");
            return (Criteria) this;
        }

        public Criteria andApplyidNotBetween(Integer value1, Integer value2) {
            addCriterion("applyid not between", value1, value2, "applyid");
            return (Criteria) this;
        }

        public Criteria andDeviceidIsNull() {
            addCriterion("deviceid is null");
            return (Criteria) this;
        }

        public Criteria andDeviceidIsNotNull() {
            addCriterion("deviceid is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceidEqualTo(Integer value) {
            addCriterion("deviceid =", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidNotEqualTo(Integer value) {
            addCriterion("deviceid <>", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidGreaterThan(Integer value) {
            addCriterion("deviceid >", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidGreaterThanOrEqualTo(Integer value) {
            addCriterion("deviceid >=", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidLessThan(Integer value) {
            addCriterion("deviceid <", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidLessThanOrEqualTo(Integer value) {
            addCriterion("deviceid <=", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidIn(List<Integer> values) {
            addCriterion("deviceid in", values, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidNotIn(List<Integer> values) {
            addCriterion("deviceid not in", values, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidBetween(Integer value1, Integer value2) {
            addCriterion("deviceid between", value1, value2, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidNotBetween(Integer value1, Integer value2) {
            addCriterion("deviceid not between", value1, value2, "deviceid");
            return (Criteria) this;
        }

        public Criteria andAskidIsNull() {
            addCriterion("askid is null");
            return (Criteria) this;
        }

        public Criteria andAskidIsNotNull() {
            addCriterion("askid is not null");
            return (Criteria) this;
        }

        public Criteria andAskidEqualTo(Integer value) {
            addCriterion("askid =", value, "askid");
            return (Criteria) this;
        }

        public Criteria andAskidNotEqualTo(Integer value) {
            addCriterion("askid <>", value, "askid");
            return (Criteria) this;
        }

        public Criteria andAskidGreaterThan(Integer value) {
            addCriterion("askid >", value, "askid");
            return (Criteria) this;
        }

        public Criteria andAskidGreaterThanOrEqualTo(Integer value) {
            addCriterion("askid >=", value, "askid");
            return (Criteria) this;
        }

        public Criteria andAskidLessThan(Integer value) {
            addCriterion("askid <", value, "askid");
            return (Criteria) this;
        }

        public Criteria andAskidLessThanOrEqualTo(Integer value) {
            addCriterion("askid <=", value, "askid");
            return (Criteria) this;
        }

        public Criteria andAskidIn(List<Integer> values) {
            addCriterion("askid in", values, "askid");
            return (Criteria) this;
        }

        public Criteria andAskidNotIn(List<Integer> values) {
            addCriterion("askid not in", values, "askid");
            return (Criteria) this;
        }

        public Criteria andAskidBetween(Integer value1, Integer value2) {
            addCriterion("askid between", value1, value2, "askid");
            return (Criteria) this;
        }

        public Criteria andAskidNotBetween(Integer value1, Integer value2) {
            addCriterion("askid not between", value1, value2, "askid");
            return (Criteria) this;
        }

        public Criteria andApplytypeIsNull() {
            addCriterion("applytype is null");
            return (Criteria) this;
        }

        public Criteria andApplytypeIsNotNull() {
            addCriterion("applytype is not null");
            return (Criteria) this;
        }

        public Criteria andApplytypeEqualTo(Boolean value) {
            addCriterion("applytype =", value, "applytype");
            return (Criteria) this;
        }

        public Criteria andApplytypeNotEqualTo(Boolean value) {
            addCriterion("applytype <>", value, "applytype");
            return (Criteria) this;
        }

        public Criteria andApplytypeGreaterThan(Boolean value) {
            addCriterion("applytype >", value, "applytype");
            return (Criteria) this;
        }

        public Criteria andApplytypeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("applytype >=", value, "applytype");
            return (Criteria) this;
        }

        public Criteria andApplytypeLessThan(Boolean value) {
            addCriterion("applytype <", value, "applytype");
            return (Criteria) this;
        }

        public Criteria andApplytypeLessThanOrEqualTo(Boolean value) {
            addCriterion("applytype <=", value, "applytype");
            return (Criteria) this;
        }

        public Criteria andApplytypeIn(List<Boolean> values) {
            addCriterion("applytype in", values, "applytype");
            return (Criteria) this;
        }

        public Criteria andApplytypeNotIn(List<Boolean> values) {
            addCriterion("applytype not in", values, "applytype");
            return (Criteria) this;
        }

        public Criteria andApplytypeBetween(Boolean value1, Boolean value2) {
            addCriterion("applytype between", value1, value2, "applytype");
            return (Criteria) this;
        }

        public Criteria andApplytypeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("applytype not between", value1, value2, "applytype");
            return (Criteria) this;
        }

        public Criteria andApplyrightIsNull() {
            addCriterion("applyright is null");
            return (Criteria) this;
        }

        public Criteria andApplyrightIsNotNull() {
            addCriterion("applyright is not null");
            return (Criteria) this;
        }

        public Criteria andApplyrightEqualTo(String value) {
            addCriterion("applyright =", value, "applyright");
            return (Criteria) this;
        }

        public Criteria andApplyrightNotEqualTo(String value) {
            addCriterion("applyright <>", value, "applyright");
            return (Criteria) this;
        }

        public Criteria andApplyrightGreaterThan(String value) {
            addCriterion("applyright >", value, "applyright");
            return (Criteria) this;
        }

        public Criteria andApplyrightGreaterThanOrEqualTo(String value) {
            addCriterion("applyright >=", value, "applyright");
            return (Criteria) this;
        }

        public Criteria andApplyrightLessThan(String value) {
            addCriterion("applyright <", value, "applyright");
            return (Criteria) this;
        }

        public Criteria andApplyrightLessThanOrEqualTo(String value) {
            addCriterion("applyright <=", value, "applyright");
            return (Criteria) this;
        }

        public Criteria andApplyrightLike(String value) {
            addCriterion("applyright like", value, "applyright");
            return (Criteria) this;
        }

        public Criteria andApplyrightNotLike(String value) {
            addCriterion("applyright not like", value, "applyright");
            return (Criteria) this;
        }

        public Criteria andApplyrightIn(List<String> values) {
            addCriterion("applyright in", values, "applyright");
            return (Criteria) this;
        }

        public Criteria andApplyrightNotIn(List<String> values) {
            addCriterion("applyright not in", values, "applyright");
            return (Criteria) this;
        }

        public Criteria andApplyrightBetween(String value1, String value2) {
            addCriterion("applyright between", value1, value2, "applyright");
            return (Criteria) this;
        }

        public Criteria andApplyrightNotBetween(String value1, String value2) {
            addCriterion("applyright not between", value1, value2, "applyright");
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

        public Criteria andCwidIsNull() {
            addCriterion("CWID is null");
            return (Criteria) this;
        }

        public Criteria andCwidIsNotNull() {
            addCriterion("CWID is not null");
            return (Criteria) this;
        }

        public Criteria andCwidEqualTo(Integer value) {
            addCriterion("CWID =", value, "cwid");
            return (Criteria) this;
        }

        public Criteria andCwidNotEqualTo(Integer value) {
            addCriterion("CWID <>", value, "cwid");
            return (Criteria) this;
        }

        public Criteria andCwidGreaterThan(Integer value) {
            addCriterion("CWID >", value, "cwid");
            return (Criteria) this;
        }

        public Criteria andCwidGreaterThanOrEqualTo(Integer value) {
            addCriterion("CWID >=", value, "cwid");
            return (Criteria) this;
        }

        public Criteria andCwidLessThan(Integer value) {
            addCriterion("CWID <", value, "cwid");
            return (Criteria) this;
        }

        public Criteria andCwidLessThanOrEqualTo(Integer value) {
            addCriterion("CWID <=", value, "cwid");
            return (Criteria) this;
        }

        public Criteria andCwidIn(List<Integer> values) {
            addCriterion("CWID in", values, "cwid");
            return (Criteria) this;
        }

        public Criteria andCwidNotIn(List<Integer> values) {
            addCriterion("CWID not in", values, "cwid");
            return (Criteria) this;
        }

        public Criteria andCwidBetween(Integer value1, Integer value2) {
            addCriterion("CWID between", value1, value2, "cwid");
            return (Criteria) this;
        }

        public Criteria andCwidNotBetween(Integer value1, Integer value2) {
            addCriterion("CWID not between", value1, value2, "cwid");
            return (Criteria) this;
        }

        public Criteria andAcktimeIsNull() {
            addCriterion("ACKTIME is null");
            return (Criteria) this;
        }

        public Criteria andAcktimeIsNotNull() {
            addCriterion("ACKTIME is not null");
            return (Criteria) this;
        }

        public Criteria andAcktimeEqualTo(Date value) {
            addCriterion("ACKTIME =", value, "acktime");
            return (Criteria) this;
        }

        public Criteria andAcktimeNotEqualTo(Date value) {
            addCriterion("ACKTIME <>", value, "acktime");
            return (Criteria) this;
        }

        public Criteria andAcktimeGreaterThan(Date value) {
            addCriterion("ACKTIME >", value, "acktime");
            return (Criteria) this;
        }

        public Criteria andAcktimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ACKTIME >=", value, "acktime");
            return (Criteria) this;
        }

        public Criteria andAcktimeLessThan(Date value) {
            addCriterion("ACKTIME <", value, "acktime");
            return (Criteria) this;
        }

        public Criteria andAcktimeLessThanOrEqualTo(Date value) {
            addCriterion("ACKTIME <=", value, "acktime");
            return (Criteria) this;
        }

        public Criteria andAcktimeIn(List<Date> values) {
            addCriterion("ACKTIME in", values, "acktime");
            return (Criteria) this;
        }

        public Criteria andAcktimeNotIn(List<Date> values) {
            addCriterion("ACKTIME not in", values, "acktime");
            return (Criteria) this;
        }

        public Criteria andAcktimeBetween(Date value1, Date value2) {
            addCriterion("ACKTIME between", value1, value2, "acktime");
            return (Criteria) this;
        }

        public Criteria andAcktimeNotBetween(Date value1, Date value2) {
            addCriterion("ACKTIME not between", value1, value2, "acktime");
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