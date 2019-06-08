package com.sevenpp.qinglantutor.utils.AipNlp;

import java.util.List;

public class Pass {
	private double score;
	private List<String> hit;
	private int label;
	public void setScore(double score) {
		this.score = score;
	}
	public double getScore() {
		return score;
	}
	public void setHit(List<String> hit) {
		this.hit = hit;
	}
	public List<String> getHit() { 
		return hit;    
	}
	public void setLabel(int label) {        
		this.label = label;    
	}
	public int getLabel() {
		return label;
	}
	
}
