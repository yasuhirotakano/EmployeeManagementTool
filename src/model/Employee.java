package model;

import java.io.Serializable;

/**
 * Employee beansクラス
 * @author 高野
 * 社員情報
 */
public class Employee implements Serializable{
	
	/** Employee beansクラスのフィールド */
	/** 社員ID */
	private int id;
	/** 名前 */
	private String name;
	/** 年齢 */
	private int age;
	/** 生年月日 */
	private String birthDay;
	/** 性別 */
	private String gender;
	/** 電話番号 */
	private String phoneNumber;
	/** 郵便番号 */
	private String postalCode;
	/** 都道府県 */
	private String prefectures;
	/** 住所 */
	private String address;
	/** 部署ID */
	private int departmentId;
	/** 役職ID */
	private int postId;
	/** 最寄駅 */
	private String nearestStation;
	/** 入社日 */
	private String enteringDay;
	/** 退社日 */
	private String leavingDay;
	
	/** getter/setterの定義 */
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return this.age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getBirthDay() {
		return this.birthDay;
	}
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
	public String getGender() {
		return this.gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPostalCode() {
		return this.postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getPrefectures() {
		return this.prefectures;
	}
	public void setPrefectures(String prefectures) {
		this.prefectures = prefectures;
	}
	public String getAddress() {
		return this.address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getDepartmentId() {
		return this.departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public int getPostId() {
		return this.postId;
	}
	public void setPostID(int postId) {
		this.postId = postId;
	}
	public String getNearestStation() {
		return this.nearestStation;
	}
	public void setNearestStation(String nearestStation) {
		this.nearestStation = nearestStation;
	}
	public String getEnteringDay() {
		return this.enteringDay;
	}
	public void setEnteringDay(String enteringDay) {
		this.enteringDay = enteringDay;
	}
	public String getLeavingDay() {
		return this.leavingDay;
	}
	public void setLeavingDay(String leavingDay) {
		this.leavingDay = leavingDay;
	}
	
	/** Employee beansクラスのコンストラクタ */
	public Employee() {
	}
	
	/**
	 * Employee beansクラスのコンストラクタ
	 * @param id データベースに登録されてる社員ID
	 * @param name データベースに登録されてる名前
	 */
	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	/**
	 * Employee beansクラスのコンストラクタ
	 * @param id データベースに登録されてるID
	 * @param name データベースに登録されてる名前
	 * @param age データベースに登録されてる年齢
	 * @param birthDay データベースに登録されてる生年月日
	 * @param gender データベースに登録されてる性別
	 * @param phoneNumber データベースに登録されてる電話番号
	 * @param postalCode データベースに登録されてる郵便番号
	 * @param prefectures データベースに登録されてる都道府県
	 * @param address データベースに登録されてる住所
	 * @param departmentId データベースに登録されてる部署ID
	 * @param postId データベースに登録されてる役職ID
	 * @param nearestStation データベースに登録されてる最寄駅
	 * @param enteringDay データベースに登録されてる入社日
	 * @param leavingDay データベースに登録されてる退社日
	 */
	public Employee(int id, String name, int age, String birthDay, String gender, String phoneNumber, String postalCode,
			String prefectures, String address, int departmentId, int postId, String nearestStation, String enteringDay,
			String leavingDay) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.birthDay = birthDay;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.postalCode = postalCode;
		this.prefectures = prefectures;
		this.address = address;
		this.departmentId = departmentId;
		this.postId = postId;
		this.nearestStation = nearestStation;
		this.enteringDay = enteringDay;
		this.leavingDay = leavingDay;
	}
}