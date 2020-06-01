package arvores;

public class Arvore<T> {

    private NoArvore<T> raiz = null;

    //Construtor
    public Arvore() {
    }

    //Metodos
    public int getAltura() {

        int altura = 0;
        int alturaMaior = 0;
        NoArvore novo = new NoArvore(this);
        NoArvore irmao = new NoArvore(this);

        novo = getRaiz().getFilho();
        irmao = novo.getIrmao(); 

        if (getRaiz().getInfo() == null) {
            return -1;
        }
        while (novo != null) {
            altura = 0;

            if (novo.getFilho() != null) {
                altura++;

                while (novo.getFilho() != null) {
                    altura++;
                    novo = novo.getFilho();
                }
            }
            if (novo.getIrmao() == null ) {
                return altura;
            } else {
                if (alturaMaior < altura) {
                    alturaMaior = altura;
                    novo =  irmao;
                } else {
                    novo = irmao;          
                    break;
                }
            }
        }
        return alturaMaior;
    }

    public void setRaiz(NoArvore<T> no) {
        this.raiz = no;
    }

    public NoArvore<T> getRaiz() {
        return this.raiz;
    }

    public boolean vazia() {
        return raiz == null;
    }

    public NoArvore<T> pertence(T info) {
        if (this.vazia()) {
            return null;
        } else {
            return raiz.pertence(info);
        }
    }

    @Override
    public String toString() {
        if (this.vazia()) {
            return "";
        } else {
            return raiz.imprimePre();
        }
    }
}
