package com.dream.medical.m;

public class TestBean {

    /**
     * code : 0
     * getOptionsById : {"id":17,"testId":2,"answerparam":"{\"field_2\":[\"你有几栋房子\",\"五栋-5\",\"我还有别墅-10\"]}","ctime":"2018-08-23 17:21:58"}
     */

    public int code;
    public GetOptionsByIdBean getOptionsById;

    public static class GetOptionsByIdBean {
        /**
         * id : 17
         * testId : 2
         * answerparam : {"field_2":["你有几栋房子","五栋-5","我还有别墅-10"]}
         * ctime : 2018-08-23 17:21:58
         */

        public int id;
        public int testId;
        public String answerparam;
        public String ctime;
    }
}
