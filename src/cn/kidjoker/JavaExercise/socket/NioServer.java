package cn.kidjoker.JavaExercise.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;

public class NioServer {
	
	public static void main(String[] args) throws IOException {
		ServerSocketChannel ssc = ServerSocketChannel.open();
		ssc.socket().bind(new InetSocketAddress(8081));
		ssc.configureBlocking(false);
		
		Selector selector = Selector.open();
		ssc.register(selector, SelectionKey.OP_ACCEPT);
		
		while(true) {
			if(selector.select(3000) == 0) {
				continue;
			}
			
			Iterator<SelectionKey> keyIntor = selector.selectedKeys().iterator();
			
			while(keyIntor.hasNext()) {
				SelectionKey key = keyIntor.next();
				new Thread(new HttpHandler(key)).run();
				keyIntor.remove();
			}
		}
	}
	
	private static class HttpHandler implements Runnable {
		
		private int bufferSize = 1024;
		
		private String localCharset = "UTF-8";
		
		private SelectionKey key;
		
		public HttpHandler(SelectionKey key) {
			this.key = key;
		}
		
		//接收请求
		public void handleAccept() throws IOException {
			SocketChannel clientChannel = ((ServerSocketChannel)key.channel()).accept();
			clientChannel.configureBlocking(false);
			clientChannel.register(key.selector(), SelectionKey.OP_READ, ByteBuffer.allocate(bufferSize));
		}
		
		//处理请求
		public void handleRead() throws IOException {
			SocketChannel sc = (SocketChannel)key.channel();
			ByteBuffer buf = (ByteBuffer) key.attachment();
			buf.clear();
			
			if(sc.read(buf) != -1) {
				sc.close();
			}
			else {
				buf.flip();
				String receivedString = Charset.forName(localCharset).newDecoder().decode(buf).toString();
				
				String[] requestMessage = receivedString.split("\r\n");
				for(String string : requestMessage) {
					System.out.println(string);
					if(string.isEmpty()) {
						break;
					}
				}
			}
		}
		
		@Override
		public void run() {
			try {
				if(key.isAcceptable()) {
					handleAccept();
				}
				if(key.isReadable()) {
					handleRead();
				}
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
