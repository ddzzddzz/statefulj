/***
 * 
 * Copyright 2014 Andrew Hall
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */
package org.statefulj.framework.core.model.impl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.statefulj.framework.core.model.Factory;

public class FactoryImpl<T, CT> implements Factory<T, CT> {

	@Override
	public T create(Class<T> clazz, String event, CT context) {
		try {
			Constructor<T> ctr = clazz.getDeclaredConstructor();
			ctr.setAccessible(true);
			return ctr.newInstance();
		} catch(IllegalAccessException e) {
			throw new RuntimeException(e);
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		} catch (IllegalArgumentException e) {
			throw new RuntimeException(e);
		} catch (InvocationTargetException e) {
			throw new RuntimeException(e);
		} catch (SecurityException e) {
			throw new RuntimeException(e);
		} catch (NoSuchMethodException e) {
			throw new RuntimeException(clazz.getCanonicalName() + " does not have a default constructor");
		}
	}

}
