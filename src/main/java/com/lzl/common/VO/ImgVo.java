package com.lzl.common.VO;

public class ImgVo {
    private String img;
    private String remark;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "ImgVo{" +
                "img='" + img + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
