package arvores;

import javax.print.attribute.standard.MediaSize;

public class Arvore<T> {

    private NoArvore<T> raiz = null;
    private int altura;

    //Construtor
    public Arvore() {
    }

    //Metodos

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
    
        public int getAltura (T info) {
            
            NoArvore novo = new NoArvore(this);
            novo = getRaiz();
            
		if (getRaiz().getInfo().equals(info)) {
			return 0;
		}
		NoArvore<T> retorno = null;
		if (novo.getFilho() != null) {
			retorno = novo.getFilho().verifica(info);
			if (retorno != null) {
				return novo.getAltura();
			}
		}
		if (novo.getIrmao() != null) {
			retorno = novo.getIrmao().verifica(info);
		}
		return novo.getAltura();
	}
}
