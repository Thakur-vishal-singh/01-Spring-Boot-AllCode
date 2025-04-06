//package com.example;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//import com.example.bean.HelloBean;
//
//@SpringBootApplication
//public class Application {
//
//	
//	 static HelloBean helloBean;
//
//	 @Autowired
//	 public Application(HelloBean helloBean) {
//		 this.helloBean =helloBean;
//	 }
//	 
//	 
//	public static void main(String[] args) {
////		ApplicationContext context = SpringApplication.run(Application.class, args);
//		SpringApplication.run(Application.class, args).getBean(Application.class);
//		
////		HelloBean helloBean = context.getBean(HelloBean.class);
//		
//		helloBean.firstHello();
//		helloBean.helloBean();
//		
//		
//	}
//
//}

//package com.example;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ApplicationContext;
//
//import com.example.bean.HelloBean;
//
//@SpringBootApplication
//public class Application {
//
//	public static void main(String[] args) {
//		// ✅ Correct way to retrieve ApplicationContext
//		ApplicationContext context = SpringApplication.run(Application.class, args);
//
//		// ✅ Fetch the HelloBean correctly
//		HelloBean helloBean = context.getBean(HelloBean.class);
//
//		// ✅ Call methods
//		helloBean.firstHello();
//		helloBean.helloBean();
//		
//	}
//}
package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.bean.HelloBean;

@SpringBootApplication
public class Application {

    private final HelloBean helloBean;  // Not static

    @Autowired
    public Application(HelloBean helloBean) {
        this.helloBean = helloBean;
    }

    public void runApp() {
        helloBean.firstHello();
        helloBean.helloBean();
    }

    public static void main(String[] args) {
        Application app = SpringApplication.run(Application.class, args).getBean(Application.class);
        app.runApp(); // Run the application logic safely
    }
}

