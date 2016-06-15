package algoritmoavancado;

/**
 *
 * @author Lucas Jr
 */
public class ArvoreBinaria {

    public tipoNoArvore raiz;

    ArvoreBinaria() {
    }

    public void inserir(tipoNoArvore atual, int valor) {
        if (raiz == null) {
            raiz = new tipoNoArvore(valor);
            System.out.println(" Inserindo valor da Raiz = " + raiz.info);
        } 
        else if (valor < atual.info) {
            if (atual.esquerda != null) {
                inserir(atual.esquerda, valor);
            } else {
                System.out.println(" Inserindo " + valor + " a esquerda de " + atual.info);
                atual.esquerda = new tipoNoArvore(valor);
            }
        } 
        else if (valor > atual.info) {
            if (atual.direita != null) {
                inserir(atual.direita, valor);
            } else {
                System.out.println(" Inserindo " + valor + " a direita de " + atual.info);
                atual.direita = new tipoNoArvore(valor);
            }
        }

    }

    public tipoNoArvore remover(tipoNoArvore atual, int valor) {
        if (raiz == null) {
            System.out.println("  Arvore vazia ");
            }
        if (valor < atual.info) {
            atual.esquerda = remover(atual.esquerda, valor);
            } 
        else if (valor > atual.info) {
            atual.direita = remover(atual.direita, valor);
            } 
        else if (atual.esquerda != null && atual.direita != null){  // 2 filhos{
            System.out.println("  Removeu No " + atual.info);
            atual.info = encontraMinimo(atual.direita).info;
            atual.direita = removeMinimo(atual.direita);
            } 
        else {
            System.out.println("  Removeu No " + atual.info);
            atual = (atual.esquerda == null) ? atual.esquerda : atual.direita;
            }
        return atual;
}
    public tipoNoArvore removeMinimo(tipoNoArvore atual) {
        if (atual == null) {
            System.out.println("  ERRO ");
            } 
        else if (atual.esquerda != null) {
            atual.esquerda = removeMinimo(atual.esquerda);
            return atual;
            } 
        else {
            return atual.direita;
            }
        return null;
}
    public tipoNoArvore encontraMinimo(tipoNoArvore atual) {
        if (atual != null) {
            while (atual.esquerda != null) {
                atual = atual.esquerda;
            }
        }
        return atual;
}

    public void imprime(tipoNoArvore noAtual) {
        if (noAtual != null) {
            imprime(noAtual.esquerda);
            System.out.print(" " + noAtual.info);
            imprime(noAtual.direita);
            
            
        }
    }

    public void menu() {
        int valor, opcao = 0;

        while (opcao != -1) {
            opcao = Input.readInt("\nDigite a opcao: \n(1) Inserir \n(2) Remover \n(3) Imprime \n(-1) Sair \nOpcao: ");
            switch (opcao) {

                case 1:
                    valor = Input.readInt("Valor: ");
                    inserir(raiz, valor);
                    break;

                case 2:
                    valor = Input.readInt("Valor: ");
                    remover(raiz, valor);
                    break;

                case 3:
                    imprime(raiz);
                    break;

                case -1:
                    System.out.println("Saindo!");
                    break;

                default:
                    System.out.println("Opcao invalida!");
                    break;

            }

        }
    }

    public static void main(String args[]) {
        ArvoreBinaria F = new ArvoreBinaria();
        F.menu();
    }
}