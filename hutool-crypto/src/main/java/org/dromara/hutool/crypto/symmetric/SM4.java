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

package org.dromara.hutool.crypto.symmetric;

import org.dromara.hutool.core.text.StrUtil;
import org.dromara.hutool.core.array.ArrayUtil;
import org.dromara.hutool.crypto.KeyUtil;
import org.dromara.hutool.crypto.Mode;
import org.dromara.hutool.crypto.Padding;

import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

/**
 * 国密对称堆成加密算法SM4实现
 *
 * <p>
 * 国密算法包括：
 * <ol>
 *     <li>非对称加密和签名：SM2，asymmetric</li>
 *     <li>摘要签名算法：SM3，digest</li>
 *     <li>对称加密：SM4，symmetric</li>
 * </ol>
 *
 * @author Looly
 * @since 4.6.8
 */
public class SM4 extends SymmetricCrypto {
	private static final long serialVersionUID = 1L;

	/**
	 * 算法名称：SM4
	 */
	public static final String ALGORITHM_NAME = "SM4";

	// region ----- Constructor

	/**
	 * 构造，使用随机密钥
	 */
	public SM4() {
		super(ALGORITHM_NAME);
	}

	/**
	 * 构造
	 *
	 * @param key 密钥
	 */
	public SM4(final byte[] key) {
		super(ALGORITHM_NAME, key);
	}

	/**
	 * 构造，使用随机密钥
	 *
	 * @param mode    模式{@link Mode}
	 * @param padding {@link Padding}补码方式
	 */
	public SM4(final Mode mode, final Padding padding) {
		this(mode.name(), padding.name());
	}

	/**
	 * 构造
	 *
	 * @param mode    模式{@link Mode}
	 * @param padding {@link Padding}补码方式
	 * @param key     密钥，支持密钥长度：128位
	 */
	public SM4(final Mode mode, final Padding padding, final byte[] key) {
		this(mode, padding, key, null);
	}

	/**
	 * 构造
	 *
	 * @param mode    模式{@link Mode}
	 * @param padding {@link Padding}补码方式
	 * @param key     密钥，支持密钥长度：128位
	 * @param iv      偏移向量，加盐
	 */
	public SM4(final Mode mode, final Padding padding, final byte[] key, final byte[] iv) {
		this(mode.name(), padding.name(), key, iv);
	}

	/**
	 * 构造
	 *
	 * @param mode    模式{@link Mode}
	 * @param padding {@link Padding}补码方式
	 * @param key     密钥，支持密钥长度：128位
	 */
	public SM4(final Mode mode, final Padding padding, final SecretKey key) {
		this(mode, padding, key, (IvParameterSpec) null);
	}

	/**
	 * 构造
	 *
	 * @param mode    模式{@link Mode}
	 * @param padding {@link Padding}补码方式
	 * @param key     密钥，支持密钥长度：128位
	 * @param iv      偏移向量，加盐
	 */
	public SM4(final Mode mode, final Padding padding, final SecretKey key, final byte[] iv) {
		this(mode, padding, key, ArrayUtil.isEmpty(iv) ? null : new IvParameterSpec(iv));
	}

	/**
	 * 构造
	 *
	 * @param mode    模式{@link Mode}
	 * @param padding {@link Padding}补码方式
	 * @param key     密钥，支持密钥长度：128位
	 * @param iv      偏移向量，加盐
	 */
	public SM4(final Mode mode, final Padding padding, final SecretKey key, final IvParameterSpec iv) {
		this(mode.name(), padding.name(), key, iv);
	}

	/**
	 * 构造
	 *
	 * @param mode    模式
	 * @param padding 补码方式
	 */
	public SM4(final String mode, final String padding) {
		this(mode, padding, (byte[]) null);
	}

	/**
	 * 构造
	 *
	 * @param mode    模式
	 * @param padding 补码方式
	 * @param key     密钥，支持密钥长度：128位
	 */
	public SM4(final String mode, final String padding, final byte[] key) {
		this(mode, padding, key, null);
	}

	/**
	 * 构造
	 *
	 * @param mode    模式
	 * @param padding 补码方式
	 * @param key     密钥，支持密钥长度：128位
	 * @param iv      加盐
	 */
	public SM4(final String mode, final String padding, final byte[] key, final byte[] iv) {
		this(mode, padding,//
			KeyUtil.generateKey(ALGORITHM_NAME, key),//
			ArrayUtil.isEmpty(iv) ? null : new IvParameterSpec(iv));
	}

	/**
	 * 构造
	 *
	 * @param mode    模式
	 * @param padding 补码方式
	 * @param key     密钥，支持密钥长度：128位
	 */
	public SM4(final String mode, final String padding, final SecretKey key) {
		this(mode, padding, key, null);
	}

	/**
	 * 构造
	 *
	 * @param mode    模式
	 * @param padding 补码方式
	 * @param key     密钥，支持密钥长度：128位
	 * @param iv      加盐
	 */
	public SM4(final String mode, final String padding, final SecretKey key, final IvParameterSpec iv) {
		super(StrUtil.format("SM4/{}/{}", mode, padding), key, iv);
	}
	// endregion
}
