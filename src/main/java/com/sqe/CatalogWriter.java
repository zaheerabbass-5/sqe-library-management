package com.sqe;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

public interface CatalogWriter {

    void write(String fileName, String content) throws IOException;

}