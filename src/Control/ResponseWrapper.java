package Control;

import apiguardian.Response;

public class ResponseWrapper {

  /**
   * Oggetto della classe Response
   */
  private Response response;

  /**
   * Costruttore della classe
   * @param response
   */
  public ResponseWrapper(final Response response) {

    this.response = response;
  }

  /**
   * Costruttore di default
   */
  public ResponseWrapper() {

  }

  /**
   * Ritorna un oggetto Response
   * @return
   */
  public Response getResponse() {
    return response;
  }

  /**
   * Attribuisce all'oggetto response il valore passato per argomento
   * @param response
   */
  public void setResponse(final Response response) {
    this.response = response;
  }
}
