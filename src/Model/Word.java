package Model;

import java.util.Comparator;

public class Word implements Comparator<Word> {
    /**
     * Stringa che contiene la parola
     */
    String w;
    /**
     * Numero di occorrenze della parola
     */
    int value;

    /**
     * Costruttore di default
     */
    public Word(){
        w="";
        value=0;
    }

    /**
     * Costruttore con un solo parametro
     * @param w Parola
     */
    public Word(String w){
        if(w.contains(" ")){
            this.w=w.substring(0,w.indexOf(" "));
            this.value=Integer.valueOf(w.substring(w.indexOf(" ")+1,w.length()));
        }
        else{
            this.w=w;
            this.value=0;
        }
    }

    /**
     * Costruttore con due parametri
     * @param w parola
     * @param value numero occorrenze
     */
    public Word(String w,int value){
        this.w=w;
        this.value=value;
    }

    /**
     * toString della classe Word
     * @return stringa composta da "parola valore"
     */
    @Override
    public String toString() {
        return getWord()+" "+getValue();
    }

    /**
     * Ritorna la parola
     * @return parola
     */
    public String getWord() {
        return w;
    }

    /**
     * Imposta la parola
     * @param w parola
     */
    public void setWord(String w) {
        this.w = w;
    }

    /**
     * Ritorna il numero di occorrenze
     * @return numero ocorrenze
     */
    public int getValue() {
        return value;
    }

    /**
     * Imposta il numero di occorrenze
     * @param value numero occorrenze
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Confronta due Word in base al numero di occorrenze
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return 1 se o1 è minore, -1 se o1 è maggiore, -2 se sono uguali
     */
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
