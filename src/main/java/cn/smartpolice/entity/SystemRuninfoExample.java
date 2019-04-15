package cn.smartpolice.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SystemRuninfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SystemRuninfoExample() {
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

        public Criteria andInfoidIsNull() {
            addCriterion("infoid is null");
            return (Criteria) this;
        }

        public Criteria andInfoidIsNotNull() {
            addCriterion("infoid is not null");
            return (Criteria) this;
        }

        public Criteria andInfoidEqualTo(Integer value) {
            addCriterion("infoid =", value, "infoid");
            return (Criteria) this;
        }

        public Criteria andInfoidNotEqualTo(Integer value) {
            addCriterion("infoid <>", value, "infoid");
            return (Criteria) this;
        }

        public Criteria andInfoidGreaterThan(Integer value) {
            addCriterion("infoid >", value, "infoid");
            return (Criteria) this;
        }

        public Criteria andInfoidGreaterThanOrEqualTo(Integer value) {
            addCriterion("infoid >=", value, "infoid");
            return (Criteria) this;
        }

        public Criteria andInfoidLessThan(Integer value) {
            addCriterion("infoid <", value, "infoid");
            return (Criteria) this;
        }

        public Criteria andInfoidLessThanOrEqualTo(Integer value) {
            addCriterion("infoid <=", value, "infoid");
            return (Criteria) this;
        }

        public Criteria andInfoidIn(List<Integer> values) {
            addCriterion("infoid in", values, "infoid");
            return (Criteria) this;
        }

        public Criteria andInfoidNotIn(List<Integer> values) {
            addCriterion("infoid not in", values, "infoid");
            return (Criteria) this;
        }

        public Criteria andInfoidBetween(Integer value1, Integer value2) {
            addCriterion("infoid between", value1, value2, "infoid");
            return (Criteria) this;
        }

        public Criteria andInfoidNotBetween(Integer value1, Integer value2) {
            addCriterion("infoid not between", value1, value2, "infoid");
            return (Criteria) this;
        }

        public Criteria andInfotimeIsNull() {
            addCriterion("infotime is null");
            return (Criteria) this;
        }

        public Criteria andInfotimeIsNotNull() {
            addCriterion("infotime is not null");
            return (Criteria) this;
        }

        public Criteria andInfotimeEqualTo(Date value) {
            addCriterion("infotime =", value, "infotime");
            return (Criteria) this;
        }

        public Criteria andInfotimeNotEqualTo(Date value) {
            addCriterion("infotime <>", value, "infotime");
            return (Criteria) this;
        }

        public Criteria andInfotimeGreaterThan(Date value) {
            addCriterion("infotime >", value, "infotime");
            return (Criteria) this;
        }

        public Criteria andInfotimeGreaterThanOrEqualTo(Date value) {
            addCriterion("infotime >=", value, "infotime");
            return (Criteria) this;
        }

        public Criteria andInfotimeLessThan(Date value) {
            addCriterion("infotime <", value, "infotime");
            return (Criteria) this;
        }

        public Criteria andInfotimeLessThanOrEqualTo(Date value) {
            addCriterion("infotime <=", value, "infotime");
            return (Criteria) this;
        }

        public Criteria andInfotimeIn(List<Date> values) {
            addCriterion("infotime in", values, "infotime");
            return (Criteria) this;
        }

        public Criteria andInfotimeNotIn(List<Date> values) {
            addCriterion("infotime not in", values, "infotime");
            return (Criteria) this;
        }

        public Criteria andInfotimeBetween(Date value1, Date value2) {
            addCriterion("infotime between", value1, value2, "infotime");
            return (Criteria) this;
        }

        public Criteria andInfotimeNotBetween(Date value1, Date value2) {
            addCriterion("infotime not between", value1, value2, "infotime");
            return (Criteria) this;
        }

        public Criteria andOnlineNownumIsNull() {
            addCriterion("Online_NowNum is null");
            return (Criteria) this;
        }

        public Criteria andOnlineNownumIsNotNull() {
            addCriterion("Online_NowNum is not null");
            return (Criteria) this;
        }

        public Criteria andOnlineNownumEqualTo(Integer value) {
            addCriterion("Online_NowNum =", value, "onlineNownum");
            return (Criteria) this;
        }

        public Criteria andOnlineNownumNotEqualTo(Integer value) {
            addCriterion("Online_NowNum <>", value, "onlineNownum");
            return (Criteria) this;
        }

        public Criteria andOnlineNownumGreaterThan(Integer value) {
            addCriterion("Online_NowNum >", value, "onlineNownum");
            return (Criteria) this;
        }

        public Criteria andOnlineNownumGreaterThanOrEqualTo(Integer value) {
            addCriterion("Online_NowNum >=", value, "onlineNownum");
            return (Criteria) this;
        }

        public Criteria andOnlineNownumLessThan(Integer value) {
            addCriterion("Online_NowNum <", value, "onlineNownum");
            return (Criteria) this;
        }

        public Criteria andOnlineNownumLessThanOrEqualTo(Integer value) {
            addCriterion("Online_NowNum <=", value, "onlineNownum");
            return (Criteria) this;
        }

        public Criteria andOnlineNownumIn(List<Integer> values) {
            addCriterion("Online_NowNum in", values, "onlineNownum");
            return (Criteria) this;
        }

        public Criteria andOnlineNownumNotIn(List<Integer> values) {
            addCriterion("Online_NowNum not in", values, "onlineNownum");
            return (Criteria) this;
        }

        public Criteria andOnlineNownumBetween(Integer value1, Integer value2) {
            addCriterion("Online_NowNum between", value1, value2, "onlineNownum");
            return (Criteria) this;
        }

        public Criteria andOnlineNownumNotBetween(Integer value1, Integer value2) {
            addCriterion("Online_NowNum not between", value1, value2, "onlineNownum");
            return (Criteria) this;
        }

        public Criteria andDisplaynumIsNull() {
            addCriterion("DisplayNum is null");
            return (Criteria) this;
        }

        public Criteria andDisplaynumIsNotNull() {
            addCriterion("DisplayNum is not null");
            return (Criteria) this;
        }

        public Criteria andDisplaynumEqualTo(Integer value) {
            addCriterion("DisplayNum =", value, "displaynum");
            return (Criteria) this;
        }

        public Criteria andDisplaynumNotEqualTo(Integer value) {
            addCriterion("DisplayNum <>", value, "displaynum");
            return (Criteria) this;
        }

        public Criteria andDisplaynumGreaterThan(Integer value) {
            addCriterion("DisplayNum >", value, "displaynum");
            return (Criteria) this;
        }

        public Criteria andDisplaynumGreaterThanOrEqualTo(Integer value) {
            addCriterion("DisplayNum >=", value, "displaynum");
            return (Criteria) this;
        }

        public Criteria andDisplaynumLessThan(Integer value) {
            addCriterion("DisplayNum <", value, "displaynum");
            return (Criteria) this;
        }

        public Criteria andDisplaynumLessThanOrEqualTo(Integer value) {
            addCriterion("DisplayNum <=", value, "displaynum");
            return (Criteria) this;
        }

        public Criteria andDisplaynumIn(List<Integer> values) {
            addCriterion("DisplayNum in", values, "displaynum");
            return (Criteria) this;
        }

        public Criteria andDisplaynumNotIn(List<Integer> values) {
            addCriterion("DisplayNum not in", values, "displaynum");
            return (Criteria) this;
        }

        public Criteria andDisplaynumBetween(Integer value1, Integer value2) {
            addCriterion("DisplayNum between", value1, value2, "displaynum");
            return (Criteria) this;
        }

        public Criteria andDisplaynumNotBetween(Integer value1, Integer value2) {
            addCriterion("DisplayNum not between", value1, value2, "displaynum");
            return (Criteria) this;
        }

        public Criteria andLoginMaxnumIsNull() {
            addCriterion("login_MaxNum is null");
            return (Criteria) this;
        }

        public Criteria andLoginMaxnumIsNotNull() {
            addCriterion("login_MaxNum is not null");
            return (Criteria) this;
        }

        public Criteria andLoginMaxnumEqualTo(Integer value) {
            addCriterion("login_MaxNum =", value, "loginMaxnum");
            return (Criteria) this;
        }

        public Criteria andLoginMaxnumNotEqualTo(Integer value) {
            addCriterion("login_MaxNum <>", value, "loginMaxnum");
            return (Criteria) this;
        }

        public Criteria andLoginMaxnumGreaterThan(Integer value) {
            addCriterion("login_MaxNum >", value, "loginMaxnum");
            return (Criteria) this;
        }

        public Criteria andLoginMaxnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("login_MaxNum >=", value, "loginMaxnum");
            return (Criteria) this;
        }

        public Criteria andLoginMaxnumLessThan(Integer value) {
            addCriterion("login_MaxNum <", value, "loginMaxnum");
            return (Criteria) this;
        }

        public Criteria andLoginMaxnumLessThanOrEqualTo(Integer value) {
            addCriterion("login_MaxNum <=", value, "loginMaxnum");
            return (Criteria) this;
        }

        public Criteria andLoginMaxnumIn(List<Integer> values) {
            addCriterion("login_MaxNum in", values, "loginMaxnum");
            return (Criteria) this;
        }

        public Criteria andLoginMaxnumNotIn(List<Integer> values) {
            addCriterion("login_MaxNum not in", values, "loginMaxnum");
            return (Criteria) this;
        }

        public Criteria andLoginMaxnumBetween(Integer value1, Integer value2) {
            addCriterion("login_MaxNum between", value1, value2, "loginMaxnum");
            return (Criteria) this;
        }

        public Criteria andLoginMaxnumNotBetween(Integer value1, Integer value2) {
            addCriterion("login_MaxNum not between", value1, value2, "loginMaxnum");
            return (Criteria) this;
        }

        public Criteria andLoginDevicenumIsNull() {
            addCriterion("login_DeviceNum is null");
            return (Criteria) this;
        }

        public Criteria andLoginDevicenumIsNotNull() {
            addCriterion("login_DeviceNum is not null");
            return (Criteria) this;
        }

        public Criteria andLoginDevicenumEqualTo(Integer value) {
            addCriterion("login_DeviceNum =", value, "loginDevicenum");
            return (Criteria) this;
        }

        public Criteria andLoginDevicenumNotEqualTo(Integer value) {
            addCriterion("login_DeviceNum <>", value, "loginDevicenum");
            return (Criteria) this;
        }

        public Criteria andLoginDevicenumGreaterThan(Integer value) {
            addCriterion("login_DeviceNum >", value, "loginDevicenum");
            return (Criteria) this;
        }

        public Criteria andLoginDevicenumGreaterThanOrEqualTo(Integer value) {
            addCriterion("login_DeviceNum >=", value, "loginDevicenum");
            return (Criteria) this;
        }

        public Criteria andLoginDevicenumLessThan(Integer value) {
            addCriterion("login_DeviceNum <", value, "loginDevicenum");
            return (Criteria) this;
        }

        public Criteria andLoginDevicenumLessThanOrEqualTo(Integer value) {
            addCriterion("login_DeviceNum <=", value, "loginDevicenum");
            return (Criteria) this;
        }

        public Criteria andLoginDevicenumIn(List<Integer> values) {
            addCriterion("login_DeviceNum in", values, "loginDevicenum");
            return (Criteria) this;
        }

        public Criteria andLoginDevicenumNotIn(List<Integer> values) {
            addCriterion("login_DeviceNum not in", values, "loginDevicenum");
            return (Criteria) this;
        }

        public Criteria andLoginDevicenumBetween(Integer value1, Integer value2) {
            addCriterion("login_DeviceNum between", value1, value2, "loginDevicenum");
            return (Criteria) this;
        }

        public Criteria andLoginDevicenumNotBetween(Integer value1, Integer value2) {
            addCriterion("login_DeviceNum not between", value1, value2, "loginDevicenum");
            return (Criteria) this;
        }

        public Criteria andFilesOpennumIsNull() {
            addCriterion("\" files_OpenNum\" is null");
            return (Criteria) this;
        }

        public Criteria andFilesOpennumIsNotNull() {
            addCriterion("\" files_OpenNum\" is not null");
            return (Criteria) this;
        }

        public Criteria andFilesOpennumEqualTo(Integer value) {
            addCriterion("\" files_OpenNum\" =", value, "filesOpennum");
            return (Criteria) this;
        }

        public Criteria andFilesOpennumNotEqualTo(Integer value) {
            addCriterion("\" files_OpenNum\" <>", value, "filesOpennum");
            return (Criteria) this;
        }

        public Criteria andFilesOpennumGreaterThan(Integer value) {
            addCriterion("\" files_OpenNum\" >", value, "filesOpennum");
            return (Criteria) this;
        }

        public Criteria andFilesOpennumGreaterThanOrEqualTo(Integer value) {
            addCriterion("\" files_OpenNum\" >=", value, "filesOpennum");
            return (Criteria) this;
        }

        public Criteria andFilesOpennumLessThan(Integer value) {
            addCriterion("\" files_OpenNum\" <", value, "filesOpennum");
            return (Criteria) this;
        }

        public Criteria andFilesOpennumLessThanOrEqualTo(Integer value) {
            addCriterion("\" files_OpenNum\" <=", value, "filesOpennum");
            return (Criteria) this;
        }

        public Criteria andFilesOpennumIn(List<Integer> values) {
            addCriterion("\" files_OpenNum\" in", values, "filesOpennum");
            return (Criteria) this;
        }

        public Criteria andFilesOpennumNotIn(List<Integer> values) {
            addCriterion("\" files_OpenNum\" not in", values, "filesOpennum");
            return (Criteria) this;
        }

        public Criteria andFilesOpennumBetween(Integer value1, Integer value2) {
            addCriterion("\" files_OpenNum\" between", value1, value2, "filesOpennum");
            return (Criteria) this;
        }

        public Criteria andFilesOpennumNotBetween(Integer value1, Integer value2) {
            addCriterion("\" files_OpenNum\" not between", value1, value2, "filesOpennum");
            return (Criteria) this;
        }

        public Criteria andLoginMaxdevicenumIsNull() {
            addCriterion("login_MaxDeviceNum is null");
            return (Criteria) this;
        }

        public Criteria andLoginMaxdevicenumIsNotNull() {
            addCriterion("login_MaxDeviceNum is not null");
            return (Criteria) this;
        }

        public Criteria andLoginMaxdevicenumEqualTo(Integer value) {
            addCriterion("login_MaxDeviceNum =", value, "loginMaxdevicenum");
            return (Criteria) this;
        }

        public Criteria andLoginMaxdevicenumNotEqualTo(Integer value) {
            addCriterion("login_MaxDeviceNum <>", value, "loginMaxdevicenum");
            return (Criteria) this;
        }

        public Criteria andLoginMaxdevicenumGreaterThan(Integer value) {
            addCriterion("login_MaxDeviceNum >", value, "loginMaxdevicenum");
            return (Criteria) this;
        }

        public Criteria andLoginMaxdevicenumGreaterThanOrEqualTo(Integer value) {
            addCriterion("login_MaxDeviceNum >=", value, "loginMaxdevicenum");
            return (Criteria) this;
        }

        public Criteria andLoginMaxdevicenumLessThan(Integer value) {
            addCriterion("login_MaxDeviceNum <", value, "loginMaxdevicenum");
            return (Criteria) this;
        }

        public Criteria andLoginMaxdevicenumLessThanOrEqualTo(Integer value) {
            addCriterion("login_MaxDeviceNum <=", value, "loginMaxdevicenum");
            return (Criteria) this;
        }

        public Criteria andLoginMaxdevicenumIn(List<Integer> values) {
            addCriterion("login_MaxDeviceNum in", values, "loginMaxdevicenum");
            return (Criteria) this;
        }

        public Criteria andLoginMaxdevicenumNotIn(List<Integer> values) {
            addCriterion("login_MaxDeviceNum not in", values, "loginMaxdevicenum");
            return (Criteria) this;
        }

        public Criteria andLoginMaxdevicenumBetween(Integer value1, Integer value2) {
            addCriterion("login_MaxDeviceNum between", value1, value2, "loginMaxdevicenum");
            return (Criteria) this;
        }

        public Criteria andLoginMaxdevicenumNotBetween(Integer value1, Integer value2) {
            addCriterion("login_MaxDeviceNum not between", value1, value2, "loginMaxdevicenum");
            return (Criteria) this;
        }

        public Criteria andLoginAppIsNull() {
            addCriterion("login_APP is null");
            return (Criteria) this;
        }

        public Criteria andLoginAppIsNotNull() {
            addCriterion("login_APP is not null");
            return (Criteria) this;
        }

        public Criteria andLoginAppEqualTo(Integer value) {
            addCriterion("login_APP =", value, "loginApp");
            return (Criteria) this;
        }

        public Criteria andLoginAppNotEqualTo(Integer value) {
            addCriterion("login_APP <>", value, "loginApp");
            return (Criteria) this;
        }

        public Criteria andLoginAppGreaterThan(Integer value) {
            addCriterion("login_APP >", value, "loginApp");
            return (Criteria) this;
        }

        public Criteria andLoginAppGreaterThanOrEqualTo(Integer value) {
            addCriterion("login_APP >=", value, "loginApp");
            return (Criteria) this;
        }

        public Criteria andLoginAppLessThan(Integer value) {
            addCriterion("login_APP <", value, "loginApp");
            return (Criteria) this;
        }

        public Criteria andLoginAppLessThanOrEqualTo(Integer value) {
            addCriterion("login_APP <=", value, "loginApp");
            return (Criteria) this;
        }

        public Criteria andLoginAppIn(List<Integer> values) {
            addCriterion("login_APP in", values, "loginApp");
            return (Criteria) this;
        }

        public Criteria andLoginAppNotIn(List<Integer> values) {
            addCriterion("login_APP not in", values, "loginApp");
            return (Criteria) this;
        }

        public Criteria andLoginAppBetween(Integer value1, Integer value2) {
            addCriterion("login_APP between", value1, value2, "loginApp");
            return (Criteria) this;
        }

        public Criteria andLoginAppNotBetween(Integer value1, Integer value2) {
            addCriterion("login_APP not between", value1, value2, "loginApp");
            return (Criteria) this;
        }

        public Criteria andMsgGetIsNull() {
            addCriterion("msg_GET is null");
            return (Criteria) this;
        }

        public Criteria andMsgGetIsNotNull() {
            addCriterion("msg_GET is not null");
            return (Criteria) this;
        }

        public Criteria andMsgGetEqualTo(Integer value) {
            addCriterion("msg_GET =", value, "msgGet");
            return (Criteria) this;
        }

        public Criteria andMsgGetNotEqualTo(Integer value) {
            addCriterion("msg_GET <>", value, "msgGet");
            return (Criteria) this;
        }

        public Criteria andMsgGetGreaterThan(Integer value) {
            addCriterion("msg_GET >", value, "msgGet");
            return (Criteria) this;
        }

        public Criteria andMsgGetGreaterThanOrEqualTo(Integer value) {
            addCriterion("msg_GET >=", value, "msgGet");
            return (Criteria) this;
        }

        public Criteria andMsgGetLessThan(Integer value) {
            addCriterion("msg_GET <", value, "msgGet");
            return (Criteria) this;
        }

        public Criteria andMsgGetLessThanOrEqualTo(Integer value) {
            addCriterion("msg_GET <=", value, "msgGet");
            return (Criteria) this;
        }

        public Criteria andMsgGetIn(List<Integer> values) {
            addCriterion("msg_GET in", values, "msgGet");
            return (Criteria) this;
        }

        public Criteria andMsgGetNotIn(List<Integer> values) {
            addCriterion("msg_GET not in", values, "msgGet");
            return (Criteria) this;
        }

        public Criteria andMsgGetBetween(Integer value1, Integer value2) {
            addCriterion("msg_GET between", value1, value2, "msgGet");
            return (Criteria) this;
        }

        public Criteria andMsgGetNotBetween(Integer value1, Integer value2) {
            addCriterion("msg_GET not between", value1, value2, "msgGet");
            return (Criteria) this;
        }

        public Criteria andMsgSendIsNull() {
            addCriterion("msg_SEND is null");
            return (Criteria) this;
        }

        public Criteria andMsgSendIsNotNull() {
            addCriterion("msg_SEND is not null");
            return (Criteria) this;
        }

        public Criteria andMsgSendEqualTo(Integer value) {
            addCriterion("msg_SEND =", value, "msgSend");
            return (Criteria) this;
        }

        public Criteria andMsgSendNotEqualTo(Integer value) {
            addCriterion("msg_SEND <>", value, "msgSend");
            return (Criteria) this;
        }

        public Criteria andMsgSendGreaterThan(Integer value) {
            addCriterion("msg_SEND >", value, "msgSend");
            return (Criteria) this;
        }

        public Criteria andMsgSendGreaterThanOrEqualTo(Integer value) {
            addCriterion("msg_SEND >=", value, "msgSend");
            return (Criteria) this;
        }

        public Criteria andMsgSendLessThan(Integer value) {
            addCriterion("msg_SEND <", value, "msgSend");
            return (Criteria) this;
        }

        public Criteria andMsgSendLessThanOrEqualTo(Integer value) {
            addCriterion("msg_SEND <=", value, "msgSend");
            return (Criteria) this;
        }

        public Criteria andMsgSendIn(List<Integer> values) {
            addCriterion("msg_SEND in", values, "msgSend");
            return (Criteria) this;
        }

        public Criteria andMsgSendNotIn(List<Integer> values) {
            addCriterion("msg_SEND not in", values, "msgSend");
            return (Criteria) this;
        }

        public Criteria andMsgSendBetween(Integer value1, Integer value2) {
            addCriterion("msg_SEND between", value1, value2, "msgSend");
            return (Criteria) this;
        }

        public Criteria andMsgSendNotBetween(Integer value1, Integer value2) {
            addCriterion("msg_SEND not between", value1, value2, "msgSend");
            return (Criteria) this;
        }

        public Criteria andCurrentusernumIsNull() {
            addCriterion("CURRENTUSERNUM is null");
            return (Criteria) this;
        }

        public Criteria andCurrentusernumIsNotNull() {
            addCriterion("CURRENTUSERNUM is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentusernumEqualTo(String value) {
            addCriterion("CURRENTUSERNUM =", value, "currentusernum");
            return (Criteria) this;
        }

        public Criteria andCurrentusernumNotEqualTo(String value) {
            addCriterion("CURRENTUSERNUM <>", value, "currentusernum");
            return (Criteria) this;
        }

        public Criteria andCurrentusernumGreaterThan(String value) {
            addCriterion("CURRENTUSERNUM >", value, "currentusernum");
            return (Criteria) this;
        }

        public Criteria andCurrentusernumGreaterThanOrEqualTo(String value) {
            addCriterion("CURRENTUSERNUM >=", value, "currentusernum");
            return (Criteria) this;
        }

        public Criteria andCurrentusernumLessThan(String value) {
            addCriterion("CURRENTUSERNUM <", value, "currentusernum");
            return (Criteria) this;
        }

        public Criteria andCurrentusernumLessThanOrEqualTo(String value) {
            addCriterion("CURRENTUSERNUM <=", value, "currentusernum");
            return (Criteria) this;
        }

        public Criteria andCurrentusernumLike(String value) {
            addCriterion("CURRENTUSERNUM like", value, "currentusernum");
            return (Criteria) this;
        }

        public Criteria andCurrentusernumNotLike(String value) {
            addCriterion("CURRENTUSERNUM not like", value, "currentusernum");
            return (Criteria) this;
        }

        public Criteria andCurrentusernumIn(List<String> values) {
            addCriterion("CURRENTUSERNUM in", values, "currentusernum");
            return (Criteria) this;
        }

        public Criteria andCurrentusernumNotIn(List<String> values) {
            addCriterion("CURRENTUSERNUM not in", values, "currentusernum");
            return (Criteria) this;
        }

        public Criteria andCurrentusernumBetween(String value1, String value2) {
            addCriterion("CURRENTUSERNUM between", value1, value2, "currentusernum");
            return (Criteria) this;
        }

        public Criteria andCurrentusernumNotBetween(String value1, String value2) {
            addCriterion("CURRENTUSERNUM not between", value1, value2, "currentusernum");
            return (Criteria) this;
        }

        public Criteria andInterfaceusernumIsNull() {
            addCriterion("INTERFACEUSERNUM is null");
            return (Criteria) this;
        }

        public Criteria andInterfaceusernumIsNotNull() {
            addCriterion("INTERFACEUSERNUM is not null");
            return (Criteria) this;
        }

        public Criteria andInterfaceusernumEqualTo(String value) {
            addCriterion("INTERFACEUSERNUM =", value, "interfaceusernum");
            return (Criteria) this;
        }

        public Criteria andInterfaceusernumNotEqualTo(String value) {
            addCriterion("INTERFACEUSERNUM <>", value, "interfaceusernum");
            return (Criteria) this;
        }

        public Criteria andInterfaceusernumGreaterThan(String value) {
            addCriterion("INTERFACEUSERNUM >", value, "interfaceusernum");
            return (Criteria) this;
        }

        public Criteria andInterfaceusernumGreaterThanOrEqualTo(String value) {
            addCriterion("INTERFACEUSERNUM >=", value, "interfaceusernum");
            return (Criteria) this;
        }

        public Criteria andInterfaceusernumLessThan(String value) {
            addCriterion("INTERFACEUSERNUM <", value, "interfaceusernum");
            return (Criteria) this;
        }

        public Criteria andInterfaceusernumLessThanOrEqualTo(String value) {
            addCriterion("INTERFACEUSERNUM <=", value, "interfaceusernum");
            return (Criteria) this;
        }

        public Criteria andInterfaceusernumLike(String value) {
            addCriterion("INTERFACEUSERNUM like", value, "interfaceusernum");
            return (Criteria) this;
        }

        public Criteria andInterfaceusernumNotLike(String value) {
            addCriterion("INTERFACEUSERNUM not like", value, "interfaceusernum");
            return (Criteria) this;
        }

        public Criteria andInterfaceusernumIn(List<String> values) {
            addCriterion("INTERFACEUSERNUM in", values, "interfaceusernum");
            return (Criteria) this;
        }

        public Criteria andInterfaceusernumNotIn(List<String> values) {
            addCriterion("INTERFACEUSERNUM not in", values, "interfaceusernum");
            return (Criteria) this;
        }

        public Criteria andInterfaceusernumBetween(String value1, String value2) {
            addCriterion("INTERFACEUSERNUM between", value1, value2, "interfaceusernum");
            return (Criteria) this;
        }

        public Criteria andInterfaceusernumNotBetween(String value1, String value2) {
            addCriterion("INTERFACEUSERNUM not between", value1, value2, "interfaceusernum");
            return (Criteria) this;
        }

        public Criteria andMaxloginusernumIsNull() {
            addCriterion("MAXLOGINUSERNUM is null");
            return (Criteria) this;
        }

        public Criteria andMaxloginusernumIsNotNull() {
            addCriterion("MAXLOGINUSERNUM is not null");
            return (Criteria) this;
        }

        public Criteria andMaxloginusernumEqualTo(String value) {
            addCriterion("MAXLOGINUSERNUM =", value, "maxloginusernum");
            return (Criteria) this;
        }

        public Criteria andMaxloginusernumNotEqualTo(String value) {
            addCriterion("MAXLOGINUSERNUM <>", value, "maxloginusernum");
            return (Criteria) this;
        }

        public Criteria andMaxloginusernumGreaterThan(String value) {
            addCriterion("MAXLOGINUSERNUM >", value, "maxloginusernum");
            return (Criteria) this;
        }

        public Criteria andMaxloginusernumGreaterThanOrEqualTo(String value) {
            addCriterion("MAXLOGINUSERNUM >=", value, "maxloginusernum");
            return (Criteria) this;
        }

        public Criteria andMaxloginusernumLessThan(String value) {
            addCriterion("MAXLOGINUSERNUM <", value, "maxloginusernum");
            return (Criteria) this;
        }

        public Criteria andMaxloginusernumLessThanOrEqualTo(String value) {
            addCriterion("MAXLOGINUSERNUM <=", value, "maxloginusernum");
            return (Criteria) this;
        }

        public Criteria andMaxloginusernumLike(String value) {
            addCriterion("MAXLOGINUSERNUM like", value, "maxloginusernum");
            return (Criteria) this;
        }

        public Criteria andMaxloginusernumNotLike(String value) {
            addCriterion("MAXLOGINUSERNUM not like", value, "maxloginusernum");
            return (Criteria) this;
        }

        public Criteria andMaxloginusernumIn(List<String> values) {
            addCriterion("MAXLOGINUSERNUM in", values, "maxloginusernum");
            return (Criteria) this;
        }

        public Criteria andMaxloginusernumNotIn(List<String> values) {
            addCriterion("MAXLOGINUSERNUM not in", values, "maxloginusernum");
            return (Criteria) this;
        }

        public Criteria andMaxloginusernumBetween(String value1, String value2) {
            addCriterion("MAXLOGINUSERNUM between", value1, value2, "maxloginusernum");
            return (Criteria) this;
        }

        public Criteria andMaxloginusernumNotBetween(String value1, String value2) {
            addCriterion("MAXLOGINUSERNUM not between", value1, value2, "maxloginusernum");
            return (Criteria) this;
        }

        public Criteria andDeviceloginnumIsNull() {
            addCriterion("DEVICELOGINNUM is null");
            return (Criteria) this;
        }

        public Criteria andDeviceloginnumIsNotNull() {
            addCriterion("DEVICELOGINNUM is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceloginnumEqualTo(String value) {
            addCriterion("DEVICELOGINNUM =", value, "deviceloginnum");
            return (Criteria) this;
        }

        public Criteria andDeviceloginnumNotEqualTo(String value) {
            addCriterion("DEVICELOGINNUM <>", value, "deviceloginnum");
            return (Criteria) this;
        }

        public Criteria andDeviceloginnumGreaterThan(String value) {
            addCriterion("DEVICELOGINNUM >", value, "deviceloginnum");
            return (Criteria) this;
        }

        public Criteria andDeviceloginnumGreaterThanOrEqualTo(String value) {
            addCriterion("DEVICELOGINNUM >=", value, "deviceloginnum");
            return (Criteria) this;
        }

        public Criteria andDeviceloginnumLessThan(String value) {
            addCriterion("DEVICELOGINNUM <", value, "deviceloginnum");
            return (Criteria) this;
        }

        public Criteria andDeviceloginnumLessThanOrEqualTo(String value) {
            addCriterion("DEVICELOGINNUM <=", value, "deviceloginnum");
            return (Criteria) this;
        }

        public Criteria andDeviceloginnumLike(String value) {
            addCriterion("DEVICELOGINNUM like", value, "deviceloginnum");
            return (Criteria) this;
        }

        public Criteria andDeviceloginnumNotLike(String value) {
            addCriterion("DEVICELOGINNUM not like", value, "deviceloginnum");
            return (Criteria) this;
        }

        public Criteria andDeviceloginnumIn(List<String> values) {
            addCriterion("DEVICELOGINNUM in", values, "deviceloginnum");
            return (Criteria) this;
        }

        public Criteria andDeviceloginnumNotIn(List<String> values) {
            addCriterion("DEVICELOGINNUM not in", values, "deviceloginnum");
            return (Criteria) this;
        }

        public Criteria andDeviceloginnumBetween(String value1, String value2) {
            addCriterion("DEVICELOGINNUM between", value1, value2, "deviceloginnum");
            return (Criteria) this;
        }

        public Criteria andDeviceloginnumNotBetween(String value1, String value2) {
            addCriterion("DEVICELOGINNUM not between", value1, value2, "deviceloginnum");
            return (Criteria) this;
        }

        public Criteria andFileopenednumIsNull() {
            addCriterion("FILEOPENEDNUM is null");
            return (Criteria) this;
        }

        public Criteria andFileopenednumIsNotNull() {
            addCriterion("FILEOPENEDNUM is not null");
            return (Criteria) this;
        }

        public Criteria andFileopenednumEqualTo(String value) {
            addCriterion("FILEOPENEDNUM =", value, "fileopenednum");
            return (Criteria) this;
        }

        public Criteria andFileopenednumNotEqualTo(String value) {
            addCriterion("FILEOPENEDNUM <>", value, "fileopenednum");
            return (Criteria) this;
        }

        public Criteria andFileopenednumGreaterThan(String value) {
            addCriterion("FILEOPENEDNUM >", value, "fileopenednum");
            return (Criteria) this;
        }

        public Criteria andFileopenednumGreaterThanOrEqualTo(String value) {
            addCriterion("FILEOPENEDNUM >=", value, "fileopenednum");
            return (Criteria) this;
        }

        public Criteria andFileopenednumLessThan(String value) {
            addCriterion("FILEOPENEDNUM <", value, "fileopenednum");
            return (Criteria) this;
        }

        public Criteria andFileopenednumLessThanOrEqualTo(String value) {
            addCriterion("FILEOPENEDNUM <=", value, "fileopenednum");
            return (Criteria) this;
        }

        public Criteria andFileopenednumLike(String value) {
            addCriterion("FILEOPENEDNUM like", value, "fileopenednum");
            return (Criteria) this;
        }

        public Criteria andFileopenednumNotLike(String value) {
            addCriterion("FILEOPENEDNUM not like", value, "fileopenednum");
            return (Criteria) this;
        }

        public Criteria andFileopenednumIn(List<String> values) {
            addCriterion("FILEOPENEDNUM in", values, "fileopenednum");
            return (Criteria) this;
        }

        public Criteria andFileopenednumNotIn(List<String> values) {
            addCriterion("FILEOPENEDNUM not in", values, "fileopenednum");
            return (Criteria) this;
        }

        public Criteria andFileopenednumBetween(String value1, String value2) {
            addCriterion("FILEOPENEDNUM between", value1, value2, "fileopenednum");
            return (Criteria) this;
        }

        public Criteria andFileopenednumNotBetween(String value1, String value2) {
            addCriterion("FILEOPENEDNUM not between", value1, value2, "fileopenednum");
            return (Criteria) this;
        }

        public Criteria andMaxlogindevicenumIsNull() {
            addCriterion("MAXLOGINDEVICENUM is null");
            return (Criteria) this;
        }

        public Criteria andMaxlogindevicenumIsNotNull() {
            addCriterion("MAXLOGINDEVICENUM is not null");
            return (Criteria) this;
        }

        public Criteria andMaxlogindevicenumEqualTo(String value) {
            addCriterion("MAXLOGINDEVICENUM =", value, "maxlogindevicenum");
            return (Criteria) this;
        }

        public Criteria andMaxlogindevicenumNotEqualTo(String value) {
            addCriterion("MAXLOGINDEVICENUM <>", value, "maxlogindevicenum");
            return (Criteria) this;
        }

        public Criteria andMaxlogindevicenumGreaterThan(String value) {
            addCriterion("MAXLOGINDEVICENUM >", value, "maxlogindevicenum");
            return (Criteria) this;
        }

        public Criteria andMaxlogindevicenumGreaterThanOrEqualTo(String value) {
            addCriterion("MAXLOGINDEVICENUM >=", value, "maxlogindevicenum");
            return (Criteria) this;
        }

        public Criteria andMaxlogindevicenumLessThan(String value) {
            addCriterion("MAXLOGINDEVICENUM <", value, "maxlogindevicenum");
            return (Criteria) this;
        }

        public Criteria andMaxlogindevicenumLessThanOrEqualTo(String value) {
            addCriterion("MAXLOGINDEVICENUM <=", value, "maxlogindevicenum");
            return (Criteria) this;
        }

        public Criteria andMaxlogindevicenumLike(String value) {
            addCriterion("MAXLOGINDEVICENUM like", value, "maxlogindevicenum");
            return (Criteria) this;
        }

        public Criteria andMaxlogindevicenumNotLike(String value) {
            addCriterion("MAXLOGINDEVICENUM not like", value, "maxlogindevicenum");
            return (Criteria) this;
        }

        public Criteria andMaxlogindevicenumIn(List<String> values) {
            addCriterion("MAXLOGINDEVICENUM in", values, "maxlogindevicenum");
            return (Criteria) this;
        }

        public Criteria andMaxlogindevicenumNotIn(List<String> values) {
            addCriterion("MAXLOGINDEVICENUM not in", values, "maxlogindevicenum");
            return (Criteria) this;
        }

        public Criteria andMaxlogindevicenumBetween(String value1, String value2) {
            addCriterion("MAXLOGINDEVICENUM between", value1, value2, "maxlogindevicenum");
            return (Criteria) this;
        }

        public Criteria andMaxlogindevicenumNotBetween(String value1, String value2) {
            addCriterion("MAXLOGINDEVICENUM not between", value1, value2, "maxlogindevicenum");
            return (Criteria) this;
        }

        public Criteria andApploginnumIsNull() {
            addCriterion("APPLOGINNUM is null");
            return (Criteria) this;
        }

        public Criteria andApploginnumIsNotNull() {
            addCriterion("APPLOGINNUM is not null");
            return (Criteria) this;
        }

        public Criteria andApploginnumEqualTo(String value) {
            addCriterion("APPLOGINNUM =", value, "apploginnum");
            return (Criteria) this;
        }

        public Criteria andApploginnumNotEqualTo(String value) {
            addCriterion("APPLOGINNUM <>", value, "apploginnum");
            return (Criteria) this;
        }

        public Criteria andApploginnumGreaterThan(String value) {
            addCriterion("APPLOGINNUM >", value, "apploginnum");
            return (Criteria) this;
        }

        public Criteria andApploginnumGreaterThanOrEqualTo(String value) {
            addCriterion("APPLOGINNUM >=", value, "apploginnum");
            return (Criteria) this;
        }

        public Criteria andApploginnumLessThan(String value) {
            addCriterion("APPLOGINNUM <", value, "apploginnum");
            return (Criteria) this;
        }

        public Criteria andApploginnumLessThanOrEqualTo(String value) {
            addCriterion("APPLOGINNUM <=", value, "apploginnum");
            return (Criteria) this;
        }

        public Criteria andApploginnumLike(String value) {
            addCriterion("APPLOGINNUM like", value, "apploginnum");
            return (Criteria) this;
        }

        public Criteria andApploginnumNotLike(String value) {
            addCriterion("APPLOGINNUM not like", value, "apploginnum");
            return (Criteria) this;
        }

        public Criteria andApploginnumIn(List<String> values) {
            addCriterion("APPLOGINNUM in", values, "apploginnum");
            return (Criteria) this;
        }

        public Criteria andApploginnumNotIn(List<String> values) {
            addCriterion("APPLOGINNUM not in", values, "apploginnum");
            return (Criteria) this;
        }

        public Criteria andApploginnumBetween(String value1, String value2) {
            addCriterion("APPLOGINNUM between", value1, value2, "apploginnum");
            return (Criteria) this;
        }

        public Criteria andApploginnumNotBetween(String value1, String value2) {
            addCriterion("APPLOGINNUM not between", value1, value2, "apploginnum");
            return (Criteria) this;
        }

        public Criteria andAchivemsgnumIsNull() {
            addCriterion("ACHIVEMSGNUM is null");
            return (Criteria) this;
        }

        public Criteria andAchivemsgnumIsNotNull() {
            addCriterion("ACHIVEMSGNUM is not null");
            return (Criteria) this;
        }

        public Criteria andAchivemsgnumEqualTo(String value) {
            addCriterion("ACHIVEMSGNUM =", value, "achivemsgnum");
            return (Criteria) this;
        }

        public Criteria andAchivemsgnumNotEqualTo(String value) {
            addCriterion("ACHIVEMSGNUM <>", value, "achivemsgnum");
            return (Criteria) this;
        }

        public Criteria andAchivemsgnumGreaterThan(String value) {
            addCriterion("ACHIVEMSGNUM >", value, "achivemsgnum");
            return (Criteria) this;
        }

        public Criteria andAchivemsgnumGreaterThanOrEqualTo(String value) {
            addCriterion("ACHIVEMSGNUM >=", value, "achivemsgnum");
            return (Criteria) this;
        }

        public Criteria andAchivemsgnumLessThan(String value) {
            addCriterion("ACHIVEMSGNUM <", value, "achivemsgnum");
            return (Criteria) this;
        }

        public Criteria andAchivemsgnumLessThanOrEqualTo(String value) {
            addCriterion("ACHIVEMSGNUM <=", value, "achivemsgnum");
            return (Criteria) this;
        }

        public Criteria andAchivemsgnumLike(String value) {
            addCriterion("ACHIVEMSGNUM like", value, "achivemsgnum");
            return (Criteria) this;
        }

        public Criteria andAchivemsgnumNotLike(String value) {
            addCriterion("ACHIVEMSGNUM not like", value, "achivemsgnum");
            return (Criteria) this;
        }

        public Criteria andAchivemsgnumIn(List<String> values) {
            addCriterion("ACHIVEMSGNUM in", values, "achivemsgnum");
            return (Criteria) this;
        }

        public Criteria andAchivemsgnumNotIn(List<String> values) {
            addCriterion("ACHIVEMSGNUM not in", values, "achivemsgnum");
            return (Criteria) this;
        }

        public Criteria andAchivemsgnumBetween(String value1, String value2) {
            addCriterion("ACHIVEMSGNUM between", value1, value2, "achivemsgnum");
            return (Criteria) this;
        }

        public Criteria andAchivemsgnumNotBetween(String value1, String value2) {
            addCriterion("ACHIVEMSGNUM not between", value1, value2, "achivemsgnum");
            return (Criteria) this;
        }

        public Criteria andSendmsgnumIsNull() {
            addCriterion("SENDMSGNUM is null");
            return (Criteria) this;
        }

        public Criteria andSendmsgnumIsNotNull() {
            addCriterion("SENDMSGNUM is not null");
            return (Criteria) this;
        }

        public Criteria andSendmsgnumEqualTo(String value) {
            addCriterion("SENDMSGNUM =", value, "sendmsgnum");
            return (Criteria) this;
        }

        public Criteria andSendmsgnumNotEqualTo(String value) {
            addCriterion("SENDMSGNUM <>", value, "sendmsgnum");
            return (Criteria) this;
        }

        public Criteria andSendmsgnumGreaterThan(String value) {
            addCriterion("SENDMSGNUM >", value, "sendmsgnum");
            return (Criteria) this;
        }

        public Criteria andSendmsgnumGreaterThanOrEqualTo(String value) {
            addCriterion("SENDMSGNUM >=", value, "sendmsgnum");
            return (Criteria) this;
        }

        public Criteria andSendmsgnumLessThan(String value) {
            addCriterion("SENDMSGNUM <", value, "sendmsgnum");
            return (Criteria) this;
        }

        public Criteria andSendmsgnumLessThanOrEqualTo(String value) {
            addCriterion("SENDMSGNUM <=", value, "sendmsgnum");
            return (Criteria) this;
        }

        public Criteria andSendmsgnumLike(String value) {
            addCriterion("SENDMSGNUM like", value, "sendmsgnum");
            return (Criteria) this;
        }

        public Criteria andSendmsgnumNotLike(String value) {
            addCriterion("SENDMSGNUM not like", value, "sendmsgnum");
            return (Criteria) this;
        }

        public Criteria andSendmsgnumIn(List<String> values) {
            addCriterion("SENDMSGNUM in", values, "sendmsgnum");
            return (Criteria) this;
        }

        public Criteria andSendmsgnumNotIn(List<String> values) {
            addCriterion("SENDMSGNUM not in", values, "sendmsgnum");
            return (Criteria) this;
        }

        public Criteria andSendmsgnumBetween(String value1, String value2) {
            addCriterion("SENDMSGNUM between", value1, value2, "sendmsgnum");
            return (Criteria) this;
        }

        public Criteria andSendmsgnumNotBetween(String value1, String value2) {
            addCriterion("SENDMSGNUM not between", value1, value2, "sendmsgnum");
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