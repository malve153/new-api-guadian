# Progetto ApiGuardian

Il programma permette di scaricare gli articoli dal sito del The Guardian o da un insieme di articoli del New York Times già scaricati e di estrarre i cinquanta termini più importanti. 
L'utente per utilizzare le funzionalità dell'api del The Guardian deve aver prima ottenuto una chiave valida dal sito altrimenti può utilizzare solo gli articoli già presenti del New York Times lasciando il campo vuoto. 
Successivamente verranno visualizzate a schermo tre opzioni tra cui scegliere:
- Download articoli
- Estrazione termini
- Download articoli ed estrazione termini

L'utente può scaricare gli articoli per argomento inserendo una parola chiave oppure viene utilizzato "nuclear power" di default se si rifiuta la scelta. Il tutto viene poi salvato all'interno di un apposito file.

Nel caso dell'estrazione termini invece è possibile scegliere tra le due fonti, The Guardian o New York Times, dalle quali vengono ricavate le cinquanta parole. Viene poi chiesto se si vuole stampare il risultato a video.

La terza comprende entrambe le opzioni precedenti ad eccezione della scelta delle fonti in quanto vengono automaticamente utilizzate le api del The Guardian.

### Specifiche

- Il calcolo delle parole viene effettuato contando per ogni parola in quanti articoli appare(viene considerata solo la prima occorrenza del termine per ciascuna notizia).
- Se nella parola è presente un trattino(-) essa viene considerata come un unico termine. Esempio: Bitcoin-friendly.
- Vengono ignorate le parole presenti nel file Resources/stoplist.txt.
- Vengono eliminati dalla parola i seguenti caratteri: ,.;:?!(){}^“”…♦¶’'’"“”\n
- Gli articoli scaricati vengono salvati all'interno del file Resources\articles.txt.

### Istruzione per installare il programma

Per creare questo progetto maven in IntelliJ IDEA eseguire i seguenti passi:

1. Cliccare su File
2. Cliccare su Open
3. Selezionare la directory contenente il progetto
4. Marchiare i package Control, Main, Model, View e com.apiguardian come source root cliccando con il tasto destro al di sopra della cartella e selezionando nella voce mark directory as l'opzione "source root"
5. Fare la stessa operazione precedente per il package Test marcando però la cartella come "test sources root"
6. Cliccare run ed eseguire il programma

### Eseguire il file .jar
Eseguire nella cartella principale del progetto il comando in Windows

    java -jar out\artifacts\new_api_guadian_jar\new-api-guadian.jar

o in Linux

    java -jar out/artifacts/new_api_guadian_jar/new-api-guadian.jar

### Librerie esterne utilizzate

- com.mashape.unirest: utilizzata in GuardianContentApi per effettuare la richiesta degli articoli(versione: 1.4.9)
- junit: usata per i test(versione: 4.12)
- com.fasterxml.jackson.core: usata per salvare e leggere gli articoli nei file in Serializzatore e Deserializzatore. Viene usata anche in GuardianContentApi(versione: 2.8.8.1)
- com.opencsv: utilizzata per leggere il file .csv nella classe Deserializzatore(versione: 5.7.1)
- com.formdev: utilizzata in Frame per creare una GUI personalizzata(versione: 3.0)