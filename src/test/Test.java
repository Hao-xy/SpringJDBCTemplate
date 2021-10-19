package test;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import action.UserAction;
import entity.User;

public class Test {
	
    public static void main( String[] args ){
    	Test test = new Test();
    	UserAction userAction = test.getController();

  // 	test.testAdd(userAction);
    	test.testFindNumbers(userAction);
/*
     	test.testFindNameById(userAction);
  	test.testFindUser(userAction);
      	test.testFindAll(userAction);
      	test.testFindMapUser(userAction);
      	test.testFindMapAll(userAction);
  */
	}
    public UserAction getController(){
    	ApplicationContext context = 
        		new ClassPathXmlApplicationContext("config/applicationContext.xml");
    	UserAction userAction = (UserAction) context.getBean("userAction");
    	return userAction;
    }
    
    public void testAdd(UserAction userAction){
    	User user  =new User();
    	user.setId(7);
    	user.setName("����");
    	user.setAge(20);
    	userAction.add(user);
    }
    
    public void testFindNumbers(UserAction userAction){
    	int numbers = userAction.findNumbers();
    	System.out.println("findNumbers�����Ĳ�ѯ�����");
    	System.out.println("����"+numbers+"���û���");
    }
    
    public void testFindNameById(UserAction userAction){
    	String name = userAction.findNameById(1);
    	System.out.println("findNameById�����Ĳ�ѯ�����");
    	System.out.println("ѧ��Ϊ1��ѧ��������Ϊ��"+name);
    }
    
    public void testFindUser(UserAction userAction){
    	System.out.println("findUser�����Ĳ�ѯ�����");
    	User user  = userAction.findById(1);
    	System.out.println("id��"+user.getId()
    	+",name:"+user.getName()
    	+",age:"+user.getAge());
    }

    public void testFindAll(UserAction userAction){
    	List<User> users  = userAction.findAll();
    	System.out.println("findAll�����Ĳ�ѯ�����");
    	for(User user:users){
	    	System.out.println("id��"+user.getId()
	    	+",name:"+user.getName()
	    	+",age:"+user.getAge());
    	}
    }

    public void testFindMapUser(UserAction userAction){
    	System.out.println("findMapUser�����Ĳ�ѯ�����");
    	Map<String,Object> user  = userAction.findMapById(1);
    	System.out.println("id��"+user.get("id")
    	+",name:"+user.get("name")
    	+",age:"+user.get("age"));
    }

    public void testFindMapAll(UserAction userAction){
    	System.out.println("findMapAll�����Ĳ�ѯ�����");
    	List<Map<String,Object>> users  = userAction.findAllMap();
    	for(Map<String,Object> user:users){
        	System.out.println("id��"+user.get("id")
        	+",name:"+user.get("name")
        	+",age:"+user.get("age"));
    	}
    }
}
