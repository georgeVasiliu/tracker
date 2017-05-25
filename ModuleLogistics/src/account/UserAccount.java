package account;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import sun.security.util.Password;

import javax.xml.bind.annotation.XmlRootElement;

/*
 * Created by george on 5/22/17.
 */
public class UserAccount {

    private final StringProperty userName;
    private StringProperty userPassword;
    private final StringProperty userFirstName;
    private final StringProperty userLastName;
    private final StringProperty userAddress;
    private final StringProperty userCity;
    private final StringProperty userCountry;
    private final IntegerProperty userPhoneNumber;

    public UserAccount(String userName, String userPassword) {
        this.userName = new SimpleStringProperty(userName);
        this.userPassword = new SimpleStringProperty(userPassword);

        userFirstName = new SimpleStringProperty();
        userLastName = new SimpleStringProperty();
        userAddress = new SimpleStringProperty();
        userCity = new SimpleStringProperty();
        userCountry = new SimpleStringProperty();
        userPhoneNumber = new SimpleIntegerProperty();

    }

    public void setUserName(String userName) {
        this.userName.setValue(userName);
    }

    public void setUserPassword(String userPassword) {
        this.userPassword.setValue(userPassword);
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName.setValue(userFirstName);
    }

    public void setUserLastName(String userLastName) {
        this.userLastName.setValue(userLastName);
    }

    public void setUserAddress(String userAddress) {
        this.userAddress.setValue(userAddress);
    }

    public void setUserCity(String userCity) {
        this.userCity.setValue(userCity);
    }

    public void setUserCountry(String userCountry) {
        this.userCountry.setValue(userCountry);
    }

    public void setUserPhoneNumber(Integer userPhoneNumber) {
        this.userPhoneNumber.setValue(userPhoneNumber);
    }


    public String getUserName() {
        return userName.get();
    }

    public String getUserFirstName() {
        return userFirstName.get();
    }

    public String getUserLastName() {
        return userLastName.get();
    }

    public String getUserCity() {
        return userCity.get();
    }

    public String getUserAddress() {
        return userAddress.get();
    }

    public String getUserCountry() {
        return userCountry.get();
    }

    public Integer getUserPhoneNumber() {
        return userPhoneNumber.get();
    }

    public String getUserPassword() {
        return userPassword.get();
    }


    public StringProperty getUserNameProperty() {
        return userName;
    }

    public StringProperty getUserCityProperty() {
        return userCity;
    }

    public StringProperty getUserCountryProperty() {
        return userCountry;
    }

    public StringProperty getUserAddressProperty() {
        return userAddress;
    }

    public StringProperty getUserPasswordProperty() {
        return userPassword;
    }

    public IntegerProperty getUserPhoneNumberProperty() {
        return userPhoneNumber;
    }

}
