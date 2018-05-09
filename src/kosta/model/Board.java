package kosta.model;

import java.io.Serializable;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class Board implements Serializable{
	/*jsr 303 방식*/
	
	private int seq;
	
	@NotEmpty(message="작성자를 입력하세요.")
	@Size(min=2, max=5, message="2자 이상 5자 미만으로 입력")
	private String writer;
	
	@Pattern(regexp="[0-9a-zA-Z가-힣]*",message="특수문자 입력 금지")
	private String title;
	private String contents;
	private String regdate;
	private int hitcount;	
	private MultipartFile uploadFile;
	private String filename;
	
	public Board(){}

	public Board(int seq, String writer, String title, String contents, String regdate, int hitcount) {
		super();
		this.seq = seq;
		this.writer = writer;
		this.title = title;
		this.contents = contents;
		this.regdate = regdate;
		this.hitcount = hitcount;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public int getHitcount() {
		return hitcount;
	}

	public void setHitcount(int hitcount) {
		this.hitcount = hitcount;
	}

	public MultipartFile getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	@Override
	public String toString() {
		return "Board [seq=" + seq + ", writer=" + writer + ", title=" + title + ", contents=" + contents + ", regdate="
				+ regdate + ", hitcount=" + hitcount + "]";
	}
	
	
}
