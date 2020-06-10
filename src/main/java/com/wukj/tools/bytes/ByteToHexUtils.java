package com.wukj.tools.bytes;

public class ByteToHexUtils {

    public static void main(String[] args) {
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
        System.out.println(Converts.hexStringToByte("A050FF090E0001050000001C01"));




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
        // 数据,n个字节
        byte rDate[] = {};
        // 和校验,两个字节(接收方地址,数据长度,命令,数据校验位(低字节在前,高字节在后),)
        byte rBitH;
        byte rBitL;



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
        byte uB;
        // 时,一个字节
        byte uHour;
        // 分,一个字节
        byte uMinute;
        // 秒,一个字节
        byte uSecond;

        







    }

    

}