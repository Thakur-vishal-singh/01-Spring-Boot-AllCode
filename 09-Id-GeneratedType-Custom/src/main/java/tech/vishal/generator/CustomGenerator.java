package tech.vishal.generator;

import java.util.Random;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.stereotype.Component;

@Component
public class CustomGenerator implements IdentifierGenerator {

	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) {

		int v = new  Random().nextInt(10);
		int v1 = new Random().nextInt(10);
		int v2 = new Random().nextInt(10);
		int v3 = new Random().nextInt(10);
		String str = v+""+v1 +""+v2+""+v3;
		Integer value = Integer.parseInt(str);
		return value;
	}

}
