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

package org.apache.ftpserver.command;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ftpserver.FtpRequestImpl;
import org.apache.ftpserver.FtpWriter;
import org.apache.ftpserver.RequestHandler;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.interfaces.Command;

/**
 * Common base class recommended for {@link Command} implementations
 */
public abstract class AbstractCommand implements Command {

    protected Log log;
    
    public AbstractCommand() {
        log = LogFactory.getLog(getClass());
    }

    public void setLogFactory(LogFactory logFactory) {
        log = logFactory.getInstance(getClass());
    }
    
    /**
     * Execute command
     */
    public abstract void execute(RequestHandler handler,
                        FtpRequestImpl request, 
                        FtpWriter out) throws IOException, FtpException;   
}
