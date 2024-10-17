
public class Main {
    public static void main(String[] args) {
        EditorTexto editor = new EditorTexto();
        editor.inserir("Olá, mundo!");
        editor.remover(6);
        editor.desfazer();
        editor.refazer();
        editor.remover(5);
        editor.desfazer();
        editor.desfazer();
    }
}

