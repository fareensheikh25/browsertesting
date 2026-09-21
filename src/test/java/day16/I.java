package day16;

import org.openqa.selenium.By;

public interface I {
String base_url="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

String path="C:\\Users\\Dell\\eclipse-workspace\\day16\\src\\test\\java\\day16\\";
By user_name=By.name("username");
By pass=By.name("password");
By button_click=By.xpath("//button[@type='submit']");
}
