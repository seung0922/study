package ch07;

// ������� isPowerOn, channel, volume�� Ŭ���� �ܺο��� ������ �� ������ �����ڸ� ���̰�
// ��� �� ����������� ���� ��𼭳� �а� ������ �� �ֵ��� getter, setter�޼��� �߰�
class MyTv2 {
	private boolean isPowerOn;
	private int channel;
	private int volume;
	
	final int MAX_VOLUME = 100;
	final int MIN_VOLUME = 0;
	final int MAX_CHANNEL = 100;
	final int MIN_CHANNEL = 1;
	
	void setChannel(int channel) {
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
	
}

public class Exercise7_10 {
	public static void main(String[] args) {
		MyTv2 t = new MyTv2();
		
		t.setChannel(10);
		System.out.println("CH:"+t.getChannel());
		t.setChannel(20);
		System.out.println("CH:"+t.getChannel());
	}
}
