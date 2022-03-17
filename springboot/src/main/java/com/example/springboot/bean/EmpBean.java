package com.example.springboot.bean;

import java.math.BigDecimal;
import java.util.Date;

public class EmpBean {
    private Short empno;

    private String ename;

    private String job;

    private Short mgr;

    private Date hiredate;

    private BigDecimal sal;

    private BigDecimal comm;

    private Short deptno;

    public EmpBean(Short empno, String ename, String job, Short mgr, Date hiredate, BigDecimal sal, BigDecimal comm, Short deptno) {
        this.empno = empno;
        this.ename = ename;
        this.job = job;
        this.mgr = mgr;
        this.hiredate = hiredate;
        this.sal = sal;
        this.comm = comm;
        this.deptno = deptno;
    }

    public EmpBean() {
        super();
    }

    public Short getEmpno() {
        return empno;
    }

    public void setEmpno(Short empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename == null ? null : ename.trim();
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job == null ? null : job.trim();
    }

    public Short getMgr() {
        return mgr;
    }

    public void setMgr(Short mgr) {
        this.mgr = mgr;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public BigDecimal getSal() {
        return sal;
    }

    public void setSal(BigDecimal sal) {
        this.sal = sal;
    }

    public BigDecimal getComm() {
        return comm;
    }

    public void setComm(BigDecimal comm) {
        this.comm = comm;
    }

    public Short getDeptno() {
        return deptno;
    }

    public void setDeptno(Short deptno) {
        this.deptno = deptno;
    }
}