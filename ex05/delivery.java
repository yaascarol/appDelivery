package delivery;

import java.util.Scanner;

public class delivery {

    static double calcularTotal(double preco, int quantidade){
    return preco * quantidade;
    };

    static double calcularDesconto(double total, int formaPagamento){
    double desconto = 0.0;
    if(formaPagamento == 1){
        desconto = total * 0.10;
    } else if(formaPagamento == 3){
        desconto = total * 0.05;
    }
    return total - desconto;
    };

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("""
        Escolha um item do cardápio:
            1. Hamburguer - R$ 18.00
            2. Pizza - R$ 25.00
            3. Batata Frita - R$ 12.00
            4. Refrigerante - R$ 8.00
            5. Milkshake - R$ 15.00
        """);
        
        int codigoItem = scanner.nextInt();

        String itemCardapio = "";
        double precoItem = 0.0;

        switch(codigoItem){
            case 1 -> {
                itemCardapio = "Hamburguer";
                precoItem = 18.00;
                break;
            }
            case 2 -> {
                itemCardapio = "Pizza";
                precoItem = 25.00;
                break;
            }
            case 3 -> {
                itemCardapio = "Batata Frita";
                precoItem = 12.00;
                break;
            }
            case 4 -> {
                itemCardapio = "Refrigerante";
                precoItem = 8.00;
                break;
            }
            case 5 -> {
                itemCardapio = "Milkshake";
                precoItem = 15.00;
                break;
            }
        }

        System.out.println("Qual a quantidade?: ");
        int quantidade = scanner.nextInt();
        
        double total = calcularTotal(precoItem, quantidade);


        System.out.println("""
        Formas de pagamento 
        1 - Dinheiro
        2 - Cartão
        3 - Pix
        """
        );

        int formaPagamento = scanner.nextInt();

        switch(formaPagamento){
            case 1 -> System.out.println("Dinheiro");
            case 2 -> System.out.println("Cartão");
            case 3 -> System.out.println("Pix");
        }

        double valorComDesconto = calcularDesconto(total, formaPagamento);
        double valorFinal = valorComDesconto;

        if(total < 40){
            System.out.println("Taxa de entrega: R$ 8.00");
            valorFinal += 8.00;
            return;
        };
        
        System.out.println("Resumo do seu pedido:\n"
        + "Produto escolhido: " + itemCardapio + "\n"
        + "Quantidade: " + quantidade + "\n"
        + "Valor do pedido: " + precoItem + "\n"
        + "Total do pedido " + total + "\n"
        + "Forma de pagamento: " + formaPagamento + "\n"
        + "Valor com desconto: " + valorComDesconto + "\n"
        + "Taxa de entrega: " + (total < 40 ? "R$ 8.00" : "Grátis") + "\n"
        + "Valor final do pedido: R$ " + valorFinal
        );
        
        scanner.close();
        }
    }