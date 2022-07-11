package com.mashibing.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author lian
 * @since 2022-07-02
 */
public class Salgrade implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "GRADE", type = IdType.AUTO)
    private Integer grade;

    private Double losal;

    private Double hisal;


    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Double getLosal() {
        return losal;
    }

    public void setLosal(Double losal) {
        this.losal = losal;
    }

    public Double getHisal() {
        return hisal;
    }

    public void setHisal(Double hisal) {
        this.hisal = hisal;
    }

    @Override
    public String toString() {
        return "Salgrade{" +
        "grade=" + grade +
        ", losal=" + losal +
        ", hisal=" + hisal +
        "}";
    }
}
