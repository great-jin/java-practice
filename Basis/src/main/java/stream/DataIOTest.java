package stream;

import org.junit.Test;

import java.io.*;

public class DataIOTest {

    /**
     * 带缓存区的输入流
     */
    @Test
    public void BufferedInputDemo(){
        InputStream in = null;
        BufferedInputStream bis = new BufferedInputStream(in);

    }

    /**
     * 带缓存区的输出流
     */
    @Test
    public void BufferedOutputDemo(){
        OutputStream out = null;
        BufferedOutputStream bos = new BufferedOutputStream(out);

    }

    /**
     * 二进制数据输入流
     */
    @Test
    public void DataInputDemo(){
        InputStream in = null;
        DataInputStream dis = new DataInputStream(in);

    }

    /**
     * 二进制数据输出流
     */
    @Test
    public void DataOutputDemo(){
        OutputStream out = null;
        DataOutputStream dos = new DataOutputStream(out);

    }

}
