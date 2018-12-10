package com.dream.medical.m;

public class OrderBean {

    /**
     * code : 0
     * indent : {"scopeTime":"13:00\u201414:00,15:00\u201417:00","unitPrice":"200,100","countPrice":"0","uname":"admin"}
     */

    public int code;
    public IndentBean indent;

    public static class IndentBean {
        /**
         * scopeTime : 13:00—14:00,15:00—17:00
         * unitPrice : 200,100
         * countPrice : 0
         * uname : admin
         */

        public String scopeTime;
        public String unitPrice;
        public String countPrice;
        public String uname;

        @Override
        public String toString() {
            return "IndentBean{" +
                    "scopeTime='" + scopeTime + '\'' +
                    ", unitPrice='" + unitPrice + '\'' +
                    ", countPrice='" + countPrice + '\'' +
                    ", uname='" + uname + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "OrderBean{" +
                "code=" + code +
                ", indent=" + indent +
                '}';
    }
}
