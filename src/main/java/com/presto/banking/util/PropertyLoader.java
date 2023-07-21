/* Licensed to the Apache Software Foundation (ASF) under one or more
contributor license agreements.  See the NOTICE file distributed with
this work for additional information regarding copyright ownership.
The ASF licenses this file to You under the Apache License, Version 2.0
(the "License"); you may not use this file except in compliance with
the License.  You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */
package com.presto.banking.util;
import java.io.IOException;
import java.util.Properties;
public class PropertyLoader {
    private static PropertyLoader instance;

    private Properties properties;

    private PropertyLoader(String fileName) {
        try {
            properties = new Properties();
            properties.load(this.getClass().getClassLoader().getResourceAsStream(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static PropertyLoader getInstance(String fileName) {
        if (instance == null) {
            instance = new PropertyLoader(fileName);
        }
        return instance;
    }

    public String getValue(String key) {
        return ((String) (properties.get(key)));
    }
}