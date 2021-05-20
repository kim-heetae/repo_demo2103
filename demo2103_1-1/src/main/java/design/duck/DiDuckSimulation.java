package design.duck;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DiDuckSimulation {
	
	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("design\\duck\\duckBean.xml");
		Duck myDuck = (Duck)context.getBean("myduck");
		myDuck.performQuack();
		myDuck.performFly();
		myDuck = null;//14라인에서 15번 라인으로 넘어갈때 candidate상태로 바뀌고 garbage collector의 대상이 됨
		myDuck = new MallardDuck();//다시 생성되는 라인 - 이전의 것과 다르다. - 위에는 관리받는 duck, 지금부터는 관리받지 못하는 duck
		myDuck.performQuack();
		myDuck.performFly();
	}
}
