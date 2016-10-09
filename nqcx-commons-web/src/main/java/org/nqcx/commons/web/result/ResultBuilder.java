/* 
 * Copyright 2014 nqcx.org All right reserved. This software is the 
 * confidential and proprietary information of nqcx.org ("Confidential 
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with nqcx.org.
 */

package org.nqcx.commons.web.result;

import org.nqcx.commons.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author naqichuan 2014年8月14日 上午11:50:15
 */
public class ResultBuilder {

    public final static String D = "default";
    public final static String M = "msg";
    public final static String E = "error";
    public final static String S = "success";

    private final static Map<String, String> types = new HashMap<String, String>();

    static {
        types.put(D, "M");
        types.put(M, "M");
        types.put(E, "E");
        types.put(S, "S");
    }

    private Map<String, Result> results;


    /**
     * @param code
     * @return
     */
    public Result getResult(String code) {
        return getResult(null, code);
    }

    /**
     * @param type
     * @param code
     * @return
     */
    public Result getResult(String type, String code) {
        String t = (type != null && types.containsKey(type.toLowerCase()) ? types.get(type.toLowerCase()) : types.get(D));
        String c = (code == null ? getFullCode("0") : getFullCode(code));

        Result rs = null;
        if ((rs = results.get(t + c)) == null) {
            rs = new Result();
            rs.setType(type);
            rs.setCode(c);
            rs.setSubject("R" + t + "." + c + ".SUBJECT");
        }
        return unite(results.get(t + getFullCode("0")), rs);
    }

    /**
     * @param code
     * @return
     */
    private static String getFullCode(String code) {
        return StringUtils.leftPad(code, 5, '0');
    }

    /**
     * 合并操作
     *
     * @param base  基本信息对像，需要合并到基本信息对像的信息
     * @param other
     * @return
     */
    private Result unite(Result base, Result other) {

        Result newRs = base.clone();

        if (other == null)
            return null;

        if (other.getCode() != null && other.getCode().length() > 0)
            newRs.setCode(other.getCode());
        if (other.getType() != null && other.getType().length() > 0)
            newRs.setType(other.getType());
        if (other.getTitle() != null && other.getTitle().length() > 0)
            newRs.setTitle(other.getTitle());
        if (other.getSubject() != null && other.getSubject().length() > 0)
            newRs.setSubject(other.getSubject());
        if (other.getSuggestTitle() != null && other.getSuggestTitle().length() > 0)
            newRs.setSuggestTitle(other.getSuggestTitle());
        if (other.getSuggest() != null && other.getSuggest().size() > 0)
            newRs.setSuggest(other.getSuggest());
        if (other.getAuto() != null && other.getAuto().length() > 0)
            newRs.setAuto(other.getAuto());
        if (other.getIndex() != null && other.getIndex().length() > 0)
            newRs.setIndex(other.getIndex());

        return newRs;
    }

    /**
     * @param results
     */
    public void setResults(Map<String, Result> results) {
        this.results = results;
    }
}