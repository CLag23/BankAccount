
public class AppLauncher {
    public static void main(String[] args) {
            BankAccountFunction account = new BankAccountFunction();
            IDandPasswords idandpasswords = new IDandPasswords();
            SignInPage loginPage = new SignInPage(idandpasswords.getLoginInfo(), account);

        }
    }

