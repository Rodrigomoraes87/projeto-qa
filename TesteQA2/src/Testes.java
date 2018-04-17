
// Esta classe é a que deve ser testada (run as: JUnit Test) pois
// possui o metódo que contém as verificações. Ela foi testada
// com 0 erros utilizando a library JUnit 5 onde verifiquei 
// que qualquer valor incorreto informado nas funções abaixo
// pára imediatamente a aplicação. (informando a linha na aba Runner).
// Os testes checam o calculo dos descontos nas mais diferentes situações
// e também quando as compras são realizadas cumulativamente (teste incremental).

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Testes {
	
	@Test
	public void testes() { // metodo que contém os assertEquals que serão utilizados
	
	// Primeiramente vamos testar o valor de quatro compras onde o cliente comprou um item de cada:
	
	assertEquals(100, new CalculaPreco("W").getTotal());	 // Leia-se: "O valor no primeiro argumento (100) corresponde
															 // ao devolvido pelo método no segundo argumento (.getTotal())".
	assertEquals(60, new CalculaPreco("X").getTotal());	     // Os demais assertEquals seguem esta mesma lógica.
    
    assertEquals(40, new CalculaPreco("Y").getTotal());
    
    assertEquals(30, new CalculaPreco("Z").getTotal());
    
	
    // Agora vamos testar com 2 itens em cada compra (o item "X" já está elegível para desconto):
    
    assertEquals(260, new CalculaPreco("WWX").getTotal());  
    
    assertEquals(210, new CalculaPreco("XXYYY").getTotal());  
    
    assertEquals(200, new CalculaPreco("YYZZZZ").getTotal());  
    
    assertEquals(160, new CalculaPreco("ZZW").getTotal());
    
    
    // Tentemos uma compra de 3 itens diferentes, com 1 item elegível (o "W") para desconto c/ sobra de "dois":
    
    assertEquals(2120, new CalculaPreco("WWWWWWWWWWWWWWWWWWWWWWWYZZ").getTotal());
    
    
    // Novamente com 3 itens (desconto) mas agora com sobra de "um":
    
    assertEquals(1010, new CalculaPreco("XXXXXXXXXXXXXXXWWZZZZ").getTotal());
    
    
    // Com os 4 itens em diferentes quantidades e em ordens diferentes:
    
    assertEquals(2190, new CalculaPreco("XXWWWWYYZZYYXXWWWZZZZZYYYXXWWWWWWYYXXZZZZ").getTotal());

    
    // O mesmo teste acima mas com a adição de caracteres não-previstos:
    
    assertEquals(2190, new CalculaPreco("XX'WW235WWYYZxZYYsXçXdweWWW??aZZZZZY45YYXXWWWWWWYYXXZZ$eeZZ").getTotal());
    
    
    // Nestes o cliente não comprou nada:
    
    assertEquals(0, new CalculaPreco(" ").getTotal());

    assertEquals(0, new CalculaPreco("").getTotal());
    
    assertEquals(0, new CalculaPreco("adaawe 3985639 7878").getTotal());
    
    
	// Simulando compras para atestar a quantidade dos itens comprados:
	
	assertEquals(10, new CalculaPreco("WXZYWYYXZW").getQuantidadeTotal());	
	
	assertEquals(7, new CalculaPreco("WZYYYYY").getQuantidadeTotal()); 
	
	assertEquals(3, new CalculaPreco("XYZ").getQuantidadeTotal()); 
	
	assertEquals(17, new CalculaPreco("WXZYWYYXZWWWYYZZZ").getQuantidadeTotal());
	
	assertEquals(5, new CalculaPreco("ZZZZY").getQuantidadeTotal());
	
	
	// Agora verificando valores por itens isolados:
	
	assertEquals(150, new CalculaPreco("XZYWWYZXYWYYX").getTotalX());
	
	assertEquals(520, new CalculaPreco("YWXWZYYWWZZYWXWZ").getTotalW());
	
	assertEquals(30, new CalculaPreco("ZWWYYXXWWXYWW").getTotalZ());
	
	assertEquals(280, new CalculaPreco("YYYZWXWXZXZZYYYY").getTotalY());
	
	
	// Verificando quantidades por itens isolados (com o mesmo input acima):
	
	assertEquals(3, new CalculaPreco("XZYWWYZXYWYYX").getQuantidadeX());
	
	assertEquals(6, new CalculaPreco("YWXWZYYWWZZYWXWZ").getQuantidadeW());
	
	assertEquals(1, new CalculaPreco("ZWWYYXXWWXYWW").getQuantidadeZ());
	
	assertEquals(7, new CalculaPreco("YYYZWXWXZXZZYYYY").getQuantidadeY());
	
	
	// E finalmente faremos testes com incrementos (calculando uma compra de cada vez):
	
	CalculaPreco compra = new CalculaPreco(""); // instanciando a "compra"
	
	compra.calc("W");                      // um item "W" foi contabilizado
	assertEquals(100, compra.getTotal());  // como para 1 item não há desconto, o valor foi cobrado integral (100)
	
	compra.calc("WWW");                    // mais 3 itens "W" foram contabilizados                  
	assertEquals(360, compra.getTotal());  // o valor no momento é de $360 pois apenas 3 itens "W" são elegíveis para desconto
	
	compra.calc("ZZYY");                   // adicionamos à "compra" 2 dos itens "Z" e "Y"
	assertEquals(500, compra.getTotal());  // comprados até o momento: 4 "W", 2 "Z" e 2 "Y" = $500
	
	compra.calc("X");                      // adicionamos um item "X"
	assertEquals(560, compra.getTotal());  // como para 1 item não há desconto, o valor foi cobrado integral
	
	compra.calc("X");                      // adicionamos mais um item "X" (tornando-o elegível para desconto)
	assertEquals(590, compra.getTotal());  // como o desconto dos itens "X" "entrou", o valor foi pra $590
	
	compra.calc("X");                      // adicionamos novamente mais um item "X" (restando um "X" sem desconto pois agora são 3);
	assertEquals(650, compra.getTotal());  // como este "X" não tem desconto (resto "um"), o valor totalizou $650
	
	}
	
}
