package demo;

public class GGBase extends Base{
    public void girisYap(){
        clickElementByXpath("div","data-cy","header-user-menu");
        clickElementByXpath("a","data-cy","header-login-button");
        sendKeysToElementByName("kullanici","tmastercs@pkinform.ru");
        sendKeysToElementByName("sifre","*Asd123*");
        clickElementById("gg-login-enter");
    }
}
