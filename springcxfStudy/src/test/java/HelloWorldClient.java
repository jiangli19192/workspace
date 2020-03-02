import java.util.ArrayList;
import java.util.List;

import com.zjl.study.springcxf.client.HelloWorldService;
import com.zjl.study.springcxf.client.HelloWorldServiceImplService;
import com.zjl.study.springcxf.client.User;

 
 
public class HelloWorldClient {
      
       public static void main(String[] args) {
//    	   ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[]{"spring-mvc.xml", "cxf-servlet.xml"});
//    	   HelloWorldService service = ctx.getBean("client", HelloWorldService.class);
//           System.out.println("#############Client getUserByName##############");
//           String text = "张江立";
//           String sayHiResult = service.sayHi(text);
//           System.out.println(sayHiResult);
    	   
    	   HelloWorldServiceImplService service = new HelloWorldServiceImplService();
    	   HelloWorldService helloWorldService = service.getHelloWorldServiceImplPort();
    	   String text = "zhangjiangli";
    	   String sayHiResult = helloWorldService.sayHi(text);
    	   System.out.println(sayHiResult);
    	   
    	   User arg0 = new User();
    	   arg0.setName(text);
    	   sayHiResult = helloWorldService.sayHiToUser(arg0);
    	   System.out.println(sayHiResult);
    	   
    	   
    	   List<User> userList = new ArrayList<User>();
    	   userList.add(arg0);
    	   
    	   User arg1 = new User();
    	   arg1.setName("aaaaaa");
    	   userList.add(arg1);
    	   
    	   List<String> strList = helloWorldService.sayHiToUserList(userList);
    	   for(String str : strList){
    		   System.out.println(str);
    	   }
       }
}