

// Esta classe cont�m a l�gica da "m�quina registradora", que recebe uma string qualquer,
// contabiliza a quantidade de cada tipo de item vendido (W, X, Y e Z), aplica as
// regras de desconto contidas no teste (item W: 3 por $260 e item X: 2 por $90)
// devolvendo o valor total da compra por meio do "getter" getTotal().


public class CalculaPreco {

	
	private int quantidadeW;    		// Aqui declaramos as
	private int quantidadeX;    		// v�riaveis que
	private int quantidadeY;    		// recebem os valores
	private int quantidadeZ;   		 	// que precisaremos 
	private int quantidadeTotal;		// considerar: as
	private int valorTotalW;   		 	// quantidades de
	private int valorTotalX;   		 	// cada tipo e os
	private int valorTotalY;    		// totais dos tipos
	private int valorTotalZ;   		 	// conforme os descontos.
	private int valorTotal;
	
	
	
	public CalculaPreco(String produtos) {     //Construtor da classe
		
		flush(); // Aqui chamamos o m�todo que inicializa (ou reinicializa) as vari�veis. 
		calc(produtos); // chamada do m�todo que calcula 
	}
	
	
	
	public void calc(String produtos) { // este metodo calcula os valores que as vari�veis receber�o
		

		for(char produto : produtos.toCharArray()) {  
 
			switch (produto) {                        // Primeiramente contabilizamos a
									                  // quantidade de cada tipo por
			case 'W': 					              // meio desta itera��o (quaisquer outros
				quantidadeW++;                        // caracteres sen�o os mencionados no
				quantidadeTotal++;                    // teste ser�o desconsiderados pelo "switch"
				break;   							  // inclusive as letras W, X, Y, e Z min�sculas).
				
			case 'X':
				quantidadeX++;
				quantidadeTotal++;
				break;
				
			case 'Y':
				quantidadeY++;
				quantidadeTotal++;
				break;
				
			case 'Z':
				quantidadeZ++;
				quantidadeTotal++;
				break;

			default:
				break;
			}
		}
		
		
		
		// Agora que sabemos quantos tipos existem na compra, vamos considerar os descontos.
		
		
		if (quantidadeW < 3) {               // Devemos garantir que compras do item "W" menores
			valorTotalW = quantidadeW * 100; // que as condi��es dos descontos n�o as recebam.
		}
		
		
		else {                                                // Como sabemos que os itens "W" recebem o desconto
			switch(quantidadeW % 3) {						  // a cada agrupamento de 3, basta que limitemos sua
			case 0: 										  // aplica��o utilizando o operador modulus ("%"), 
				valorTotalW = (quantidadeW / 3) * 260;		  // que identificar� quando a quantidade de itens "W"
				break;										  // for m�ltipla de 3 (resto "zero"), e tamb�m quando 
															  // restar "um" ou "dois" (situa��es sem-desconto).
			case 1:
				valorTotalW = ((quantidadeW - 1) / 3) * 260; 
				valorTotalW += 100; // Aqui somamos o valor sem-desconto do item que restou.
				break;
			
			case 2:
				valorTotalW = ((quantidadeW - 2) / 3) * 260;
				valorTotalW += 200; // Aqui somamos o valor sem-desconto dos itens que restaram.
				break;

			default:
				break;
			}
		}

		
		
		if (quantidadeX < 2) {                 // Do mesmo modo, devemos garantir tamb�m que compras do item "X" menores
			valorTotalX = quantidadeX * 60;    // que suas condi��es sejam cobradas sem desconto.
		}
		
		else {
			switch(quantidadeX % 2) {                   // Aqui procedemos � exemplo do item "W", mas considerando que
			case 0:										// para a verifica��o para n�meros m�ltiplos de 2 inexiste
				valorTotalX = (quantidadeX / 2) * 90;   // prever caso de resto "dois".
				break;
				
			case 1:
				valorTotalX = ((quantidadeX - 1) / 2) * 90;
				valorTotalX += 60; // Aqui somamos o valor sem-desconto do item que restou.
				break;

			default:
				break;
			}
		}

		
		valorTotalY = quantidadeY * 40; // Como n�o h� desconto para os itens "Y" e "Z",
		valorTotalZ = quantidadeZ * 30; // os contabilizaremos apenas multiplicando quantidade versus pre�o.
		
		valorTotal = valorTotalW + valorTotalX + valorTotalY + valorTotalZ; // E aqui somamos os valores
	}

	
	
	public void flush() {
		
		quantidadeW = 0;    		
		quantidadeX = 0;    		// m�todo para
		quantidadeY = 0;    		// zerar ou inicializar as vari�veis 
		quantidadeZ = 0;   		 	
		quantidadeTotal = 0;		
		valorTotalW = 0;   		 	
		valorTotalX = 0;   		 	
		valorTotalY = 0;    		
		valorTotalZ = 0;
		valorTotal = 0;
	}
	
	
	
	public int getTotal() { // m�todo que retorna o valor total
		return valorTotal;
	}
	
	public int getQuantidadeTotal() { // m�todo que retorna a quantidade total
		return quantidadeTotal;
	}
	
	public int getQuantidadeW() { // m�todo que retorna a quantidade de itens "W" comprados
		return quantidadeW;
	}
	
	public int getQuantidadeX() { // m�todo que retorna a quantidade de itens "X" comprados
		return quantidadeX;
	}
	
	public int getQuantidadeY() { // m�todo que retorna a quantidade de itens "Y" comprados
		return quantidadeY;
	}
	
	public int getQuantidadeZ() { // m�todo que retorna a quantidade de itens "Z" comprados
		return quantidadeZ;
	}
	
	public int getTotalW() { // m�todo que retorna a quantidade de itens "W" comprados
		return valorTotalW;
	}
	
	public int getTotalX() { // m�todo que retorna a quantidade de itens "X" comprados
		return valorTotalX;
	}
	
	public int getTotalY() { // m�todo que retorna a quantidade de itens "Y" comprados
		return valorTotalY;
	}
	
	public int getTotalZ() { // m�todo que retorna a quantidade de itens "Z" comprados
		return valorTotalZ;
	}
	
}