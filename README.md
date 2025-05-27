Exercicio em Java explicado linha a linha. Matéria de Estrutura de Dados segundo semestre FATEC.

// Define a classe Node, que representa um nó individual na lista encadeada.
class Node {
    int data;   // Armazena o valor do nó.
    Node next;   // Armazena a referência para o próximo nó na lista.

    // Construtor da classe Node.
    Node(int data) {
        this.data = data;   // Inicializa o valor do nó com o dado fornecido.
        this.next = null;   // Inicializa a referência para o próximo nó como nula, indicando que este é o último nó (por enquanto).
    }
}

// Define a classe ListaEncadeada, que representa a estrutura da lista encadeada.
public class ListaEncadeada {
    Node head;   // Armazena a referência para o primeiro nó (cabeça) da lista. Inicialmente é nulo para uma lista vazia.

    // Método para adicionar um novo nó no início da lista.
    public void addFirst(int data) {
        Node newNode = new Node(data);   // Cria um novo nó com o dado fornecido.
        newNode.next = head;              // Faz o 'next' do novo nó apontar para o nó que atualmente é a cabeça da lista. Se a lista estiver vazia, 'head' é nulo, e 'newNode.next' também será nulo.
        head = newNode;                   // Atualiza a 'head' da lista para ser o novo nó, tornando-o o primeiro elemento.
    }

    // Método para adicionar um novo nó no final da lista.
    public void add(int data) {
        Node newNode = new Node(data);   // Cria um novo nó com o dado fornecido.
        if (head == null) {              // Verifica se a lista está vazia (a cabeça é nula).
            head = newNode;               // Se a lista estiver vazia, o novo nó se torna a cabeça.
        } else {                         // Se a lista não estiver vazia:
            Node temp = head;             // Cria um nó temporário e o inicializa com a cabeça da lista.
            while (temp.next != null) {   // Percorre a lista enquanto o 'next' do nó temporário não for nulo (ou seja, enquanto não chegamos ao último nó).
                temp = temp.next;         // Move o nó temporário para o próximo nó na lista.
            }
            temp.next = newNode;          // Quando o loop termina, 'temp' está no último nó. Faz o 'next' do último nó apontar para o novo nó, adicionando-o ao final.
        }
    }

    // Outro método para adicionar um novo nó no final da lista (funcionalmente igual a 'add').
    public void addLast(int data) {
        Node newNode = new Node(data);   // Cria um novo nó com o dado fornecido.
        if (head == null) {              // Verifica se a lista está vazia.
            head = newNode;               // Se estiver vazia, o novo nó se torna a cabeça.
        } else {                         // Se não estiver vazia:
            Node temp = head;             // Cria um nó temporário e o inicializa com a cabeça.
            while (temp.next != null) {   // Percorre até o último nó.
                temp = temp.next;         // Move para o próximo nó.
            }
            temp.next = newNode;          // Faz o 'next' do último nó apontar para o novo nó.
        }
    }

    // Método para inserir um novo nó em uma posição específica da lista.
    public void insertAtPosition(int data, int position) {
        if (position < 0) {               // Verifica se a posição é válida (não negativa).
            System.out.println("Posição Inválida!");
            return;                        // Sai do método se a posição for inválida.
        }

        Node newNode = new Node(data);   // Cria um novo nó com o dado fornecido.

        if (position == 0) {              // Se a posição for 0, insere no início.
            newNode.next = head;          // Faz o 'next' do novo nó apontar para a cabeça atual.
            head = newNode;               // Atualiza a cabeça para ser o novo nó.
            return;                        // Sai do método após a inserção no início.
        }

        Node temp = head;                 // Cria um nó temporário e o inicializa com a cabeça.
        for (int i = 0; i < position - 1 && temp != null; i++) {
            temp = temp.next;             // Percorre a lista até a posição anterior à desejada (ou até o final da lista).
        }

        if (temp == null) {               // Se 'temp' se tornou nulo antes de alcançar a posição desejada (posição maior que o tamanho da lista).
            System.out.println("Posição Inválida!");
        } else {                         // Se 'temp' está no nó anterior à posição de inserção:
            newNode.next = temp.next;     // Faz o 'next' do novo nó apontar para o nó que estava originalmente na posição de inserção.
            temp.next = newNode;          // Faz o 'next' do nó anterior apontar para o novo nó, inserindo-o na lista.
        }
    }

    // Método para exibir os elementos da lista encadeada.
    public void display() {
        Node current = head;              // Cria um nó 'current' e o inicializa com a cabeça da lista.
        while (current != null) {        // Percorre a lista enquanto 'current' não for nulo (ou seja, enquanto houver nós na lista).
            System.out.print(current.data + "->"); // Imprime o valor do nó atual seguido de "->".
            current = current.next;       // Move 'current' para o próximo nó na lista.
        }
        System.out.println("null");       // Após percorrer toda a lista, imprime "null" para indicar o final.
    }

    // Método principal (ponto de entrada do programa).
    public static void main(String[] args) {
        ListaEncadeada lista = new ListaEncadeada(); // Cria uma nova instância da classe ListaEncadeada.
        lista.add(1);                              // Adiciona o valor 1 ao final da lista.
        lista.add(2);                              // Adiciona o valor 2 ao final da lista.
        lista.add(3);                              // Adiciona o valor 3 ao final da lista.

        lista.display();                           // Chama o método 'display' para imprimir a lista: 1->2->3->null

        lista.addFirst(0);                         // Adiciona o valor 0 no início da lista.
        lista.display();                           // Imprime a lista: 0->1->2->3->null

        lista.addLast(4);                          // Adiciona o valor 4 no final da lista.
        lista.display();                           // Imprime a lista: 0->1->2->3->4->null

        lista.insertAtPosition(5, 2);              // Insere o valor 5 na posição de índice 2 (terceiro elemento).
        lista.display();                           // Imprime a lista: 0->1->5->2->3->4->null

        lista.insertAtPosition(6, 0);              // Insere o valor 6 na posição de índice 0 (início).
        lista.display();                           // Imprime a lista: 6->0->1->5->2->3->4->null

        lista.insertAtPosition(7, 7);              // Insere o valor 7 na posição de índice 7 (final da lista atual).
        lista.display();                           // Imprime a lista: 6->0->1->5->2->3->4->7->null

        lista.insertAtPosition(8, 10);             // Tenta inserir o valor 8 em uma posição inválida (maior que o tamanho da lista). Isso imprimirá "Posição Inválida!".
    }
}
