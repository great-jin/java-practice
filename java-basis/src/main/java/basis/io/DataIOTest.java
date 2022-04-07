package basis.io;

import org.junit.Test;

import java.io.*;

public class DataIOTest {

    /**
     * 二进制数据输入流
     */
    @Test
    public void DataInputDemo() {
        InputStream in = null;
        DataInputStream dis = new DataInputStream(in);
    }

    /**
     * 二进制数据输出流
     */
    @Test
    public void DataOutputDemo() {
        OutputStream out = null;
        DataOutputStream dos = new DataOutputStream(out);
    }

}
