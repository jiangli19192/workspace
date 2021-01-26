package com.zjl.study.SysConvert;

import java.util.logging.Logger;

/**
 * 十进制与十六进制简单互转
 * 
 * 原文链接：https://blog.csdn.net/hanchao5272/article/details/79434076
 * 
 * ClassName : DccimalToHexaDecimal
 * @author 张江立
 * @date 2020年2月22日 下午1:40:32
 *
 */
public class DccimalToHexaDecimal {
	private static final Logger LOGGER = Logger.getLogger("TenToHexDemo");
    public static void main(String[] args) {
         //定义一个十进制值
        int valueTen = 328;
        //将其转换为十六进制并输出
        String strHex = Integer.toHexString(valueTen);
        LOGGER.info(valueTen + " [十进制]---->[十六进制] " + strHex);
        //将十六进制格式化输出
        String strHex2 = String.format("%08x",valueTen);
        LOGGER.info(valueTen + " [十进制]---->[十六进制] " + strHex2);

        LOGGER.info("==========================================================");
        //定义一个十六进制值
        String strHex3 = "00001322";
        //将十六进制转化成十进制
        int valueTen2 = Integer.parseInt(strHex3,16);
        LOGGER.info(strHex3 + " [十六进制]---->[十进制] " + valueTen2);

        LOGGER.info("==========================================================");
        //可以在声明十进制时，自动完成十六进制到十进制的转换
        int valueHex = 0x00001322;
        LOGGER.info("int valueHex = 0x00001322 --> " + valueHex);
        
        
        System.out.println(0x17);
        System.out.println(0x18);
        System.out.println(0x19);
        System.out.println(0x20);
        System.out.println(Integer.toHexString(2));
    }
}
