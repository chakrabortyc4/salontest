package SpringMy.Maven.db.enities;

// default package
// Generated May 11, 2018 12:05:26 PM by Hibernate Tools 3.2.2.GA


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * PayStatus generated by hbm2java
 */
@Entity
@Table(name="pay_status"
    ,catalog="salontest"
)
public class PayStatus  implements java.io.Serializable {


     private Integer payId;
     private Users users;
     private int attemptSection;
     private int totalEntry;
     private String couponCodeNumber;
     private int totalAmount;
     private int discountAmount;
     private String courencyType;
     private Integer recivedAmont;
     private Date entryCreatedTime;
     private String payingStatus;
     private Date payTime;
     private Date lastUpdateTime;
     private String recivedCourencyType;

    public PayStatus() {
    }

	
    public PayStatus(Users users, int attemptSection, int totalEntry, int totalAmount, int discountAmount, String courencyType, Date entryCreatedTime, String payingStatus) {
        this.users = users;
        this.attemptSection = attemptSection;
        this.totalEntry = totalEntry;
        this.totalAmount = totalAmount;
        this.discountAmount = discountAmount;
        this.courencyType = courencyType;
        this.entryCreatedTime = entryCreatedTime;
        this.payingStatus = payingStatus;
    }
    public PayStatus(Users users, int attemptSection, int totalEntry, String couponCodeNumber, int totalAmount, int discountAmount, String courencyType, Integer recivedAmont, Date entryCreatedTime, String payingStatus, Date payTime, Date lastUpdateTime, String recivedCourencyType) {
       this.users = users;
       this.attemptSection = attemptSection;
       this.totalEntry = totalEntry;
       this.couponCodeNumber = couponCodeNumber;
       this.totalAmount = totalAmount;
       this.discountAmount = discountAmount;
       this.courencyType = courencyType;
       this.recivedAmont = recivedAmont;
       this.entryCreatedTime = entryCreatedTime;
       this.payingStatus = payingStatus;
       this.payTime = payTime;
       this.lastUpdateTime = lastUpdateTime;
       this.recivedCourencyType = recivedCourencyType;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="pay_id", unique=true, nullable=false)
    public Integer getPayId() {
        return this.payId;
    }
    
    public void setPayId(Integer payId) {
        this.payId = payId;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id", nullable=false)
    public Users getUsers() {
        return this.users;
    }
    
    public void setUsers(Users users) {
        this.users = users;
    }
    
    @Column(name="attempt_section", nullable=false)
    public int getAttemptSection() {
        return this.attemptSection;
    }
    
    public void setAttemptSection(int attemptSection) {
        this.attemptSection = attemptSection;
    }
    
    @Column(name="total_entry", nullable=false)
    public int getTotalEntry() {
        return this.totalEntry;
    }
    
    public void setTotalEntry(int totalEntry) {
        this.totalEntry = totalEntry;
    }
    
    @Column(name="coupon_code_number", length=45)
    public String getCouponCodeNumber() {
        return this.couponCodeNumber;
    }
    
    public void setCouponCodeNumber(String couponCodeNumber) {
        this.couponCodeNumber = couponCodeNumber;
    }
    
    @Column(name="total_amount", nullable=false)
    public int getTotalAmount() {
        return this.totalAmount;
    }
    
    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }
    
    @Column(name="discount_amount", nullable=false)
    public int getDiscountAmount() {
        return this.discountAmount;
    }
    
    public void setDiscountAmount(int discountAmount) {
        this.discountAmount = discountAmount;
    }
    
    @Column(name="courency_type", nullable=false, length=45)
    public String getCourencyType() {
        return this.courencyType;
    }
    
    public void setCourencyType(String courencyType) {
        this.courencyType = courencyType;
    }
    
    @Column(name="recived_amont")
    public Integer getRecivedAmont() {
        return this.recivedAmont;
    }
    
    public void setRecivedAmont(Integer recivedAmont) {
        this.recivedAmont = recivedAmont;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="entry_created_time", nullable=false, length=19)
    public Date getEntryCreatedTime() {
        return this.entryCreatedTime;
    }
    
    public void setEntryCreatedTime(Date entryCreatedTime) {
        this.entryCreatedTime = entryCreatedTime;
    }
    
    @Column(name="paying_status", nullable=false, length=45)
    public String getPayingStatus() {
        return this.payingStatus;
    }
    
    public void setPayingStatus(String payingStatus) {
        this.payingStatus = payingStatus;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="pay_time", length=19)
    public Date getPayTime() {
        return this.payTime;
    }
    
    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="last_update_time", length=19)
    public Date getLastUpdateTime() {
        return this.lastUpdateTime;
    }
    
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }
    
    @Column(name="recived_courency_type", length=45)
    public String getRecivedCourencyType() {
        return this.recivedCourencyType;
    }
    
    public void setRecivedCourencyType(String recivedCourencyType) {
        this.recivedCourencyType = recivedCourencyType;
    }




}


