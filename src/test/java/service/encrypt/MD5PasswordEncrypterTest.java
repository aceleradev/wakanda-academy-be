package service.encrypt;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.security.NoSuchAlgorithmException;

import org.junit.Before;
import org.junit.Test;

import com.aceleradev.api.service.encrypt.PasswordEncrypter;
import com.aceleradev.api.service.encrypt.impl.MD5PasswordEncrypter;

public class MD5PasswordEncrypterTest {
	
	private PasswordEncrypter encrypter;
	
	@Before
	public void createEncrypter() {
		this.encrypter = new MD5PasswordEncrypter();
	}
	
	@Test
	public void assertMd5HashOk() throws NoSuchAlgorithmException {
		String md5Hash = this.encrypter.encrypt(ENCRYPTED_VALUE);
		assertEquals(EXPECTED_HAHS, md5Hash);
	}
	
	private static final String ENCRYPTED_VALUE = "12345";
	private static final String EXPECTED_HAHS = "827ccb0eea8a706c4c34a16891f84e7b";

}
