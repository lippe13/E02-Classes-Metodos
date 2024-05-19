import java.util.Scanner;

class Cliente{

    String nome;
    String CPF;
    String endereco;
    int idade;
    char sexo;

}

class Conta {

    Cliente cliente;
    int numero;
    float saldo_atual;
    float limite;
    
    void imprimir (String nome, String CPF, String endereco, int idade, char sexo, int numero, float saldo_atual, float limite){
        System.out.println("-----CLIENTE-----");
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + CPF);
        System.out.println("Endereco: " + endereco);
        System.out.println("Idade: " + idade);
        System.out.println("Sexo: " + sexo);
        System.out.println("-----CONTA-----");
        System.out.println("Numero: " + numero);
        System.out.println("Limite: " + limite);
        System.out.println("Saldo Atual: " + saldo_atual);
    }

    void saca (float quantidade){

        if(saldo_atual >= quantidade){

            float nv_saldo = this.saldo_atual - quantidade;
            saldo_atual = nv_saldo;
            System.out.println("Saque realizado com sucesso, no valor de BRL " + quantidade);

        } else{
            System.out.println("Saldo Insuficiente");
        }
    }

    void depositar (float quantidade){


        float nv_saldo = this.saldo_atual + quantidade;
        if(nv_saldo > this.limite){
            System.out.println("Limite estourado!!!");
        } else{
        saldo_atual = nv_saldo;
        System.out.println("Deposito realizado com sucesso, no valor de BRL " + quantidade);}

    }

}

class BMG {
       public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Conta conta;
        conta = new Conta();

        Cliente cliente;
        cliente = new Cliente();

        int x;
        float quantidade;
            
            do{

                System.out.println("-----BANCO BMG-----");
                System.out.println("[1] - Cadastrar conta");
                System.out.println("[2] - Cadastrar cliente");
                System.out.println("[3] - Imprimir dados da sua conta");
                System.out.println("[4] - Sacar");
                System.out.println("[5] - Depositar");
                System.out.println("[0] - Sair");

                System.out.print("Insira um valor: ");
                x = sc.nextInt();
                sc.nextLine();
                System.out.println("");

                
                switch (x) {

                case 1:
                    
                System.out.print("Insira o numero da conta: ");
                    conta.numero = sc.nextInt();
                    System.out.print("Insira seu saldo atual: ");
                    conta.saldo_atual = sc.nextFloat();
                    System.out.print("Insira seu limite: ");
                    conta.limite = sc.nextFloat();
                    sc.nextLine();

                break;
                
                case 2:

                    System.out.print("Insira seu nome: ");
                    cliente.nome = sc.nextLine();
                    System.out.print("Insira seu CPF: ");
                    cliente.CPF = sc.nextLine();
                    System.out.print("Insira seu endereco: ");
                    cliente.endereco = sc.nextLine();
                    System.out.print("Insira sua idade: ");
                    cliente.idade = sc.nextInt();
                    System.out.print("Insira seu sexo: ");
                    cliente.sexo = sc.next().charAt(0);
                    sc.nextLine();

                break;

                case 3:

                    conta.imprimir(cliente.nome, cliente.CPF, cliente.endereco, cliente.idade,cliente.sexo, conta.numero, conta.saldo_atual, conta.limite);

                break;

                case 4:

                    quantidade = 0;
                    System.out.print("Insira a quantidade que deseja sacar: ");
                    quantidade = sc.nextFloat();
                    conta.saca(quantidade);

                break;

                case 5:

                    quantidade = 0;
                    System.out.print("Insira a quantidade que deseja depositar: ");
                    quantidade = sc.nextFloat();
                    conta.depositar(quantidade);                    

                break;

                case 0:

                    System.out.println("Obrigado por usar o Banco BMG!");

                break;

                default:

                    System.out.println("Valor Invalido, tente novamente.");

                break;
            }

            System.out.println("");
            
        } while (x != 0);
        sc.close();
    } 
}
