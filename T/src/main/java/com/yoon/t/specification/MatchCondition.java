package com.yoon.t.specification;

import java.util.Map;

public class MatchCondition {
    private String expectedContainedKey;
    private String expectedContainedValue;

    public MatchCondition(String expectedContainedKey, String expectedContainedValue) {
        this.expectedContainedKey = expectedContainedKey;
        this.expectedContainedValue = expectedContainedValue;
    }

    public static MatchCondition expectedContainedKey(String expectedContainedKey, String expectedContainedValue) {
        return new MatchCondition(expectedContainedKey, expectedContainedValue);
    }

    public boolean isSatisfy(Object o){
        if(o instanceof Map) {
            Map<String, String> map = (Map<String, String>) o;
            return expectedContainedValue.equals(map.get(expectedContainedKey));
        }
        return false;
    }
}
