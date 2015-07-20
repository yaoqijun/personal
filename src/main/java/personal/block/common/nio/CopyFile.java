package personal.block.common.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by yaoqijun.
 * Date:2015-07-17
 * Email:yaoqj@terminus.io
 * Descirbe:
 */
public class CopyFile {
    public static void main(String []args) throws Exception {
        String filein = "copy.sql";
        String fileout = "copy.txt";

        //获取文件的输入输出
        FileInputStream fileInputStream = new FileInputStream(filein);
        FileOutputStream fileOutputStream = new FileOutputStream(fileout);

        //获取输入输出通道
        FileChannel fin = fileInputStream.getChannel();
        FileChannel fout = fileOutputStream.getChannel();

        //创建缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        while (true){
            byteBuffer.clear();
            int r = fin.read(byteBuffer);
            if(r == -1){
                break;
            }
            byteBuffer.flip();

            fout.write(byteBuffer);
        }
        fin.close();
        fout.close();
        System.out.println("finish");
    }
}
