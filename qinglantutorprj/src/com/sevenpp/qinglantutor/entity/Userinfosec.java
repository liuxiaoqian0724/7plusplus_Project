		
		package com.sevenpp.qinglantutor.entity;
		
/**
		*
		* 项目名称：qinglantutorprj
		* 类名称：UserInfo
		* 类描述：
		* 创建人：rain
		* 创建时间：2018年12月18日 下午5:58:50
		* 修改人：rain
		* 修改时间：2018年12月18日 下午5:58:50
		* 修改备注：
		* @version
		*
		*/
		
		public class Userinfosec {
			private int id;
			private String name;
			private int price;
			private int teachage;
			private int reviewstar;
			private int teachsum;	//教过的学生数
			private double dataintegrity;	//资料完整度
			public int getId() {
				return id;
			}
			public void setId(int id) {
				this.id = id;
			}
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}
			public int getPrice() {
				return price;
			}
			public void setPrice(int price) {
				this.price = price;
			}
			public int getTeachage() {
				return teachage;
			}
			public void setTeachage(int teachage) {
				this.teachage = teachage;
			}
			public int getReviewstar() {
				return reviewstar;
			}
			public void setReviewstar(int reviewstar) {
				this.reviewstar = reviewstar;
			}
			public int getTeachsum() {
				return teachsum;
			}
			public void setTeachsum(int teachsum) {
				this.teachsum = teachsum;
			}
			public double getDataintegrity() {
				return dataintegrity;
			}
			public void setDataintegrity(double dataintegrity) {
				this.dataintegrity = dataintegrity;
			}
			public Userinfosec(int id, String name, int price, int teachage, int reviewstar, int teachsum,
					double dataintegrity) {
				super();
				this.id = id;
				this.name = name;
				this.price = price;
				this.teachage = teachage;
				this.reviewstar = reviewstar;
				this.teachsum = teachsum;
				this.dataintegrity = dataintegrity;
			}
			
			public Userinfosec() {}
}

	