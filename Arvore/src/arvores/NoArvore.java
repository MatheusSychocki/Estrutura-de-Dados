package arvores;

public class NoArvore<T> {

    private T info;
    private NoArvore<T> filho;
    private NoArvore<T> irmao;
    private static int altura;

    public NoArvore(T info) {
        this.info = info;
    }

    public T getInfo() {
        return this.info;
    }

    public void inserirFilho(NoArvore<T> no) {
        no.irmao = this.filho;
        this.filho = no;
    }

    public NoArvore<T> pertence(T info) {
        if (this.info.equals(info)) {
            return this;
        }

        NoArvore<T> retorno = null;
        if (this.filho != null) {
            retorno = filho.pertence(info);
            if (retorno != null) {
                return retorno;
            }
        }

        if (this.irmao != null) {
            retorno = irmao.pertence(info);
        }

        return retorno;
    }

    public String imprimePre() {
        // trata a raiz
        String str = "<" + this.info;

        if (this.filho != null) {
            str += filho.imprimePre();
        }
        str += ">";
        if (this.irmao != null) {
            str += irmao.imprimePre();
        }

        return str;
    }

    public NoArvore<T> getFilho() {
        return filho;
    }

    public NoArvore<T> getIrmao() {
        return irmao;
    }

    public NoArvore<T> verifica(T info) {
        if (this.info.equals(info)) {
            return this;
        }

        NoArvore<T> retorno = null;
        if (this.filho != null) {
            altura++;
            retorno = filho.verifica(info);

            if (retorno != null) {
                return retorno;
            }
        }

        if (this.irmao != null) {
            retorno = irmao.verifica(info);
        }

        return retorno;
    }

    public int getAltura() {
        return altura;
    }

}
