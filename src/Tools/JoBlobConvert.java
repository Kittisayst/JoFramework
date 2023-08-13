package Tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class JoBlobConvert {

    private File file;

    public JoBlobConvert() {
    }

    public JoBlobConvert(File file) {
        this.file = file;
    }

    public InputStream getFileInput() throws Exception {
        InputStream stream = new FileInputStream(file);
        System.out.println("stream " + stream);
        return stream;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

}
