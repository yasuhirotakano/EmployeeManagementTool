package model;

import java.io.Serializable;

/**
 * Image beansクラス
 * @author 高野
 * 画像情報
 */
public class Image implements Serializable{
	
	/** image beansクラスのフィールド */
	/** 画像ID */
	private int imageId;
	/** 画像データ */
	private byte[] imageData;
	
	/** getter/setterの定義 */
	public int getImageId() {
		return this.imageId;
	}
	public void setImageId(int imageId) {
		this.imageId = imageId;
	}
	public byte[] getImageData() {
		return this.imageData;
	}
	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}
	
	/** image beansクラスのコンストラクタ */
	public Image() {
	}
	
	/**
	 * image beansクラスのコンストラクタ
	 * @param imageId データベースに登録されてる画像ID
	 * @param imageData データベースに登録されてる画像のバイトデータ
	 */
	public Image(int imageId, byte[] imageData) {
		this.imageId = imageId;
		this.imageData = imageData;
	}
}