package com.musicbeat.web.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 加密哈希工具类
 *
 * @author windawings
 * @time.creation 2017/01/26 13:44
 * @version 1.0.0
 * @since 1.0.0
 */
public class EncryptUtil  {
  public static final int SHA256LENGTH = 64;

  /**
   * 传入文本内容，返回 SHA-256 串
   *
   * @param strText the str text
   * @return string
   */
  public static String SHA256(final String strText) {
    return SHA(strText, "SHA-256");
  }

  /**
   * 传入文本内容，返回 SHA-512 串
   *
   * @param strText the str text
   * @return string
   */
  public static String SHA512(final String strText) {
    return SHA(strText, "SHA-512");
  }

  /**
   * 传入文本内容，返回 MD5 串
   *
   * @param strText the str text
   * @return string
   */
  public static String MD5(final String strText) {
    return SHA(strText, "MD5");
  }

  /**
   * 传入文本内容，返回 SHA1 串
   *
   * @param strText the str text
   * @return string
   */
  public static String SHA1(final String strText) {
    return SHA(strText, "SHA-1");
  }

  /**
   * 字符串 SHA 加密
   *
   * @param strText 哈希字串
   * @param strType 哈希类型
   * @return 哈希内容
   */
  private static String SHA(final String strText, final String strType) {
    // 返回值
    String strResult = null;

    // 是否是有效字符串
    if (strText != null && strText.length() > 0) {
      try {
        // SHA 加密开始
        // 创建加密对象 并傳入加密類型
        MessageDigest messageDigest = MessageDigest.getInstance(strType);
        // 传入要加密的字符串
        messageDigest.update(strText.getBytes());
        // 得到 byte 類型结果
        byte byteBuffer[] = messageDigest.digest();

        // 將 byte 轉換爲 string
        StringBuilder strHexString = new StringBuilder();
        // 遍歷 byte buffer
        for (byte b: byteBuffer) {
          String hex = Integer.toHexString(0xFF & b);
          if (hex.length() == 1) {
            strHexString.append('0');
          }
          strHexString.append(hex);
        }
        // 得到返回結果
        strResult = strHexString.toString();
      } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
      }
    }

    return strResult;
  }
}
