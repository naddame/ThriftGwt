/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.thrift;

import org.apache.thrift.TException;

public class GWTHelper {
	public static Object convert(Object o) throws TException {

		try {
			if (o instanceof GWTReady) {
				return ((GWTReady) o).Thrift2GWT(o);
			} else if (o.getClass().getName().contains(".gwt.") || o.getClass().getName().startsWith("gwt.")) {
				Class c = Class.forName(o.getClass().getName().replace("gwt.",""));
				if (o instanceof org.apache.thrift.gwt.TEnum) {
					java.lang.reflect.Method m = c.getDeclaredMethod("findByValue", int.class);
					return m.invoke(null, ((org.apache.thrift.gwt.TEnum) o).getValue());
				} else {
					Object obj = c.newInstance();
					java.lang.reflect.Method m = c.getDeclaredMethod("GWT2Thrift", Object.class);
					return m.invoke(obj, o);
				}
			} else {
				throw new TException("Cannot convert class "+ o.getClass().getName());
			} 
		} catch (TException te) {
			throw te;
		} catch (Exception e) {
			throw new TException(e.getMessage(), e.getCause());
		}
	}
}