import java.util.*;
public class CaixaEletronico 
{
   public String codigo;
   public String logradouro;
   public int numero_rua;
   public String cidade;
   public String estado;
   public Bandeja bandeja1;
   public Bandeja bandeja2;
   public Bandeja bandeja3;
   public Bandeja bandeja4;

   public CaixaEletronico() {
      codigo = new String("ABC12");
      logradouro =  new String("Rua Das Palmeiras");
      numero_rua = 200;
      cidade =  new String("Campinas");
      estado =  new String("Sao Paulo");
      bandeja1 = new Bandeja(100, 50); 
      bandeja2 = new Bandeja(50, 10);
      bandeja3 = new Bandeja(20, 40);
      bandeja4 = new Bandeja(10, 20);
   }

   public double saldo() {
	double saldo = (bandeja1.valorDeFace * bandeja1.quantidadeCedula);
	saldo = saldo+(bandeja2.valorDeFace * bandeja2.quantidadeCedula);
	saldo = saldo+(bandeja3.valorDeFace * bandeja3.quantidadeCedula);
	saldo = saldo+(bandeja4.valorDeFace * bandeja4.quantidadeCedula);
	return saldo;
   }
   public double saldoDaBandeja(int a) {
      double b;
      switch (a) {
         case 1:
            b = bandeja1.valorDeFace * bandeja1.quantidadeCedula;
            return b;
         case 2:
            b = bandeja2.valorDeFace * bandeja2.quantidadeCedula;
            return b;
         case 3:
            b = bandeja3.valorDeFace * bandeja3.quantidadeCedula;
            return b;
         case 4:
            b = bandeja4.valorDeFace * bandeja4.quantidadeCedula;
            return b;
      }
      return 0;
   }
   public RetornoSaque sacar(double valor) 
   {
      RetornoSaque retornoSaque = new RetornoSaque();
      int b1QtdCedula = bandeja1.quantidadeCedula;
      int b2QtdCedula = bandeja2.quantidadeCedula;
      int b3QtdCedula = bandeja3.quantidadeCedula;      
      int b4QtdCedula = bandeja4.quantidadeCedula;

      if (saldo() < valor){
       retornoSaque.codigo = 1;
       System.out.println(this.saldo());
       System.out.println(valor);
         return retornoSaque;
      }
      else 
      {
         boolean boo = true;
         while (boo) {
            if (b1QtdCedula == 0 || bandeja1.valorDeFace > valor) {
               boo = false;
	    }
            else {
               valor = valor - bandeja1.valorDeFace;
               retornoSaque.cedulasBandeja1++;
               b1QtdCedula--;
            }
         }
         boo = true;
         while (boo) {
            if (b2QtdCedula == 0 || bandeja2.valorDeFace > valor) {
               boo = false;
	    }
            else {
               valor = valor - bandeja2.valorDeFace;
               retornoSaque.cedulasBandeja2++;
               b2QtdCedula--;
            }
         }
         boo = true;
         while (boo) {
            if (b3QtdCedula == 0 || bandeja3.valorDeFace > valor) {
               boo = false;
	    }
            else {
               valor = valor - bandeja3.valorDeFace;
               retornoSaque.cedulasBandeja3++;
               b3QtdCedula--;
            }
         }
         boo = true;
         while (boo) {
            if (b4QtdCedula == 0 && bandeja4.valorDeFace > valor) {
               boo = false;
               retornoSaque.codigo = 2;
               return retornoSaque;
	    }
            else if (bandeja4.valorDeFace <= valor){
               valor = valor - bandeja4.valorDeFace;
               retornoSaque.cedulasBandeja4++;
               b4QtdCedula--;
            }
            else {
               boo = false;
            }
         } 
         if (valor != 0) {
            retornoSaque.codigo = 3;
            return retornoSaque;
         }
         bandeja1.quantidadeCedula = b1QtdCedula;
         bandeja2.quantidadeCedula = b2QtdCedula;
         bandeja3.quantidadeCedula = b3QtdCedula;
         bandeja4.quantidadeCedula = b4QtdCedula; 
         retornoSaque.codigo = 4;
         return retornoSaque;
      }
   }
}
