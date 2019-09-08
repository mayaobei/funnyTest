import java.io.*; 
 import javax.net.ssl.SSLServerSocket; 
 import javax.net.ssl.SSLServerSocketFactory; 
 import javax.net.ssl.SSLSocket; 
 
 class SSLServer { 
 
 // ����������Ȩ���û���������
 private static final String USER_NAME = "principal"; 
 private static final String PASSWORD = "credential"; 
 // �������˱�������
 private static final String SECRET_CONTENT = 
"This is confidential content from server X, for your eye!"; 
 
 private SSLServerSocket serverSocket = null; 
 
 public SSLServer() throws Exception { 
     // ͨ���׽��ֹ�������ȡһ�����������׽���
     SSLServerSocketFactory socketFactory = (SSLServerSocketFactory) 
 SSLServerSocketFactory.getDefault(); 
     serverSocket = (SSLServerSocket)socketFactory.createServerSocket(7070); 
 } 
 
 private void runServer() { 
     while (true) { 
         try { 
             System.out.println("Waiting for connection..."); 
             // ���������׽��ֽ�������״̬���ȴ����Կͻ��˵���������
             SSLSocket socket = (SSLSocket) serverSocket.accept(); 
             
             // ��ȡ���������׽���������
             BufferedReader input = new BufferedReader( 
                    new InputStreamReader(socket.getInputStream())); 
         // ���������ж�ȡ�ͻ����û���������
             String userName = input.readLine(); 
             String password = input.readLine(); 
             
             // ��ȡ���������׽��������
             PrintWriter output = new PrintWriter( 
                    new OutputStreamWriter(socket.getOutputStream())); 
 
         // �����������֤�����ͨ���򽫱������ݷ��͸��ͻ���
             if (userName.equals(USER_NAME) && password.equals(PASSWORD)) { 
                 output.println("Welcome, " + userName); 
                 output.println(SECRET_CONTENT); 
             } else { 
                 output.println("Authentication failed, you have no  access to server X..."); 
             } 
         
         // �ر�����Դ���׽�����Դ
             output.close(); 
             input.close(); 
             socket.close(); 
 
         } catch (IOException ioException) { 
             ioException.printStackTrace(); 
         } 
     } 
 } 
 
 public static void main(String args[]) throws Exception { 
     SSLServer server = new SSLServer(); 
     server.runServer(); 
 } 
 }