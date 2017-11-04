// example of sending an image from file image.jpg to a server at serveraddress:5000

import java.net.Socket;
import java.io.DataOutputStream;
import java.io.FileInputStream;
public class ExampleClient {
  public static void main(String[] args) {
    Socket outputSocket = new Socket("serveraddress", 5000);
    DataOutputStream dos = new DataOutputStream(outputSocket.getOutputStream());
    FileInputStream fis = new FileInputStream("image.jpg");
    
    byte[] data = new byte[65 /*size*/];
    fis.read(data);
    dos.write(data);
    
    dos.flush();
    dos.close();
    fis.close();
    outputSocket.close();
  }
}
