package com.sinlov.java.utils;

import com.sinlov.java.utils.HexUtils;
import org.junit.Test;


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
public class TestHexUtils {

    public static final String TEST_STR_TWO = "12345678qwertyui";
    public static final String TEST_HEX_STR = "4fb136d957b092cd29";

    @Test
    public void testHexStr2Bytes() {
        System.out.println("hex string: " + (byte) (79));
        System.out.println("hex string: " + (byte) (177));
        System.out.println("hex string: " + (byte) (0x75));
        System.out.println("hex string: " + (byte) (177 & 0xffff));
        byte[] bytes = HexUtils.hexStringToBytes("4fb136d957b092cd29c9b8555167b730976596f12af1ba99032f87ee753e2d465105e92919e81f6ed2de0af9abb98ca08d5db6fe46085a0b1158a5a7d349feea");
        for (byte d :
                bytes) {
            System.out.println("hexStringToBytes: " + HexUtils.byte2HexStr(d));
        }
        byte[] hexBytes = HexUtils.hexStr2Bytes(TEST_HEX_STR);
        for (byte b :
                hexBytes) {
            System.out.println("hexBytes to byte: " + HexUtils.byte2HexStr(b));
        }
        byte[] strDatas = TEST_STR_TWO.getBytes();
        System.out.println("Datas: " + HexUtils.bytes2HexStr(strDatas));
        for (byte data :
                strDatas) {
            System.out.println("str to byte: " + HexUtils.byte2HexStr(data));
        }
    }
}
