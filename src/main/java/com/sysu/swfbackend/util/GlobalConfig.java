package com.sysu.swfbackend.util;


public class GlobalConfig {

    public static final Boolean Test = true;

    public enum ResponseCode{
        SUCCESS(0, "success"),
        ERROR(1, "error");

        private final int code;
        private final String desc;
        ResponseCode(int code, String desc) {
            this.code = code;
            this.desc = desc;
        }
        public int getCode(){return code;}
        public String getDesc(){return desc;}
    }
}
