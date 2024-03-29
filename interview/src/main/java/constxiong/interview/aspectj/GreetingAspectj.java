package constxiong.interview.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingAspectj {

	/**
	 * 第一个*表示任意返回值,第二个*表示任意方法,..表示任意参数
	 * @param pjp
	 * @return
	 * @throws Throwable
	 */
	@Around("execution(* constxiong.interview.aop.GreetingImpl.*(..))")
	public Object around(ProceedingJoinPoint pjp) throws Throwable{
		before();
		Object result = pjp.proceed();
		after();
		return result;
	}

	private void before() {
		System.out.println("before");
	}

	private void after() {
		System.out.println("after");
	}
	
}
