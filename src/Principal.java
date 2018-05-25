import java.util.*;
public class Principal 
{
   public static void main (String[] args)
   {
      CaixaEletronico CE = new CaixaEletronico();      
      Scanner scanner = new Scanner(System.in);
      do 
      {
         System.out.print("\nEscolha uma opcao: \n1. Exibir saldo total do caixa.\n2. Exibir o saldo de uma bandeja especifica.\n3. Sacar uma quantia.\n4. Sair do programa.\n");
         int escolha = scanner.nextInt();
         switch(escolha){
            case 1:
               System.out.println("Saldo total do caixa é de: " + CE.saldo() + "\n");
               break;
            case 2:
               System.out.println("Selecione qual bandeja: \n");
               int c = scanner.nextInt();
               switch(c){
                  case 1:
                     System.out.println("Saldo total da bandeja 1 é de: " + CE.saldoDaBandeja(1) + "\n");
                     break;
                  case 2:
                     System.out.println("Saldo total da bandeja 2 é de: " + CE.saldoDaBandeja(2) + "\n");
                     break;
                  case 3:
                     System.out.println("Saldo total da bandeja 3 é de: " + CE.saldoDaBandeja(3) + "\n");
                     break;
                  case 4:
                     System.out.println("Saldo total da bandeja 4 é de: " + CE.saldoDaBandeja(4) + "\n");
                     break;
                  default:
                     System.out.println("Opcao inválida!\n");
                  }
               break;
            case 3:
               System.out.println("Selecione a quantidade a ser sacada:\n");
               double valor = scanner.nextDouble();
               RetornoSaque retornoSaque = CE.sacar(valor);
               switch (retornoSaque.codigo){
                  case 1:
                     System.out.println("Saldo do caixa insuficiente!");
                     break;
                  case 2:
                     System.out.println("Quantidade de cedulas disponiveis insuficiente para operacao, por favor, verifique o saldo do caixa");
                     break;
                  case 3:
                     System.out.println("Valor inserido não pode ser retirado, verifique as cedulas disponiveis no caixa.");
                     break;
                  case 4:
                     System.out.println("Saque realizado com sucesso!\nValor total sacado: "+valor+
                        "\n"+retornoSaque.cedulasBandeja1+" cedulas de "+CE.bandeja1.valorDeFace+
                        "\n"+retornoSaque.cedulasBandeja2+" cedulas de "+CE.bandeja2.valorDeFace+
                        "\n"+retornoSaque.cedulasBandeja3+" cedulas de "+CE.bandeja3.valorDeFace+
                        "\n"+retornoSaque.cedulasBandeja4+" cedulas de "+CE.bandeja4.valorDeFace);
                     break;
               }
               break;
            case 4:
               System.out.println("\nFinalizando o programa...\n\n");
               return;
            default:
               System.out.println("Opcao invalida!\n");
               break;
         }
      } while(true);
   }
}
