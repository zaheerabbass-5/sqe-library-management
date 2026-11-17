
package com.sqe;

import java.io.IOException;

public interface CatalogWriter {

    void write(String fileName, String content) throws IOException;

}
