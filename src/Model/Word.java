package Model;

import java.util.Comparator;

public class Word implements Comparator<Word> {
    String w;
    int value;

    public Word(){
        w="";
        value=0;
    }
    public Word(String w){
        this.w=w;
        value=1;
    }
    public Word(String w,int value){
        this.w=w;
        this.value=value;
    }

    @Override
    public String toString() {
        return getWord()+" "+getValue();
    }

    public String getWord() {
        return w;
    }

    public void setWord(String w) {
        this.w = w;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public int compare(Word o1, Word o2) {
        if(o1.getValue()<o2.getValue())
            return 1;
        if(o1.getValue()>o2.getValue())
            return -1;
        if(o1.getValue()==o2.getValue())
            return o1.getWord().compareTo(o2.getWord());
        return -2;
    }

}
