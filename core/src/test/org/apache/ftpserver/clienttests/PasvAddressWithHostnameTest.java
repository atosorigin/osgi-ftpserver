/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.ftpserver.clienttests;

import java.util.Properties;

/**
 * Test for external passive address configured as hostname rather than
 * IP address.
 */
public class PasvAddressWithHostnameTest extends ClientTestTemplate {

    protected Properties createConfig() {
        Properties config = createDefaultConfig();

        config.setProperty("config.listeners.default.data-connection.class",
                "org.apache.ftpserver.DefaultDataConnectionConfig");
        config.setProperty(
                "config.listeners.default.data-connection.passive.external-address",
                "localhost");

        return config;
    }

    public void testPasvAddress() throws Exception {
        client.login(ADMIN_USERNAME, ADMIN_PASSWORD);
        client.pasv();

        assertTrue(client.getReplyString().indexOf("(127,0,0,1,") > -1);
    }
}