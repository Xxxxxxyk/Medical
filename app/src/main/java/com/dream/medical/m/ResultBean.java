package com.dream.medical.m;

public class ResultBean {

    /**
     * code : 0
     * getOptionsById : {"id":2,"testId":2,"maxscore":300,"minscore":0,"content":"你人品很好，请继续保持","suggest":null,"ctime":"2018-08-24 11:35:05"}
     */

    public int code;
    public GetOptionsByIdBean getOptionsById;

    public static class GetOptionsByIdBean {
        /**
         * id : 2
         * testId : 2
         * maxscore : 300
         * minscore : 0
         * content : 你人品很好，请继续保持
         * suggest : null
         * ctime : 2018-08-24 11:35:05
         */

        public int id;
        public int testId;
        public int maxscore;
        public int minscore;
        public String content;
        public String suggest;
        public String ctime;

        @Override
        public String toString() {
            return "GetOptionsByIdBean{" +
                    "id=" + id +
                    ", testId=" + testId +
                    ", maxscore=" + maxscore +
                    ", minscore=" + minscore +
                    ", content='" + content + '\'' +
                    ", suggest='" + suggest + '\'' +
                    ", ctime='" + ctime + '\'' +
                    '}';
        }
    }
}
