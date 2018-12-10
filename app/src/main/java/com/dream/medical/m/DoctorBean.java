package com.dream.medical.m;

import java.util.List;

public class DoctorBean {
    /**
     * code : 0
     * page : {"totalCount":2,"pageSize":10,"totalPage":1,"currPage":1,"list":[{"id":2,"introduce":"大米饭博士，人称雷电法王，中国网瘾治疗第一人","cratetime":"2018-08-17 17:38:14","updatetime":"2018-08-17 17:38:14","r2":null,"r1":null,"uname":"admin","uid":2},{"id":1,"introduce":"梁文：主任医生，毕业于北大医学院心理系博士生导师，从事心理疾病问诊20余年，拥有丰富经验。预约问诊时间每周一、三、五.am8:00-pm16:00\r\n收费200元/小时，每半小时为收费单位","cratetime":"2018-08-16 13:49:27","updatetime":"2018-08-16 13:49:27","r2":null,"r1":null,"uname":"admin","uid":1}]}
     */

    public int code;
    public PageBean page;

    public static class PageBean {
        /**
         * totalCount : 2
         * pageSize : 10
         * totalPage : 1
         * currPage : 1
         * list : [{"id":2,"introduce":"大米饭博士，人称雷电法王，中国网瘾治疗第一人","cratetime":"2018-08-17 17:38:14","updatetime":"2018-08-17 17:38:14","r2":null,"r1":null,"uname":"admin","uid":2},{"id":1,"introduce":"梁文：主任医生，毕业于北大医学院心理系博士生导师，从事心理疾病问诊20余年，拥有丰富经验。预约问诊时间每周一、三、五.am8:00-pm16:00\r\n收费200元/小时，每半小时为收费单位","cratetime":"2018-08-16 13:49:27","updatetime":"2018-08-16 13:49:27","r2":null,"r1":null,"uname":"admin","uid":1}]
         */

        public int totalCount;
        public int pageSize;
        public int totalPage;
        public int currPage;
        public List<ListBean> list;

        public static class ListBean {
            /**
             * id : 2
             * introduce : 大米饭博士，人称雷电法王，中国网瘾治疗第一人
             * cratetime : 2018-08-17 17:38:14
             * updatetime : 2018-08-17 17:38:14
             * r2 : null
             * r1 : null
             * uname : admin
             * uid : 2
             */

            public int id;
            public String introduce;
            public String cratetime;
            public String updatetime;
            public String r2;
            public String r1;
            public String uname;
            public int uid;
        }
    }
}
