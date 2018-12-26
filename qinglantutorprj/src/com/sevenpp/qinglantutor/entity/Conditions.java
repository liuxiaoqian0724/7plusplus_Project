
		package com.sevenpp.qinglantutor.entity;
		/**
		*
		* 项目名称：qinglantutorprj
		* 类名称：Conditions
		* 类描述：
		* 创建人：cuishan
		* 创建时间：2018年12月10日 下午4:11:09
		* 修改人：rain
		* 修改时间：2018年12月10日 下午4:11:09
		* 修改备注：
		* @version
		*
		*/
		
		public class Conditions {

			private Integer grade;
			private Integer subject;
			private String department;
			private String sex;
			private String major;
			public Integer getGrade() {
				return grade;
			}
			public void setGrade(Integer grade) {
				this.grade = grade;
			}
			public Integer getSubject() {
				return subject;
			}
			public void setSubject(Integer subject) {
				this.subject = subject;
			}
			public String getDepartment() {
				return department;
			}
			public void setDepartment(String department) {
				this.department = department;
			}
			public String getSex() {
				return sex;
			}
			public void setSex(String sex) {
				this.sex = sex;
			}
			public String getMajor() {
				return major;
			}
			public void setMajor(String major) {
				this.major = major;
			}
			public Conditions(Integer grade, Integer subject, String department, String sex, String major) {
				super();
				this.grade = grade;
				this.subject = subject;
				this.department = department;
				this.sex = sex;
				this.major = major;
			}
			
			public Conditions() {}
}

	