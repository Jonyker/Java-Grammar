package com.wukj.tools.bytes;

public class ByteToHexUtils {

    public void testByte() {
        byte a = (byte) 0xA0;
        byte b = (byte) 0x50;
        byte c = (byte) 0xFF;
        byte d = (byte) 0x09;
        byte e = (byte) 0x0E;
        byte f = (byte) 0x00;
        byte g = (byte) 0x01;
        byte h = (byte) 0x05;
        byte i = (byte) 0x00;
        byte j = (byte) 0x00;
        byte k = (byte) 0x00;
        byte l = (byte) 0x1C;
        byte m = (byte) 0x01;

        byte[] data = { a, b, c, d, e, f, g, h, i, j, k, l, m };

        // 二进制数据 转 十六进制(Hex)数据
        System.out.println(Converts.bytesToHexString(data));
        // 十六进制(Hex)数据 转 二进制数据
        System.out.println(Converts.bytesToHexString(Converts.hexStringToByte("A050FF090E0001050000001C01")));

        // 主机下发byte名称以s开头
        // 头部,固定两个字节
        byte sHeadA = (byte) 0xA0;
        byte sHeadB = (byte) 0x50;
        // 接收方地址,一个字节(当地址为0xff时，表示全体（对所有的分站有效）)
        byte sReceive;
        // 数据长度,一个字节(包括命令,数据,校验位)
        byte sLength;
        // 命令,一个字节
        byte sCommand;
        // 数据,n个字节
        byte sDate[] = {};
        // 和校验,两个字节(接收方地址,数据长度,命令,数据校验位(低字节在前,高字节在后),)
        byte sBitH;
        byte sBitL;



        // 读取UWB实时数据

        // 从机上传byte名称以r开头
        // 头部,固定两个字节
        byte rHeadA = (byte) 0xAA;
        byte rHeadB = (byte) 0x55;
        // 发送方地址,一个字节(当地址为0xff时，表示全体（对所有的分站有效）)
        byte rReceive;
        // 数据长度,一个字节(包括命令,数据,校验位)
        byte rLength;
        // 命令,一个字节
        byte rCommand;

        // 年,一个字节
        byte rYear;
        // 月,一个字节
        byte rMonth;
        // 日,一个字节
        byte rDay;
        // 卡数目,一个字节
        byte rCardNum;

        // 数据,n个字节
        byte rDate[] = {};

        // UWB卡片格式,14个字节
        // 读头号,一个字节
        byte uHead;
        // 卡号,四个字节
        byte uCardNo;
        // 序号,一个字节
        byte uNo;
        // 序号,一个字节
        byte uDistance;
        // 电压,一个字节
        byte uElec;
        // 状态,一个字节
        byte uState;
        // 备用,一个字节
        byte uStandby;
        // 时,一个字节
        byte uHour;
        // 分,一个字节
        byte uMinute;
        // 秒,一个字节
        byte uSecond;

        // 保留字,一个字节
        byte rKeep;
        // 和校验,两个字节(接收方地址,数据长度,命令,数据校验位(低字节在前,高字节在后),)
        byte rBitH;
        byte rBitL;

        
        // 原始串口数据
        // "aa" 55 01 16 0a 19 02 25 01 01 05 00 00 00 4f 37 00 29 00 00 00 01 10 00 28 01"
        // 通过串口接收的16进制数据(需要转换)            
        byte[] setialData = Converts.hexStringToByte("aa5501160a1902250101050000004f3700290000000110002801".toUpperCase());
        // System.out.println(Converts.bytesToHexString(Converts.hexStringToByte("aa5501160a1902250101050000004f3700290000000110002801".toUpperCase())));

        // 输出byte的16进制数据
        System.out.println("固定头部-----byte--0: " + Integer.toHexString(setialData[0] & 0xFF));
        System.out.println("固定头部-----byte--1: " + Integer.toHexString(setialData[1] & 0xFF));
        // 收到从机到主机数据,校验,前两个字节,AA 55
        if((setialData[0] == rHeadA)&&(setialData[1] == rHeadB)){
            // 基站地址
            System.out.println("基站地址-----byte--2: " + Integer.toHexString(setialData[2] & 0xFF));
            // 数据长度
            System.out.println("数据长度-----byte--3: " + Integer.toHexString(setialData[3] & 0xFF));
            // 命令
            System.out.println("命令数据-----byte--4: " + Integer.toHexString(setialData[4] & 0xFF));
            // 年
            System.out.println("年-----byte--5: " + Integer.toHexString(setialData[5] & 0xFF));
            // 月
            System.out.println("月-----byte--6: " + Integer.toHexString(setialData[6] & 0xFF));
            // 日
            System.out.println("日-----byte--7: " + Integer.toHexString(setialData[7] & 0xFF));
            // 卡片数量
            String cCount = Integer.toHexString(setialData[8] & 0xFF);
            System.out.println("卡片数量-----byte--8: " + Integer.toHexString(setialData[8] & 0xFF));
            // 截取全部卡包数据
            int dateLength = Integer.parseInt(cCount)*14;
            rDate = subBytes(setialData,9,dateLength);
            System.out.println("----------------------------------");
            System.out.println("卡包数据-----------------byte--9~"+ dateLength+": " + Converts.bytesToHexString(rDate));
            System.out.println("卡包数据-------读头号---byte-----0: " + Integer.toHexString(rDate[0] & 0xFF));
            byte cardNo[] = subBytes(rDate,1,4);
            System.out.println("卡包数据-------卡片号---byte--1~4: " + Converts.bytesToHexString(cardNo));
            System.out.println("卡包数据-------序号------byte-----5: " + Integer.toHexString(rDate[5] & 0xFF));
            System.out.println("卡包数据-------距离------byte--6~7: " + Converts.bytesToHexString(subBytes(rDate,6,2)));
            System.out.println("卡包数据-------电压------byte-----8: " + Integer.toHexString(rDate[8] & 0xFF));
            System.out.println("卡包数据-------状态------byte-----9: " + Integer.toHexString(rDate[9] & 0xFF));
            System.out.println("卡包数据-------备用------byte----10: " + Integer.toHexString(rDate[10] & 0xFF));
            System.out.println("卡包数据-------时------byte----11: " + Integer.toHexString(rDate[11] & 0xFF));
            System.out.println("卡包数据-------分------byte----12: " + Integer.toHexString(rDate[12] & 0xFF));
            System.out.println("卡包数据-------秒------byte----13: " + Integer.toHexString(rDate[13] & 0xFF));
            System.out.println("----------------------------------");

            System.out.println("卡包数据-------状态------byte-----xxxx: " + Long.toString(rDate[9] & 0xff, 2));

            int length = setialData.length;
            System.out.println("校验位置-----byte--"+ (length-2) + ": " + Integer.toHexString(setialData[length-2] & 0xFF));
            System.out.println("校验位置-----byte--"+ (length-1) + ": " + Integer.toHexString(setialData[length-1] & 0xFF));
            
        }







    }

    // 截取指定位置的byte
    public byte[] subBytes(byte[] src, int begin, int count) {
        byte[] bs = new byte[count];
        System.arraycopy(src, begin, bs, 0, count);
        return bs;
    }

    /**
     * byte数组转换为二进制字符串,每个字节以","隔开
     **/
    public static String conver2HexStr(byte[] b) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            result.append(Long.toString(b[i] & 0xff, 2) + ",");
        }
        return result.toString().substring(0, result.length() - 1);
    }

    

}