/*
 * Copyright 1998-2013 jd.com All right reserved. This software is the
 * confidential and proprietary information of jd.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with jd.com.
 */

package org.nqcx.commons.lang;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.nqcx.commons.lang.page.PageBuilder;
import org.nqcx.commons.lang.sort.SortBase;

/**
 * Data transfer object
 * 
 * @author naqichuan Dec 23, 2013 10:11:59 PM
 */
public class DTO extends EntityBase {

	/**
	 * 成功标记
	 */
	private boolean success = false;

	/**
	 * id
	 */
	protected long id;

	/**
	 * ids
	 */
	protected long[] ids;

	/**
	 * 实体对象
	 */
	protected Object object;

	/**
	 * 实例对象列表
	 */
	protected List<Object> list;

	/**
	 * 参数列表
	 */
	protected Map<String, Object> paramsMap;

	/**
	 * 返回结果
	 */
	protected Map<String, Object> resultMap;

	/**
	 * 分页
	 */
	protected PageBuilder page;

	/**
	 * 排序
	 */
	protected SortBase sort;

	public DTO() {

	}

	public DTO(boolean success) {
		this.success = success;
	}

	public boolean isSuccess() {
		return success;
	}

	public DTO setSuccess(boolean success) {
		this.success = success;
		return this;
	}

	public long getId() {
		return id;
	}

	public DTO setId(long id) {
		this.id = id;
		return this;
	}

	public long[] getIds() {
		return ids;
	}

	public DTO setIds(long[] ids) {
		this.ids = ids;
		return this;
	}

	/**
	 * 取实体对象
	 * 
	 * @return object
	 */
	@SuppressWarnings("unchecked")
	public <T> T getObject() {
		return (T) object;
	}

	public DTO setObject(Object object) {
		this.object = object;
		return this;
	}

	/**
	 * 取实体对象列表
	 * 
	 * @return 实体对象的List
	 */
	@SuppressWarnings("unchecked")
	public <T> List<T> getList() {
		return (List<T>) list;
	}

	public DTO setList(List<Object> list) {
		this.list = list;
		return this;
	}

	public Map<String, Object> getParamsMap() {
		return paramsMap;
	}

	public DTO setParamsMap(Map<String, Object> paramsMap) {
		this.paramsMap = paramsMap;
		return this;
	}

	public DTO putParam(String key, Object value) {
		if (this.paramsMap == null)
			this.paramsMap = new LinkedHashMap<String, Object>();
		this.paramsMap.put(key, value);
		return this;
	}

	@SuppressWarnings("unchecked")
	public <T> T getParam(String key) {
		return this.paramsMap == null ? null : (T) this.paramsMap.get(key);
	}

	public void removeParam(String key) {
		if (this.paramsMap != null)
			this.paramsMap.remove(key);
	}

	public Map<String, Object> getResultMap() {
		return resultMap;
	}

	public DTO setResultMap(Map<String, Object> resultMap) {
		this.resultMap = resultMap;
		return this;
	}

	public DTO putResult(String key, Object value) {
		if (this.resultMap == null)
			this.resultMap = new LinkedHashMap<String, Object>();
		this.resultMap.put(key, value);
		return this;
	}

	@SuppressWarnings("unchecked")
	public <T> T getResult(String key) {
		return this.resultMap == null ? null : (T) this.resultMap.get(key);
	}

	public void removeResult(String key) {
		if (this.resultMap != null)
			this.resultMap.remove(key);
	}

	public PageBuilder getPage() {
		return page;
	}

	public DTO setPage(PageBuilder page) {
		this.page = page;
		return this;
	}

	public long getTotalCount() {
		return getPage() == null ? 0 : getPage().getTotalCount();
	}

	public SortBase getSort() {
		return sort;
	}

	public DTO setSort(SortBase sort) {
		this.sort = sort;
		return this;
	}
}
