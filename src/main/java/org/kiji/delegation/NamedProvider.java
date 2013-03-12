/**
 * (c) Copyright 2012 WibiData, Inc.
 *
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.kiji.delegation;

import org.kiji.annotations.ApiAudience;

/**
 * A service implementation that can be selected based on its name.
 *
 * <p>{@link Lookup} is often used to select a specific instance of a more
 * general model which is identified by a user- or program-friendly name.
 * For example, a suite of tools may want to allow a user to launch a command
 * line tool by name; every tool may implement an interface named CliTool
 * that supports a <tt>getName()</tt> method and a <tt>run()</tt> method.</p>
 *
 * <p>Such implementations may implement the <tt>NamedProvider</tt> interface,
 * which allows them to declare the friendly name of the tool or implementation.
 * A {@link NamedLookup} can be used to retrieve an instance of the more general
 * interface (like the example <tt>CliTool</tt>) by name.</p>
 *
 * <p>All instances of a given interface or abstract class that itself
 * implements <tt>NamedProvider</tt> can be loaded by the {@link NamedLookup}.
 * The NamedLookup then iterates through instances to retrieve one by name.</p>
 *
 * <p>Instances of a class or interface that implements NamedLookup should not
 * override the same name; the order in which they are loaded, and thus the
 * implementation selected at runtime will be undefined.</p>
 */
@ApiAudience.Public
public interface NamedProvider {
  /**
   * Returns the friendly name for the implementation. Clients of
   * {@link NamedLookup} can select an instance by this name.
   *
   * <p>Multiple instances should not share the same name; the order in which
   * they are resolved is undefined.</p>
   *
   * <p>This function must return the same value every time it is called.</p>
   *
   * <p>This method must not return null.</p>
   *
   * @return the name of this provider implementation to be queried by the client.
   */
  String getName();
}
