package com.sevenpp.qinglantutor.entity;

public class ReviewTrend {

	private String prop;
	private String adj;
	private Integer sentiment;
	private Integer begin_pos;
	private Integer end_pos;
	private String abstra;
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
	public Integer getSentiment() {
		return sentiment;
	}
	public void setSentiment(Integer sentiment) {
		this.sentiment = sentiment;
	}
	public Integer getBegin_pos() {
		return begin_pos;
	}
	public void setBegin_pos(Integer begin_pos) {
		this.begin_pos = begin_pos;
	}
	public Integer getEnd_pos() {
		return end_pos;
	}
	public void setEnd_pos(Integer end_pos) {
		this.end_pos = end_pos;
	}
	public String getAbstra() {
		return abstra;
	}
	public void setAbstra(String abstra) {
		this.abstra = abstra;
	}
	@Override
	public String toString() {
		return "ReviewTrend [prop=" + prop + ", adj=" + adj + ", sentiment=" + sentiment + ", begin_pos=" + begin_pos
				+ ", end_pos=" + end_pos + ", abstra=" + abstra + "]";
	}
	
	
}