package com.example.desafios.utils.cryptography;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class MongoAesEncryptionUtil {

  private static String ALGORITHM = "AES/CBC/PKCS5Padding";
  private static String SECRET_KEY = "3E1A7F9D4C8B2E05A6D3F1E9B0C7A2D8";
  private static String INIT_VECTOR = "7c3a9b5f2d8e4c106fae7d92b31c8a04";

  public static String encrypt(String value) {
    try {
      
      IvParameterSpec iv = new IvParameterSpec(INIT_VECTOR.getBytes("UTF-8"));
      SecretKeySpec sKeySpec = new SecretKeySpec(SECRET_KEY.getBytes("UTF-8"), "AES");

      Cipher cipher = Cipher.getInstance(ALGORITHM);
      cipher.init(Cipher.ENCRYPT_MODE, sKeySpec, iv);

      byte[] encrypted = cipher.doFinal(value.getBytes("UTF-8"));
      return Base64.getEncoder().encodeToString(encrypted);
    } catch (Exception e) {
      throw new RuntimeException("Erro ao criptografar valor", e);
    }
  }

  public static String decrypt(String encrypted) {
    try {
      IvParameterSpec iv = new IvParameterSpec(INIT_VECTOR.getBytes("UTF-8"));
      SecretKeySpec sKeySpec = new SecretKeySpec(SECRET_KEY.getBytes("UTF-8"), "AES");

      Cipher cipher = Cipher.getInstance(ALGORITHM);
      cipher.init(Cipher.ENCRYPT_MODE, sKeySpec, iv);

      byte[] original = cipher.doFinal(Base64.getDecoder().decode(encrypted));
      return new String(original, StandardCharsets.UTF_8);
    } catch (Exception e) {
      throw new RuntimeException("Erro ao descriptografar valor", e);
    }
  }

}
