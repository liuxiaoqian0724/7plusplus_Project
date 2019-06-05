package com.sevenpp.qinglantutor.entity;

import java.io.Serializable;

public class TrendReview implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String prop;
	private String adj;
	private String sentiment;
	private String begin_pos;
	private String end_pos;
	private String abstractWord;
	
	public String getProp() {
		return prop;
	}
	public void setProp(String prop) {
		this.prop = prop;
	}
	public String getAdj() {
		return adj;
	}
	public void setAdj(String adj) {
		this.adj = adj;
	}
	public String getSentiment() {
		return sentiment;
	}
	public void setSentiment(String sentiment) {
		this.sentiment = sentiment;
	}
	public String getBegin_pos() {
		return begin_pos;
	}
	public void setBegin_pos(String begin_pos) {
		this.begin_pos = begin_pos;
	}
	public String getEnd_pos() {
		return end_pos;
	}
	public void setEnd_pos(String end_pos) {
		this.end_pos = end_pos;
	}
	public String getAbstractWord() {
		return abstractWord;
	}
	public void setAbstractWord(String abstractWord) {
		this.abstractWord = abstractWord;
	}
	@Override
	public String toString() {
		return "TrendReview [prop=" + prop + ", adj=" + adj + ", sentiment=" + sentiment + ", begin_pos=" + begin_pos
				+ ", end_pos=" + end_pos + ", abstractWord=" + abstractWord + "]";
	}
	
	
}


