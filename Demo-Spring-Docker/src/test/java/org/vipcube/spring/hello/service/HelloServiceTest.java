package org.vipcube.spring.hello.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.vipcube.spring.hello.dto.Hello;
import org.vipcube.spring.hello.service.impl.HelloServiceImpl;

@SpringBootTest(
		classes = {
				HelloServiceImpl.class
		}
)
public class HelloServiceTest {
	@Autowired
	private IHelloService service;

	@Test
	public void test(){
		String name = "brad";
		Hello hello = this.service.hello( name );
		Assertions.assertEquals( name, hello.getName() );
	}
}
