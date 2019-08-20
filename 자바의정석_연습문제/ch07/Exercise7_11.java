package ch07;

// ������� isPowerOn, channel, volume�� Ŭ���� �ܺο��� ������ �� ������ �����ڸ� ���̰�
// ��� �� ����������� ���� ��𼭳� �а� ������ �� �ֵ��� getter, setter�޼��� �߰�
class MyTv2 {
	private boolean isPowerOn;
	private int channel;
	private int volume;
	int prevChannel;
	
	final int MAX_VOLUME = 100;
	final int MIN_VOLUME = 0;
	final int MAX_CHANNEL = 100;
	final int MIN_CHANNEL = 1;
	
	void setChannel(int channel) {
		// ���� ä���� ���� ������ ������� ����
		// ������ ä���� ���� channel�� �ֱ� ���� ������ ä�ΰ��� prev�� ����
		prevChannel = this.channel;
		this.channel = channel;
	}
	int getChannel() {
		return channel;
	}
	void setVolume(int volume) {
		this.volume = volume;
	}
	int getVolume() {
		return volume;
	}
	
	// ���� ä�η� �̵��ϴ� ����� �޼��带 �߰�
	// (���� ä���� ���� ������ ��������� �����ض�)
	void gotoPrevChannel() {
		setChannel(prevChannel);
	}
	
}

public class Exercise7_11 {
	public static void main(String[] args) {
		MyTv2 t = new MyTv2();
		
		t.setChannel(10);
		System.out.println("CH:"+t.getChannel());
		t.setChannel(20);
		System.out.println("CH:"+t.getChannel());
		t.gotoPrevChannel();
		System.out.println("CH:"+t.getChannel());
		t.gotoPrevChannel();
		System.out.println("CH:"+t.getChannel());
	}
}
