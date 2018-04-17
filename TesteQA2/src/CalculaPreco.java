

// Esta classe contém a lógica da "máquina registradora", que recebe uma string qualquer,
// contabiliza a quantidade de cada tipo de item vendido (W, X, Y e Z), aplica as
// regras de desconto contidas no teste (item W: 3 por $260 e item X: 2 por $90)
// devolvendo o valor total da compra por meio do "getter" getTotal().


public class CalculaPreco {

	
	private int quantidadeW;    		// Aqui declaramos as
	private int quantidadeX;    		// váriaveis que
	private int quantidadeY;    		// recebem os valores
	private int quantidadeZ;   		 	// que precisaremos 
	private int quantidadeTotal;		// considerar: as
	private int valorTotalW;   		 	// quantidades de
	private int valorTotalX;   		 	// cada tipo e os
	private int valorTotalY;    		// totais dos tipos
	private int valorTotalZ;   		 	// conforme os descontos.
	private int valorTotal;
	
	
	
	public CalculaPreco(String produtos) {     //Construtor da classe
		
		flush(); // Aqui chamamos o método que inicializa (ou reinicializa) as variáveis. 
		calc(produtos); // chamada do método que calcula 
	}
	
	
	
	public void calc(String produtos) { // este metodo calcula os valores que as variáveis receberão
		

		for(char produto : produtos.toCharArray()) {  
 
			switch (produto) {                        // Primeiramente contabilizamos a
									                  // quantidade de cada tipo por
			case 'W': 					              // meio desta iteração (quaisquer outros
				quantidadeW++;                        // caracteres senão os mencionados no
				quantidadeTotal++;                    // teste serão desconsiderados pelo "switch"
				break;   							  // inclusive as letras W, X, Y, e Z minúsculas).
				
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
			valorTotalW = quantidadeW * 100; // que as condições dos descontos não as recebam.
		}
		
		
		else {                                                // Como sabemos que os itens "W" recebem o desconto
			switch(quantidadeW % 3) {						  // a cada agrupamento de 3, basta que limitemos sua
			case 0: 										  // aplicação utilizando o operador modulus ("%"), 
				valorTotalW = (quantidadeW / 3) * 260;		  // que identificará quando a quantidade de itens "W"
				break;										  // for múltipla de 3 (resto "zero"), e também quando 
															  // restar "um" ou "dois" (situações sem-desconto).
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

		
		
		if (quantidadeX < 2) {                 // Do mesmo modo, devemos garantir também que compras do item "X" menores
			valorTotalX = quantidadeX * 60;    // que suas condições sejam cobradas sem desconto.
		}
		
		else {
			switch(quantidadeX % 2) {                   // Aqui procedemos à exemplo do item "W", mas considerando que
			case 0:										// para a verificação para números múltiplos de 2 inexiste
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

		
		valorTotalY = quantidadeY * 40; // Como não há desconto para os itens "Y" e "Z",
		valorTotalZ = quantidadeZ * 30; // os contabilizaremos apenas multiplicando quantidade versus preço.
		
		valorTotal = valorTotalW + valorTotalX + valorTotalY + valorTotalZ; // E aqui somamos os valores
	}

	
	
	public void flush() {
		
		quantidadeW = 0;    		
		quantidadeX = 0;    		// método para
		quantidadeY = 0;    		// zerar ou inicializar as variáveis 
		quantidadeZ = 0;   		 	
		quantidadeTotal = 0;		
		valorTotalW = 0;   		 	
		valorTotalX = 0;   		 	
		valorTotalY = 0;    		
		valorTotalZ = 0;
		valorTotal = 0;
	}
	
	
	
	public int getTotal() { // método que retorna o valor total
		return valorTotal;
	}
	
	public int getQuantidadeTotal() { // método que retorna a quantidade total
		return quantidadeTotal;
	}
	
	public int getQuantidadeW() { // método que retorna a quantidade de itens "W" comprados
		return quantidadeW;
	}
	
	public int getQuantidadeX() { // método que retorna a quantidade de itens "X" comprados
		return quantidadeX;
	}
	
	public int getQuantidadeY() { // método que retorna a quantidade de itens "Y" comprados
		return quantidadeY;
	}
	
	public int getQuantidadeZ() { // método que retorna a quantidade de itens "Z" comprados
		return quantidadeZ;
	}
	
	public int getTotalW() { // método que retorna a quantidade de itens "W" comprados
		return valorTotalW;
	}
	
	public int getTotalX() { // método que retorna a quantidade de itens "X" comprados
		return valorTotalX;
	}
	
	public int getTotalY() { // método que retorna a quantidade de itens "Y" comprados
		return valorTotalY;
	}
	
	public int getTotalZ() { // método que retorna a quantidade de itens "Z" comprados
		return valorTotalZ;
	}
	
}