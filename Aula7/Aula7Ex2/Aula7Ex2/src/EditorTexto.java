import java.util.Stack;

public class EditorTexto {
    private StringBuilder texto;
    private Stack<Operacao> pilhaDesfazer; 
    private Stack<Operacao> pilhaRefazer; 

    public EditorTexto() {
        texto = new StringBuilder();
        pilhaDesfazer = new Stack<>();
        pilhaRefazer = new Stack<>();
    }

    public void inserir(String novoTexto) {
        pilhaDesfazer.push(new Operacao("inserir", novoTexto));
        texto.append(novoTexto);
        pilhaRefazer.clear(); 
        System.out.println("Texto após inserção: " + texto);
    }

    public void remover(int quantidade) {
        if (quantidade > texto.length()) {
            quantidade = texto.length();
        }
        String textoRemovido = texto.substring(texto.length() - quantidade);
        pilhaDesfazer.push(new Operacao("remover", textoRemovido));
        texto.delete(texto.length() - quantidade, texto.length());
        pilhaRefazer.clear();
        System.out.println("Texto após remoção: " + texto);
    }

    public void desfazer() {
        if (!pilhaDesfazer.isEmpty()) {
            Operacao operacao = pilhaDesfazer.pop();
            if (operacao.getTipo().equals("inserir")) {
                texto.delete(texto.length() - operacao.getTexto().length(), texto.length());
                pilhaRefazer.push(operacao);
            } else if (operacao.getTipo().equals("remover")) {
                texto.append(operacao.getTexto());
                pilhaRefazer.push(operacao);
            }
            System.out.println("Texto após desfazer: " + texto);
        } else {
            System.out.println("Nenhuma operação para desfazer.");
        }
    }

    public void refazer() {
        if (!pilhaRefazer.isEmpty()) {
            Operacao operacao = pilhaRefazer.pop();
            if (operacao.getTipo().equals("inserir")) {
                texto.append(operacao.getTexto());
                pilhaDesfazer.push(operacao);
            } else if (operacao.getTipo().equals("remover")) {
                texto.delete(texto.length() - operacao.getTexto().length(), texto.length());
                pilhaDesfazer.push(operacao);
            }
            System.out.println("Texto após refazer: " + texto);
        } else {
            System.out.println("Nenhuma operação para refazer.");
        }
    }

    public String getTexto() {
        return texto.toString();
    }
}

