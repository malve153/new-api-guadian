# Progetto ApiGuardian

Il programma permette di scaricare articoli dal sito del The Guardian e/o di estrarre i cinquanta termini più importanti, o da questa prima fonte, o da un insieme di pezzi del New York Times di cui è già stato effettuato il download. 
L'utente deve prima aver ottenuto una chiave valida dal sito del The Guardian da inserire nell'apposito spazio nella schermata iniziale per poter utilizzare le funzionalità dell'api, altrimenti può utilizzare solo i testi già presenti del New York Times lasciando il campo vuoto. 
Successivamente vengono visualizzate a schermo tre opzioni tra cui poter scegliere:
- Download articoli
- Estrazione termini
- Download articoli ed estrazione termini

L'utente può scegliere di scaricare gli articoli per argomento inserendo una relativa parola chiave, in caso contrario viene utilizzato "nuclear power" di default è stata rifiutata la scelta.

Nel caso dell'estrazione termini invece è possibile scegliere tra le due fonti disponibili, The Guardian o New York Times, da cui vengono ricavate le cinquanta parole e dopo il quale viene infine chiesto se si vuole stampare a video il risultato.

La terza opzione comprende entrambi i punti precedenti ad eccezione della scelta delle fonti in quanto vengono automaticamente utilizzate le api del The Guardian.


### Specifiche

- Il calcolo delle parole viene effettuato contando ogni parola in quanti articoli appare (viene considerata solo la prima occorrenza del termine per ciascun testo).
- Se "due parole" sono divise da un trattino(-), esse vengono considerate come un unico termine. Esempio: Bitcoin-friendly.
- Vengono ignorati i termini presenti nel file stopList.txt presente dentro la cartella Resources.
- Vengono eliminati i seguenti caratteri: ,.;:?!(){}^“”…♦¶’'’"“”\n
- Gli articoli scaricati vengono salvati all'interno del file articles.txt, presente anch'esso nella cartella Resources.


### Istruzioni per installare il programma

Per creare questo progetto maven in IntelliJ IDEA eseguire i seguenti passi:

1. Cliccare su File
2. Cliccare su Open
3. Selezionare la directory contenente il progetto
4. Marchiare i package Control, Main, Model, View e com.apiguardian come source root cliccando con il tasto destro al di sopra della cartella e selezionando nella voce 'mark directory as' l'opzione "source root"
5. Fare la stessa precedente operazione per il package Test marcando però la cartella come "test sources root"
6. Cliccare run ed eseguire il programma


### Eseguire il file .jar
Eseguire nella cartella principale del progetto il seguente comando:

--> in Windows

    java -jar out\artifacts\new_api_guadian_jar\new-api-guadian.jar

--> in Linux

    java -jar out/artifacts/new_api_guadian_jar/new-api-guadian.jar


### Librerie esterne utilizzate

- com.mashape.unirest   (v 1.4.9)
    - per effettuare la richiesta degli articoli in GuardianContentApi

- junit    (v 4.12)
  - per i test

- com.fasterxml.jackson.core    (v: 2.8.8.1)
  - per salvare e leggere gli articoli nei file in Serializzatore e in Deserializzatore
  - in GuardianContentApi

- com.opencsv   (v 5.7.1)
  - per leggere il file .csv nella classe Deserializzatore

- com.formdev   (v 3.0)
  - per creare una GUI personalizzata in Frame