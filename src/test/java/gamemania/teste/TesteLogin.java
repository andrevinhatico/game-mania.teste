package gamemania.teste;


import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteLogin {
	
	private WebDriver driver;
	
	@Before	
	public void Setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chrome=driver\\chromedriver.exe");
		driver = new ChromeDriver(); //Abre Navegador
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void testarLogin() {
		driver.get("http://localhost:4200/login");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		WebElement inputEmail = driver.findElement(By.id("exampleInputEmail1"));
		WebElement inputSenha = driver.findElement(By.id("exampleInputPassword1"));
		WebElement botaoLogin = driver.findElement(By.id("botao-enviar"));	
		
		String[] listaSenhas = {"test12", "senhates12", "qualquersenha12", "bahia123"};
		
		for(int tentativas = 0; tentativas < listaSenhas.length; tentativas++) {
			
			try {
				
				inputEmail.clear();
				inputSenha.clear();
				
				inputEmail.sendKeys("andre@email.com"); 
				inputSenha.sendKeys(listaSenhas[tentativas]);
				botaoLogin.click();
				
				Thread.sleep(3000);			
				
			} catch (InterruptedException e) {
				e.printStackTrace();
				
			}
			
			
			
			
		}
		
		//inputEmail.sendKeys("andre@email.com"); 
		//inputSenha.sendKeys("bahia12"); //senha correta "bahia123"
		//botaoLogin.click();
		
			
	}	

}
