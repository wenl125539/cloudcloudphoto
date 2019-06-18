package com.cphoto.pojo;

public class Photo {
    private Long photoid;

    private Long photosid;

    private String phototitle;

    private String createtime;

    private String photodesc;

    private String photopath;

    public Long getPhotoid() {
        return photoid;
    }

    public void setPhotoid(Long photoid) {
        this.photoid = photoid;
    }

    public Long getPhotosid() {
        return photosid;
    }

    public void setPhotosid(Long photosid) {
        this.photosid = photosid;
    }

    public String getPhototitle() {
        return phototitle;
    }

    public void setPhototitle(String phototitle) {
        this.phototitle = phototitle == null ? null : phototitle.trim();
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }

    public String getPhotodesc() {
        return photodesc;
    }

    public void setPhotodesc(String photodesc) {
        this.photodesc = photodesc == null ? null : photodesc.trim();
    }

    public String getPhotopath() {
        return photopath;
    }

    public void setPhotopath(String photopath) {
        this.photopath = photopath == null ? null : photopath.trim();
    }
}