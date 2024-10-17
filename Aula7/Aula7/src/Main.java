public class Main {
    public static void main(String[] args) {
        Navegador navegador = new Navegador();
        navegador.visitarPagina("https://www.google.com", "Google");
        navegador.visitarPagina("https://www.wikipedia.org", "Wikipedia");
        navegador.mostrarPaginaAtual();
        navegador.voltar();
        navegador.mostrarPaginaAtual();
        navegador.voltar();
        navegador.mostrarPaginaAtual();
    }
}