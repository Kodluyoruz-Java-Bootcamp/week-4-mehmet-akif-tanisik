package emlakcepte.client.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import emlakcepte.model.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Payment {

    public Integer userId;
    public String cardNo;

public Payment(){}
    public Payment(Integer userId, String cardNo) {
        this.userId = userId;
        this.cardNo = cardNo;

    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }
}
