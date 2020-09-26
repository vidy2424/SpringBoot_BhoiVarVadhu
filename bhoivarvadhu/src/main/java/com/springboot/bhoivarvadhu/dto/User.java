package com.springboot.bhoivarvadhu.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Id;


import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.web.multipart.MultipartFile;

	@Entity
	@Table(name = "user_detail")
	@Document(indexName = "[user_detail]", type = "[user_detail]", shards = 1)
   	public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; 
 
	private String fullName; 
	private String dOB;
	private int age;
	private int clickCount;
	private Timestamp dateTime;
	private String marital_Status;	
	private String caste;
	private String gender;
	private String your_Surname;
	private String maternal_Uncle_Surname;
	private String other_Surname;
	private String maternal_Uncle_Surname_optional;
	private String job_business ;
	private String annual_Income;
	private String father;
	private String education;
	private String occupation;
	private String groom_Bride;
	private String mother;
	private String brother;
	private String sister;
	private String married_Brother;
	private String married_Sister;
	private String email;
	private String password;
	private String permanent_Address;
	private String current_Address;
	private String city;
	private String contact_No_1;
	private String contact_No_2;
	private String landline_No;
	private String zodiac_Sign;
	private String mangal;
	private String nakshatras;
	private String birth_Time;
	private String birth_Time_HrMin;
	private String birth_Place;
	private String nadi;
	private String height;
	private String weight;
	private String blood_Group;
	private String complexion;
	private String physical_Disability;
	private String mention_Physical_Disability;
	private String education_Expectation;
	private String job_Expectation ;
	private String annual_Income_Expectation;
	private String age_Difference_Expectation;
	private String city_Priority_Expectation;
	private String other_Expectation;
	private String role;
	private boolean enabled = true;
	
	private String code;

	@Transient
	private MultipartFile file;
 
	// default constructor
	public User() {
		
		this.code = "PRD" + UUID.randomUUID().toString().substring(26).toUpperCase();
		
	}

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public MultipartFile getFile() {
		return file;
	}


	public void setFile(MultipartFile file) {
		this.file = file;
	}


	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getdOB() {
		return dOB;
	}
	public void setdOB(String dOB) {
		this.dOB = dOB;
	}
 
	public int getAge() {
		return age;
	}
 
	public void setAge(int age) {
		this.age = age;
	}
 

	public int getClickCount() {
		return clickCount;
	}


	public void setClickCount(int clickCount) {
		this.clickCount = clickCount;
	}


	public Timestamp getDateTime() {
		return dateTime;
	}


	public void setDateTime(Timestamp dateTime) {
		this.dateTime = dateTime;
	}


	public String getMarital_Status() {
		return marital_Status;
	}
	public void setMarital_Status(String marital_Status) {
		this.marital_Status = marital_Status;
	}
	public String getCaste() {
		return caste;
	}
	public void setCaste(String caste) {
		this.caste = caste;
	}
	public String getYour_Surname() {
		return your_Surname;
	}
	public void setYour_Surname(String your_Surname) {
		this.your_Surname = your_Surname;
	}
	public String getMaternal_Uncle_Surname() {
		return maternal_Uncle_Surname;
	}
	public void setMaternal_Uncle_Surname(String maternal_Uncle_Surname) {
		this.maternal_Uncle_Surname = maternal_Uncle_Surname;
	}
	public String getOther_Surname() {
		return other_Surname;
	}
	public void setOther_Surname(String other_Surname) {
		this.other_Surname = other_Surname;
	}
	public String getMaternal_Uncle_Surname_optional() {
		return maternal_Uncle_Surname_optional;
	}
	public void setMaternal_Uncle_Surname_optional(String maternal_Uncle_Surname_optional) {
		this.maternal_Uncle_Surname_optional = maternal_Uncle_Surname_optional;
	}
	public String getJob_business() {
		return job_business;
	}
	public void setJob_business(String job_business) {
		this.job_business = job_business;
	}
	public String getAnnual_Income() {
		return annual_Income;
	}
	public void setAnnual_Income(String annual_Income) {
		this.annual_Income = annual_Income;
	}
	public String getFather() {
		return father;
	}
	public void setFather(String father) {
		this.father = father;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getGroom_Bride() {
		return groom_Bride;
	}
	public void setGroom_Bride(String groom_Bride) {
		this.groom_Bride = groom_Bride;
	}
	public String getMother() {
		return mother;
	}
	public void setMother(String mother) {
		this.mother = mother;
	}
	public String getBrother() {
		return brother;
	}
	public void setBrother(String brother) {
		this.brother = brother;
	}
	public String getSister() {
		return sister;
	}
	public void setSister(String sister) {
		this.sister = sister;
	}
	public String getMarried_Brother() {
		return married_Brother;
	}
	public void setMarried_Brother(String married_Brother) {
		this.married_Brother = married_Brother;
	}
	public String getMarried_Sister() {
		return married_Sister;
	}
	public void setMarried_Sister(String married_Sister) {
		this.married_Sister = married_Sister;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPermanent_Address() {
		return permanent_Address;
	}
	public void setPermanent_Address(String permanent_Address) {
		this.permanent_Address = permanent_Address;
	}
	public String getCurrent_Address() {
		return current_Address;
	}
	public void setCurrent_Address(String current_Address) {
		this.current_Address = current_Address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
 	public String getContact_No_1() {
		return contact_No_1;
	}


	public void setContact_No_1(String contact_No_1) {
		this.contact_No_1 = contact_No_1;
	}


	public String getContact_No_2() {
		return contact_No_2;
	}


	public void setContact_No_2(String contact_No_2) {
		this.contact_No_2 = contact_No_2;
	}


	public String getLandline_No() {
		return landline_No;
	}


	public void setLandline_No(String landline_No) {
		this.landline_No = landline_No;
	}


	public String getZodiac_Sign() {
		return zodiac_Sign;
	}
	public void setZodiac_Sign(String zodiac_Sign) {
		this.zodiac_Sign = zodiac_Sign;
	}
	public String getMangal() {
		return mangal;
	}
	public void setMangal(String mangal) {
		this.mangal = mangal;
	}
	public String getNakshatras() {
		return nakshatras;
	}
	public void setNakshatras(String nakshatras) {
		this.nakshatras = nakshatras;
	}
	public String getBirth_Time() {
		return birth_Time;
	}
	public void setBirth_Time(String birth_Time) {
		this.birth_Time = birth_Time;
	}
	public String getBirth_Time_HrMin() {
		return birth_Time_HrMin;
	}
	public void setBirth_Time_HrMin(String birth_Time_HrMin) {
		this.birth_Time_HrMin = birth_Time_HrMin;
	}
	public String getBirth_Place() {
		return birth_Place;
	}
	public void setBirth_Place(String birth_Place) {
		this.birth_Place = birth_Place;
	}
	public String getNadi() {
		return nadi;
	}
	public void setNadi(String nadi) {
		this.nadi = nadi;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getBlood_Group() {
		return blood_Group;
	}
	public void setBlood_Group(String blood_Group) {
		this.blood_Group = blood_Group;
	}
	public String getComplexion() {
		return complexion;
	}
	public void setComplexion(String complexion) {
		this.complexion = complexion;
	}
	public String getPhysical_Disability() {
		return physical_Disability;
	}
	public void setPhysical_Disability(String physical_Disability) {
		this.physical_Disability = physical_Disability;
	}
	public String getMention_Physical_Disability() {
		return mention_Physical_Disability;
	}
	public void setMention_Physical_Disability(String mention_Physical_Disability) {
		this.mention_Physical_Disability = mention_Physical_Disability;
	}
	public String getEducation_Expectation() {
		return education_Expectation;
	}
	public void setEducation_Expectation(String education_Expectation) {
		this.education_Expectation = education_Expectation;
	}
	public String getJob_Expectation() {
		return job_Expectation;
	}
	public void setJob_Expectation(String job_Expectation) {
		this.job_Expectation = job_Expectation;
	}
	public String getAnnual_Income_Expectation() {
		return annual_Income_Expectation;
	}
	public void setAnnual_Income_Expectation(String annual_Income_Expectation) {
		this.annual_Income_Expectation = annual_Income_Expectation;
	}
	public String getAge_Difference_Expectation() {
		return age_Difference_Expectation;
	}
	public void setAge_Difference_Expectation(String age_Difference_Expectation) {
		this.age_Difference_Expectation = age_Difference_Expectation;
	}
	public String getCity_Priority_Expectation() {
		return city_Priority_Expectation;
	}
	public void setCity_Priority_Expectation(String city_Priority_Expectation) {
		this.city_Priority_Expectation = city_Priority_Expectation;
	}
	public String getOther_Expectation() {
		return other_Expectation;
	}
	public void setOther_Expectation(String other_Expectation) {
		this.other_Expectation = other_Expectation;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", fullName=" + fullName + ", dOB=" + dOB + ", age=" + age + ", clickCount="
				+ clickCount + ", dateTime=" + dateTime + ", marital_Status=" + marital_Status + ", caste=" + caste
				+ ", gender=" + gender + ", your_Surname=" + your_Surname + ", maternal_Uncle_Surname="
				+ maternal_Uncle_Surname + ", other_Surname=" + other_Surname + ", maternal_Uncle_Surname_optional="
				+ maternal_Uncle_Surname_optional + ", job_business=" + job_business + ", annual_Income="
				+ annual_Income + ", father=" + father + ", education=" + education + ", occupation=" + occupation
				+ ", groom_Bride=" + groom_Bride + ", mother=" + mother + ", brother=" + brother + ", sister=" + sister
				+ ", married_Brother=" + married_Brother + ", married_Sister=" + married_Sister + ", email=" + email
				+ ", password=" + password + ", permanent_Address=" + permanent_Address + ", current_Address="
				+ current_Address + ", city=" + city + ", contact_No_1=" + contact_No_1 + ", contact_No_2="
				+ contact_No_2 + ", landline_No=" + landline_No + ", zodiac_Sign=" + zodiac_Sign + ", mangal=" + mangal
				+ ", nakshatras=" + nakshatras + ", birth_Time=" + birth_Time + ", birth_Time_HrMin=" + birth_Time_HrMin
				+ ", birth_Place=" + birth_Place + ", nadi=" + nadi + ", height=" + height + ", weight=" + weight
				+ ", blood_Group=" + blood_Group + ", complexion=" + complexion + ", physical_Disability="
				+ physical_Disability + ", mention_Physical_Disability=" + mention_Physical_Disability
				+ ", education_Expectation=" + education_Expectation + ", job_Expectation=" + job_Expectation
				+ ", annual_Income_Expectation=" + annual_Income_Expectation + ", age_Difference_Expectation="
				+ age_Difference_Expectation + ", city_Priority_Expectation=" + city_Priority_Expectation
				+ ", other_Expectation=" + other_Expectation + ", role=" + role + ", enabled=" + enabled + ", code="
				+ code + ", file=" + file + "]";
	}

 


 
  	
//	@JsonBackReference
// 	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	private Cart cart;
//
//	public Cart getCart() {
//		return cart;
//	}
//
//	public void setCart(Cart cart) {
//		this.cart = cart;
//	}

}
