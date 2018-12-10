package com.dream.medical.m;

import java.util.List;

public class LiveBean {

    /**
     * code : 0
     * list : [{"userId":21,"url":"www.baidu.com","utime":"2018-10-08 21:20:13"},{"userId":22,"url":"www.baidu.com","utime":"2018-10-08 21:20:13"}]
     */

    public int code;
    public List<ListBean> list;

    public static class ListBean {
        /**
         * userId : 21
         * url : www.baidu.com
         * utime : 2018-10-08 21:20:13
         */

        public int userId;
        public String url;
        public String utime;
    }
}
