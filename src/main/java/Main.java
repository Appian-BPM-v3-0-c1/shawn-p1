import com.revature.shop.services.UserService;
import com.revature.shop.daos.UserDAO;
import com.revature.shop.ui.LoginMenu;

public class Main {

    public static void main(String[]args) {

        new LoginMenu(new UserService(new UserDAO())).start();

    }
}
