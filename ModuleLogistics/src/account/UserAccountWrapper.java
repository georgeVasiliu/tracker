package account;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by g0dzax on 5/25/2017.
 */

@XmlRootElement(name = "userAccounts")
public class UserAccountWrapper {
    private List<UserAccount> userAccounts;

    @XmlElement(name = "userAccount")
    public List<UserAccount> getUserAccounts() {
        return userAccounts;
    }

    public void setUserAccounts(List<UserAccount> userAccounts) {
        this.userAccounts = userAccounts;
    }
}
