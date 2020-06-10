package com.cos.blog.test;

import org.junit.Test;

// 1234 -> 해쉬 ABADJFADSKF@%#%$% 이런걸 데이터베이스에 집어넣을거임

// 해시암호 : SHA256, HMAC256을 사용한다.
// 해시는 복호화 X , 암호화 + 복호화를 같이 하는 것은 Base64를 많이 사용한다.
public class SHA256 { 
	private final static String salt = "코스";
	
	@Test
	public void encSha256() {
		String plain = "1234";
		String result = "";
		
		byte[] bytePlain = plain.getBytes();
		byte[] byteSalt = salt.getBytes();
		
		for (byte b : bytePlain) {
			System.out.print(b + " ");
		}
		System.out.println();
		
		for (byte b : byteSalt) {
			System.out.print(b + " ");
		}
		
		byte[] bytePlainAndSalt = new byte[bytePlain.length+byteSalt.length];
		
		
	}
}
