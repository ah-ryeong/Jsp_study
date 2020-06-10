package com.cos.blog.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

// 1234 -> 해쉬 ABADJFADSKF@%#%$% 이런걸 데이터베이스에 집어넣을거임

// 해시암호 : SHA256, HMAC256을 사용한다.
// 해시는 복호화 X , 암호화 + 복호화를 같이 하는 것은 Base64를 많이 사용한다.
public class SHA256 { 
private final static String mSalt = "코스";
	
    
    public static String encodeSha256(String source) {
        String result = "";
        
        byte[] a = source.getBytes();
        byte[] salt = mSalt.getBytes();
        byte[] bytes = new byte[a.length + salt.length];
        
        System.arraycopy(a, 0, bytes, 0, a.length);
        System.arraycopy(salt, 0, bytes, a.length, salt.length);
        
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(bytes);
            
            byte[] byteData = md.digest();
            
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xFF) + 256, 16).substring(1));
            }
            
            result = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        
        return result;
    }
}
