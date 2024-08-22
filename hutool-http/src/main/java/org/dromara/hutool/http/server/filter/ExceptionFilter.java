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

package org.dromara.hutool.http.server.filter;

import com.sun.net.httpserver.Filter;
import org.dromara.hutool.http.server.HttpServerRequest;
import org.dromara.hutool.http.server.HttpServerResponse;

/**
 * 异常处理过滤器
 *
 * @author looly
 */
public abstract class ExceptionFilter implements HttpFilter {

	@Override
	public void doFilter(final HttpServerRequest req, final HttpServerResponse res, final Filter.Chain chain) {
		try {
			chain.doFilter(req.getHttpExchange());
		} catch (final Throwable e) {
			afterException(req, res, e);
		}
	}

	/**
	 * 异常之后的处理逻辑
	 *
	 * @param req {@link HttpServerRequest}
	 * @param res {@link HttpServerResponse}
	 * @param e   异常
	 */
	public abstract void afterException(final HttpServerRequest req, final HttpServerResponse res, final Throwable e);
}
