
		package com.sevenpp.qinglantutor.entity;

		import java.util.Comparator;

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
		
		public class UserInfo implements Comparable<UserInfo> {
			private int id;
			private String username;
			private String userimg;
			private String introduce;
			private int price;
			private String teacherage;
			private int reviewstar;
			private int reviewsum;
			private String reviewcontent;
			private int intellgencesort;	//智能排序 (评价数量*50%+评价星级*50%)
			
			public UserInfo() {}
			
			
			public UserInfo(int id, String username, String userimg, String introduce, int price, String teacherage,
					int reviewstar, int reviewsum, String reviewcontent) {
				super();
				this.id = id;
				this.username = username;
				this.userimg = userimg;
				this.introduce = introduce;
				this.price = price;
				this.teacherage = teacherage;
				this.reviewstar = reviewstar;
				this.reviewsum = reviewsum;
				this.reviewcontent = reviewcontent;
			}


			public int getId() {
				return id;
			}
			public void setId(int id) {
				this.id = id;
			}
			public String getUsername() {
				return username;
			}
			public void setUsername(String username) {
				this.username = username;
			}
			public String getUserimg() {
				return userimg;
			}
			public void setUserimg(String userimg) {
				this.userimg = userimg;
			}
			public String getIntroduce() {
				return introduce;
			}
			public void setIntroduce(String introduce) {
				this.introduce = introduce;
			}
			public int getPrice() {
				return price;
			}
			public void setPrice(int price) {
				this.price = price;
			}
			public String getTeacherage() {
				return teacherage;
			}
			public void setTeacherage(String teacherage) {
				this.teacherage = teacherage;
			}
			public int getReviewstar() {
				return reviewstar;
			}
			public void setReviewstar(int reviewstar) {
				this.reviewstar = reviewstar;
			}
			public int getReviewsum() {
				return reviewsum;
			}
			public void setReviewsum(int reviewsum) {
				this.reviewsum = reviewsum;
			}
			public String getReviewcontent() {
				return reviewcontent;
			}
			public void setReviewcontent(String reviewcontent) {
				this.reviewcontent = reviewcontent;
			}
			public int getIntellgencesort() {
				return intellgencesort;
			}
			public void setIntellgencesort() {
				this.intellgencesort=(int) (this.reviewsum*0.5+this.reviewstar/5*100*0.5);
			}


			
			@Override
			public int compareTo(UserInfo o) {
				// TODO Auto-generated method stub
				return Comparators.reviewStar.compare(this, o);

						/**
						* compareTo(这里用一句话描述这个方法的作用)
						* TODO(这里描述这个方法适用条件 – 可选)
						* TODO(这里描述这个方法的执行流程 – 可选)
						* TODO(这里描述这个方法的使用方法 – 可选)
						* TODO(这里描述这个方法的注意事项 – 可选)
						* @param name
						* @param @return 设定文件
						* @return String DOM对象
						* @Exception 异常对象
						* @since CodingExample Ver(编码范例查看) 1.1
						*/
					
			}
			
			public static class Comparators{
				
				//按价格排序
				public static Comparator<UserInfo> price = new Comparator<UserInfo>() {
					@Override
		            public int compare(UserInfo o1, UserInfo o2) {
		                return o1.price - o2.price;
		            }
				};
				//按评价星级排序
				public static Comparator<UserInfo> reviewStar =new Comparator<UserInfo>() {
					@Override
					public int compare(UserInfo o1,UserInfo o2) {
						return (o1.reviewstar - o2.reviewstar)*(-1);
					}
				};
				//按评价数排序
				public static Comparator<UserInfo> reviewSum = new Comparator<UserInfo>() {
					@Override
					public int compare (UserInfo o1,UserInfo o2) {
						return (o1.reviewsum-o2.reviewsum)*(-1);
					}
				};
				
				//智能排序
				public static Comparator<UserInfo> intellgenceSort = new Comparator<UserInfo>() {
					@Override
					public int compare (UserInfo o1,UserInfo o2) {
						return (o1.intellgencesort-o2.intellgencesort)*(-1);
					}
				};
				
			}
			
}

	