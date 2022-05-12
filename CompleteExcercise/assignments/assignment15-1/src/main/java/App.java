import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
	public static void main(String[] args) {
		@SuppressWarnings({ "unused", "resource" })
		ApplicationContext context = new ClassPathXmlApplicationContext("springconfig.xml");       
	}
}
