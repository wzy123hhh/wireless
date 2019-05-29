package team.wireless.entity;

import java.sql.Date;

/**
 * 会议资料
 * @author 王智源
 *
 */
public class MFile {
	private int saveno;
	private String upusernum;
	private String filename;
	private String savepath;
	private String filesize;
	private Date uptime;
	private String filetype;
	
	public MFile() {
		super();
	}
	
	
	public MFile(String upusernum, String filename, String savepath, String filesize, String filetype) {
		super();
		this.upusernum = upusernum;
		this.filename = filename;
		this.savepath = savepath;
		this.filesize = filesize;
		this.filetype = filetype;
	}


	public MFile(int saveno, String upusernum, String filename, String savepath, String filesize, Date uptime,
			String filetype) {
		super();
		this.saveno = saveno;
		this.upusernum = upusernum;
		this.filename = filename;
		this.savepath = savepath;
		this.filesize = filesize;
		this.uptime = uptime;
		this.filetype = filetype;
	}
	public int getSaveno() {
		return saveno;
	}
	public void setSaveno(int saveno) {
		this.saveno = saveno;
	}
	public String getUpusernum() {
		return upusernum;
	}
	public void setUpusernum(String upusernum) {
		this.upusernum = upusernum;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getSavepath() {
		return savepath;
	}
	public void setSavepath(String savepath) {
		this.savepath = savepath;
	}
	public String getFilesize() {
		return filesize;
	}
	public void setFilesize(String filesize) {
		this.filesize = filesize;
	}
	public Date getUptime() {
		return uptime;
	}
	public void setUptime(Date uptime) {
		this.uptime = uptime;
	}
	public String getFiletype() {
		return filetype;
	}
	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}
	
	
}
