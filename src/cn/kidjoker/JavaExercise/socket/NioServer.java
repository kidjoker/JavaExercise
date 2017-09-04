package cn.kidjoker.JavaExercise.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class NioServer {
	
	public static void main(String[] args) throws IOException {
		ServerSocketChannel ssc = ServerSocketChannel.open();
		ssc.configureBlocking(false);
		ssc.socket().bind(new InetSocketAddress(8081));
		
		Selector selector = Selector.open();
		ssc.register(selector, SelectionKey.OP_ACCEPT);
		
		
		
	}
	
	private static class Handler {
		
		private int bufferSize = 1024;
		
		private String localCharset = "UTF-8";
		
		public Handler() {
		}
		
		public Handler(int bufferSize){
			this(bufferSize,null);
		}
		
		public Handler(String localCharset) {
			this(-1,localCharset);
		}
		
		public Handler(int bufferSize,String localCharset) {
			if(bufferSize > 0) {
				this.bufferSize = bufferSize;
			}
			if(localCharset != null) {
				this.localCharset = localCharset;
			}
		}
		
		public void handleAccept(SelectionKey key) throws IOException {
			SocketChannel 
		}
	}
}
