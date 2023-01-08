package emlakcepte.dto.model.response;

import emlakcepte.model.enums.RealtyType;

public class RealtyResponse {

    private String title;
    private String province;
    private Integer userId;
    private Integer no;

    private RealtyType realtyType;

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public RealtyType getRealtyType() {
        return realtyType;
    }

    public void setRealtyType(RealtyType realtyType) {
        this.realtyType = realtyType;
    }

    public Integer getRealtyNo() {
        return no;
    }

    public void setRealtyNo(Integer no) {
        this.no = no;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
