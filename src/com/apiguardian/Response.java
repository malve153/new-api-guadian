package apiguardian;

public class Response {

  /**
   * Sringa che indica lo stato della risposta dell'API Guardian
   */
  private String status;

  /**
   * Stringa che indica il livello dell'utente
   */
  private String userTier;

  /**
   * Numero di risultati disponibili
   */
  private int total;

  /**
   * Indice di partenza
   */
  private int startIndex;

  /**
   * Numero di elementi restituiti
   */
  private int pageSize;

  /**
   * Numero della pagina attuale
   */
  private int currentPage;

  /**
   * Quantità totale di pagine presenti nella chiamata
   */
  private int pages;

  /**
   * Ordinamento utilizzato
   */
  private String orderBy;

  /**
   * Array che conterrà gli articoli
   */
  private Article[] results;

  /**
   * Costruttore di default
   */
  public Response() {

  }

  /**
   * Costruttore della classe
   * @param status stato della risposta dell'API Guardian
   * @param userTier livello dell'utente
   * @param total Numero di risultati disponibili
   * @param startIndex Indice di partenza
   * @param pageSize Numero di elementi restituiti
   * @param currentPage Numero della pagina attuale
   * @param pages Quantità totale di pagine presenti nella chiamata
   * @param orderBy Ordinamento utilizzato
   * @param results Array che conterrà gli articoli
   */
  public Response(final String status, final String userTier, final int total, final int startIndex, final int pageSize, final int currentPage, final int pages, final String orderBy, final Article[] results) {
    this.status = status;
    this.userTier = userTier;
    this.total = total;
    this.startIndex = startIndex;
    this.pageSize = pageSize;
    this.currentPage = currentPage;
    this.pages = pages;
    this.orderBy = orderBy;
    this.results = results;
  }

  /**
   * Ritorna lo stato
   * @return stato della chiamata
   */
  public String getStatus() {
    return status;
  }

  /**
   * Imposta lo stato
   * @param status stato della chiamata
   */
  public void setStatus(final String status) {
    this.status = status;
  }

  /**
   * Ritorna il livello utente
   * @return livello utente
   */
  public String getUserTier() {
    return userTier;
  }

  /**
   * Imposta il livello utente
   * @param userTier livello utente
   */
  public void setUserTier(final String userTier) {
    this.userTier = userTier;
  }

  /**
   * Restituisce total
   * @return Numero di risultati disponibili
   */
  public int getTotal() {
    return total;
  }

  /**
   * imposta il numero di risultati
   * @param total Numero di risultati disponibili
   */
  public void setTotal(final int total) {
    this.total = total;
  }

  /**
   * Ritorna l'indice di partenza
   * @return indice di partenza
   */
  public int getStartIndex() {
    return startIndex;
  }

  /**
   * imposta l'indice di partenza
   * @param startIndex indice di partenza
   */
  public void setStartIndex(final int startIndex) {
    this.startIndex = startIndex;
  }

  /**
   * Ritorna il numero di elementi restituiti
   * @return Numero di elementi restituiti
   */
  public int getPageSize() {
    return pageSize;
  }

  /**
   * Imposta il numero di elementi restituiti
   * @param pageSize Numero di elementi restituiti
   */
  public void setPageSize(final int pageSize) {
    this.pageSize = pageSize;
  }

  /**
   * Ritorna il numero della pagina attuale
   * @return Numero della pagina attuale
   */
  public int getCurrentPage() {
    return currentPage;
  }

  /**
   * Imposta il numero della pagina attuale
   * @param currentPage Numero della pagina attuale
   */
  public void setCurrentPage(final int currentPage) {
    this.currentPage = currentPage;
  }

  /**
   * Ritorna la quantità totale di pagine
   * @return Quantità totale di pagine presenti nella chiamata
   */
  public int getPages() {
    return pages;
  }

  /**
   * imposta la quantità totale di pagine
   * @param pages Quantità totale di pagine presenti nella chiamata
   */
  public void setPages(final int pages) {
    this.pages = pages;
  }

  /**
   * Ritorna l'ordinamento utilizzato
   * @return Ordinamento utilizzato
   */
  public String getOrderBy() {
    return orderBy;
  }

  /**
   * Imposta l'ordinamento
   * @param orderBy Ordinamento utilizzato
   */
  public void setOrderBy(final String orderBy) {
    this.orderBy = orderBy;
  }

  /**
   * Ritorna l'array di articoli
   * @return array di article
   */
  public Article[] getResults() {
    return results;
  }

  /**
   * Imposta l'array di articoli
   * @param results Array di articles
   */
  public void setResults(final Article[] results) {
    this.results = results;
  }
}
