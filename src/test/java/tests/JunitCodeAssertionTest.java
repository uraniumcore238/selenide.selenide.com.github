package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class JunitCodeAssertionTest {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void assertTheJunitCode() {

        String url = "https://github.com/selenide/selenide";
        String softAssertion = "Soft assertions";
        String jUnit5Text = "JUnit5";


        open(url);
        $x("//h1[contains(@class, ' d-flex')]//a[@href='/selenide/selenide']").shouldHave(text("selenide"));
        $x("//span[@data-content='Wiki']").click();
        ElementsCollection myElements = $$x("//div[@class='markdown-body']/ul/li/a");
        for (int i = 0; i < myElements.size(); i++) {
            String myStr = myElements.get(i).getText();
            System.out.println(myStr);
            if (myStr.equals(softAssertion)) {
                myElements.get(i).click();
                break;
            }

        }
        $x("//ol/li[.='Using JUnit5 extend test class:']").shouldHave(text(jUnit5Text));

    }


}
