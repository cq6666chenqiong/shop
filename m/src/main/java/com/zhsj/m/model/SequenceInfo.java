package com.zhsj.m.model;

public class SequenceInfo {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_sequence.name
     *
     * @mbggenerated Thu Nov 02 21:51:33 CST 2017
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_sequence.current_value
     *
     * @mbggenerated Thu Nov 02 21:51:33 CST 2017
     */
    private Integer currentValue;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_sequence._increment
     *
     * @mbggenerated Thu Nov 02 21:51:33 CST 2017
     */
    private Integer increment;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_sequence.name
     *
     * @return the value of tb_sequence.name
     *
     * @mbggenerated Thu Nov 02 21:51:33 CST 2017
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_sequence.name
     *
     * @param name the value for tb_sequence.name
     *
     * @mbggenerated Thu Nov 02 21:51:33 CST 2017
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_sequence.current_value
     *
     * @return the value of tb_sequence.current_value
     *
     * @mbggenerated Thu Nov 02 21:51:33 CST 2017
     */
    public Integer getCurrentValue() {
        return currentValue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_sequence.current_value
     *
     * @param currentValue the value for tb_sequence.current_value
     *
     * @mbggenerated Thu Nov 02 21:51:33 CST 2017
     */
    public void setCurrentValue(Integer currentValue) {
        this.currentValue = currentValue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_sequence._increment
     *
     * @return the value of tb_sequence._increment
     *
     * @mbggenerated Thu Nov 02 21:51:33 CST 2017
     */
    public Integer getIncrement() {
        return increment;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_sequence._increment
     *
     * @param increment the value for tb_sequence._increment
     *
     * @mbggenerated Thu Nov 02 21:51:33 CST 2017
     */
    public void setIncrement(Integer increment) {
        this.increment = increment;
    }
}