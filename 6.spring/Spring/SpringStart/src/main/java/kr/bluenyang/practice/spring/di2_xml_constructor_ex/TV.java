package kr.bluenyang.practice.spring.di2_xml_constructor_ex;

public class TV {

    Speaker speaker;

    public TV(Speaker speaker) {
        this.speaker = speaker;
    }

    public void volumeUp() {
        speaker.increaseVolume();
    }

    public void volumeDown() {
        speaker.decreaseVolume();
    }
}
