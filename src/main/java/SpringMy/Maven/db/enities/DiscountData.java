package SpringMy.Maven.db.enities;

// default package
// Generated May 11, 2018 12:05:26 PM by Hibernate Tools 3.2.2.GA


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * DiscountData generated by hbm2java
 */
@Entity
@Table(name="discount_data"
    ,catalog="salontest"
    , uniqueConstraints = @UniqueConstraint(columnNames="user_id") 
)
public class DiscountData  implements java.io.Serializable {


     private Integer discountId;
     private Users users;
     private String couponCode;
     private int createdBy;
     private int discountPersent;

    public DiscountData() {
    }

    public DiscountData(Users users, String couponCode, int createdBy, int discountPersent) {
       this.users = users;
       this.couponCode = couponCode;
       this.createdBy = createdBy;
       this.discountPersent = discountPersent;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="discount_id", unique=true, nullable=false)
    public Integer getDiscountId() {
        return this.discountId;
    }
    
    public void setDiscountId(Integer discountId) {
        this.discountId = discountId;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id", unique=true, nullable=false)
    public Users getUsers() {
        return this.users;
    }
    
    public void setUsers(Users users) {
        this.users = users;
    }
    
    @Column(name="coupon_code", nullable=false, length=45)
    public String getCouponCode() {
        return this.couponCode;
    }
    
    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }
    
    @Column(name="created_by", nullable=false)
    public int getCreatedBy() {
        return this.createdBy;
    }
    
    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }
    
    @Column(name="discount_persent", nullable=false)
    public int getDiscountPersent() {
        return this.discountPersent;
    }
    
    public void setDiscountPersent(int discountPersent) {
        this.discountPersent = discountPersent;
    }




}


