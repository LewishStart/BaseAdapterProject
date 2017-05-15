package com.lewish.start.expandablelistviewdemo;

import java.util.ArrayList;
import java.util.List;

/**
 * author: sundong
 * created at 2017/5/15 17:21
 */
public class GroupBean {
    public String groupName;
    public String groupId;
    public List<EntryBean> entryBeanList = new ArrayList<>();

    public class EntryBean {
        public String entryName;
        public String entryId;
    }
}
