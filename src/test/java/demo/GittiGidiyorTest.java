package demo;

import static org.junit.Assert.*;
import org.junit.Test;


public class GittiGidiyorTest extends GGBase {
    @Test
    public void kullaniciKayitTest(){
        clickElementByXpath("div","data-cy","header-user-menu");
        clickElementByXpath("a","data-cy","header-register-button");
        sendKeysToElementByName("name","ali veli");
        sendKeysToElementByName("surname","velioglu");
        sendKeysToElementByName("email","lbhatiapara@minnacarter.com");
        sendKeysToElementByName("passwd","*Asd123*");
        sendKeysToElementByName("gsmData","5551234599");
        clickElementByXpath("label","for","informed-email");
        clickElementByXpath("input","id","SubmitForm");


        clickElementByXpath("div","data-cy","header-user-menu");

        assertTrue(findElementByXpath("a","title","Siparişlerim").isDisplayed());
    }

    @Test
    public void urunAramaVeSepeteEklemeTest(){
        sendKeysToElementByName("k","mousepad");
        clickElementByXpath("button","data-cy","search-find-button");
        clickElementByXpath("li","product-index","3");

        WebDriverWaitForSecondsUntilClickable(10,"add-to-basket");
        clickElementById("add-to-basket");
        assertEquals("1",findElementByXpath("span","class","notify-user basket-item-count").getAttribute("innerHTML"));
    }

    @Test
    public void girisYapTest(){
        girisYap();
        assertTrue(findElementByXpath("a","title","Siparişlerim").isDisplayed());
    }

    @Test
    public void adresEklemeTest(){
        girisYap();
        clickElementByXpath("div","data-cy","header-user-menu");
        findElementByXpath("a","title","Bilgilerim / Ayarlarım").click();
        clickElementByXpath("a","href","/bana-ozel/adreslerim");
        sendKeysToElementByName("sifre","*Asd123*");
        clickElementById("gg-login-enter");
        clickElementByXpath("a","href","//www.gittigidiyor.com/bana-ozel/adreslerim/ekle");
        sendKeysToElementByName("title","saray");
        sendKeysToElementByName("name","ali");
        sendKeysToElementByName("surname","velioglu");
        selectItemByValue("34","cities");
        selectItemByValue("479","counties");
        selectItemByIndex(3,"neighborhoods");
        sendKeysToElementByName("zipCode","34000");
        sendKeysToElementByName("address","lorem ipsum lorem ipsum lorem ipsum");
        sendKeysToElementByName("phone","5551234599");
        clickElementById("AddressSave");

        assertEquals("Tebrikler. Adres ekleme işleminiz başarıyla tamamlandı.",
                getTextByXpath("//div[@class='gg-ui-alert-primary-confirm']/span"));

    }
}
