package account;

import hash.HashGen;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import sun.security.util.Password;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Random;

/*
 * Created by george on 5/22/17.
 */
public class UserAccount {

    private final StringProperty userUID;
    private final StringProperty localFolder;
    private final StringProperty projectsFolder;


    private final StringProperty userName;
    private final StringProperty userPassword;
    private final StringProperty userFirstName;
    private final StringProperty userLastName;
    private final StringProperty userAddress;
    private final StringProperty userCity;
    private final StringProperty userCountry;
    private final IntegerProperty userPhoneNumber;

    public UserAccount() {
        localFolder = new SimpleStringProperty();
        projectsFolder = new SimpleStringProperty();
        userUID = new SimpleStringProperty();
        userName = new SimpleStringProperty();
        userPassword = new SimpleStringProperty();
        userFirstName = new SimpleStringProperty();
        userLastName = new SimpleStringProperty();
        userAddress = new SimpleStringProperty();
        userCity = new SimpleStringProperty();
        userCountry = new SimpleStringProperty();
        userPhoneNumber = new SimpleIntegerProperty();
    }


    public UserAccount(String userName, String userPassword) {
        this.userName = new SimpleStringProperty(userName);
        this.userPassword = new SimpleStringProperty(userPassword);

        userFirstName = new SimpleStringProperty();
        userLastName = new SimpleStringProperty();
        userAddress = new SimpleStringProperty();
        userCity = new SimpleStringProperty();
        userCountry = new SimpleStringProperty();
        userPhoneNumber = new SimpleIntegerProperty();
        localFolder = new SimpleStringProperty();
        projectsFolder = new SimpleStringProperty();
        userUID = new SimpleStringProperty();
        userUID.set(userName.substring(0, 3) + HashGen.getHash(userPassword).substring(0, 3));

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

    public String getUserUID() {
        return userUID.get();
    }

    public String getLocalFolder() {
        return localFolder.get();
    }

    public void setLocalFolder(String localFolder) {
        this.localFolder.set(localFolder);
    }

    public String getProjectsFolder() {
        return projectsFolder.get();
    }

    public void setProjectsFolder(String projectsFolder) {
        this.projectsFolder.set(projectsFolder);
    }


    public StringProperty getUserLocalFolderProperty() { return localFolder ;}
    public StringProperty getUserProejctsFolderProperty() { return projectsFolder;}
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
