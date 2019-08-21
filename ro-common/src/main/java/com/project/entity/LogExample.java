package com.project.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LogExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table log
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table log
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table log
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table log
     *
     * @mbggenerated
     */
    public LogExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table log
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table log
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table log
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table log
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table log
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table log
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table log
     *
     * @mbggenerated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table log
     *
     * @mbggenerated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table log
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table log
     *
     * @mbggenerated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table log
     *
     * @mbggenerated
     */
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andLoginaccountIsNull() {
            addCriterion("loginaccount is null");
            return (Criteria) this;
        }

        public Criteria andLoginaccountIsNotNull() {
            addCriterion("loginaccount is not null");
            return (Criteria) this;
        }

        public Criteria andLoginaccountEqualTo(String value) {
            addCriterion("loginaccount =", value, "loginaccount");
            return (Criteria) this;
        }

        public Criteria andLoginaccountNotEqualTo(String value) {
            addCriterion("loginaccount <>", value, "loginaccount");
            return (Criteria) this;
        }

        public Criteria andLoginaccountGreaterThan(String value) {
            addCriterion("loginaccount >", value, "loginaccount");
            return (Criteria) this;
        }

        public Criteria andLoginaccountGreaterThanOrEqualTo(String value) {
            addCriterion("loginaccount >=", value, "loginaccount");
            return (Criteria) this;
        }

        public Criteria andLoginaccountLessThan(String value) {
            addCriterion("loginaccount <", value, "loginaccount");
            return (Criteria) this;
        }

        public Criteria andLoginaccountLessThanOrEqualTo(String value) {
            addCriterion("loginaccount <=", value, "loginaccount");
            return (Criteria) this;
        }

        public Criteria andLoginaccountLike(String value) {
            addCriterion("loginaccount like", value, "loginaccount");
            return (Criteria) this;
        }

        public Criteria andLoginaccountNotLike(String value) {
            addCriterion("loginaccount not like", value, "loginaccount");
            return (Criteria) this;
        }

        public Criteria andLoginaccountIn(List<String> values) {
            addCriterion("loginaccount in", values, "loginaccount");
            return (Criteria) this;
        }

        public Criteria andLoginaccountNotIn(List<String> values) {
            addCriterion("loginaccount not in", values, "loginaccount");
            return (Criteria) this;
        }

        public Criteria andLoginaccountBetween(String value1, String value2) {
            addCriterion("loginaccount between", value1, value2, "loginaccount");
            return (Criteria) this;
        }

        public Criteria andLoginaccountNotBetween(String value1, String value2) {
            addCriterion("loginaccount not between", value1, value2, "loginaccount");
            return (Criteria) this;
        }

        public Criteria andLoginipIsNull() {
            addCriterion("loginip is null");
            return (Criteria) this;
        }

        public Criteria andLoginipIsNotNull() {
            addCriterion("loginip is not null");
            return (Criteria) this;
        }

        public Criteria andLoginipEqualTo(String value) {
            addCriterion("loginip =", value, "loginip");
            return (Criteria) this;
        }

        public Criteria andLoginipNotEqualTo(String value) {
            addCriterion("loginip <>", value, "loginip");
            return (Criteria) this;
        }

        public Criteria andLoginipGreaterThan(String value) {
            addCriterion("loginip >", value, "loginip");
            return (Criteria) this;
        }

        public Criteria andLoginipGreaterThanOrEqualTo(String value) {
            addCriterion("loginip >=", value, "loginip");
            return (Criteria) this;
        }

        public Criteria andLoginipLessThan(String value) {
            addCriterion("loginip <", value, "loginip");
            return (Criteria) this;
        }

        public Criteria andLoginipLessThanOrEqualTo(String value) {
            addCriterion("loginip <=", value, "loginip");
            return (Criteria) this;
        }

        public Criteria andLoginipLike(String value) {
            addCriterion("loginip like", value, "loginip");
            return (Criteria) this;
        }

        public Criteria andLoginipNotLike(String value) {
            addCriterion("loginip not like", value, "loginip");
            return (Criteria) this;
        }

        public Criteria andLoginipIn(List<String> values) {
            addCriterion("loginip in", values, "loginip");
            return (Criteria) this;
        }

        public Criteria andLoginipNotIn(List<String> values) {
            addCriterion("loginip not in", values, "loginip");
            return (Criteria) this;
        }

        public Criteria andLoginipBetween(String value1, String value2) {
            addCriterion("loginip between", value1, value2, "loginip");
            return (Criteria) this;
        }

        public Criteria andLoginipNotBetween(String value1, String value2) {
            addCriterion("loginip not between", value1, value2, "loginip");
            return (Criteria) this;
        }

        public Criteria andActionurlIsNull() {
            addCriterion("actionurl is null");
            return (Criteria) this;
        }

        public Criteria andActionurlIsNotNull() {
            addCriterion("actionurl is not null");
            return (Criteria) this;
        }

        public Criteria andActionurlEqualTo(String value) {
            addCriterion("actionurl =", value, "actionurl");
            return (Criteria) this;
        }

        public Criteria andActionurlNotEqualTo(String value) {
            addCriterion("actionurl <>", value, "actionurl");
            return (Criteria) this;
        }

        public Criteria andActionurlGreaterThan(String value) {
            addCriterion("actionurl >", value, "actionurl");
            return (Criteria) this;
        }

        public Criteria andActionurlGreaterThanOrEqualTo(String value) {
            addCriterion("actionurl >=", value, "actionurl");
            return (Criteria) this;
        }

        public Criteria andActionurlLessThan(String value) {
            addCriterion("actionurl <", value, "actionurl");
            return (Criteria) this;
        }

        public Criteria andActionurlLessThanOrEqualTo(String value) {
            addCriterion("actionurl <=", value, "actionurl");
            return (Criteria) this;
        }

        public Criteria andActionurlLike(String value) {
            addCriterion("actionurl like", value, "actionurl");
            return (Criteria) this;
        }

        public Criteria andActionurlNotLike(String value) {
            addCriterion("actionurl not like", value, "actionurl");
            return (Criteria) this;
        }

        public Criteria andActionurlIn(List<String> values) {
            addCriterion("actionurl in", values, "actionurl");
            return (Criteria) this;
        }

        public Criteria andActionurlNotIn(List<String> values) {
            addCriterion("actionurl not in", values, "actionurl");
            return (Criteria) this;
        }

        public Criteria andActionurlBetween(String value1, String value2) {
            addCriterion("actionurl between", value1, value2, "actionurl");
            return (Criteria) this;
        }

        public Criteria andActionurlNotBetween(String value1, String value2) {
            addCriterion("actionurl not between", value1, value2, "actionurl");
            return (Criteria) this;
        }

        public Criteria andModuleIsNull() {
            addCriterion("module is null");
            return (Criteria) this;
        }

        public Criteria andModuleIsNotNull() {
            addCriterion("module is not null");
            return (Criteria) this;
        }

        public Criteria andModuleEqualTo(String value) {
            addCriterion("module =", value, "module");
            return (Criteria) this;
        }

        public Criteria andModuleNotEqualTo(String value) {
            addCriterion("module <>", value, "module");
            return (Criteria) this;
        }

        public Criteria andModuleGreaterThan(String value) {
            addCriterion("module >", value, "module");
            return (Criteria) this;
        }

        public Criteria andModuleGreaterThanOrEqualTo(String value) {
            addCriterion("module >=", value, "module");
            return (Criteria) this;
        }

        public Criteria andModuleLessThan(String value) {
            addCriterion("module <", value, "module");
            return (Criteria) this;
        }

        public Criteria andModuleLessThanOrEqualTo(String value) {
            addCriterion("module <=", value, "module");
            return (Criteria) this;
        }

        public Criteria andModuleLike(String value) {
            addCriterion("module like", value, "module");
            return (Criteria) this;
        }

        public Criteria andModuleNotLike(String value) {
            addCriterion("module not like", value, "module");
            return (Criteria) this;
        }

        public Criteria andModuleIn(List<String> values) {
            addCriterion("module in", values, "module");
            return (Criteria) this;
        }

        public Criteria andModuleNotIn(List<String> values) {
            addCriterion("module not in", values, "module");
            return (Criteria) this;
        }

        public Criteria andModuleBetween(String value1, String value2) {
            addCriterion("module between", value1, value2, "module");
            return (Criteria) this;
        }

        public Criteria andModuleNotBetween(String value1, String value2) {
            addCriterion("module not between", value1, value2, "module");
            return (Criteria) this;
        }

        public Criteria andMethodIsNull() {
            addCriterion("method is null");
            return (Criteria) this;
        }

        public Criteria andMethodIsNotNull() {
            addCriterion("method is not null");
            return (Criteria) this;
        }

        public Criteria andMethodEqualTo(String value) {
            addCriterion("method =", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotEqualTo(String value) {
            addCriterion("method <>", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodGreaterThan(String value) {
            addCriterion("method >", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodGreaterThanOrEqualTo(String value) {
            addCriterion("method >=", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodLessThan(String value) {
            addCriterion("method <", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodLessThanOrEqualTo(String value) {
            addCriterion("method <=", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodLike(String value) {
            addCriterion("method like", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotLike(String value) {
            addCriterion("method not like", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodIn(List<String> values) {
            addCriterion("method in", values, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotIn(List<String> values) {
            addCriterion("method not in", values, "method");
            return (Criteria) this;
        }

        public Criteria andMethodBetween(String value1, String value2) {
            addCriterion("method between", value1, value2, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotBetween(String value1, String value2) {
            addCriterion("method not between", value1, value2, "method");
            return (Criteria) this;
        }

        public Criteria andActiontimeIsNull() {
            addCriterion("actiontime is null");
            return (Criteria) this;
        }

        public Criteria andActiontimeIsNotNull() {
            addCriterion("actiontime is not null");
            return (Criteria) this;
        }

        public Criteria andActiontimeEqualTo(Long value) {
            addCriterion("actiontime =", value, "actiontime");
            return (Criteria) this;
        }

        public Criteria andActiontimeNotEqualTo(Long value) {
            addCriterion("actiontime <>", value, "actiontime");
            return (Criteria) this;
        }

        public Criteria andActiontimeGreaterThan(Long value) {
            addCriterion("actiontime >", value, "actiontime");
            return (Criteria) this;
        }

        public Criteria andActiontimeGreaterThanOrEqualTo(Long value) {
            addCriterion("actiontime >=", value, "actiontime");
            return (Criteria) this;
        }

        public Criteria andActiontimeLessThan(Long value) {
            addCriterion("actiontime <", value, "actiontime");
            return (Criteria) this;
        }

        public Criteria andActiontimeLessThanOrEqualTo(Long value) {
            addCriterion("actiontime <=", value, "actiontime");
            return (Criteria) this;
        }

        public Criteria andActiontimeIn(List<Long> values) {
            addCriterion("actiontime in", values, "actiontime");
            return (Criteria) this;
        }

        public Criteria andActiontimeNotIn(List<Long> values) {
            addCriterion("actiontime not in", values, "actiontime");
            return (Criteria) this;
        }

        public Criteria andActiontimeBetween(Long value1, Long value2) {
            addCriterion("actiontime between", value1, value2, "actiontime");
            return (Criteria) this;
        }

        public Criteria andActiontimeNotBetween(Long value1, Long value2) {
            addCriterion("actiontime not between", value1, value2, "actiontime");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andGmtcreateIsNull() {
            addCriterion("gmtcreate is null");
            return (Criteria) this;
        }

        public Criteria andGmtcreateIsNotNull() {
            addCriterion("gmtcreate is not null");
            return (Criteria) this;
        }

        public Criteria andGmtcreateEqualTo(Date value) {
            addCriterion("gmtcreate =", value, "gmtcreate");
            return (Criteria) this;
        }

        public Criteria andGmtcreateNotEqualTo(Date value) {
            addCriterion("gmtcreate <>", value, "gmtcreate");
            return (Criteria) this;
        }

        public Criteria andGmtcreateGreaterThan(Date value) {
            addCriterion("gmtcreate >", value, "gmtcreate");
            return (Criteria) this;
        }

        public Criteria andGmtcreateGreaterThanOrEqualTo(Date value) {
            addCriterion("gmtcreate >=", value, "gmtcreate");
            return (Criteria) this;
        }

        public Criteria andGmtcreateLessThan(Date value) {
            addCriterion("gmtcreate <", value, "gmtcreate");
            return (Criteria) this;
        }

        public Criteria andGmtcreateLessThanOrEqualTo(Date value) {
            addCriterion("gmtcreate <=", value, "gmtcreate");
            return (Criteria) this;
        }

        public Criteria andGmtcreateIn(List<Date> values) {
            addCriterion("gmtcreate in", values, "gmtcreate");
            return (Criteria) this;
        }

        public Criteria andGmtcreateNotIn(List<Date> values) {
            addCriterion("gmtcreate not in", values, "gmtcreate");
            return (Criteria) this;
        }

        public Criteria andGmtcreateBetween(Date value1, Date value2) {
            addCriterion("gmtcreate between", value1, value2, "gmtcreate");
            return (Criteria) this;
        }

        public Criteria andGmtcreateNotBetween(Date value1, Date value2) {
            addCriterion("gmtcreate not between", value1, value2, "gmtcreate");
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

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table log
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table log
     *
     * @mbggenerated
     */
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