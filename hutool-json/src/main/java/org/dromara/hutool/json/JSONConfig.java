/*
 * Copyright (c) 2013-2024 Hutool Team and hutool.cn
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.dromara.hutool.json;

import org.dromara.hutool.core.comparator.CompareUtil;
import org.dromara.hutool.core.convert.Converter;
import org.dromara.hutool.json.convert.JSONConverter;
import org.dromara.hutool.json.writer.NumberWriteMode;

import java.io.Serializable;
import java.util.Comparator;

/**
 * JSON配置项
 *
 * @author looly
 * @since 4.1.19
 */
public class JSONConfig implements Serializable {
	private static final long serialVersionUID = 119730355204738278L;

	/**
	 * 键排序规则，{@code null}表示不排序，不排序情况下，按照加入顺序排序
	 */
	private Comparator<String> keyComparator;
	/**
	 * 是否忽略转换过程中的异常
	 */
	private boolean ignoreError;
	/**
	 * 是否忽略键的大小写
	 */
	private boolean ignoreCase;
	/**
	 * 日期格式，null表示默认的时间戳
	 */
	private String dateFormat;
	/**
	 * 是否忽略null值
	 */
	private boolean ignoreNullValue = true;
	/**
	 * 是否支持transient关键字修饰和@Transient注解，如果支持，被修饰的字段或方法对应的字段将被忽略。
	 */
	private boolean transientSupport = true;
	/**
	 * 是否去除末尾多余0，例如如果为true,5.0返回5
	 */
	private boolean stripTrailingZeros = true;
	/**
	 * 是否检查重复key
	 */
	private boolean checkDuplicate;
	/**
	 * 自定义的类型转换器，用于在getXXX操作中自动转换类型
	 */
	private Converter converter = JSONConverter.of(this);
	/**
	 * Number写出模式
	 */
	private NumberWriteMode numberWriteMode = NumberWriteMode.NORMAL;

	/**
	 * 创建默认的配置项
	 *
	 * @return JSONConfig
	 */
	public static JSONConfig of() {
		return new JSONConfig();
	}

	/**
	 * 获取键排序规则<br>
	 * 键排序规则，{@code null}表示不排序，不排序情况下，按照加入顺序排序
	 *
	 * @return 键排序规则
	 * @since 5.7.21
	 */
	public Comparator<String> getKeyComparator() {
		return this.keyComparator;
	}

	/**
	 * 设置自然排序，即按照字母顺序排序
	 *
	 * @return this
	 * @since 5.7.21
	 */
	public JSONConfig setNatureKeyComparator() {
		return setKeyComparator(CompareUtil.natural());
	}

	/**
	 * 设置键排序规则<br>
	 * 键排序规则，{@code null}表示不排序，不排序情况下，按照加入顺序排序
	 *
	 * @param keyComparator 键排序规则
	 * @return this
	 * @since 5.7.21
	 */
	public JSONConfig setKeyComparator(final Comparator<String> keyComparator) {
		this.keyComparator = keyComparator;
		return this;
	}

	/**
	 * 是否忽略转换过程中的异常
	 *
	 * @return 是否忽略转换过程中的异常
	 */
	public boolean isIgnoreError() {
		return ignoreError;
	}

	/**
	 * 设置是否忽略转换过程中的异常
	 *
	 * @param ignoreError 是否忽略转换过程中的异常
	 * @return this
	 */
	public JSONConfig setIgnoreError(final boolean ignoreError) {
		this.ignoreError = ignoreError;
		return this;
	}

	/**
	 * 是否忽略键的大小写
	 *
	 * @return 是否忽略键的大小写
	 */
	public boolean isIgnoreCase() {
		return ignoreCase;
	}

	/**
	 * 设置是否忽略键的大小写
	 *
	 * @param ignoreCase 是否忽略键的大小写
	 * @return this
	 */
	public JSONConfig setIgnoreCase(final boolean ignoreCase) {
		this.ignoreCase = ignoreCase;
		return this;
	}

	/**
	 * 日期格式，null表示默认的时间戳
	 *
	 * @return 日期格式，null表示默认的时间戳
	 */
	public String getDateFormat() {
		return dateFormat;
	}

	/**
	 * 设置日期格式，null表示默认的时间戳<br>
	 * 此方法设置的日期格式仅对转换为JSON字符串有效，对解析JSON为bean无效。
	 *
	 * @param dateFormat 日期格式，null表示默认的时间戳
	 * @return this
	 */
	public JSONConfig setDateFormat(final String dateFormat) {
		this.dateFormat = dateFormat;
		return this;
	}

	/**
	 * 是否忽略null值
	 *
	 * @return 是否忽略null值
	 */
	public boolean isIgnoreNullValue() {
		return this.ignoreNullValue;
	}

	/**
	 * 设置是否忽略null值
	 *
	 * @param ignoreNullValue 是否忽略null值
	 * @return this
	 */
	public JSONConfig setIgnoreNullValue(final boolean ignoreNullValue) {
		this.ignoreNullValue = ignoreNullValue;
		return this;
	}

	/**
	 * 是否支持transient关键字修饰和@Transient注解，如果支持，被修饰的字段或方法对应的字段将被忽略。
	 *
	 * @return 是否支持
	 * @since 5.4.2
	 */
	public boolean isTransientSupport() {
		return this.transientSupport;
	}

	/**
	 * 设置是否支持transient关键字修饰和@Transient注解，如果支持，被修饰的字段或方法对应的字段将被忽略。
	 *
	 * @param transientSupport 是否支持
	 * @return this
	 * @since 5.4.2
	 */
	public JSONConfig setTransientSupport(final boolean transientSupport) {
		this.transientSupport = transientSupport;
		return this;
	}

	/**
	 * 是否去除末尾多余0，例如如果为true,5.0返回5
	 *
	 * @return 是否去除末尾多余0，例如如果为true,5.0返回5
	 * @since 5.6.2
	 */
	public boolean isStripTrailingZeros() {
		return stripTrailingZeros;
	}

	/**
	 * 设置是否去除末尾多余0，例如如果为true,5.0返回5
	 *
	 * @param stripTrailingZeros 是否去除末尾多余0，例如如果为true,5.0返回5
	 * @return this
	 * @since 5.6.2
	 */
	public JSONConfig setStripTrailingZeros(final boolean stripTrailingZeros) {
		this.stripTrailingZeros = stripTrailingZeros;
		return this;
	}

	/**
	 * 是否检查多个相同的key
	 *
	 * @return 是否检查多个相同的key
	 * @since 5.8.5
	 */
	public boolean isCheckDuplicate() {
		return checkDuplicate;
	}

	/**
	 * 是否检查多个相同的key
	 *
	 * @param checkDuplicate 是否检查多个相同的key
	 * @return this
	 * @since 5.8.5
	 */
	public JSONConfig setCheckDuplicate(final boolean checkDuplicate) {
		this.checkDuplicate = checkDuplicate;
		return this;
	}

	/**
	 * 获取自定义的类型转换器，用于在序列化、反序列化操作中实现对象类型转换
	 *
	 * @return 转换器
	 */
	public Converter getConverter() {
		return converter;
	}

	/**
	 * 设置自定义的类型转换器，用于在序列化、反序列化操作中实现对象类型转换
	 *
	 * @param converter 转换器
	 */
	public void setConverter(final Converter converter) {
		this.converter = converter;
	}

	/**
	 * 获取Number写出模式
	 *
	 * @return Number写出模式
	 * @since 6.0.0
	 */
	public NumberWriteMode getNumberWriteMode() {
		return numberWriteMode;
	}

	/**
	 * 设置数字写出模式<br>
	 * 考虑到在JS或其他环境中，Number超过一定长度会丢失精度，因此针对Number类型值，可选写出规则
	 *
	 * @param numberWriteMode Number写出模式
	 * @return this
	 * @since 6.0.0
	 */
	public JSONConfig setNumberWriteMode(final NumberWriteMode numberWriteMode) {
		this.numberWriteMode = numberWriteMode;
		return this;
	}
}
