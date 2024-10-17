public class Pagina {
    private String url;
    private String titulo;

    public Pagina(String url, String titulo) {
        this.url = url;
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return titulo + " (" + url + ")";
    }
}
