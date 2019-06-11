package com.sevenpp.qinglantutor.utils.AipNlp;

import java.util.List;

public class Result {
	private int spam;

    private List<String> review;

    private List<String> reject;

    private List<Pass> pass;
    public void setSpam(int spam) {
    	this.spam = spam;
    }
    public int getSpam() {
    	return spam;
    } 
    public void setReview(List<String> review) {
    	this.review = review;
    }
    public List<String> getReview() {
    	return review;
    }
    public void setReject(List<String> reject) {
    	this.reject = reject;    
    }    
    public List<String> getReject() {
    	return reject;    
    } 
    public void setPass(List<Pass> pass) {
    	this.pass = pass;
    }  
    public List<Pass> getPass() {
    	return pass;
    }
  
}
