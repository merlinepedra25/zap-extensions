/*
 * Zed Attack Proxy (ZAP) and its related class files.
 *
 * ZAP is an HTTP/HTTPS proxy for assessing web application security.
 *
 * Copyright 2020 The ZAP Development Team
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
package org.zaproxy.addon.encoder.processors.predefined;

import java.io.IOException;
import java.util.Base64;
import org.parosproxy.paros.control.Control;
import org.zaproxy.addon.encoder.EncodeDecodeOptions;
import org.zaproxy.addon.encoder.ExtensionEncoder;

public class Base64UrlDecoder extends DefaultEncodeDecodeProcessor {

    private static final Base64UrlDecoder INSTANCE = new Base64UrlDecoder();

    @Override
    protected String processInternal(String value) throws IOException {
        EncodeDecodeOptions encDecOpts =
                Control.getSingleton()
                        .getExtensionLoader()
                        .getExtension(ExtensionEncoder.class)
                        .getOptions();
        return new String(Base64.getUrlDecoder().decode(value), encDecOpts.getBase64Charset());
    }

    public static Base64UrlDecoder getSingleton() {
        return INSTANCE;
    }
}
