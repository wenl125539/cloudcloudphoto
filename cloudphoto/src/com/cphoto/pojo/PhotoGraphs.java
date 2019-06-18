package com.cphoto.pojo;

public class PhotoGraphs {
    private Long photosid;

    private String userid;

    private String photosname;

    private String createtime;

    private String photosdesc;

    public Long getPhotosid() {
        return photosid;
    }

    public void setPhotosid(Long photosid) {
        this.photosid = photosid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getPhotosname() {
        return photosname;
    }

    public void setPhotosname(String photosname) {
        this.photosname = photosname == null ? null : photosname.trim();
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }

    public String getPhotosdesc() {
        return photosdesc;
    }

    public void setPhotosdesc(String photosdesc) {
        this.photosdesc = photosdesc == null ? null : photosdesc.trim();
    }
}