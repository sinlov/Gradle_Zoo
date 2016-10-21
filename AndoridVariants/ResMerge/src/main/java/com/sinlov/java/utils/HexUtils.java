package com.sinlov.java.utils;

/**
 * <pre>
 *     sinlov
 *
 *     /\__/\
 *    /`    '\
 *  ≈≈≈ 0  0 ≈≈≈ Hello world!
 *    \  --  /
 *   /        \
 *  /          \
 * |            |
 *  \  ||  ||  /
 *   \_oo__oo_/≡≡≡≡≡≡≡≡o
 *
 * </pre>
 * Created by sinlov on 16/9/5.
 */
public class HexUtils {

    private static final String HEX_STR_POOL = "0123456789ABCDEF";
    private static StringBuffer buf = new StringBuffer();

    public static byte[] hexStr2Bytes(String hexStr) {
        if (hexStr.length() < 1)
            return null;
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }

    public static byte[] hexStringToBytes(String hexString) {
        if (hexString == null || hexString.equals("")) {
            return null;
        }
        hexString = hexString.toUpperCase();
        int length = hexString.length() / 2;
        char[] hexChars = hexString.toCharArray();
        byte[] d = new byte[length];
        for (int i = 0; i < length; i++) {
            int pos = i * 2;
            byte h = charToByte(hexChars[pos]);
            byte l = charToByte(hexChars[pos + 1]);
            d[i] = (byte) (h << 4 | l);
        }
        return d;
    }

    /**
     * Convert char to byte
     * @param c char
     * @return byte
     */
    private static byte charToByte(char c) {
        return (byte) HEX_STR_POOL.indexOf(c);
    }


    public static String bytes2HexStr(byte[] datas) {
        if (datas == null || datas.length == 0) {
            return null;
        }
        buf.setLength(0);
        for (int i = 0; i < datas.length; i++) {
            if (((int) datas[i] & 0xff) < 0x10) {
                 /* & 0xff转换无符号整型 */
                buf.append("0");
            }
             /* 转换16进制,下方法同 */
            buf.append(Long.toHexString((int) datas[i] & 0xff));
        }
        return buf.toString();
    }

    public static String byte2HexStr(byte data) {
        buf.setLength(0);
        buf.append("0x");
        if (((int) data & 0xff) < 0x10) {
            buf.append("0");
        }
        buf.append(Long.toHexString((int) data & 0xff));
        return buf.toString();
    }

    private HexUtils() {
    }
}
