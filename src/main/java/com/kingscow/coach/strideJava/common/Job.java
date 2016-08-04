package com.kingscow.coach.strideJava.common;

public class Job {
    private String name;
    private String job;

    public Job() {}

    public Job(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return this.job;
    }

    @Override
    public String toString() {
        return this.getName()+"="+this.getJob();
    }

}
